//-----------------------------------------------------
// Title: tester  class
// Author: Serra Sabah/ Mehmet Fatih Yiğitel
// ID: 4865115490, 27673119242
// Section:02, section 01
// Assignment: 5
// Description: TThis class is the tester that we receive input from the user and gives the desired output.
//-----------------------------------------------------

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;

public class tester {

public static void main(String[] args) throws IOException   {
		
		
		String line = "";
		String[] tokens;
		String[] v;
		String txt;
		String puzzletxt;
		Scanner scan = new Scanner(System.in);
		
		//read file by using bufferedreader
		txt = scan.next();
		FileReader file = new FileReader(txt);
	    BufferedReader reader = new BufferedReader(file);

	    ArrayList<String> words = new ArrayList<String>();
	    ArrayList<String> lowercased = new ArrayList<String>();
		while((line = reader.readLine()) != null)
		{
		
				tokens = line.split(" ");
				for(int i=0; i<tokens.length;i++) {

					//Ensures that punctuation marks in text are not taken
					tokens[i] = tokens[i].replaceAll("[^a-zA-Z]", "");
					words.add(tokens[i]); 
				}  	
		}
		
		System.out.println(words);
		

        
      //we add the this word ArrayList elements into the “st” trie data structure that we create.
        TrieST<Integer> st = new TrieST<Integer>();
        for (int i = 0; i<words.size(); i++) {
            st.put(words.get(i), i);
        }

 
		int number;
		String commandword ;
		int command;
		
		//We create a switch case statement for the different methods that we want to call.
		while(true) {
	 
			command = scan.nextInt();
			
			switch (command) {

			case 1:
				
				// scan input then call Search method in driver class
				  commandword = scan.next().toLowerCase();
				  Driver d1 = new Driver(st);
				  System.out.println(d1.Search(commandword));
				  System.exit(0);
				break;

			case 2:
				// scan input then call autoComplete method in driver class
				commandword = scan.next().toLowerCase();
				  Driver d2 = new Driver(st);
				d2.autoComplete(commandword);
				System.exit(0);
				break;
			
			case 3:
				//scan input
				 commandword = scan.next().toLowerCase();
				  Driver d = new Driver();
				String [] word = new String[words.size()];
				//add elements from arraylist to array
				for(int i=0; i< words.size();i++) {
					word[i] = words.get(i);
				}
				//Reverse the words in the array with the reverseWord method in the driver class
				ArrayList<String> l2 = new ArrayList<>(Arrays.asList(d.reverseWord(word).split(" ")));
		   
				//create new TrieST and add new reverse words
		        TrieST<Integer> t = new TrieST<Integer>();
		        for (int i = 0; i<l2.size(); i++) {
		            t.put(l2.get(i), i);
		        }		        
		        
		        Driver d3 = new Driver(t);
		        
		        d3.reverseAutoComplete(commandword);
		        System.exit(0);
				break;
				
			case 4:
				//scan input
				 commandword = scan.next().toLowerCase();
				String commandword2 = scan.next();
				Driver d4 = new Driver();   //words in tries
				String [] word4 = new String[words.size()];
				//add elements from arraylist to array
				for(int i=0; i< words.size();i++) {
					word4[i] = words.get(i);
				}
				
				//Reverse the words in the array with the reverseWord method in the driver class
				ArrayList<String> l4 = new ArrayList<>(Arrays.asList(d4.reverseWord(word4).split(" ")));
		   
				//create new TrieST and add new reverse words
		        TrieST<Integer> t4 = new TrieST<Integer>();
		        for (int i = 0; i<l4.size(); i++) {
		            t4.put(l4.get(i), i);
		        }		        
		        
		        Driver d44 = new Driver(st,t4);   //reverse words in tries
		        
		        d44.FullAutoComplete(commandword, commandword2);
		        System.exit(0);
				break;

			case 5:
				number = scan.nextInt();
				
				Driver d5 = new Driver(words);
				d5.findTopK(number);
				System.exit(0);
				break;
				
			case 6:
				puzzletxt = scan.next();
					String line1 = "";
					String[] tokens1;
					String[] v1;
			       

					// check the first line how many charcter to set multi dimensional array lenght
					String line0 = Files.readAllLines(Paths.get(puzzletxt)).get(0);
			        //System.out.println(line0);
			        int lenght = line0.replace(" ", "").length();
			        // we find the first line character number to find the multi-dimenisoanl char array lenght
			       
			        //so we have lenght now. We can create an multi-dimenisonal char array
			        char [][] Mychar = new char[lenght][lenght]; 


					
					//read file by using bufferedreader
					FileReader file1 = new FileReader(puzzletxt);
				    BufferedReader reader1 = new BufferedReader(file1);

				    ArrayList<String> puzzle = new ArrayList<String>();
				    ArrayList<String> lowercased1 = new ArrayList<String>();
					while((line1 = reader1.readLine()) != null)
					{
			           
					
							tokens1 = line1.split(" ");
							for(int i=0; i<tokens1.length;i++) {

								tokens1[i] = tokens1[i].replaceAll("[^a-zA-Z]", "");
								puzzle.add(tokens1[i]); 
							}  	
					}
					
					//System.out.println(puzzle);


			      
			        



			        //converting our words arraylist to multi-dimensional char array
			        int temp = 0;
			        for(int i = 0; i<lenght; i++){
			            for(int j = 0; j<lenght; j++){
			                temp++;
			                String a = puzzle.get(temp-1);
			                Mychar[i][j] = a.charAt(0);
			            }
			        }
		
				
					Vector<String> vector = new Vector();
					
					Puzzle a = new Puzzle(Mychar, vector);

					ArrayList<String>  findedwords = new ArrayList<>();
					
					String kop;
			        for(int i = 0; i<words.size(); i++){
						kop = a.find(words.get(i));
						findedwords.add(kop);
			        	
				}

			    
				   ArrayList<String>  printed = new ArrayList<>();
				   for(int i=0; i<findedwords.size(); i++){
					   if(findedwords.get(i) !=null){
						   
						  if(!printed.contains(findedwords.get(i)))
						   printed.add(findedwords.get(i));
						   
					   }
				   }

				
				   System.out.println(printed);
		        System.exit(0);
				break;
		
			}}
}
}
