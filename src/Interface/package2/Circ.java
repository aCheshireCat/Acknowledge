package Interface.package2;

public class Circ implements Calculate ,GeometryShape{
		
	public float getArea(float r){
		System.out.println("PI = 3.14159：area is " + Calculate.PI*r*r);
		return Calculate.PI*r*r;
	}
	public float getCircumference(float r){
		System.out.println("PI = 3.14159：length is " + 2*Calculate.PI*r);
		return 2*Calculate.PI*r;
	}

	//	完成了Calculate接口下所有方法的实现
	public void draw(){
		System.out.println("draw a circle");
	}
	public float getArea(int r){
		return GeometryShape.PI*r*r;
	}
	public float getCircumference(int  r){
		return 2*GeometryShape.PI*r;
	}
}
