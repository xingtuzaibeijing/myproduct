import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author QianHuaSheng
 * @version V1.0
 * @description
 * @date 2018/11/5
 */
public class WaitThread {
	public static void main(String[] args) {
		//最开始执行in in输入一条
		Res res = new Res();
		InThread inRunable = new InThread(res);
		OutThread outRunable = new OutThread(res);
		Thread inThread = new Thread(inRunable);
		Thread outThread = new Thread(outRunable);
		inThread.start();
		outThread.start();
		//再执行out out 输出一条

	}
}

class InThread implements Runnable {

	private Res res;

	public InThread(Res res) {
		this.res = res;
	}

	public void run() {
		synchronized (res) {
			while (true) {
				if (res.isFlag()) {
					try {
						res.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(res.getCount());
				if (res.getCount() % 2 == 0) {
					res.setName("小明");
					res.setSex("男");
				} else {
					res.setName("小红");
					res.setSex("女");
				}
				res.setCount(res.getCount() + 1);
				res.setFlag(!res.isFlag());
				res.notify();
			}
		}
	}
}

class OutThread implements Runnable {

	private Res res;

	public OutThread(Res res) {
		this.res = res;
	}

	public void run() {
		synchronized (res) {
			while (true) {
				if (!res.isFlag()) {
					try {
						res.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(res.getName()+res.getSex());
				res.setFlag(!res.isFlag());
				res.notify();
			}
		}
	}
}

class Res {
	private String name;
	private String sex;

	private Lock lock = new ReentrantLock();

	private boolean flag=false;

	private Integer count=0;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Lock getLock() {
		return lock;
	}

	public void setLock(Lock lock) {
		this.lock = lock;
	}
}