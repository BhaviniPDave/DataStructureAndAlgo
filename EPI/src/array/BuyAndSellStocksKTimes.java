package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuyAndSellStocksKTimes {

    public static double buyAndSellStocksKTimes (List<Double> prices,int k) {
        if(k == 0) {
            return 0.0;
        }
        else if (2 * k >= prices.size()){
            return unlimitedPairsProfit (prices);
        }

        List<Double> minPrices = new ArrayList<>(Collections.nCopies(k,Double.MAX_VALUE));
        List<Double> maxProfits = new ArrayList<>(Collections.nCopies(k,0.0));

        for (Double price: prices) {
            for (int i = k-1;i>=0;i--) {
                maxProfits.set(i,Math.max(maxProfits.get(i),price-minPrices.get(i)));
                minPrices.set(i,Math.min(minPrices.get(i),price - (i > 0 ?maxProfits.get(i-1):0.0)));
            }
        }

        return maxProfits.get(maxProfits.size() -1);
    }

    private static double unlimitedPairsProfit (List<Double> prices) {
        double profit = 0.0;
        for (int i=1;i<prices.size();i++) {
            profit += Math.max(0.0, prices.get(i) - prices.get(i-1));
        }
        return profit;
    }

    public static void main (String [] args) {
        List<Double> prices = new ArrayList<>();
        prices.add(225.0);
        prices.add(220.0);
        prices.add(230.0);
        prices.add(245.0);
        prices.add(235.0);
        prices.add(230.0);
        prices.add(250.0);
        prices.add(260.0);
        prices.add(210.0);
        prices.add(200.0);
        prices.add(245.0);
        prices.add(255.0);
        prices.add(240.0);

        System.out.println(buyAndSellStocksKTimes(prices,3));
    }
}
