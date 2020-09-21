package workshop.chapter03;

import workshop.model.Apple;
import workshop.util.ApplePredicate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lambdas {

    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Hello !!!");
        runnable.run();

        List<Apple> apples = Apple.getApples();

        List<Apple> greenApples = filter(apples, (Apple apple) -> "green".equals(apple.getColor()));
        System.out.println(greenApples);

        System.out.println("------------");

        List<Apple> apples2 = new ArrayList<>(apples);
        apples2.sort(Comparator.comparingInt(Apple::getWeight));
        System.out.println(apples2);
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
}