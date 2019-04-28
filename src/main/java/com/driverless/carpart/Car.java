package com.driverless.carpart;

public interface Car {

	void move() throws Exception;
	int getPositionX();
	int getPositionY();
	String getOrientation();

}
