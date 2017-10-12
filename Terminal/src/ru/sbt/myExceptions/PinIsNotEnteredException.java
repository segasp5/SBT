package ru.sbt.myExceptions;

public class PinIsNotEnteredException extends RuntimeException {
    public PinIsNotEnteredException(String s) {
        super(s);
    }
}
