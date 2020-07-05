package workshop.chapter11.v1;

import workshop.chapter11.ExchangeService;
import workshop.chapter11.ExchangeService.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PriceFinder {

    private final List<Shop> shops = getShopInfo();

    private final Executor executor = Executors.newFixedThreadPool(shops.size(), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            return thread;
        }
    });

    public List<String> findPriceSequential(String product) {
        return shops.stream()
                .map(shop -> shop.getName() + " price is " + shop.getPrice(product))
                .collect(Collectors.toList());
    }

    public List<String> findPriceParallel(String product) {
        return shops.parallelStream()
                .map(shop -> shop.getName() + " price is " + shop.getPrice(product))
                .collect(Collectors.toList());
    }

    public List<String> findPriceFuture(String product) {
        List<CompletableFuture<String>> futures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getName() + " price is " + shop.getPrice(product), executor))
                .collect(Collectors.toList());
        return futures.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

    public List<String> findPriceInUsd(String product) {
        List<CompletableFuture<Double>> futures = new ArrayList<>();

        for (Shop shop : shops) {
            CompletableFuture<Double> futurePrice = CompletableFuture.supplyAsync(() -> shop.getPrice(product))
                    .thenCombine(CompletableFuture.supplyAsync(() -> ExchangeService.getRate(Money.EUR, Money.USD)), (price, rate) -> price * rate);
            futures.add(futurePrice);
        }
        return futures.stream()
                .map(CompletableFuture::join)
                .map(price -> "price is " + price)
                .collect(Collectors.toList());
    }

    public List<String> findPriceInUsd2(String product) {
        List<CompletableFuture<String>> priceFutures = new ArrayList<>();
        for (Shop shop : shops) {
            CompletableFuture<String> futurePriceUsd = CompletableFuture.supplyAsync(() -> shop.getPrice(product))
                    .thenCombine(CompletableFuture.supplyAsync(() -> ExchangeService.getRate(Money.EUR, Money.USD)), (price, rate) -> price * rate)
                    .thenApply(price -> shop.getName() + " price is " + price);

            priceFutures.add(futurePriceUsd);
        }

        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    public List<String> findPriceInUsd3(String product) {
        Stream<CompletableFuture<String>> stream = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product))
                .thenCombine(CompletableFuture.supplyAsync(() -> ExchangeService.getRate(Money.EUR, Money.USD)), (price, rate) -> price * rate)
                .thenApply(price -> shop.getName() + " price is " + price));

        List<CompletableFuture<String>> priceFutures = stream.collect(Collectors.toList());

        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    public List<String> findPriceInUsdJava7(String product) {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Future<Double>> futurePrices = new ArrayList<>();
        for (Shop shop : shops) {

            final Future<Double> futureRate = executor.submit(new Callable<Double>() {
                @Override
                public Double call() throws Exception {
                    return ExchangeService.getRate(Money.EUR, Money.USD);
                }
            });

            Future<Double> futurePriceUsd = executor.submit(new Callable<Double>() {
                @Override
                public Double call() throws Exception {
                    double priceEur = shop.getPrice(product);
                    return priceEur * futureRate.get();
                }
            });

            futurePrices.add(futurePriceUsd);
        }
        List<String> prices = new ArrayList<>();
        for (Future<Double> futurePrice : futurePrices) {
            try {
                prices.add("price is " + futurePrice.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return prices;
    }

    private List<Shop> getShopInfo() {
        return List.of(
                new Shop("BestPrice"),
                new Shop("LetsSaveBig"),
                new Shop("MyFavoriteShop"),
                new Shop("BuyItAll") /*, new Shop("ShopEasy") */
        );
    }
}
