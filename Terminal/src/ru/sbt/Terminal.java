package ru.sbt;

public interface Terminal {

    int getBalance();

    boolean getAccess(int pin);

    void putMoney(int money);

    void takeMoney(int money);
}
