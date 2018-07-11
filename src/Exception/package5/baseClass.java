package Exception.package5;

public class baseClass {
	private String name;
	private int age;
	private String info;
	baseClass(){
		
	}
	public baseClass(String name,int age,String info){
		this.name = name;
		this.age = age;
		this.info = info;
	}
	public void Pri(){
		System.out.println("the name is "+ name);
		System.out.println("the age is "+ age);
		System.out.println("the info is "+ info);
	}
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}

}
