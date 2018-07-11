package IO.package1;
import java.io.*;

public class FileSeqAccess {
	public static void main(String args[]){
		File fileObj = new File("e:\\TestIn.txt");
		FileInputStream inObj;
		FileOutputStream outObj;
		FileCopy classObj;
		
			try {
				fileObj.createNewFile();
				inObj = new FileInputStream("e:\\TestIn.txt");
				outObj = new FileOutputStream("e:\\TestOut.txt");
				System.out.println("-----------------------");
				System.out.println("this context is test.txt");
				classObj = new FileCopy(inObj,outObj); 
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			} catch(IOException e){
				e.printStackTrace();
				System.out.println(e);
			
			}

			
		
		
	}

}
