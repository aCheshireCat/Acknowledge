package IO;

import java.io.File;
import java.io.IOException;


public class CreatNewFile {

	public static void main(String args[]){
		File a = new File("f:/demo.java");
		try {
			a.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
