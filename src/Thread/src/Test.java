package Thread.src;
import java.util.concurrent.*;

import java.io.*;

public class Test {
//	public static void main(String[] args) throws Exception {
//		FileWriter fw = new FileWriter("111.txt");
//		BufferedWriter bw = new BufferedWriter(fw);
//		for(int i=1; i<= 25; i++) {
//			if(i%5 == 0) bw.newLine();
//			bw.write(i + " ");
//		}
//
//		bw.flush();
//		bw.close();
//	}

	public static void main(String[] args) throws Exception {
		new Test().createThread();
	}

	public Status createThread() throws Exception
	{
		Status finalStatus = new Status(false);
		int threadSize = 3;
		try
		{

			ExecutorService pool = Executors.newFixedThreadPool(threadSize);
			for (int i = 0; i < threadSize; i++) {
				pool.execute(new Runnable(){
					@Override
					public void run() {
						System.out.println("Asynchronous task");
					}
				});
			}
			pool.shutdown();
			finalStatus.setStatus(true);

		}catch (Exception ex)
		{
			finalStatus.setMsg(ex.getMessage());
			return finalStatus;
		}

		return finalStatus;
	}

}

class  Status{
	public boolean status = false;
	public String msg = "";

	public Status(boolean status) {
		System.out.println("this is status constructor with paramters ");
		this.status = status;
	}

	public Status() {
		System.out.println("this is status constructor without paramters ");
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}