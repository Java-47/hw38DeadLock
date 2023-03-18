package telran.deadlock.controller;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import telran.deadlock.model.DeadLockTask;

public class DeadLockApl {
	private static final Lock lock1 = new ReentrantLock();
	private static final Lock lock2 = new ReentrantLock();

	public static void main(String[] args) {
		
		DeadLockTask task1 = new DeadLockTask(lock1, lock2);
		DeadLockTask task2 = new DeadLockTask(lock2, lock1);

		Thread thread1 = new Thread(task1);
		Thread thread2 = new Thread(task2);

		thread1.start();
		thread2.start();
	}
}