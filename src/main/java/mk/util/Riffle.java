package mk.util;

import mk.domain.Card;
import mk.domain.Ranges;
import mk.excel.XLSXReader;
import org.apache.commons.lang3.Range;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Riffle {

    public List<String> read(File dir) throws IOException {
        File[] files = dir.listFiles();
        if(files == null){
            throw new RuntimeException("Files is not found");
        }
        List<String> list = new ArrayList<>();
        for (File file : files) {
            if(file.isFile()) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    String line;
                    while((line = bufferedReader.readLine()) != null){
                        list.add(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    public List<String> read(String fileName){
        List<String> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            list = stream
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Card> parser(List<String> list){
        List<Card> cards = new ArrayList();
        for (String element : list) {
            if(element != null && element.length() > 21)
                cards.add(new Card(element.substring(1, 17), element.substring(70, 78)));
        }
        return cards;
    }

    public void counting(List<String> list, String file) throws IOException {

        FileWriter writer = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        Map<String, List<String>> collect = list.stream()
                .collect(Collectors.groupingBy(o -> o));
        collect.entrySet()
                .forEach(e -> {
                    try {
                        bufferedWriter.write(e.getKey() + " - " + e.getValue().size() + "\n\n");
                    } catch (IOException io) {
                        io.printStackTrace();
                    }
                });
        bufferedWriter.close();
        System.out.println("Success");
    }



    public Boolean checkRange(Long card){
        boolean check;
        if(Range.between(4301608010501000L, 4301608010699999L).contains(card)    //  Pensiya
                || Range.between(4301700000400000L, 4301700000599999L).contains(card)
                || Range.between(5227580000440000L, 5227580000639999L).contains(card)
                || Range.between(5574330000500000L, 5574330000799999L).contains(card)
                || Range.between(6798360000460000L, 6798360000559999L).contains(card)   // End Pensiya
                || Range.between(4301608010820000L, 4301608011319999L).contains(card)  //  Start  Tələbə
                || Range.between(4301700000700000L, 4301700000799999L).contains(card)
                || Range.between(4301700000901000L, 4301700000911009L).contains(card)
                || Range.between(4301700001011020L, 4301700001111029L).contains(card)
                || Range.between(5227580000640000L, 5227580000939999L).contains(card)
                || Range.between(5574330000850000L, 5574330000999999L).contains(card)
                || Range.between(6798360000350000L, 6798360000449999L).contains(card)
                || Range.between(6798360000350000L, 6798360000449999L).contains(card)  // End Tələbə
                || Range.between(4301608010700000L, 4301608010799999L).contains(card)  // begin Sosial Muavinet
                || Range.between(4301700000600000L, 4301700000699999L).contains(card)
                || Range.between(5227580000940000L, 5227580001039999L).contains(card)
                || Range.between(5574330000830000L, 5574330000849999L).contains(card)
                || Range.between(6798360000450000L, 6798360000459999L).contains(card)   // end Sosial Muavinet
                || Range.between(4301608010800000L, 4301608010819999L).contains(card)   // begin  USY
                || Range.between(5227580001040000L, 5227580001139999L).contains(card)
                || Range.between(5574330000800000L, 5574330000829999L).contains(card) )  // end USY
        {
            check = true;
        }
        else{
            check = false;
        }
        return check;
    }


//    public Boolean checkRange(Long card, String path) throws IOException {
//        boolean check = false;
//        XLSXReader xlsxReader = new XLSXReader();
//        ArrayList<Ranges> ranges = xlsxReader.xlsx(path);
////        System.out.println(ranges.size());
//        for (int i = 0; i < ranges.size(); i++)
//        {
////            System.out.println("MIN:    " + ranges.get(i).getMin());
////            System.out.println(i + "   MAX:    " + ranges.get(i).getMax() + "\n");
//
//            if(Range.between(ranges.get(i).getMin(), ranges.get(i).getMax()).contains(card))
//            {
//                check = true;
//            }
//            else{
//                check = false;
//            }
//        }
//        return check;
//    }





}
