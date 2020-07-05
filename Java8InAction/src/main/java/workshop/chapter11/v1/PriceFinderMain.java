package workshop.chapter11.v1;

import java.util.List;
import java.util.function.Supplier;

public class PriceFinderMain {

    private static PriceFinder priceFinder = new PriceFinder();

    public static void main(String[] args) {
        execute("sequential", () -> priceFinder.findPriceSequential("myPhone27S"));
        System.out.println("-------------");
        execute("parallel", () -> priceFinder.findPriceParallel("myPhone27S"));
        System.out.println("-------------");
        execute("composed CompletableFuture", () -> priceFinder.findPriceFuture("myPhone27S"));
        System.out.println("-------------");
        execute("combined USD CompletableFuture", () -> priceFinder.findPriceInUsd("myPhone27S"));
        System.out.println("-------------");
        execute("combined USD CompletableFuture v2", () -> priceFinder.findPriceInUsd2("myPhone27S"));
        System.out.println("-------------");
        execute("combined USD CompletableFuture v3", () -> priceFinder.findPriceInUsd3("myPhone27S"));
        System.out.println("-------------");
        execute("combined USD Future Java 7", () -> priceFinder.findPriceInUsdJava7("myPhone27S"));
    }

    private static void execute(String msg, Supplier<List<String>> supplier) {
        long start = System.nanoTime();
        List<String> list = supplier.get();
        list.forEach(System.out::println);
        long duration = ((System.nanoTime() - start) / 1_000_000);
        System.out.println(msg + " done in " + duration + " msecs");
    }
}
