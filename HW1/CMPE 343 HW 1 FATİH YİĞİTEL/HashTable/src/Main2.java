import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main2 {

    public static void main(String[] args) throws FileNotFoundException {

        // We create LinearProbingHashST and SeparateChainingHashST objects
        LinearProbingHashST a = new LinearProbingHashST<>();
        SeparateChainingHashST b = new SeparateChainingHashST<>();

        int dataSize = 1024;

        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();  

        //We add the words from input file our hashtables
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);

        int m = 0;
        //Set a value for keys
        int value1 = 1;
        while (scan.hasNextLine()) {

            String s = scan.next();
            // We put into Key and value pairs fo both LinearProbingHashST and SeparateChainingHashST hashtables
            a.put(s, value1);
            b.put(s, value1);
            value1++;

        
        }




        //////////////////////////////////////////////////////////////////////////
        // At this part I found most 3 used words in main class
        File file1 = new File("input.txt");
        Scanner scan1 = new Scanner(file);
        ArrayList<String> list = new ArrayList<String>();
        // We add elements in to the arrayList
        while (scan1.hasNext()) {
            list.add(scan1.next());
        }
        //Some arrays for holding most 3 used words and their number of occurances
        String[] sa = new String[3];
        String[] top3 = new String[3];
        String[] top3value = new String[3];
        Integer[] top3Integer = new Integer[3];

        // Most 3 used word in the List
        // I gropued them according to the their counting
        //and hold them in the list.
        Map<String, Long> map = list.stream().collect(Collectors.groupingBy(w -> w, Collectors.counting()));
        List<Map.Entry<String, Long>> result = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(3).collect(Collectors.toList());


                //I use arrays for show them. 
        for (int i = 0; i < result.size(); i++) {

            sa[i] = result.get(i).toString();

        }
        // it holds most 3 used words
        for (int i = 0; i < result.size(); i++) {

            top3[i] = (sa[i].substring(0, sa[i].indexOf("=")));

        }
        // it holds most 3 used words' number of occurances as string
        for (int i = 0; i < result.size(); i++) {

            top3value[i] = (sa[i].substring(sa[i].indexOf("=") + 1, sa[i].indexOf("=") + 2));

        }
        // it holds most 3 used words' number of occurances as Integer
        for (int i = 0; i < result.size(); i++) {
            top3Integer[i] = Integer.parseInt(top3value[i]);
        }

        /////////////////////////////////////////////////////////////////



        //And finally it displays what we need

        System.out.println("Final table sizes for linear probing and separate chaining are " + a.finalsize() + " and "
                + b.finalsize());
                System.out.println("");

        System.out.println("Top 3 most used words, their indexes for linear probing, their node");
        System.out.println("indexes for separate chaining and their number of occurrences:");
        System.out.println((top3[0]) + " " + a.GetIndex(top3[0]) + " " + b.GetNodeIndex(top3[0]) + " " + top3Integer[0]);
        System.out.println((top3[1]) + " " + a.GetIndex(top3[1]) + " " + b.GetNodeIndex(top3[1]) + " " + top3Integer[1]);
        System.out.println((top3[2]) + " " + a.GetIndex(top3[2]) + " " + b.GetNodeIndex(top3[2]) + " " + top3Integer[2]);



        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        // I check the 
	//System.out.println("Used Memory before: " + usedMemoryBefore/dataSize + " KB");
	//System.out.println("Memory increased: " + (usedMemoryAfter-usedMemoryBefore)/dataSize + " KB");
    }

}
