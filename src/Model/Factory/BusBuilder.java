package Model.Factory;

import java.awt.Color;

public class BusBuilder implements Builder {
	private String motor;
	private int wheels;
	private Color color;
//	@Override
	public void buildMotor() {
		// TODO Auto-generated method stub
		this.motor = "Bus's motor";
	}
//	@Override
	public void buildWheels() {
		// TODO Auto-generated method stub
		this.wheels = 8;
	}
//	@Override
	public void paintColor() {
		// TODO Auto-generated method stub
		this.color = Color.green;
	}
//	@Override
	public AbstractProduct getProduct() {
		AbstractProduct p = new Bus ();
		p.setColor(color);
		p.setMotor(motor);
		p.setWheels(wheels);
		return p;
	}
}