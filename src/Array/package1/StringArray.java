package Array.package1;
public class StringArray 
{
public static void main (String[] args)
{
   //java�����ʼ��
   String[] strArray={"1","2","3"};
   //���java����
   for(int i=0;i<strArray.length;i++)
   {
    System.out.println(strArray[i]);//������ 1 2 3
   }

   //�޸�java����ĵڶ���Ԫ��Ϊ a
   strArray[1]="a";

   //Java����ĳ���
   int arrayLength=strArray.length;

//   ���java����
   for(int i=0;i<strArray.length;i++)
   {
    System.out.println(strArray[i]);//������ 1 a 3
   }
}
}
