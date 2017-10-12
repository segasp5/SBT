package ru.sbt.myExceptions;

public class WrongPinException extends RuntimeException {
    public WrongPinException(String s) {
        super(s);
    }
}
