package String.package3;

import java.io.UnsupportedEncodingException;

public class strDemo {
	public static void main(String args[]) throws UnsupportedEncodingException {
		String x =new String();
		x = "aaaa";
		String y = new String("aaaa"); 
		System.out.println(x);
		System.out.println(x.equals(y));
		System.out.println(x==y);
		
		
		byte[] a = {48,48,48,48,48,48,48,48};
		byte[] c = {48,48,48,48,48,48,48,48};
		byte[] b = "abcdefg".getBytes("GBK");
		byte[] d = null;
		System.arraycopy(b, 0, a, 0, b.length);
		System.arraycopy(b, 0, c, c.length-b.length, b.length);
		
		System.arraycopy(b, 0, d, 0, b.length);
		System.out.println(b.length);
		System.out.println(a.length);
		System.out.println(d.length);
		System.out.println(new String(a));
		System.out.println(new String(c));
	}

}
