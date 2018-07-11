package Classes.package5;

public class test {
	public static void main(String[] args){
		
		
//		BaseClass PloymophicBC = new BaseClass();
//		SubClass subPloymophicBC = new SubClass();
//		PloymophicBC = subPloymophicBC;
		
		BaseClass PloymophicBC = new SubClass();
		
		System.out.println(PloymophicBC.book);
		PloymophicBC.base();
		PloymophicBC.test();
		
	}

}
