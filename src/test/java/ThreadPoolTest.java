import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author QianHuaSheng
 * @version V1.0
 * @description 线程池
 * @date 2018/11/8
 */
public class ThreadPoolTest {
	public static void main(String[] args) {
//		缓存的线程池
//		ExecutorService executorService = Executors.newCachedThreadPool();
//		for (int i = 0, len = 10; i < len; i++) {5
//			final int  tmp=i;
//			executorService.execute(new Thread(new Runnable() {
//				public void run() {
//					System.out.println(Thread.currentThread().getName() + "  个线程"+tmp);
//				}
//			}));
//		}

//		ExecutorService executorService = Executors.newFixedThreadPool(3);
//		for (int i = 0; i < 10; i++) {
//			final int  tmp=i;
//			executorService.execute(new Runnable() {
//				public void run() {
//					System.out.println(Thread.currentThread().getName()+"i:"+tmp);
//				}
//			});
//		}

		ExecutorService executorService = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors()*2);
		for (int i = 0; i < 10; i++) {
			final int tmp = i;
			((ScheduledExecutorService) executorService).schedule(new Runnable() {
				public void run() {
					System.out.println(Thread.currentThread().getName() + "i:" + tmp);
				}
			},3,TimeUnit.SECONDS);
		}
//		Executors.newCachedThreadPool();
//		Executors.newFixedThreadPool();
//		Executors.newScheduledThreadPool();
//		Executors.newSingleThreadExecutor();
//		executorService.shutdown();
	}
}
