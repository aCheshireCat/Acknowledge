package dataStructure;

/**
 * Created by Administrator on 2018/6/22.
 * @see recursive call
 */
public class recursive {

    public static void main(String[] args) {

        cul(5);
        culModelTwo(5);
    }


    public static double fact(int n) {
        double ret = 0;
        if (n > 1)
            ret = n * (fact(n - 1));
        else
            ret = 1;
        return ret;
    }

    public static void cul(int n)
    {
        System.out.println(fact(5));
        double sum = 0.0d;
        for(int i=1 ; i<=5;i++)
        {
            sum += 1/(fact(i));
        }
        System.out.println(sum);
    }

    public static double factModelTwo(int n)
    {
        double dn = n;
        double res = 0.0d;
        if(n>1)
        {
//            System.out.println(1/dn);
            res =  ((1/dn) * (factModelTwo(n-1)));
        }else
        {
            res = 1;
        }
        return res;
    }
    public static void culModelTwo (int n)
    {
        double sum=0;
        for (int i = 1; i <= n; i++) {
//            System.out.println("the " + i + " time cul;");
            sum += factModelTwo(i);
        }
        System.out.println("sum:" + sum);
    }

}
