package Model.Factory;

//	 ��ʼ������Ʒ

	 

	 public class BuidlerTest {
	 	public static void main(String[] a){
	 		//���첻ͬ��Builder
	 		Builder builder1 = new CarBuilder();
	 		Builder builder2 = new BusBuilder();
	 		Builder builder3 = new TruckBuilder();
	 		
	 		//Directorʹ�ò�ͬ��Builder�����յõ���ͬ�Ĳ�Ʒ
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

