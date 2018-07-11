package Array;


public class test {
	public static void main(String[] args){
		

	int numObj;
	int arrayNum;
	FactoricalTest classObj = new FactoricalTest();
	classObj.setValue(4);
	numObj = classObj.getValue();
	arrayNum = classObj.getBitNum(numObj);
	classObj.init(arrayNum);
	classObj.calculate(numObj);
	classObj.Print(arrayNum);
	}

}
