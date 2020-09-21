package workshop.chapter02;

import workshop.model.Apple;
import workshop.util.ApplePredicate;

public class AppleColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
