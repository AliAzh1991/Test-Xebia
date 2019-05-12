package com.xebia.test.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Objet qui represente une pelouse (grille)
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Pelouse {
	/**
	 * Valeur minimale de X
	 */
	private Integer minX = 0;

	/**
	 * Valeur minimale de Y
	 */
	private Integer minY = 0;

	/**
	 * Valeur maximale de X
	 */
	private Integer maxX;

	/**
	 * Valeur maximale de Y
	 */
	private Integer maxY;

	/**
	 * Position actuelle de la tondeuse
	 */
	private Position position;

	/**
	 * Constructeur pour l'initialisation de la grille
	 * et de la premiere position de la tondeuse
	 * @param maxX Valeur minimale de X
	 * @param maxY Valeur maximale de Y
	 * @param position Position actuelle de la tondeuse
	 */
	public Pelouse(Integer maxX, Integer maxY, Position position) {
		this.maxX = maxX;
		this.maxY = maxY;
		this.position = position;
	}
}
