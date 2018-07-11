package Model.Factory;

public class Truck extends AbstractProduct {

	@Override
	public void canLoad() {
		System.out.println("Truck: can load much goods");
	}


}
