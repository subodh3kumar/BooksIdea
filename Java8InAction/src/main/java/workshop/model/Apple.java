package workshop.model;

import java.util.List;

public final class Apple {

    private int weight;
    private String color;

    public Apple() {
    }

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }

    public static List<Apple> getApples() {
        return List.of(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red")
        );
    }
}
