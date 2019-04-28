package com.driverless.carpart;

public class DriverlessCar implements Car{

	private int positionX;
	private int positionY;
	private final String[] orientation = {"North","East","South","West"};
	private int orientationFlag;
	private final String errMsg="Car moves outside the car park boundaries";
	
	public DriverlessCar(){
		this.setPositionX(1);
		this.setPositionY(1);
		this.setOrientationFlag(0);
	}

	public void move() throws Exception {
		switch (orientationFlag) {
		case 0:
			if(this.positionY==4) throw new Exception(errMsg);
			this.setPositionY(this.positionY+1);
			break;
		case 1:
			if(this.positionX==4) throw new Exception(errMsg);
			this.setPositionX(this.positionX+1);
			break;
		case 2:
			if(this.positionY==1) throw new Exception(errMsg);
			this.setPositionY(this.positionY-1);
			break;	
		case 3:
			if(this.positionX==1) throw new Exception(errMsg);
			this.setPositionX(this.positionX-1);
			break;
		default:
			break;
		}
		
	}
	
	public void clockwise(){
		this.setOrientationFlag(++this.orientationFlag%4);
	}
	
	private void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	private void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	
	public int getPositionX() {
		return this.positionX;
	}

	public int getPositionY() {
		return this.positionY;
	}

	public String getOrientation() {
		return orientation[orientationFlag];
	}
	
	public int getOrientationFlag() {
		return orientationFlag;
	}

	private void setOrientationFlag(int orientationFlag) {
		this.orientationFlag = orientationFlag;
	}

}
