package Interface.package4;

public class SuperMp3 implements Usb, Wifi {

	public void start() {
		// TODO Auto-generated method stub
		System.out.println("MP3正常接入电脑");

	}

	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("MP3正常停止工作");
	}

	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("MP3通过wifi连接");
	}

}
