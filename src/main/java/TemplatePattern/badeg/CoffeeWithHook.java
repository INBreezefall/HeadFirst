package TemplatePattern.badeg;

import TemplatePattern.greateg.CaffeineBeverage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeeWithHook extends CaffeineBeverage {
    @Override
    public void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }

    @Override
    public void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    @Override
    protected boolean condition() {
        return "y".equals(getUserInput());
    }

    private String getUserInput() {
        String answer = null;

        System.out.println("Would you like milk and sugar with you coffee (y/n)?");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = in.readLine();
        } catch (IOException ioe) {
            System.err.println("IO error trying to read your answer");
        }

        if (answer == null)
            return "n";
        return answer;
    }
}
