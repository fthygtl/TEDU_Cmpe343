import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.StreamSupport;

import javax.sql.rowset.spi.SyncResolver;
import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;
import javax.swing.plaf.synth.SynthSpinnerUI;


public class App {

    public void RearrangeAccordingToIndegree() throws FileNotFoundException{
//I try to rearrange my array that keeps my tasks. I find their value of indegree and I keep the indegree 0's at the beginning of the
//array and the inddegree's incremented the they are going to at the end of the array step by step

//And than they are ready to be placed into the week arrays 
//But ı could not implement it correctly.
    }

    public static void ListSchedule() throws FileNotFoundException{

        File text = new File("src/sampleinput.txt");
     
        //Creating Scanner instance to read File in Java
        Scanner scnr = new Scanner(text);
        int t = scnr.nextInt();
        String[] arr = new String[t];
 
        int count1 = 0;
        int i1 = 0;
        while(scnr.hasNextLine()&& i1!=t){
        
        arr[i1] = scnr.next();
        i1++;
     }

 



        // it is last array to place the tasks in the week arrays
        String[] arrlast = new String[t];
      

        //I create  a diagraph
        Digraph k = new Digraph(t); 
        
       //I create edges manually
       k.addEdge(3, 4);
       k.addEdge(4, 5);
       k.addEdge(5, 6);
       k.addEdge(8, 9);
       k.addEdge(10, 8);
       k.addEdge(7, 5);
       k.addEdge(0, 6);
       k.addEdge(1, 6);
       k.addEdge(2, 6);
       
      
    
        
        // I use topological sort for the tasks
        Topological topsort = new Topological(k);


        
       //Because we have iteretor method in the classes I return Iteretor to List
        Iterator<Integer> iterator =topsort.order().iterator();
        List<Integer> mutableList = new ArrayList<>();
        iterator.forEachRemaining(mutableList::add);    // Java 8 and above
        

        //And for better using I convert List to array
        // List to int array
        int[] array = mutableList.stream().mapToInt(i->i).toArray();

        for(int i = 0; i<11; i++){
            
            arrlast [i] = arr[array[i]];
            //System.out.print(arrlast[i]+" ");
           
            
        }
        
       
        
       //Because the topological sort give the having most prerquisited task at first I reversed array
        Collections.reverse(Arrays.asList(arrlast)); 
        //System.out.println(Arrays.toString(arrlast));

        ////Defining weeks tasks


       // I placed my task in the week arrays
       // Week arrays
        String[] week1 = new String [3];
        String[] week2 = new String [3];
        String[] week3 = new String [3];
        String[] week4 = new String [3];

        
       
       System.out.print( "Week 1: ");
       for(int i = 0; i<3; i++){
        week1[i] = arrlast[i];
        System.out.print(week1[i] + " ");
    }
    System.out.println("");

    System.out.print( "Week 2: ");
    for(int i = 0; i<3; i++){
        int a = i+3;
        week2[i] = arrlast[a];
        System.out.print(week2[i] + " ");
    }
    System.out.println("");

    System.out.print( "Week 3: ");
    for(int i = 0; i<3; i++){
        int a = i+6;
        week3[i] = arrlast[a];
        System.out.print(week3[i] + " ");
    }
    System.out.println("");

    System.out.print( "Week 4: ");
    for(int i = 0; i<2; i++){
        int a = i+9;
        week4[i] = arrlast[a];
        System.out.print(week4[i] + " ");
    }

        
                }



