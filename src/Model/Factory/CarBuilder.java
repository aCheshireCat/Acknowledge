package Model.Factory;

import java.awt.Color;

public class CarBuilder implements  Builder{
	private String motor;
	private int wheels;
	private Color color;
//	@Override
	public void buildMotor() {
		this.motor = "Car's motor";
	}
//	@Override
	public void buildWheels() {
		this.wheels = 4;
	}
//	@Override
	public void paintColor() {
		this.color = Color.black;
	}
//	@Override
	public AbstractProduct getProduct() {
		AbstractProduct p = new Car ();
		p.setColor(color);
		p.setMotor(motor);
		p.setWheels(wheels);
		return p;
	}
}