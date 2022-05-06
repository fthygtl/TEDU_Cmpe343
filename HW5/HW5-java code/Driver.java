//-----------------------------------------------------
// Title: Driver  class
// Author: Serra Sabah/ Mehmet Fatih Yiðitel
// ID: 4865115490, 27673119242
// Section:02, section 01
// Assignment: 5
// Description: this class contains the specified methods in the assignment
//-----------------------------------------------------

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class Driver {

	TrieST<?> t ;
	TrieST<?> t2 ;
	String reverseWord="";  
	ArrayList<String> words = new ArrayList<>();
	public Driver(TrieST<?> t) {
		this.t=t;
	}
	public Driver() {
	
	}
	
	public Driver(TrieST<?> t, TrieST<?> t2 ) {
		this.t=t;
		this.t2=t2;
	}
	public Driver(Iterable<String> keys) {
		
	}
	
	public Boolean Search(String name) {
		
	return t.contains(name);
	
	}
	
	public Driver(ArrayList<String> words) {
		this.words = words;
	
	}
	
	public void autoComplete(String prefix) {
		
//		keysWithPrefix method is the iterator method and it gives us to some strings
//		according to perexix given as a parameter. However we need to order them lexicographically, 
//		so we decided to add them into an ArrayList to rearrange the order of strings lexicographically. 
//		To do that we use iterator.hasNext() method and we add them to ArrayList.
//		Using Collections.sort(Listed) we were able to sort the resulting ArrayList lexicographically. 
//		Then we print the result we found by adding commas.
		
		    Iterator<String> iterator =t.keysWithPrefix(prefix).iterator();
		    ArrayList<String> Listed = new ArrayList<>();
	        while (iterator.hasNext()) {
	        	Listed.add( iterator.next());
	        }

	        Collections.sort(Listed);
		    String separator = "";  // separator here is your ","
		    for (int i=0; i< Listed.size();i++) {
		    	System.out.print(separator + Listed.get(i));
		        separator = ", ";
		    }
	}
	
	public String reverseWord(String[] word) {
		
		//This method reverses the words of the .txt file received from the tester. 
		
		String reverseWord="";  
		 for(String w:word){  
		        StringBuilder sb=new StringBuilder(w);  
		        sb.reverse();  
		        reverseWord+=sb.toString()+" ";  
		    }  
		 return reverseWord.trim();  	 
	}
	
	public void reverseAutoComplete(String suffix) {
		
//		To find the suffix we reversed the word and looked for the parameter like a prefix.
//		then we made the words we found original.
		
			   Iterator<String> iterator =t.keysWithPrefix(suffix).iterator();
			    ArrayList<String> Listed = new ArrayList<>();
		        while (iterator.hasNext()) {
		        	Listed.add( iterator.next());
		        }

		        ArrayList<String> l2 = new ArrayList<>(Arrays.asList(reverseWord1(Listed).split(" ")));
			    String separator = "";  // separator here is your ","
			    Collections.sort(l2);
			    for (int i=0; i< l2.size();i++) {
			    	System.out.print(separator + l2.get(i));
			        separator = ", ";
			    }
	}
	
	public void FullAutoComplete(String prefix, String suffix) {
		//find prefix words 
		  Iterator<String> iteratorprefix =t.keysWithPrefix(prefix).iterator();
		    ArrayList<String> Listedprefix = new ArrayList<>();
	        while (iteratorprefix.hasNext()) {
	        	Listedprefix.add( iteratorprefix.next());
	        }
	        
	        //find suffix words
		 Iterator<String> iteratorsuffix =t2.keysWithPrefix(suffix).iterator();
		    ArrayList<String> Listedsuffix = new ArrayList<>();
	        while (iteratorsuffix.hasNext()) {
	        	Listedsuffix.add(iteratorsuffix.next());
	        }

	        ArrayList<String> Listedsuffix2 = new ArrayList<>(Arrays.asList(reverseWord1(Listedsuffix).split(" ")));
	        
	        Collections.sort(Listedprefix);
	        Collections.sort(Listedsuffix2);

        //We suppressed the common ones in the ArrayList of the words containing the entered prefixes and suffixes using 
	        Listedprefix.retainAll(Listedsuffix2);
	        
	        for(int i=0; i< Listedprefix.size();i++) {
	        	System.out.println(Listedprefix.get(i));
	        }
	        
		
	}
	
	private String reverseWord1(ArrayList<String> keysWithPrefix) {
		//This method reverses the ArrayList values in the entered parameter.
		 for(String w:keysWithPrefix){  
		        StringBuilder sb=new StringBuilder(w);  
		        sb.reverse();   
		        reverseWord+=sb.toString()+" ";  
		    }
 
		return reverseWord;  
		
	}
	
public void findTopK (int k){
		/*In the findTopK method firstly We find occurring numbers of every string. 
		 * We are holding these values in  the “occurnum” array. 
		 * The occurring number of any string is holding in the “occurnum”  array. 
		 * Strings have same index number with related occurring numbers. 
		 * We are doing it in the for loop with if statement.*/
	
		int [] occurnum = new int[words.size()];
		for(int i = 0; i<words.size(); i++){
			int count = 0;
			String element = words.get(i);
			for (int j = 0; j < words.size(); j += 1) {
                if (words.get(j).equals(element)) {
                    count += 1;
					
                }
            }
			occurnum[i] = count;
			

			}
			ArrayList<String>  findedwords = new ArrayList<>();
			for(int p = 0; p<words.size(); p++){
				if(occurnum[p] == k && !findedwords.contains(words.get(p))){
					System.out.print(words.get(p) +" ");
					findedwords.add(words.get(p));
				}



		}
		
	}


}
