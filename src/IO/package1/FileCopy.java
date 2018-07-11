package IO.package1;
import java.io.*;

class FileCopy {
	FileCopy(FileInputStream inStr,FileOutputStream outStr){
		int Len;
		byte[] Buf = new byte[12]; 
		try{
			while((Len = inStr.read(Buf,0,12))!=-1){
				String copyStr = new String(Buf);
				System.out.println(copyStr);
				outStr.write(Buf,0,Len);
				
			}
		} catch(IOException e){
			System.out.printf("error:" + e);
			
		}
		
		
	}
}
