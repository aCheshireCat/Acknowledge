package Classes.package2;
public class subClassTestCarryDemo {
	public static void main(String args[]){
	
		subClassTestDemo subTest = new subClassTestDemo();
		subTest.setSex("male");
		subTest.setBirth("2012-2-3");//Ҫ����package1�µ�setBirth��������Ϊpublic
		subTest.setCloth("blue");
		subTest.setShoes("white");
		
		subTest.getAge();

		System.out.println(subTest.getBirth()+"\n"+subTest.getCloth());
		
		
	}

}
