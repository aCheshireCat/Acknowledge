package Model.Factory;

public class Car extends AbstractProduct {

	@Override
	public void canLoad() {
		System.out.println("Car: can load 4 passengers");
	}


}
