package ru.sbt;

import ru.sbt.myExceptions.*;

public class TerminalImpl implements Terminal {

    private final TerminalServer server = new TerminalServer();

    private final PinValidator pinValidator = new PinValidator();
    private int numberOfWrongPins = 0;
    private long unlockTime = System.currentTimeMillis() - 1;
    private boolean pinIsEntered = false;

    private void checkIfPinIsEntered() {
        if (!pinIsEntered) {
            throw new PinIsNotEnteredException("Pin is not entered");
        }
        pinIsEntered = false;
    }


    @Override
    public boolean getAccess(int pin) {
        if (System.currentTimeMillis() < unlockTime) {
            throw new LockedException("Your account is still locked, it will be unlocked at " + unlockTime);
        }
        if (pinValidator.validatePin(pin)) {
            pinIsEntered = true;
            return true;
        }

        numberOfWrongPins++;
        if (numberOfWrongPins == 3) {
            numberOfWrongPins = 0;
            unlockTime = System.currentTimeMillis() + 5000;
            throw new LockedException("You entered wrong pin 3 times. Account will be unlocked at " + unlockTime);
        }
        throw new WrongPinException("Wrong pin, " + (3 - numberOfWrongPins) + " attempts left");
    }

    @Override
    public int getBalance() {
        checkIfPinIsEntered();
        return server.getBalance();
    }


    @Override
    public void putMoney(int money) {
        checkIfPinIsEntered();
        if (money % 100 != 0) {
            throw new WrongAmountOfMoneyException("Wrong amount of money");
        }
        server.putMoney(money);
    }

    @Override
    public void takeMoney(int money) {
        checkIfPinIsEntered();
        if (money % 100 != 0) {
            throw new WrongAmountOfMoneyException("Wrong amount of money");
        }
        int balance = server.getBalance();
        if (balance < money) {
            throw new NotEnoughMoneyException("Not enough money on your account");
        }
        server.takeMoney(money);
    }
}
