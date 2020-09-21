package workshop.chapter02;

import workshop.model.Apple;
import workshop.util.ApplePredicate;

import java.util.ArrayList;
import java.util.List;

public class FilteringApples {

    public static void main(String[] args) {
        List<Apple> apples = Apple.getApples();

        List<Apple> greenApples = filterByColor(apples, "green");
        System.out.println(greenApples);

        System.out.println("------------");

        List<Apple> redApples = filterByColor(apples, "red");
        System.out.println(redApples);

        System.out.println("------------");

        List<Apple> greenApples2 = filter(apples, new AppleColorPredicate());
        System.out.println(greenApples2);

        System.out.println("------------");

        List<Apple> heavyApples = filter(apples, new AppleWeightPredicate());
        System.out.println(heavyApples);

        System.out.println("------------");

        List<Apple> redApples2 = filter(apples, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor());
            }
        });
        System.out.println(redApples2);
    }

    private static List<Apple> filter(List<Apple> apples, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    private static List<Apple> filterByColor(List<Apple> apples, String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }
}
