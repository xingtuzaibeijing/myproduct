import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author QianHuaSheng
 * @version V1.0
 * @description
 * @date 2018/11/5
 */
public class LockThread {
	public static void main(String[] args) {
		//最开始执行in in输入一条
		LockRes lockRes = new LockRes();
		Condition condition = lockRes.getLock().newCondition();
		InLockThread inRunable = new InLockThread(lockRes,condition);
		OutLockThread outRunable = new OutLockThread(lockRes, condition);
		Thread inThread = new Thread(inRunable);
		Thread outThread = new Thread(outRunable);
		inThread.start();
		outThread.start();
		//再执行out out 输出一条
	}
}

class InLockThread implements Runnable {

	private LockRes lockRes;
	private Condition condition;
	public InLockThread(LockRes lockRes,Condition condition) {
		this.lockRes = lockRes;
		this.condition=condition;
	}

	public void run() {
		try {
			lockRes.getLock().lock();
			while (true) {
				if (lockRes.isFlag()) {
					try {
						condition.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(lockRes.getCount());
				if (lockRes.getCount() % 2 == 0) {
					lockRes.setName("小明");
					lockRes.setSex("男");
				} else {
					lockRes.setName("小红");
					lockRes.setSex("女");
				}
				lockRes.setCount(lockRes.getCount() + 1);
				lockRes.setFlag(!lockRes.isFlag());
				condition.signal();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lockRes.getLock().unlock();
		}
	}
}


class OutLockThread implements Runnable {

	private LockRes lockRes;
	private Condition condition;
	public OutLockThread(LockRes lockRes,Condition condition) {
		this.lockRes = lockRes;
		this.condition=condition;
	}

	public void run() {
		try {
			lockRes.getLock().lock();
			while (true) {
				if (!lockRes.isFlag()) {
					try {
						condition.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(lockRes.getName() + lockRes.getSex());
				lockRes.setFlag(!lockRes.isFlag());
				condition.signal();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lockRes.getLock().unlock();
		}
	}

}


class LockRes {
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