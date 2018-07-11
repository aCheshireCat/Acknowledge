package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.io.InputStream;

public class TCPClient extends Thread {


	public void run() {
		try {
			Socket socket = new Socket("172.30.165.29", 8888);
			OutputStream ous = socket.getOutputStream();
			InputStream ins = socket.getInputStream();
			BufferedReader r = new BufferedReader(new InputStreamReader(ins, "UTF-8"));
			
			// ���ͷ�����
			ous.write(">>>>>>>>>>>>>>>>".getBytes("UTF-8"));
			ous.flush();
			// ���ո�������
			System.out.println(">>>> " + r.readLine());
			
			// ���ͷ�����
			ous.write("<<<<<<<<<<<<<<<<".getBytes("UTF-8"));
			ous.flush();
			// ���շ�����
			System.out.println(">>>> " + r.readLine());
			
			Thread.sleep(3*1000);
			
			ins.close();
			ous.close();
			socket.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 3; i++) {
			try {
				new TCPClient().start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
}