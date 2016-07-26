package com.china.gavin.javabase.thread;

public class BankAccount {
	private int amount;
	private int balance;

	public BankAccount(int amount, int balance) {
		this.amount = amount;
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}

	public synchronized void deposit(int amount) {
		// public void deposit(int amount) {
		balance = balance + amount;
	}

	public synchronized void withdraw(int amount) {
		// public void withdraw(int amount) {
		balance = balance - amount;
	}

	public static void main(String[] args) throws InterruptedException {
		BankAccount a = new BankAccount(1, 1000);
		Thread t1 = new Thread(new Depositor(a, 100), "depositor");
		Thread t2 = new Thread(new Withdrawer(a, 100), "withdraw");
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(a.getBalance());
	}

	static class Depositor implements Runnable {
		BankAccount account;
		int amount;

		public Depositor(BankAccount account, int amount) {
			this.account = account;
			this.amount = amount;
		}

		@Override
		public void run() {
			for (int i = 0; i < 100001; i++)
				account.deposit(amount);
		}
	}

	static class Withdrawer implements Runnable {
		BankAccount account;
		int amount;

		public Withdrawer(BankAccount account, int amount) {
			this.account = account;
			this.amount = amount;
		}

		@Override
		public void run() {
			for (int i = 0; i < 100000; i++)
				account.withdraw(amount);
		}
	}
}
