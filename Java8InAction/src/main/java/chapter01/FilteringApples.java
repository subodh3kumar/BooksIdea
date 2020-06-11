package chapter01;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilteringApples {

    public static void main(String[] args) {
        List<Apple> apples = List.of(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        // Green Apples using Method Reference
        List<Apple> greenApples = filterApples(apples, FilteringApples::isGreenApple);
        greenApples.forEach(System.out::println);

        System.out.println("--------------");

        // Heavy Apple using Method Reference
        List<Apple> heavyApples = filterApples(apples, FilteringApples::isHeavyApple);
        heavyApples.forEach(System.out::println);

        System.out.println("--------------");

        // Green Apples without Method Reference
        List<Apple> greenApples2 = filterApples(apples, (Apple apple) -> "green".equals(apple.getColor()));
        greenApples2.forEach(System.out::println);

        System.out.println("--------------");

        // Heavy Apples without Method Reference
        List<Apple> heavyApples2 = filterApples(apples, (Apple apple) -> apple.getWeight() > 150);
        heavyApples2.forEach(System.out::println);
    }

    private static List<Apple> filterApples(List<Apple> apples, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    private static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }
}


