package telran.deadlock.model;

import java.util.concurrent.locks.Lock;

public class DeadLockTask implements Runnable {
	private Lock lock1;
	private Lock lock2;

	public DeadLockTask(Lock lock1, Lock lock2) {
		this.lock1 = lock1;
		this.lock2 = lock2;
	}

	public void run() {
		lock1.lock();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lock2.lock();

	}
}
