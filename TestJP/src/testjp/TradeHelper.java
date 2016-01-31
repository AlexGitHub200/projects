/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testjp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author alex
 */
public class TradeHelper {
    
    
    
    
    public  HashMap<String, Double> calcStockPrice(HashSet<Trade> stockset) {

        HashMap<String, Helpersum> stockPriceHelper = new HashMap<String, Helpersum>();

        for (Trade stock : stockset) {

            Helpersum item = new Helpersum();
            double d = stock.getPrice() * stock.getShareq();

            if (stockPriceHelper.get(stock.getSymbol()) == null) {
                item.setPriceq(d);
                item.setSumquantity(stock.getShareq());
                stockPriceHelper.put(stock.getSymbol(), item);
            } else {
                item.setPriceq(stockPriceHelper.get(stock.getSymbol()).getPriceq() + d);
                item.setSumquantity(stockPriceHelper.get(stock.getSymbol()).getSumquantity() + stock.getShareq());
                stockPriceHelper.put(stock.getSymbol(), item);
            }

        }

        HashMap<String, Double> stockPrice = new HashMap<String, Double>();

        for (Map.Entry<String, Helpersum> entry : stockPriceHelper.entrySet()) {
            String key = entry.getKey();
            double result = entry.getValue().getPriceq() / (double) entry.getValue().getSumquantity();

            stockPrice.put(key, result);
        }

        return stockPrice;
    }

    public double calcGeometricMean(HashMap<String, Double> stocs) {

        double result = 1.0;
        stocs.size();

        for (Map.Entry<String, Double> entry : stocs.entrySet()) {

            result = entry.getValue() * result;
        }

        return Math.pow(result, 1 / stocs.size());
    }

    class Helpersum {

        double priceq;

        public double getPriceq() {
            return priceq;
        }

        public void setPriceq(double priceq) {
            this.priceq = priceq;
        }

        public long getSumquantity() {
            return sumquantity;
        }

        public void setSumquantity(long sumquantity) {
            this.sumquantity = sumquantity;
        }
        long sumquantity;

    }
    
    
}
