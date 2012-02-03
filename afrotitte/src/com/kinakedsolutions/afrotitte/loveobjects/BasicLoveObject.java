package com.kinakedsolutions.afrotitte.loveobjects;

/**
 * A base class for LoveObjects, intended to provide all methods and preferences for the basic game mechanics.
 */
public abstract class BasicLoveObject implements LoveObject {
	
	protected String name;
	protected float satisfaction = 0;
	protected float desiredDepth = 0;
	protected float desiredSpeed = 0;

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public float getSatisfaction() {
		return satisfaction;
	}

}
