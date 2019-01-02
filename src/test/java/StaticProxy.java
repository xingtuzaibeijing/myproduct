/**
 * @author QianHuaSheng
 * @version V1.0
 * @description
 * @date 2018/12/10
 */
public class StaticProxy {
	public static void main(String[] args) {
		Aodi aodi = new Aodi();
		new BuyCar(aodi).sale();
	}
}

class Car {
	public void sale() {
		System.out.println("买买买");
	}
}

class Aodi extends Car {
	@Override
	public void sale() {
		System.out.println("买了个奥迪双钻");
	}
}

class BuyCar {
	private Car car;

	public BuyCar(Car car){
		this.car=car;
	}

	public void sale(){
		car.sale();
	}
}
