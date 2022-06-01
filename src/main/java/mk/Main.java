package mk;

import mk.config.ReadProperties;
import mk.domain.Card;
import mk.domain.Ranges;
import mk.excel.XLSXReader;
import mk.util.Riffle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) throws IOException {


        ReadProperties readProperties = new ReadProperties();
//        String xlsx = readProperties.getPropValues().getProperty("xlsx");
        File dir = new File(readProperties.getPropValues().getProperty("outFiles"));
        String writeFile = readProperties.getPropValues().getProperty("createdFile");
        Riffle rif = new Riffle();
        List<Card> cards = rif.parser(rif.read(dir));
        List<String> list = new ArrayList<>();
        for (Card card : cards) {
            if(rif.checkRange(Long.parseLong(card.getPan()))) {
                list.add(card.getDate());
            }
        }
        rif.counting(list, writeFile);


    }
}







