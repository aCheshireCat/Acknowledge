package Classes.package1;

public class classTestSubDemo extends classTestDemo{
	
	private String sex;
	private String birth;
	
	
	public void setSex(String sex){
		this.sex = sex;
	}
	public void setBirth(String birth){
		this.birth = birth;
	}
	protected String getSex(){
//		System.out.println(sex);
		return sex;
	}
	public String getBirth(){
//		System.out.println(birth);
		return birth;
	}
	

}
