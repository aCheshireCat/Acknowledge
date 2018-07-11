package Classes.package3;

interface x{
	public String getName();
	public short getAge();
	public String getInfo();
	public void setInfo(String name,short age ,String info);
	
	
}
class A implements x{
	private String name;
	private short age;
	private String info;
	public A(){
		int title = 100;
		System.out.println(title);
	}
	public void setInfo(String name,short age,String info){
		this.name = name;
		this.age = age;
		this.info = info;

	}
	public String getInfo(){
		return info;
	}
	public String getName(){
		return name;
	}
	public short getAge(){
		return age;
	}
	
}
class B extends A{
	
	
}
class C extends B{
	
}
public class Test {

}
