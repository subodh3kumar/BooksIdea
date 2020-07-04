package workshop.chapter11.v1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ShopMain {

    public static void main(String[] args) {
        Shop shop = new Shop("BestShop");

        long start = System.nanoTime();
        Future<Double> future = shop.getPriceAsync("my favorite product");
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("invocation returned after " + invocationTime + " msecs");

        doSomethingElse();

        try {
            double price = future.get();
            System.out.printf("price is %.2f%n", price);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("price returned after " + retrievalTime + " msecs");
    }

    private static void doSomethingElse() {
        System.out.println("doing something else...");
    }
}


