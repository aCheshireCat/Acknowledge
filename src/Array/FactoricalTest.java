package Array;

import java.lang.Math;
public class FactoricalTest {
	int n;
	int[] displayArray;
	void setValue(int value){		//设置整个数组的值
		n = value;	
	}
	int getValue(){					//得到整个数组的值
		return n;
	}
	int getBitNum(int n){		//获得n!的位数
		double sum = 1.0;
		for(int i = 1;i<=n;i++)
			sum += Math.log(i)/Math.log(10);
		return (int)sum;
	}
	void init(int r){		//用于计算n!的值
		displayArray = new int[r];
		displayArray[0] = 1;
		for(int i=1;i<r;i++)
			displayArray[i] = 0;
	}
	void calculate(int n){		//用于计算n!的值
		int pos = 0;
		for(int i = 2;i<=n;i++){
			double addPlus = 0;
			int bitcount = getBitNum(n);
			if(displayArray[pos] == 0)
					pos = pos+1;
			for(int j = pos;j<bitcount;j++)
			{
				addPlus += i*displayArray[j];
				displayArray[j] = (int)(addPlus*10);
				addPlus /=10;
			}
			
		}
	}
	void Print(int n){
		int bit = 0;
		for(int i = n-1;i>=0;i--){
			if(bit*30==0)
				System.out.print("\n第"+(bit/30+1)+"个30位：");
			System.out.print(displayArray[i]);
			bit++;
		}
		
		
	}
	

}
