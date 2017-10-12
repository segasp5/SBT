package ru.sbt;

public class PinValidator {
    private final int pinCode = 1234;

    public boolean validatePin(int pin){
        return this.pinCode == pin;
    }
}
