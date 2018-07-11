package Interface.package4;
public class TestUsb {

 
	public static void main(String[] args) {

	  Computer computer = new Computer();
	  Camera camera1 = new Camera();
	  SuperMp3 Mp3 =new SuperMp3();
	  System.out.println("通过电脑实现这个接口");
	  System.out.println("下面通过电脑USB实现这个接口");
	  computer.useUsb(camera1);
	  System.out.println("相机通过电脑WIFI实现连接");
	  computer.usewifi(camera1);
	  System.out.println("Mp3通过电脑WIFI实现连接");
	  computer.useWifi(Mp3);
	  
 }

}


