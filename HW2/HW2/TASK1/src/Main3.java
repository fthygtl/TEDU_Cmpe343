import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Main3 {
    public static void main(String[] args) throws FileNotFoundException {
        
        // to read input from file I use file and scanner
        File file = new File("src/sampleinput1.txt");
        Scanner scan = new Scanner(file);
        

        // add all the elements into int array
        int [] arr =  new int[29];
        int a = 0;
        
        while (scan.hasNextLine()) {

            int s = scan.nextInt();
            
           arr[a] = s;
           a++;
        
        }

// take the source vertices as an input
        int source;
        int m,n,k,l;
        int i = 0;
        m = arr[i]*1000;
        n = arr[i+1]*100;
        k = arr[i+2]*10;
        l = arr[i+3];
        source = m+n+k+l;
        
//take the destination vertices as an input 
        int dest;
        m = arr[i+4]*1000;
        n = arr[i+5]*100;
        k = arr[i+6]*10;
        l = arr[i+7];
        dest= m+n+k+l;
        
//take the number of forbidden configs      
int numForbidden;
m = arr[i+8];
numForbidden = m;

//forbidden numbers into ForbiddenNumbersArr array
int forbid1;
m = arr[i+9]*1000;
n = arr[i+10]*100;
k = arr[i+11]*10;
l = arr[i+12];
forbid1 = m+n+k+l;

int forbid2;
m = arr[i+13]*1000;
n = arr[i+14]*100;
k = arr[i+15]*10;
l = arr[i+16];
forbid2 = m+n+k+l;

int forbid3;
m = arr[i+17]*1000;
n = arr[i+18]*100;
k = arr[i+19]*10;
l = arr[i+20];
forbid3 = m+n+k+l;

int forbid4;
m = arr[i+21]*1000;
n = arr[i+22]*100;
k = arr[i+23]*10;
l = arr[i+24];
forbid4 = m+n+k+l;

int forbid5;
m = arr[i+25]*1000;
n = arr[i+26]*100;
k = arr[i+27]*10;
l = arr[i+28];
forbid5 = m+n+k+l;

// array for forbidden configurations
int []ForbiddenNumbersArr = {forbid1,forbid2,forbid3,forbid4,forbid5};

////////////////////////////////////////////////////////////////////

// Our graph for the keeping vertices
Graph Graph = new Graph(10000);

// for loop to add vertices to the graph 
for(int vertices=1000; vertices<10000; vertices++) {

    //Eliminate the forbidden configurations
    if(vertices!=forbid1 && vertices!=forbid2 && vertices!=forbid3 && vertices!=forbid4 && vertices!=forbid5) {
        
    // For the First Digit 
        
    //if the first digit is not equal to zero we add the edges the value of it's for a thousand less for the first digit
    if((vertices/1000)%10 != 0 ){
        Graph.addEdge(vertices, vertices-1000);
    }
    //if the first digit is equal to zero we add the edges the value of it's for nine thousand more for the first digit to get the cycle 
    if((vertices/1000)%10 == 0 ){
        Graph.addEdge(vertices, vertices+9000);
    }
    //if the first digit is not equal to nine we add the edges the value of it's for a thousand more for the first digit 
    if((vertices/1000)%10 != 9){
        Graph.addEdge(vertices, vertices+1000);
    }
    //if the first digit is equal to nine we add the edges the value of it's nine thousand less for the first digit 
    if((vertices/1000)%10 == 9 ){
        Graph.addEdge(vertices, vertices-9000);
    }
    // For the Second Digit
        

    // The process is similar the explanation that I wrote for the first digit.
    
    if((vertices/100)%10 != 0){
    Graph.addEdge(vertices, vertices-100);
    }
    if((vertices/100)%10 == 0){
    Graph.addEdge(vertices, vertices+900);
    }
    if((vertices/100)%10 != 9){
        Graph.addEdge(vertices, vertices+100);
    }
    if((vertices/100)%10 == 9){
    Graph.addEdge(vertices, vertices-900);
    }
    

   // For the Third Digit
        
    // The process is similar the explanation that I wrote for the first digit.
    if((vertices/10)%10 != 0){
    Graph.addEdge(vertices, vertices-10);
    }
    if((vertices/10)%10 == 0){
    Graph.addEdge(vertices, vertices+90);
    }
    if((vertices/10)%10 != 9){
        Graph.addEdge(vertices, vertices+10);
    }
    if((vertices/10)%10 == 9){
    Graph.addEdge(vertices, vertices-90);
    }
        
   // For the Fourth Digit
        
   // The process is similar the explanation that I wrote for the first digit.
    if(vertices%10 != 0 ){
        Graph.addEdge(vertices, vertices-1);
    }
    if(vertices%10 == 0 ){
        Graph.addEdge(vertices, vertices+9);
    }
    if(vertices%10 != 9 ){
        Graph.addEdge(vertices, vertices+1);
    }
    if(vertices%10 == 9 ){
        Graph.addEdge(vertices, vertices-9);
    }
        
    }
}


// It prints the all graph (you should increase console limit)
//System.out.println(Graph);

BreadthFirstPaths s = new BreadthFirstPaths(Graph,source);

// It prints the number of the edges in the shortest path between source and destination vertex
System.out.println(s.distTo(dest));


    }
}

