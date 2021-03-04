package array;

import java.util.ArrayList;
import java.util.List;

public class BuyAndSellStockOnce {
    public static double computeMaxProfile (List<Double> prices) {
        double minPrice = Double.MAX_VALUE;
        double maxProfit = 0.0;
        for (Double price: prices) {
            maxProfit = Math.max(maxProfit,price - minPrice);
            minPrice = Math.min(minPrice,price);
        }
        return maxProfit;
    }
    public static void main (String [] args) {
        List<Double> prices = new ArrayList<>();
        prices.add(310.0);
        prices.add(315.0);
        prices.add(275.0);
        prices.add(295.0);
        prices.add(260.0);
        prices.add(270.0);
        prices.add(290.0);
        prices.add(230.0);
        prices.add(255.0);
        prices.add(250.0);

        System.out.print(computeMaxProfile(prices));
    }
}
