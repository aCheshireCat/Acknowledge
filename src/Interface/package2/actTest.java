package Interface.package2;

public class actTest {

	public static void main(String args[]){
		
		Circ obj = new Circ();
		int r = 13;
		float R = 13.2f;
		float area = obj.getArea(r);
		float length = obj.getCircumference(r);
		System.out.println("PI = 3��area is " + area);
		System.out.println("PI = 3��length is " + length);
		//���������㣻
		obj.draw();
		obj.getArea(R);
		obj.getCircumference(R);
		//�������أ�������������Ϊfloat;
	}
}
