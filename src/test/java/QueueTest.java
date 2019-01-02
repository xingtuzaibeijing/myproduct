import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author QianHuaSheng
 * @version V1.0
 * @description
 * @date 2018/11/7
 */
public class QueueTest {
	public static void main(String[] args) throws InterruptedException {
		LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>();
		//生产者 往阻塞队列中添加消息
		AtomicInteger count = new AtomicInteger(1);
		LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
		ProducerThread producerThread = new ProducerThread(linkedBlockingQueue, count);
		ConsumerThread consumerThread = new ConsumerThread(linkedBlockingQueue, count);
		//消费者从队列获取消息
		Thread producer = new Thread(producerThread);
		Thread consumber = new Thread(consumerThread);
		producer.start();
		consumber.start();
		Thread.sleep(10*1000);
		producer.stop();
	}
}

class ProducerThread implements Runnable {

	private AtomicInteger count;
	LinkedBlockingQueue linkedBlockingQueue;

	ProducerThread(LinkedBlockingQueue linkedBlockingQueue, AtomicInteger count) {
		this.linkedBlockingQueue = linkedBlockingQueue;
		this.count = count;
	}

	public void run() {
		while (1 == 1) {
			System.out.println("正在产生消息");
			boolean offer = linkedBlockingQueue.offer(count.incrementAndGet());
			if (offer) {
				System.out.println("生产成功");
			}
			if (!offer) {
				System.out.println("生产失败");
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}

class ConsumerThread implements Runnable {

	private AtomicInteger count;
	LinkedBlockingQueue linkedBlockingQueue;

	ConsumerThread(LinkedBlockingQueue linkedBlockingQueue, AtomicInteger count) {
		this.linkedBlockingQueue = linkedBlockingQueue;
		this.count = count;
	}

	public void run() {
		//循环消费
		while (1 == 1) {
			try {
				String poll = (String) (linkedBlockingQueue.take()+"");
				if (poll == null) {
					System.out.println("读取队列失败");
				}
				if (poll != null) {
					System.out.println("读取队列成功 数据为：" + poll);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		//消费消费
	}
}
