package Classes.package2;

import Classes.package1.classTestSubDemo;

public class subClassTestDemo extends classTestSubDemo {
	
	private String cloth;
	private String shoes;
	
	void setCloth(String cloth){
		this.cloth = cloth;
	}
	void setShoes(String shoes){
		this.shoes = shoes;
	}
	String getCloth(){
		return cloth;
	}
	String getShoes(){
		return shoes;
	}

}
