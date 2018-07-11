package dataType.StringDemo;

import java.io.UnsupportedEncodingException;

public class stringConvertByte {

	public static String str = null;
	
	public static byte[] by = null;
	
	public static void main(String[] args) throws UnsupportedEncodingException {
			
	
		by = new byte[]{(byte)0xef,(byte)0x14};
		
		System.out.println(by[0] + "|"+ by[1]);
		
//		str = new String(by,"GBK");
		
		str = "hello world!ÄãºÃ";
		String stnum = "123";
		
		System.out.println(str);
		System.out.println(str.substring(0,	 3));
		System.out.println(str.substring(3,	 5));
		byte[] a = str.getBytes("GBK");
//		System.out.println(stnum.getBytes("GBK"));
		
	}
	
}
