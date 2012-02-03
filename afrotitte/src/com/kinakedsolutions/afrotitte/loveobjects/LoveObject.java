package com.kinakedsolutions.afrotitte.loveobjects;

/**
 * The common interface for all receivers of love motions.
 * LoveObjects are on the receiving end of a LoveMachine, and are to be satisfied by a Player.
 */
public interface LoveObject {
	
	// TODO: design this interface

	/**
	 * @return the name of this Love Object.
	 */
	public String getName();
	
	/**
	 * @return the current level of satisfaction.
	 */
	public float getSatisfaction();
	
}
