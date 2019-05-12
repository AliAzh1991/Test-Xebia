package com.xebia.test;

import com.xebia.test.models.Pelouse;
import com.xebia.test.models.Position;
import com.xebia.test.utils.Constantes;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe d'execution qui comporte la methode executer
 */
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class App {

    /**
     * Initialisation de la pelouse
     */
    private Pelouse pelouse;

    /**
     * Methode d'execution
     * @param actions actions a executer
     * @return Position des tondeuses
     */
    public String executer(String actions) {
        List<Character> todoActions = actions.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.toList());

        todoActions.forEach(action -> {
            switch (String.valueOf(action)) {
                case Constantes.DROITE:
                    this.pelouse.getPosition().right();
                    break;
                case Constantes.GAUCHE:
                    this.pelouse.getPosition().left();
                    break;
                case Constantes.AVANCER:
                    avancer();
                    break;
                default:
                    break;
            }
        });
        return pelouse.getPosition().toString();
    }

    /**
     * Methode qui permet d'avancer la tondeuse
     */
    private void avancer() {
        Position position = pelouse.getPosition();
        switch (position.getOrientation()) {
            case N:
                position.setY((position.getY().equals(pelouse.getMaxY()) ? position.getY() : position.getY() + 1));
                break;
            case E:
                position.setX((position.getX().equals(pelouse.getMaxX()) ? position.getX() : position.getX() + 1));
                break;
            case S:
                position.setY((position.getY().equals(pelouse.getMinY()) ? position.getY() : position.getY() - 1));
                break;
            case W:
                position.setX((position.getX().equals(pelouse.getMinX()) ? position.getX() : position.getX() - 1));
                break;
            default:
                break;
        }
    }
}
