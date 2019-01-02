import java.util.concurrent.ConcurrentHashMap;

/**
 * @author QianHuaSheng
 * @version V1.0
 * @description
 * @date 2018/11/5
 */
public class StopThread {
	public static void main(String[] args) {
		StopRunable stopRunable = new StopRunable();
		Thread thread = new Thread(stopRunable);
		thread.start();
		for (int i = 0, len = 300; i < len; i++) {
			if (i ==200) {
				System.out.println("-----------------------------------------");
				thread.interrupt();
			}
		}
	}
}


class StopRunable implements Runnable {

	public synchronized void run() {
		if(true){
			try {
				ConcurrentHashMap concurrentHashMap=new ConcurrentHashMap();
				concurrentHashMap.put("1","测试");
				concurrentHashMap.get("1");
				System.out.println("上锁");
				this.wait();
				System.out.println("开锁");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}