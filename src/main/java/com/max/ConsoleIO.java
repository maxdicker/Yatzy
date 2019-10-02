package com.max;

import java.util.Scanner;

public class ConsoleIO implements IO {

    private Scanner keyboardInput = new Scanner(System.in);

    @Override
    public String read() {
        return keyboardInput.nextLine();
    }

    @Override
    public void write(String s) {
        System.out.println(s);
    }
}
