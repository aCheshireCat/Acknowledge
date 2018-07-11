package Singleton;

public class HungrySingleton {
		//构造函数私有化
        private   static   final HungrySingleton   singleton   =   new   HungrySingleton   (); 
        private   HungrySingleton   (){
        	
        } 
        public   HungrySingleton   getInstance(){
        	return   singleton;
        } 
}   




