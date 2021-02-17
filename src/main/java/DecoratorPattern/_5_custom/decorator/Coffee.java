package DecoratorPattern._5_custom.decorator;

public abstract class Coffee implements Beverage {
    protected String description = "Unknown Coffee";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
