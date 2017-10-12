package ru.sbt.myExceptions;

public class WrongAmountOfMoneyException extends RuntimeException {
    public WrongAmountOfMoneyException(String s) {
        super(s);
    }
}
