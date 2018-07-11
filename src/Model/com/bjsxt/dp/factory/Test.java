package Model.com.bjsxt.dp.factory;

public class Test {
	public static void main(String[] args) {
		Car c = Car.getInstance();
		Car c2  = Car.car;
		c.run();
//		if(c == c2)
//		System.out.println("same car");
		PlaneFactory factory = new PlaneFactory();
		Moveable m = factory.create();
		
//		Moveable m = new Plane();//承接于同一接口
		m.run();

	}
}