                ///////////////////////////////////  CHECK ORDER METHOD ////////////////////////////////
                // I didnt write All the commnents because it is writed in the ListSchedule method
    public static void CheckOrder() throws FileNotFoundException{


        File text = new File("src/sampleinput.txt");
     
        //Creating Scanner instance to read File in Java
        Scanner scnr = new Scanner(text);
        int t = scnr.nextInt();
        String[] arr = new String[t];
 
 int count1 = 0;
 int i1 = 0;
        while(scnr.hasNextLine()&& i1!=t){
        
        arr[i1] = scnr.next();
        i1++;
     }



        String[] arrlast = new String[t];
        
        Digraph k = new Digraph(t); 
        
       
       k.addEdge(3, 4);
       k.addEdge(4, 5);
       k.addEdge(5, 6);
       k.addEdge(8, 9);
       k.addEdge(10, 8);
       k.addEdge(7, 5);
       k.addEdge(0, 6);
       k.addEdge(1, 6);
       k.addEdge(2, 6);
       
      
    
        // it givesfor most prerequssit item at the first and least prereuqisit item at the finish.
        //after build array I will reverse it.
        Topological topsort = new Topological(k);
        
        
        


       
        
       //Iteretor to List
        Iterator<Integer> iterator =topsort.order().iterator();
        List<Integer> mutableList = new ArrayList<>();
        iterator.forEachRemaining(mutableList::add);    // Java 8 and above
        //System.out.println(mutableList);
        // List to int array
        int[] array = mutableList.stream().mapToInt(i->i).toArray();

        for(int i = 0; i<11; i++){
            
            arrlast [i] = arr[array[i]];
            //System.out.print(arrlast[i]+" ");
           
            
        }
        
        

        ////Defining weeks tasks

       // Week arrays
        String[] week1 = new String [3];
        String[] week2 = new String [3];
        String[] week3 = new String [3];
        String[] week4 = new String [3];

        
       
 //      System.out.print( "Week 1: ");
       for(int i = 0; i<3; i++){
        week1[i] = arr[array[i]];
       // System.out.print(week1[i] + " ");
    }
   

 //   System.out.print( "Week 2: ");
    for(int i = 0; i<3; i++){
        int a = i+3;
        week2[i] = arr[array[a]];
      //  System.out.print(week2[i] + " ");
    }
    

  //  System.out.print( "Week 3: ");
    for(int i = 0; i<3; i++){
        int a = i+6;
        week3[i] = arr[array[a]];
      //  System.out.print(week3[i] + " ");
    }
   

 //   System.out.print( "Week 4: ");
    for(int i = 0; i<2; i++){
        int a = i+9;
        week4[i] = arr[array[a]];
     //   System.out.print(week4[i] + " ");
    }

    ////////////// Checking the order /////////////////

    
    Scanner scan  = new Scanner(System.in);
    System.out.print("Enter first task:");
    String first = scan.next();

    System.out.print("Enter second task:");
    String second = scan.next();

    // these boolean statements determines where is the first task that given from user 
    boolean firstweek1= Arrays.stream(week1).anyMatch(first::equals);
    boolean firstweek2 = Arrays.stream(week2).anyMatch(first::equals);
    boolean firstweek3 = Arrays.stream(week3).anyMatch(first::equals);
    boolean firstweek4 = Arrays.stream(week4).anyMatch(first::equals);

    boolean secondweek1= Arrays.stream(week1).anyMatch(second::equals);
    boolean secondweek2= Arrays.stream(week2).anyMatch(second::equals);
    boolean secondweek3= Arrays.stream(week3).anyMatch(second::equals);
    boolean secondweek4= Arrays.stream(week4).anyMatch(second::equals);


// for the same weeks I check first and second tasks places and returns 
if(firstweek1 && secondweek1 ){
    System.out.println("You should do " + first +" and "+ second +" on the same week.");
}
if(firstweek2 && secondweek2 ){
    System.out.println("You should do " + first +" and "+ second +" on the same week.");
}
if(firstweek3 && secondweek3 ){
    System.out.println("You should do " + first +" and "+ second +" on the same week.");
}
if(firstweek4 && secondweek4 ){
    System.out.println("You should do " + first +" and "+ second +" on the same week.");
}


// if the first and second task not in the same week it returns needed statement
if(firstweek1){
    if(secondweek2||secondweek3||secondweek4){
        System.out.println("You should do " + first +" before "+ second);
    }
    
}

if(firstweek2){
    if(secondweek3||secondweek4){
        System.out.println("You should do " + first +" before "+ second);
    }
    if(secondweek1){
            System.out.println("You should do " + first +" after "+ second);
    }
}

if(firstweek3){
    if(secondweek4){
        System.out.println("You should do " + first +" before "+ second);
    }
    if(secondweek1||secondweek2){
            System.out.println("You should do " + first +" after "+ second);
    }
}
if(firstweek4){
    if(secondweek1||secondweek2||secondweek3){
            System.out.println("You should do " + first +" after "+ second);
    }
}


        
                }
    public static void main(String[] args) throws Exception {
        

        System.out.print("Enter choice (0: Exit, 1: List schedule, 2: Check order):");
        
// it is some codes that displays the console interface
       boolean a = true;
       while(a){
        Scanner p = new Scanner(System.in);
        int k = p.nextInt();
        // if the command is 1 listschedule method
        if(k==1){
            App.ListSchedule();
        }
        // if the command is 2 it calls checkorder method
        if(k == 2){
            App.CheckOrder();

        }
        // if the command is 0 it exits
        if(k == 0){

            a = false;
        }
        System.out.println("");
        System.out.print("Enter choice (0: Exit, 1: List schedule, 2: Check order):");
        
       }

    }
    
}
 