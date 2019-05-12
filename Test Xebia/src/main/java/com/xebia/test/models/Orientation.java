package com.xebia.test.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * Orientaions possibles
 */
@AllArgsConstructor
@Getter
public enum Orientation {
  /**
   * North
   */
  N(0),
  /**
   * East
   */
  E(1),
  /**
   * South
   */
  S(2),
  /**
   * West
   */
  W(3);

  /**
   * Valeur courante
   */
  private int value;

  /**
   * @return the Enum representation for the given string.
   * @throws IllegalArgumentException if unknown string.
   */
  public static Orientation fromValue(final int value) throws IllegalArgumentException {
    return Arrays.stream(Orientation.values())
            .filter(v -> v.value == value)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Mauvaise valeur: " + value));
  }

  /**
   * Orientation a droite
   */
  public int right(){
    return (value == 3) ? 0 : value + 1;
  }

  /**
   * Orientation a gauche
   */
  public int left(){
    return (value == 0) ? 3 : value - 1;
  }

}
