package com.xebia.test;

import java.util.Arrays;
import java.util.Collection;
import com.xebia.test.models.Pelouse;
import com.xebia.test.models.Position;
import com.xebia.test.utils.Constantes;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Classe de test de la classe App
 */
@RunWith(Parameterized.class)
@Slf4j
public class AppTest {

    @Parameters
    public static Collection<String[]> data() {
        return Arrays.asList(new String[][] { { "5 5", "1 2 N", "GAGAGAGAA", "1 3 N" }, { "5 5", "3 3 E", "AADAADADDA", "5 1 E" } });
    }

    private Integer maxX;
    private Integer maxY;
    private Position position;
    private String  resAttendu;
    private String  actions;

    public AppTest(String maxXY, String mower, String actions, String resAttendu) {
        this.maxX = Integer.parseInt(maxXY.split(Constantes.DEFAULT_TEST_SEPARATOR)[0]);
        this.maxY = Integer.parseInt(maxXY.split(Constantes.DEFAULT_TEST_SEPARATOR)[1]);
        this.position = new Position(mower.split(Constantes.DEFAULT_TEST_SEPARATOR));
        this.actions = actions;
        this.resAttendu = resAttendu;
    }

    /**
     * Methode pour le test de la fonction execution
     */
    @Test
    public void execution() {
        Pelouse pelouse = new Pelouse(maxX, maxY, position);
        App application = new App(pelouse);
        String result = application.executer(actions);
        log.trace(result);
        // Verification du resultat attendu
        Assertions.assertThat(result).isEqualTo(resAttendu);
    }

}
