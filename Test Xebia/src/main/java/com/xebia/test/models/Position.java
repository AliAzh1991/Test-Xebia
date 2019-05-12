package com.xebia.test.models;

import lombok.*;

/**
 * Objet qui represente une position sur la grille
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Position {

	/**
	 * Valeur actuelle de x
	 */
	private Integer x;

	/**
	 * Valeur actuelle de y
	 */
	private Integer y;

	/**
	 * Orientation actuelle
	 */
	private Orientation orientation;

	/**
	 * Initialisation de la position de la tondeuse
	 * @param split chaine de caracteres en entree
	 */
	public Position(String[] split) {
		this.x = Integer.parseInt(split[0]);
		this.y = Integer.parseInt(split[1]);
		this.orientation = Orientation.valueOf(split[2]);
	}

	/**
	 * Changer l'orientation a droite
	 */
	public void right(){
		this.orientation = Orientation.fromValue(this.orientation.right());
	}

	/**
	 * Changer l'orientation a gauche
	 */
	public void left(){
		this.orientation = Orientation.fromValue(this.orientation.left());
	}


	@Override
	public String toString() {
		return x + " " + y + " " + orientation;
	}
}
