package ru.sbt;

public class TerminalServer {
    private int balance = 500;

    public int getBalance() {
        return balance;
    }

    public void putMoney(int money) {
        this.balance += money;
    }

    public void takeMoney(int money) {
        this.balance -= money;
    }
}
