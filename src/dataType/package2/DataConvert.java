package dataType.package2;

public class DataConvert {
	int ele = 100;
	byte ele_2 = 99;
	byte ele_3 = 44;
	byte ele_4 =(byte)(ele_2+ele_3);
	long ele_5 = 999999999999L;
	long i = 199999;
	int s=4;
	
	public void play(){
		switch(s) {
		case 2 :System.out.println("----------");
				break;
			
		}
	}
	public static void main(String[] args) {
		
		byte[] a= {'2','2'};
		byte b[] = new byte[]{(byte)0xef,(byte)0x14};
		b=a;
		System.out.println(a.length);
		System.out.println(b.length + "|" + new String(b));

		char aa = 'a';
		byte bb = (byte)aa;
		System.out.println(bb);

		
	}
}
