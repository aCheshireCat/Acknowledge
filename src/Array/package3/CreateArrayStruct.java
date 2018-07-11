package package3;

public class CreateArrayStruct {

//		int a[];
		private int ArrayIntName[] = new int[10];
		private String[] ArrayStringName;
		public void init(){
			int i,j;
			for(i=0;i<10;i++)
				ArrayIntName[i] = i;
			ArrayStringName = new String[10];
			for(j=0;j<10;j++)
				ArrayStringName[j] =  "a"+j;
			
		}
		public void print(){
			int i,j;
			for(i=0;i<10;i++)
			System.out.println(ArrayIntName[i]);
			for(j=0;j<10;j++)
			System.out.println(ArrayStringName[j]);
	
		}
}
