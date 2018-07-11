package Model.com.bjsxt.dp.factory;

import java.util.ArrayList;
import java.util.List;

public class Car implements Moveable {
	//����ֻ��һ�� ����call singleton
	public static final Car car = new Car();
	//����
	private static List<Car> cars = new ArrayList<Car>();
	
	public Car(){
		
	}
	
	public static Car getInstance (){
		
		return car;
	}
	
	public void run(){
		System.out.println("ð���̱����� Car...");
	}
	
}
