import java.util.Arrays;

/**
 * @author QianHuaSheng
 * @version V1.0
 * @description
 * @date 2018/11/5
 */
public class Test {
	public static void main(String[] args) {
//		TestThread testThread=new TestThread();
//		Thread thread1=new Thread(testThread,"线程一");
//		Thread thread2=new Thread(testThread,"线程二");
//		Thread thread3=new Thread(testThread,"线程三");
//		thread1.start();
//		thread2.start();
//		thread3.start();
//		int a = 0;
//		System.out.println(a);
//		Integer a=120;
//		Integer b=120;
//		System.out.println(a==b);
//		String a = "测试2";
//		final String b = "测试";
//		String c = b + "2";
//		System.out.println(c == a);

//		EntityOrder  order=new EntityOrder();
//		order.setRname("测试");
//		Integer a=1;
//		System.out.println("调用方法前");
//		outSms(order);
//		outSms(a);
//		System.out.println("调用方法后");
//		System.out.println(order.getRname());
//		System.out.println(a);
//		StringBuffer stringBuffer=new StringBuffer("12");
//		stringBuffer.append(21212);
//		StringBuilder stringBuilder=new StringBuilder("12");
//		stringBuilder.append("12");
//		SimpleDateFormat sdf=new SimpleDateFormat();
//		sdf.parse();
//		boolean b=true;

//		String.valueOf()
//		String s = Stringb + "1";
//		System.out.println(s);
//		System.out.println("//g.us.sinaimg.cn/000vNbhUlx07mINyxQI0010402001Alo0k010.mp4?Expires=1543550643&ssig=xFiQeq8EcE&KID=unistore,video");
		Integer[] a = new Integer[1];
		a[0] = 1;
		a=Arrays.copyOf(a, 3);
		a[1] = 2;
		System.out.println(a[2]);
//		StringBuffer stringBuffer=new StringBuffer();
//		stringBuffer.append();
	}

//	public static void outSms(EntityOrder order) {
//		System.out.println("调用方法EntityOrder");
//		order.setRname("今天是个好日子");
//	}
//	public static void outSms(Integer sms) {
//		System.out.println("调用方法String");
//		sms=2;
//	}
}

class TestThread implements Runnable {

	public Boolean flag = true;
	public Integer count = 1;

	public void run() {
		synchronized (flag) {
			if (count % 3 != 0) {
				try {
					String name = Thread.currentThread().getName();
					count++;
					System.out.println(Thread.currentThread().getName() + "我被人锁了");
					flag.wait();
					System.out.println(Thread.currentThread().getName() + "我被人放了");

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				flag.notify();
//				System.out.println(Thread.currentThread().getName()+"我被人放了");
			}
		}
	}
}

