package String.StringTokenizer;

import java.util.StringTokenizer;

public class StringTokenizerTest {
	public static void main(String[] args) {
	
	String s = new String("this is a test");
	StringTokenizer st = new StringTokenizer(s," ",true);
//	StringTokenizer st = new StringTokenizer(s," ",false);
	
	System.out.println( "Token Total: " + st.countTokens() );
	
	while( st.hasMoreElements() )
	{
	System.out.println( st.nextToken() );
	}
	
	
	}

}
