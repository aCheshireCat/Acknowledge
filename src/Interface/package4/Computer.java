package Interface.package4;

public class Computer {
	public void useUsb(Usb usb){	//使用接口
		usb.start();
		usb.stop();
		
	}
	public void useWifi(Wifi wifi){
		wifi.start();
		wifi.stop();
		wifi.insert();
		
	}
	public void usewifi(Usb usb){
		usb.start();
		usb.stop();
	}
	
	
	
}
