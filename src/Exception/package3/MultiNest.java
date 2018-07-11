package Exception.package3;

	class MultiNest { 
		static void procedure() { 
		try { 
		int a = 0; 
		int b = 42/a; 
		} catch(java.lang.ArithmeticException e) { 
		System.out.println("in procedure, catch ArithmeticException: " +e); 
		} 
		} 
		public static void main(String args[]) { 
		try { 
		procedure(); 
		} catch(java.lang. Exception e) { 
		System.out.println("in main, catch Exception: " +e); 
		} 
	}
}



