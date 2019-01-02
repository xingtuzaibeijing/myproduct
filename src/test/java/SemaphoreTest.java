import java.util.concurrent.Semaphore;

/**
 * @author QianHuaSheng
 * @version V1.0
 * @description
 * @date 2018/11/7
 */
public class SemaphoreTest {
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(3);
		SemaphoreThread semaphoreThread;
		for (int i = 0, len = 10; i < len; i++) {
			semaphoreThread = new SemaphoreThread(i + "位老表", semaphore);
			Thread thread = new Thread(semaphoreThread);
			thread.start();
		}
	}
}


class SemaphoreThread implements Runnable {

	public Semaphore semaphore;

	public String name;


	public SemaphoreThread(String name, Semaphore semaphore) {
		this.name = name;
		this.semaphore = semaphore;
	}

	public void run() {
		if (semaphore.availablePermits() > 0) {
			System.out.println(name + "皇帝登基了");
		} else {
			System.out.println("皇帝没有茅坑");
		}
		try {
			semaphore.acquire();
			System.out.println(name + "登基中");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			//使用完退出坑位
			semaphore.release();
		}
	}
}

