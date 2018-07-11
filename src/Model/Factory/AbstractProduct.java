package Model.Factory;

import java.awt.Color;

//抽象出产品
public abstract class AbstractProduct {
	private String motor;
	private int wheels;
	private Color color;
	public String getMotor() {
		return motor;
	}
	public void setMotor(String motor) {
		this.motor = motor;
	}
	public int getWheels() {
		return wheels;
	}
	public void setWheels(int wheels) {
		this.wheels = wheels;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public abstract void canLoad();
	
	public void print(){
		System.out.println(motor + "; wheels:" + wheels + "; color:" + color);
		canLoad();
	}
}