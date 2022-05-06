import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class App {
    public static void main(String[] args) throws Exception {


        int m = 0;
        

        File file = new File("src/input.txt");
        Scanner scan = new Scanner(file);
        

        // add all the elements into int array
        String [] arr =  new String[6];
        
        int a = 0;
        
        while (scan.hasNextLine()) {

            String s = scan.next();
            
           arr[a] = s;
           a++;
        
        }

        
        
        char[]firstline=arr[2].toCharArray();
        char[]secondline=arr[3].toCharArray();
        char[]thirdline=arr[4].toCharArray();
        char[]fourthline=arr[5].toCharArray();

        for(int i = 0; i<arr.length; i++){
            System.out.println(firstline[i]);
        }

        AdjMatrixGraph Graph = new AdjMatrixGraph(m);
    }
}
