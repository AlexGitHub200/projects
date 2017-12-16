/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testjp;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author alex
 */
public class Trade {

        Date timestamp;
        long shareq;
        boolean buy;
        double price;
        String symbol;
        

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public void setShareq(long shareq) {
        this.shareq = shareq;
    }

    public void setBuy(boolean buy) {
        this.buy = buy;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
        

        public Date getTimestamp() {
            return timestamp;
        }

        public long getShareq() {
            return shareq;
        }

        public boolean isBuy() {
            return buy;
        }

        public double getPrice() {
            return price;
        }

        public String getSymbol() {
            return symbol;
        }

        @Override
        public boolean equals(Object o) {
            if ((o instanceof Trade) && (((Trade) o).symbol.equalsIgnoreCase(this.symbol))) {
                if (((Trade) o).timestamp.equals(this.timestamp)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 17 * hash + Objects.hashCode(this.timestamp);
            hash = 17 * hash + Objects.hashCode(this.symbol);
            return hash;
        }

    }