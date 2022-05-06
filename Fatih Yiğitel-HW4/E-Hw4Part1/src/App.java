import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import javax.swing.plaf.synth.SynthPasswordFieldUI;

public class App {

    //outputa göre olması gereken mst sıralması:
    //0-3 0-4 0-1 1-6 6-2 2-5
   
    public static void main(String[] args) throws Exception {

        
   // String arrays for keeping two city and distance between them
   String[] dist1 = new String[3];
   String[] dist2 = new String[3];
   String[] dist3 = new String[3];
   String[] dist4 = new String[3];
   String[] dist5 = new String[3];
   String[] dist6 = new String[3];
   String[] dist7 = new String[3];
   String[] dist8 = new String[3];
   String[] dist9 = new String[3];
      

   File text = new File("src/sample_input1.txt");

   //Creating Scanner instance to read File in Java
   Scanner scnr = new Scanner(text);
   
   String[] arr1 = new String[100];

   int count1 = 0;
   int i1 = 0;
   int lineNum =0;
   while(scnr.hasNextLine()&&lineNum!=7){
   arr1[i1] = scnr.next();
   i1++;
   lineNum++;
}
int size = 0;

   for(int i=0; i<100;i++){
       if(arr1[i]!=null){
           size++;
       }
   }
   

   String[] arr = new String[size];
   
   for(int i=0; i<size;i++){
      arr[i] = arr1[i];
       }

       Arrays.sort(arr);
       
       /*
       // make the string array alp order
       arr = Stream.of(arr)
       .sorted()
       .toArray(String[]::new);
       */
       
       //System.out.println(Arrays.toString(arr));
       int a = 0;
       while(scnr.hasNextLine()&&lineNum!=10){
           dist1[a] = scnr.next();
           a++;
           lineNum++;
       }
       a=0;
       while(scnr.hasNextLine()&&lineNum!=13){
           dist2[a] = scnr.next();
           a++;
           lineNum++;
       }
       a=0;
       while(scnr.hasNextLine()&&lineNum!=16){
           dist3[a] = scnr.next();
           a++;
           lineNum++;
       }
       a=0;
       while(scnr.hasNextLine()&&lineNum!=19){
           dist4[a] = scnr.next();
           a++;
           lineNum++;
       }
       a=0;
       while(scnr.hasNextLine()&&lineNum!=22){
           dist5[a] = scnr.next();
           a++;
           lineNum++;
       }
       a=0;
       while(scnr.hasNextLine()&&lineNum!=25){
           dist6[a] = scnr.next();
           a++;
           lineNum++;
       }
       a=0;
       while(scnr.hasNextLine()&&lineNum!=28){
           dist7[a] = scnr.next();
           a++;
           lineNum++;
       }
       a=0;

       while(scnr.hasNextLine()&&lineNum!=31){
           dist8[a] = scnr.next();
           a++;
           lineNum++;
       }
       a=0;
       while(scnr.hasNextLine()&&lineNum!=34){
           dist9[a] = scnr.next();
           a++;
           lineNum++;
       }
       a=0;

/*
       System.out.println(Arrays.toString(dist1));
       System.out.println(Arrays.toString(dist2));
       System.out.println(Arrays.toString(dist3));
       System.out.println(Arrays.toString(dist4));
       System.out.println(Arrays.toString(dist5));
       System.out.println(Arrays.toString(dist6));
       System.out.println(Arrays.toString(dist7));
       System.out.println(Arrays.toString(dist8));
       System.out.println(Arrays.toString(dist9));
       */



int val = 0;
 
EdgeWeightedGraph G=  new EdgeWeightedGraph(7); 

val = Integer.parseInt(dist1[2]); 
Edge e1 = new Edge(Arrays.asList(arr).indexOf(dist1[0]),Arrays.asList(arr).indexOf(dist1[1]),val);

val = Integer.parseInt(dist2[2]); 
Edge e2 = new Edge(Arrays.asList(arr).indexOf(dist2[0]),Arrays.asList(arr).indexOf(dist2[1]),val);

val = Integer.parseInt(dist3[2]); 
Edge e3 = new Edge(Arrays.asList(arr).indexOf(dist3[0]),Arrays.asList(arr).indexOf(dist3[1]),val);

val = Integer.parseInt(dist4[2]); 
Edge e4 = new Edge(Arrays.asList(arr).indexOf(dist4[0]),Arrays.asList(arr).indexOf(dist4[1]),val);

val = Integer.parseInt(dist5[2]); 
Edge e5 = new Edge(Arrays.asList(arr).indexOf(dist5[0]),Arrays.asList(arr).indexOf(dist5[1]),val);

val = Integer.parseInt(dist6[2]); 
Edge e6 = new Edge(Arrays.asList(arr).indexOf(dist6[0]),Arrays.asList(arr).indexOf(dist6[1]),val);

val = Integer.parseInt(dist7[2]); 
Edge e7 = new Edge(Arrays.asList(arr).indexOf(dist7[0]),Arrays.asList(arr).indexOf(dist7[1]),val);

val = Integer.parseInt(dist8[2]); 
Edge e8 = new Edge(Arrays.asList(arr).indexOf(dist8[0]),Arrays.asList(arr).indexOf(dist8[1]),val);

val = Integer.parseInt(dist9[2]); 
Edge e9 = new Edge(Arrays.asList(arr).indexOf(dist9[0]),Arrays.asList(arr).indexOf(dist9[1]),val);

Edge [] arrayedge = {e1,e2,e3,e4,e5,e6,e7,e8,e9};

//System.out.println(Arrays.toString(arrayedge));
for(int i = 0; i<arrayedge.length;i++){
    G.addEdge(arrayedge[i]);
}




LazyPrimMST LP =new  LazyPrimMST(G);


//System.out.println("Prim algoritm "+MST.edges());
//System.out.println("Kruskal algorithm "+MSTkruskal.edges());

    

        //Because we have iteretor method in the classes I return Iteretor to List
        Iterator<Edge> iterator =LP.edges().iterator();
        List<Edge> Listed = new ArrayList<>();
        iterator.forEachRemaining(Listed::add);    // Java 8 and above


        //System.out.println(Listed.toString());
        
        Object [] o = Listed.toArray();   
        //System.out.println(Listed.toString());
        
//finding total weight of mst
  

    double totalWeight = 0;
    for(int i = 0; i<Listed.size(); i++){
        totalWeight += Listed.get(i).weight();
    }
        System.out.println((int)totalWeight);

        
       

        int a4 = 0;
        int counted = 0;
        // System.out.println(Arrays.toString(arr));
        // System.out.println(Arrays.toString(arrayedge));
        for(int i = 1; i<Listed.size();i++){
            
          if(arr[Listed.get(i-1).other(Listed.get(i-1).either())] == arr[Listed.get(i).other(Listed.get(i).either())]){
            System.out.println(""+arr[Listed.get(i-1).either()] + " " + arr[Listed.get(i-1).other(Listed.get(i-1).either())]+ " " + (int)Listed.get(i-1).weight());
          

                String temp = arr[Listed.get(i).either()];
                arr[Listed.get(i).either()] = arr[Listed.get(i).other(Listed.get(i).either())];
                arr[Listed.get(i).other(Listed.get(i).either())] = temp;
        
        System.out.println(arr[Listed.get(i).either()] + " " + arr[Listed.get(i).other(Listed.get(i).either())]+ " " + (int)Listed.get(i).weight());
        }else{

            if(arr[Listed.get(i).either()]==arr[i+1]){
            
                System.out.println(arr[Listed.get(i-1).other(Listed.get(i-1).either())] + " " +arr[Listed.get(i).either()]+ " " + (int)Listed.get(i).weight());
                

            }else{
                System.out.println(""+ arr[Listed.get(i-1).either()] + " " + arr[Listed.get(i-1).other(Listed.get(i-1).either())]+ " " + (int)Listed.get(i-1).weight());
            }

                

            }
        
           
        
                }
                
                // System.out.println(Arrays.toString(arr));
                // System.out.println(Arrays.toString(arrayedge));
            }
           
            

        }
       

        