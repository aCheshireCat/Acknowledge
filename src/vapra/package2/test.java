package vapra.package2;

import vapra.package2.Rectangle;

public class test {
	public static void main(String args[]){
		Rectangle a = new Rectangle(3,6);
			a.display();
		Rectangle b;
			b = a.scale(3);
			b.display();
			a.display();
//		Rectangle c;
//			c = a.scale(3,'w');
//			c.display();
			
		
	}

}
