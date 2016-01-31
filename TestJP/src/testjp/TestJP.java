/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class TestJP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {

        double mean;
        ArrayList<Stock> listData = new ArrayList<Stock>();

        readStockData(listData);

        for (Stock st : listData) {
            st.calcDivident();
            st.calcPeRatio();
            
            System.out.println("Stock ("+st.getSymbol()+ ") Yield ("+ st.getDyield()+ ") P/E ratio ("+ st.getPeratio()+")" );
        }

        
        
        HashSet<Trade> stockset = new HashSet<Trade>();

        readTradeData(stockset);

        TradeHelper tHelp = new TradeHelper();
        HashMap<String, Double> calcStockPrices;
        calcStockPrices = tHelp.calcStockPrice(stockset);
        mean = tHelp.calcGeometricMean(calcStockPrices);

        for (Map.Entry<String, Double> entry : calcStockPrices.entrySet()) {
            System.out.println("Stock " + entry.getKey() + " price " + entry.getValue());
        }

        System.out.println("GBCE Share Index = " + mean);

        //otan erthie einia Date date = dt.parse(date_s); 
//        Calendar rightNow = Calendar.getInstance();
//        int hour = rightNow.get(Calendar.HOUR_OF_DAY);
//        int min = rightNow.get(Calendar.MINUTE);
//
//        //rightNow.get
//        Date timestamp = rightNow.getTime();
        //HashSet<String> stocknames  = new HashSet<String>();
        // ArrayList <Trade> as= new ArrayList<Trade>();
    }

    public static void readStockData(ArrayList<Stock> listData) {

        try {
            File file = new File(ClassLoader.getSystemResource("data.txt").getFile());
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {

                String[] a = line.split(",");

                Stock item = new Stock();
                item.setSymbol(a[0]);
                item.setType(a[1]);
                item.setLdivdent(Double.parseDouble(a[2]));
                if (a[3].equals("") == false) {
                    item.setFdivident(Double.parseDouble(a[3]));
                }
                item.setParvalue(Integer.parseInt(a[4]));
                item.setTprice(Integer.parseInt(a[5]));
                listData.add(item);

//                int i = 0;
//                for (String s : a) {
//
//                    System.out.println("a[" + i + "]= " + s);
//                    i++;
//
//                }
                line = br.readLine();

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestJP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestJP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void readTradeData(HashSet<Trade> listData) throws ParseException {

        try {
            File file = new File(ClassLoader.getSystemResource("trades.txt").getFile());
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {

                String[] a = line.split(",");

                Trade item = new Trade();
                item.setSymbol(a[0]);
                item.setShareq(Long.parseLong(a[1]));
                if (a[2].equals("buy")) {
                    item.setBuy(true);
                } else {
                    item.setBuy(false);
                }

                item.setPrice(Double.parseDouble(a[3]));

                SimpleDateFormat dt = new SimpleDateFormat("YYYY/MM/DD/hh/mm");
                item.setTimestamp(dt.parse(a[4]));
                listData.add(item);

//                int i = 0;
//                for (String s : a) {
//
//                    System.out.println("a[" + i + "]= " + s);
//                    i++;
//
//                }
                line = br.readLine();

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestJP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestJP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
