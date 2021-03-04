package array;

import java.util.ArrayList;
import java.util.List;

public class BuyAndSellStocksTwice {

    public static double buyAndSellStockTwice (List<Double> prices) {
        double maxProfit = 0.0;
        double minPrice = Double.MAX_VALUE;
        List<Double> firstBuySellProfits = new ArrayList<>();
        for (int i=0;i<prices.size();i++) {
            maxProfit = Math.max(maxProfit,prices.get(i) - minPrice);
            minPrice = Math.min(minPrice,prices.get(i));
            firstBuySellProfits.add(maxProfit);
        }

        double maxPrice = Double.MIN_VALUE;
        for(int i= prices.size() -1;i>0;i--) {
            maxPrice = Math.max(maxPrice,prices.get(i));
            maxProfit = Math.max(maxProfit,maxPrice - prices.get(i) + firstBuySellProfits.get(i-1));
        }
        return maxProfit;
    }
    public static void main (String [] args) {
        List<Double> prices = new ArrayList<>();
        prices.add(12.0);
        prices.add(11.0);
        prices.add(13.0);
        prices.add(9.0);
        prices.add(12.0);
        prices.add(8.0);
        prices.add(14.0);
        prices.add(13.0);
        prices.add(15.0);

        System.out.println(buyAndSellStockTwice(prices));
    }
}
