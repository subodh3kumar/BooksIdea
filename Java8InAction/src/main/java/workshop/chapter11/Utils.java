package workshop.chapter11;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Random;

public class Utils {

    private static final Random RANDOM = new Random(0);
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.US));

    public static void delay() {
        int delay = 1000;
        //int delay = 500 + RANDOM.nextInt(2000);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static double format(double number) {
        synchronized (DECIMAL_FORMAT) {
            return Double.parseDouble(DECIMAL_FORMAT.format(number));
        }
    }
}
