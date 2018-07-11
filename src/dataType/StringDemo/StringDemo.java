package dataType.StringDemo;

import java.io.UnsupportedEncodingException;

public class StringDemo {
	
	public static String ELEMENT_SPACE = " ";
	public static String ELEMENT_ZERO = "0";
	public static void main(String[] args) throws UnsupportedEncodingException {
		
//		String limit = "12";
//		
//		String code = "";
//		
//		byte[] bytes = code.getBytes("GBK");
//		
//		char[] chars = new char[10];
//		
//		code.getChars(0, code.length(), chars, 0);
//		
//		System.out.println(chars);
//		
//		System.out.println(bytes);
//		
//		System.out.println(String.format("%-"+ String.valueOf(1)+limit + "s", code) + "-------");
//		System.out.println(String.format("%" + limit +"s", code) + "-------");
//
//		
//		char[] a = {'c','£ã'};
//		String b = "c£ã";
//		System.out.println(a + "|" + b);
//		System.out.println(a.length + "|" + b.getBytes("GBK").length);
//		
//		String space = " ";
//		System.out.println(space.equals(" "));
		
//		if(code != null && code.length() >= 5)
//    	{
//    		int length = code.length();
//    		StringBuffer sbTemp = new StringBuffer(8);
//    		sbTemp.append(code.substring(length - 5, length));
//    		
//    		int i = 0;
//    		while(8 - length - i > 0)    		
//    		{
//    			i++;
//				sbTemp.append("0");
//    		}
//    		
//			sbTemp.append(code.substring(0, length - 5));
//			System.out.println(code);
//			System.out.println(sbTemp.toString());
//	  
//    	}
	  
		String name=null;
		System.out.println(addSpecialElementByLeft(name,10,ELEMENT_SPACE,true) + "--");
		System.out.println(addSpecialElementByLeft(name,10,ELEMENT_ZERO,true) + "--");
		System.out.println(addSpecialElementByLeft("",10,ELEMENT_SPACE,true) + "--");
		System.out.println(addSpecialElementByLeft("",10,ELEMENT_ZERO,true) + "--");
		System.out.println(addSpecialElementByLeft("abcbc",10,ELEMENT_SPACE,false) + "--");
		System.out.println(addSpecialElementByLeft("123",10,ELEMENT_ZERO,true) + "--");
		System.out.println(addSpecialElementByLeft("abcbc",10,ELEMENT_SPACE,false) + "--");
		
		String ab="";
		System.out.println(ab.getBytes("GBK").length);
	}
	
    public static String addSpecialElementByLeft(String name, int limitLength,String specialChar,boolean addSpecialLeft){
    	if(isNotNull(specialChar))
    	{
    		StringBuffer sb = null;
    		if(!isNotNull(name))
    		{
    			sb = new StringBuffer();
    			for(int i=0;i<limitLength;i++){
    				sb.append(specialChar);
    			}
    			name = sb.toString();
    		}else{
    			int strLen = name.length();
    			if (strLen < limitLength) {
    				while (strLen < limitLength) {
    					sb = new StringBuffer();
    					if(addSpecialLeft)
    						sb.append(specialChar).append(name);//×ó²¹0
    					else
    						sb.append(name).append(specialChar);//ÓÒ²¹0
    					name = sb.toString();
    					strLen = name.length();
    				}
    			}
    		}
    		return name;
    	}else{
    		return name;
    	}
    }
    public static boolean isNotNull(String aInputStr) {
        if (aInputStr == null || aInputStr.equals("")) {
            return false;
        }else return true;
    }

}
