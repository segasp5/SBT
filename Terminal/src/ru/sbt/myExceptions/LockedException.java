package ru.sbt.myExceptions;

public class LockedException extends RuntimeException {
    public LockedException(String s) {
        super(s);
    }
}
