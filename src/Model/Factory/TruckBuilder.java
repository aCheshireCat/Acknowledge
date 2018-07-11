package Model.Factory;

import java.awt.Color;

public class TruckBuilder implements Builder {
	private String motor;
	private int wheels;
	private Color color;
//	@Override
	public void buildMotor() {
		this.motor = "Truck's motor";
	}
//	@Override
	public void buildWheels() {
		this.wheels = 12;
	}
//	@Override
	public void paintColor() {
		this.color = Color.gray;
	}
//	@Override
	public AbstractProduct getProduct() {
		AbstractProduct p = new Truck ();
		p.setColor(color);
		p.setMotor(motor);
		p.setWheels(wheels);
		return p;
	}
}