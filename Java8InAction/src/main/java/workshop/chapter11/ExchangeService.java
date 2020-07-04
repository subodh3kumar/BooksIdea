package workshop.chapter11;

public class ExchangeService {

    public enum Money {
        USD(1.0), EUR(1.35387), GBP(1.69715), CAD(.92106), MXN(.07683);

        private final double rate;

        Money(double rate) {
            this.rate = rate;
        }
    }

    public static double getRate(Money source, Money dest) {
        return getRateWithDelay(source, dest);
    }

    private static double getRateWithDelay(Money source, Money dest) {
        Utils.delay();
        return dest.rate / source.rate;
    }
}
