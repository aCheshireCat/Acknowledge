package Singleton;

public class LazySingleton {
		
		private static String name;
		private static int age;
		
	
		private LazySingleton(String nam,int ag){
			LazySingleton.name = nam ;
			LazySingleton.age = ag;
		}
        private   static   LazySingleton   singleton   =   null; 
        public   static   synchronized   LazySingleton   getInstance(String name,int age){ 
        	
                  if(singleton==null){ 
                          singleton   =   new   LazySingleton(name,age); 
                  } 
                return   singleton; 
        }
        public void display(){
        	System.out.println("element:" + this.name + ":" + this.age);        	
        }
        public String getName(){
        	return name;
        }
        public int getAge(){
        	return age;
        }
}  




