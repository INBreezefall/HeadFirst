package TemplatePattern.greateg.subclass;

import TemplatePattern.greateg.CaffeineBeverage;

public class Coffee extends CaffeineBeverage {
    @Override
    public void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }

    @Override
    public void brew() {
        System.out.println("Dripping Coffee through filter");
    }
}
