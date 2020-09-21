package workshop.chapter02;

import workshop.model.Apple;
import workshop.util.ApplePredicate;

public class AppleWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
