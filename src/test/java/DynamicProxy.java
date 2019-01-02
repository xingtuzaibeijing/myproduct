import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author QianHuaSheng
 * @version V1.0
 * @description
 * @date 2018/12/10
 */
public class DynamicProxy {
	public static void main(String[] args) {
		Villa villa=new Villa();
		HouseProxy houseProxy=new HouseProxy(villa);
		Hose hose = (Hose) Proxy.newProxyInstance(villa.getClass().getClassLoader(), villa.getClass().getInterfaces(), houseProxy);
		hose.sale();
	}
}

interface  Hose {
	public void sale();
}

class  Villa implements Hose {
	@Override
	public void sale() {
		System.out.println("买了个大别墅");
	}
}

class HouseProxy implements InvocationHandler {
	private  Object tarjet;

	public HouseProxy(Object tarjet){
		this.tarjet=tarjet;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("我是房产中介.....开始监听你买房啦!");
		Object invoke = method.invoke(tarjet, args);
		System.out.println("我是房产中介.....结束监听你买房啦!");
		return invoke;
	}
}
