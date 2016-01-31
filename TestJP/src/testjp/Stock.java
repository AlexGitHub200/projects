/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testjp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class Stock{
         String symbol;
         String type;
         double ldivdent;
         double fdivident;
         int parvalue;
         int tprice;
         double dyield;

    public double getPeratio() {
        return peratio;
    }

    public void setPeratio(double peratio) {
        this.peratio = peratio;
    }
         double peratio;

    public double getDyield() {
        return dyield;
    }

    public void setDyield(double dyield) {
        this.dyield = dyield;
    }

    public int getTprice() {
        return tprice;
    }

    public void setTprice(int tprice) {
        this.tprice = tprice;
    }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public double getLdivdent() {
            return ldivdent;
        }

        public void setLdivdent(double ldivdent) {
            this.ldivdent = ldivdent;
        }

        public double getFdivident() {
            return fdivident;
        }

        public void setFdivident(double fdivident) {
            this.fdivident = fdivident;
        }

        public int getParvalue() {
            return parvalue;
        }

        public void setParvalue(int parvalue) {
            this.parvalue = parvalue;
        }
        
        
        public void calcDivident() {
            if(type.contains("Common"))
                dyield =ldivdent / (double) tprice;
            else
                dyield = fdivident * parvalue / (double) (tprice *100);

    }

    public void calcPeRatio() {

        if (dyield != 0) {
            peratio= tprice / (double) dyield;
        } else {
            peratio= 0;
        }
    }
        
    }
