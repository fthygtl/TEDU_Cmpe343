import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.swing.plaf.synth.SynthSpinnerUI;
public class App {

  
    public static void main(String[] args) throws Exception {
    	
    	// I use scanners for the take input of file name, source city name, destination city
         Scanner scan = new Scanner(System.in);
         String filename = scan.next();
         String firstCity = scan.next();
         String secondCity =  scan.next();
            
        
        File text = new File(filename);
   //Creating Scanner instance to read File in Java

   Scanner scnr = new Scanner(text);
   //takes the first input (vertices number)
int numvertices;
numvertices=  scnr.nextInt();

//takes the second input (edges number)
int numedges;
numedges = scnr.nextInt();
//to take every line in the array

String cities [] = new String[numvertices*4];

// to take vertices numbers consist of an edge
String edges [] = new String[numedges*2];
//numedges = 9
int linenumber = 0;

//while there is no line while loop will stop (it will scan beginning of the edges)
while(scnr.hasNextLine()&&linenumber!=numvertices*4){
    
	
	//takes the input into array
        cities[linenumber] = scnr.next();
        linenumber++;
    
}
//System.out.println(Arrays.toString(cities));
int a = 0;

//it will scan end of the file
while(scnr.hasNextLine()&&linenumber!=(numvertices*4)+(numedges*2)){
    
    edges[a] = scnr.next();
    a++;
    linenumber++;
}
//System.out.println(Arrays.toString(edges));

EdgeWeightedDigraph G = new EdgeWeightedDigraph(numvertices);

// taking coordinates in an array

//FOR x CORDÄ°NTATES
int Xcordinates[] = new int [numvertices];
int c = 0;
for(int i = 1; i<cities.length; i=i+4){
Xcordinates[c] = Integer.parseInt(cities[i]);
c++;
}
//System.out.println(Arrays.toString(Xcordinates));

//FOR Y CORDÄ°NTATES
int Ycordinates[] = new int [numvertices];
int t = 0;
for(int i = 2; i<cities.length; i=i+4){
    Ycordinates[t] = Integer.parseInt(cities[i]);
    t++;
    }
//System.out.println(Arrays.toString(Ycordinates));

// CÄ°TÄ°ES STRIÄ°G ARRAY

String City [] = new String [numvertices];
int r = 0;
for(int i = 3; i<cities.length; i=i+4){
    City [r] = (cities[i]);
    r++;
    }
//System.out.println(Arrays.toString(City));


// Source indexes
int [] source = new int[numedges];
//Destination indexes
int [] destination = new int[numedges];
int b = 0;
for(int i = 0; i<numedges*2; i=i+2){

    source[b] = Integer.parseInt(edges[i]);
    destination [b]= Integer.parseInt(edges[i+1]);
    b++;
}
//System.out.println(Arrays.toString(source));
//System.out.println(Arrays.toString(destination));

//Edge ARRAYLÄ°ST
List<DirectedEdge> Edges = new ArrayList<>();

//FÄ°NDÄ°NG DÄ°STANCE GÄ°VEN VERTEXES AND ADDÄ°NG EDGES Ä°NTO THE GRAPH
            for(int i = 0; i<numedges; i++){
    // Generate or get variables

    //FÄ°NDÄ°NG DÄ°STANCES
    double d;
    int dist;
    dist = ((Xcordinates[source[i]]-Xcordinates[destination[i]])*(Xcordinates[source[i]]-Xcordinates[destination[i]])+(Ycordinates[source[i]]-Ycordinates[destination[i]])*(Ycordinates[source[i]]-Ycordinates[destination[i]]));                                             
     d =dist;
     double last;
     last = Math.sqrt(d);

    //CREATÄ°NG EDGES AND ADDÄ°NG EDGE ARRAYLÄ°ST
    Edges.add(i ,new DirectedEdge(source[i],destination[i],last));
    G.addEdge(Edges.get(i));
    }    

   // System.out.println(G.toString());


    
   

    // Convert  ARRAY AN ARRAYLLT TO FÄ°NDÄ°NG Ä°NDEX EASÄ°LY

    List<String> cityArraylist = new ArrayList<>();
    for(int i = 0; i<City.length; i++){
        cityArraylist.add(i,City[i]);
    }

    //System.out.println("ne istiyourm "+cityArraylist.toString());
//System.out.println(firstCity);
//System.out.println(secondCity);
   int a1 = cityArraylist.indexOf(firstCity);
   int a2 = cityArraylist.indexOf(secondCity);

   //a1 ve a2 yi kontrol et
//System.out.println("Å�ehirlerin indexleri "+a1 +" "+a2);

    long t1 = System.currentTimeMillis();
    //Dijkstra algoritjm for computing closest way from source vertex
    DijkstraSP DJ = new DijkstraSP(G,a1);
    long t2 = System.currentTimeMillis();
    //System.out.println(DJ.pathTo(5));
    

    
    //Because we have iteretor method in the classes I return Iteretor to List
    Iterator<DirectedEdge> iterator = DJ.pathTo(a2).iterator();
    List<DirectedEdge> mutableList = new ArrayList<>();
    iterator.forEachRemaining(mutableList::add);    // Java 8 and above


    
    List<String> needed = new ArrayList<>();


for (int counter = 0; counter < mutableList.size(); counter++) {
    
needed.add(City[mutableList.get(counter).to()]);
   // System.out.println(City[mutableList.get(counter).from()]);
   
}           

Collections.reverse(needed);

System.out.println(needed.size()+1 +" cities to be visited:");
// these will be also first input that came from the user
System.out.println(firstCity);
for (int counter = 0; counter < needed.size(); counter++) {
    
    System.out.println(needed.get(counter));
       // System.out.println(City[mutableList.get(counter).from()]);
       
    }           
    
// The distance  between source and destination city
System.out.println("Distance: "+(int)DJ.distTo(a2) +" km");


// the time for the execution for Dijkstra algorithm
System.out.println(t2-t1);

}

}
