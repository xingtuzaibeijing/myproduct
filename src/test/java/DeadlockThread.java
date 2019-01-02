public class DeadlockThread {
	public static void main(String[] args) {
		ExtendsThread extendsThread = new ExtendsThread();
		Thread window1 = new Thread(extendsThread, "窗口一");
		Thread window2 = new Thread(extendsThread, "窗口一");
		window1.start();
		extendsThread.booFalg = false;
		window2.start();
	}
}

class ExtendsThread extends Thread {
	Boolean booFalg = true;

	private Integer count = 100;

	@Override
	public void run() {
		//如果booFalg 为true先拿一把锁
		//false少拿一把锁
		//当flase执行的时候true 也进的去
		if (booFalg) {
			synchronized (count) {
				while (count > 0) {
					sale();
				}
			}
		} else {
			sale();
		}
	}

	private void sale() {
		synchronized (count) {
			synchronized (booFalg) {
				System.out.println(Thread.currentThread().getName() + "正在出售" + count + "第张票");
				count--;
			}
		}
	}
}

class ImplThread implements Runnable {

	public void run() {
	}
}
