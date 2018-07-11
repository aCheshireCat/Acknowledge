package Interface.package1;

public class ComputerTime {
	public static void main(String args[]){
		
		System.out.println("-------------------");	
		String[] Arr = {"car","123","231","111"};
		double a = Double.parseDouble(Arr[1]);//是以字符串形式传进来的，所以要进行一次数据类型转化
		double b = Double.parseDouble(Arr[2]);
		double c = Double.parseDouble(Arr[3]);
		   double v,t;
           try {
                 Common d=(Common) Class.forName("CalTime.vehicle."+Arr[0]).newInstance();
                 v=d.CountTime(a,b,c);
                 t=1000/v;
                 System.out.println("平均速度: "+v+" km/h");
                 System.out.println("运行时间："+t+" 小时");
           }  catch(Exception e){
                 System.out.println("class not found");
           }


		
	}
	
	
}
