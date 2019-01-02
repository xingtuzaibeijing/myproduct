import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author QianHuaSheng
 * @version V1.0
 * @description
 * @date 2018/11/9
 */
public class CacheTest {


	public AtomicInteger count;
	public static volatile Map<String, String> dataMap = new HashMap();

	static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	static Lock r = rwl.readLock();
	static Lock w = rwl.writeLock();
	//读方法
	public static void read(String key) throws InterruptedException {
		r.lock();
		System.out.println("正在读取。。key：" + key + "开始");
		Thread.sleep(100);
		String s = dataMap.get(key);
		System.out.println("正在读取。。key：" + key+"value:"+ s+ "结束");
		r.unlock();
	}

	//写方法
	public static void write(String key, String value) throws InterruptedException {
		w.lock();
		System.out.println("正在写入。。value：" + value + "开始");
		Thread.sleep(100);
		dataMap.put(key, value);
		System.out.println("正在写入。。value：" + value + "结束");
		w.unlock();
	}

	//定义count
	public static void main(String[] args) {
		//写入
		new Thread(new Runnable() {
			public void run() {
				for(int i=0,len=10;i<len;i++){
					try {
						CacheTest.write(i+"",i+"");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		//读取
		new Thread(new Runnable() {
			public void run() {
				for(int i=0,len=10;i<len;i++){
					try {
						CacheTest.read(i+"");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}
