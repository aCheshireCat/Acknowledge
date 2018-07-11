package Exception.package1;
import java.io.*;
public class ExceptionTestDemo2 {
	public static void main(String args[]){
		try{
			FileInputStream streamObj = new FileInputStream("readem.txt");
			
		}catch(IOException x){
			System.out.println("File Accessing");	//提示信息
		}

		
		
	}

}
