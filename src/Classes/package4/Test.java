package Classes.package4;

//������캯������
class Person
{
private String name="";
private int age=0;

public Person()
{
   System.out.println("person�޲������캯��");
}

public Person(String name,int age)
{
   this.name=name;
   this.age=age;
   System.out.println("person 2 �����Ĺ��캯��");  
}
} 

class Student extends Person
{

private String school;
private String grade;

public Student()
{
   System.out.println("student �޲����Ĺ��캯��");
}

public Student(String name ,int age,String school)
{
   System.out.println("student 3 �����Ĺ��캯��");
}
    public   Student(String name ,int age,String school,String grade)
{
   super(name,age);
   this.school=school;
   this.grade=grade;
   System.out.println("student 4 �����Ĺ��캯����super().");
}
}

public class Test
{
public static void main(String[] args)
{
   System.out.println("st1:");
   Student st2=new Student();
   System.out.println("---------------------------");
     
   System.out.println("st2:");
   Student st=new Student("zhangsan",76,"university");
   System.out.println("---------------------------");
  
   System.out.println("st3:");
   Student st3=new Student("lisi",24,"university","Student");

}
} 

/*
=======================================
st1:
person�޲������캯��
student �޲����Ĺ��캯��
---------------------------
st2:
person�޲������캯��
student 3 �����Ĺ��캯��
---------------------------
st3:
person 2 �����Ĺ��캯��
student 4 �����Ĺ��캯����super().

*************************************
**/

