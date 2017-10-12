package ru.sbt;

import ru.sbt.myExceptions.LockedException;
import ru.sbt.myExceptions.PinIsNotEnteredException;
import ru.sbt.myExceptions.WrongPinException;

public class Test {
    public static void main(String[] args) {
        TerminalImpl terminal = new TerminalImpl();

        //not entering pin
        try {
            terminal.getBalance();
        } catch (PinIsNotEnteredException e) {
            System.out.println(e.getMessage());
        }

        terminal.getAccess(1234);
        System.out.println(terminal.getBalance());

        //wrong pin once
        try {
            terminal.getAccess(1111);
            System.out.println(terminal.getBalance());
        } catch (WrongPinException e) {
            System.out.println(e.getMessage());
        }

        //wrong pin 1 more times
        try {
            terminal.getAccess(1111);
            System.out.println(terminal.getBalance());
        } catch (WrongPinException e) {
            System.out.println(e.getMessage());
        }

        //wrong pin for 3 times
        try {
            terminal.getAccess(1111);
            System.out.println(terminal.getBalance());
        } catch (LockedException e) {
            System.out.println(e.getMessage());
        }

        //wrong pin for 4 times - locked account
        try {
            terminal.getAccess(1111);
            System.out.println(terminal.getBalance());
        } catch (LockedException e) {
            System.out.println(e.getMessage());
        }

    }
}
