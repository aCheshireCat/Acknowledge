package Interface.package4;
public class TestUsb {

 
	public static void main(String[] args) {

	  Computer computer = new Computer();
	  Camera camera1 = new Camera();
	  SuperMp3 Mp3 =new SuperMp3();
	  System.out.println("ͨ������ʵ������ӿ�");
	  System.out.println("����ͨ������USBʵ������ӿ�");
	  computer.useUsb(camera1);
	  System.out.println("���ͨ������WIFIʵ������");
	  computer.usewifi(camera1);
	  System.out.println("Mp3ͨ������WIFIʵ������");
	  computer.useWifi(Mp3);
	  
 }

}


