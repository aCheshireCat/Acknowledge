package Model.Factory;

//	 开始生产产品

	 

	 public class BuidlerTest {
	 	public static void main(String[] a){
	 		//创造不同的Builder
	 		Builder builder1 = new CarBuilder();
	 		Builder builder2 = new BusBuilder();
	 		Builder builder3 = new TruckBuilder();
	 		
	 		//Director使用不同的Builder，最终得到不同的产品
	 		Director director = new Director(builder3);
	 		director.construct();
	 		AbstractProduct product = builder3.getProduct();
	 		product.print();
	 	}
	 } 


class Director {
			private Builder builder;
			public Director(Builder builder){
				this.builder = builder ;
			}
			public void construct(){
				builder.buildMotor();
				builder.buildWheels();
				builder.paintColor();
			}
		}

