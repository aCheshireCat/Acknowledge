package Interface.package3;

public class newInMember implements structInfo,getDetail{
	private String name;
	private int ID;
	private int age;
	private String info;
	public void setInfo(String name,int ID,int age,String info){
		this.name = name;
		this.ID = ID;
		this.age = age;
		this.info = info;		
	}
	public String getName(){
		return name;
	}
	public int getID(){
		return ID;
	}
	public int getAge(){
		return age;
	}
	public String getInfo(){
		return info;
	}
}
