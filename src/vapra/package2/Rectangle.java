package vapra.package2;

public class Rectangle {
	int width;
	int height;
	Rectangle(int width,int height){
		this.width = width;
		this.height = height;
	}
	Rectangle(){
		
	}
	void display(){
		System.out.println("width:" + width);
		System.out.println("height:" + height);
	}
	Rectangle scale(int s){
		Rectangle r = new Rectangle(width*s,height*s);	//创建新的内存空间来存放声明的对象
		return r;
		
//		width = width *s;
//		height = height *s;
//		return this;
	}
	Rectangle scale(int s, char type){
		Rectangle r = null;
		if(type == 'w')
			r = new Rectangle(width*s,height);
		else if(type == 'h')
			r = new Rectangle(width,height*s);
		else 
			System.out.println("input type error");
		return r;
	}	
	
//	Rectangle scale(int s, char type){
//		if(type == 'w')
//			width = width *s;
//		else if(type == 'h')
//			height = height *s;
//		else 
//			System.out.println("input type error");
//		return this;
//	}
	
	

}
