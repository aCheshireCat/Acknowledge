package Model.com.bjsxt.dp.factory;

import java.util.ArrayList;
import java.util.List;

public class Car implements Moveable {
	//由于只有一个 所以call singleton
	public static final Car car = new Car();
	//多例
	private static List<Car> cars = new ArrayList<Car>();
	
	public Car(){
		
	}
	
	public static Car getInstance (){
		
		return car;
	}
	
	public void run(){
		System.out.println("冒着烟奔跑中 Car...");
	}
	
}
