package stringclass.stringBuffer;

public class StringBufferTest {
	public static void main(String[] args) {

		StringBuffer db =new StringBuffer(2);
	
		db.insert(0, "abcdefghijklmn");
	
		System.out.println(db);
	
	}
}
