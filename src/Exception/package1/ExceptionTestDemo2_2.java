package package1;
import java.io.*;
public class ExceptionTestDemo2_2 {
	public static void main(String args[]) throws IOException {
		
		FileInputStream streamObj = new FileInputStream("readem.txt");
		System.out.println("File Accessing!");
		
	}

}
//抛出例外，可编译，但不能执行！