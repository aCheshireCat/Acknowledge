package Array.package1;
public class StringArray 
{
public static void main (String[] args)
{
   //java数组初始化
   String[] strArray={"1","2","3"};
   //输出java数组
   for(int i=0;i<strArray.length;i++)
   {
    System.out.println(strArray[i]);//输出结果 1 2 3
   }

   //修改java数组的第二个元素为 a
   strArray[1]="a";

   //Java数组的长度
   int arrayLength=strArray.length;

//   输出java数组
   for(int i=0;i<strArray.length;i++)
   {
    System.out.println(strArray[i]);//输出结果 1 a 3
   }
}
}
