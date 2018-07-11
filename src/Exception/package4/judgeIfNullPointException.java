package Exception.package4;

public class judgeIfNullPointException {
	static void  demo(){
		try{
			throw new NullPointerException("demo");
		}catch(NullPointerException e){
			System.out.println("Caught inside demo");
			throw e;
		}
	}
	
	
	
	public static void main(String[] args){
//		try{
//			demo();
//		}catch(NullPointerException e){
//			System.out.println("Recaught"+ e);
//		}


		String str = null;
		if(str!=null && str.length()>0)
		{
			System.out.println("&& not null");
		}
		if(str==null || str.length()<0)
		{
			System.out.println("|| not null");
		}
		//
		if(str!=null & str.length()>0)
		{

		}
		if(str==null | str.length()<0)
		{

		}
	}

	
	
}