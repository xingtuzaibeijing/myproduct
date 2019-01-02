import java.util.concurrent.CountDownLatch;

/**
 * @author QianHuaSheng
 * @version V1.0
 * @description
 * @date 2018/11/6
 */
public class CountDownLatchTest {
	public static void main(String[] args) {
		CountDownLatch countDownLatch1=new CountDownLatch(1);
		CountDownLatch countDownLatch2=new CountDownLatch(1);
		Thread1 thread11 = new Thread1();
		//线程一 扣一的count
		thread11.countDownLatch=countDownLatch1;
		Thread thread1 = new Thread(thread11);
		//线程二 等待线程一 扣二
		Thread2 thread21 = new Thread2();
		thread21.countDownLatch=countDownLatch2;
		thread21.awiatCountDownLatch=countDownLatch1;
		Thread thread2 = new Thread(thread21);
		//线程三 等二
		Thread3 thread31 = new Thread3();
		thread31.awiatCountDownLatch=countDownLatch2;
		Thread thread3 = new Thread(thread31);
		thread1.start();
		thread2.start();
		thread3.start();

	}
}


class Thread1 implements  Runnable{
	CountDownLatch countDownLatch;
	public void run() {
		countDownLatch.countDown();
		System.out.println("线程一开始执行");
	}
}

class Thread2 implements  Runnable{
	CountDownLatch countDownLatch;
	CountDownLatch awiatCountDownLatch;
	public void run() {
		try {
			awiatCountDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		countDownLatch.countDown();
		System.out.println("线程二开始执行");

	}
}

class Thread3 implements  Runnable{
	CountDownLatch awiatCountDownLatch;
	public void run() {
		try {
			awiatCountDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("线程三开始执行");
	}
}