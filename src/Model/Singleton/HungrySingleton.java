package Singleton;

public class HungrySingleton {
		//���캯��˽�л�
        private   static   final HungrySingleton   singleton   =   new   HungrySingleton   (); 
        private   HungrySingleton   (){
        	
        } 
        public   HungrySingleton   getInstance(){
        	return   singleton;
        } 
}   




