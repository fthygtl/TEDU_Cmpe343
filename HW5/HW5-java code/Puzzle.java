//-----------------------------------------------------
// Title: Puzzle  class
// Author: Serra Sabah/ Mehmet Fatih Yiðitel
// ID: 4865115490, 27673119242
// Section:02, section 01
// Assignment: 5
// Description: This class helps to solve Puzzle
//-----------------------------------------------------


import java.util.Vector;

public class Puzzle {
	
	char[][] puzzle; // The puzzle representation.
	Vector<String> toFind; // The words to find.
	
	Puzzle(char[][] puzzle, Vector<String> toFind) {
		this.puzzle = puzzle;
		this.toFind = toFind;
	}

	

	
	// Searches for first letter until match is found or array is exhausted.
	public String find(String word) { 
		boolean wordFound = false;
		int size = puzzle[0].length; // Puzzle dimensions.
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				if (wordFound == false && puzzle[row][column] == word.charAt(0)) { // Assumes the puzzle only contains the match once.
					return confirmMatch(word, row, column);
				}
			}
		}
		return null;
	}
	
	// Searches all eight directions from a first letter match passed by Find().
	// Algorithm is efficient, but lots of repeated code. Consider a recursive solution.
	public String confirmMatch(String word, int row, int column) { 
		boolean foundMatch = false;
		int len = word.length(); // We will only search in directions that have at least this much space. 
		
		if ((column - len) >= -1) { // The word can exist to the left.
			int wordPos = 0;
			for (int i = column; i >= (column - len) + 1; i--) {
				if (word.charAt(wordPos) != puzzle[row][i]) {
					break;
				}
				if (i == (column - len) + 1) { // A match was found
					foundMatch = true;
					return(word);
				}
				wordPos++;
			}
		}
		
		if ((column + len) <= puzzle[0].length) { // The word can exist to the right
			int wordPos = 0;
			for (int i = column; i <= (column + len) - 1; i++) {
				if (word.charAt(wordPos) != puzzle[row][i]) {
					break;
				}
				if (i == (column + len) - 1) { // A match was found
					foundMatch = true;
					return(word);
				}
				wordPos++;
			}
		}
		
		if ((row - len) >= -1) { // The word can exist above
			int wordPos = 0;
			for (int i = row; i >= (row - len) + 1; i--) {
				if (word.charAt(wordPos) != puzzle[i][column]) {
					break;
				}
				if (i == (row - len) + 1) { // A match was found
					foundMatch = true;
					return(word);
				}
				wordPos++;
			}
		}

		if ((row + len) <= puzzle[0].length) { // The word can exist below
			int wordPos = 0;
			for (int i = row; i <= (row + len) - 1; i++) {
				if (word.charAt(wordPos) != puzzle[i][column]) {
					break;
				}
				if (i == (row + len) - 1) { // A match was found
					foundMatch = true;
					return(word);
				}
				wordPos++;
			}
		}
		
		if ((row - len) >= -1 && (column - len) >= -1) { // The word can exist up and to the left
			int wordPos = 0;
			int j = column;
			for (int i = row; i >= (row - len) + 1; i--) {
				if (word.charAt(wordPos) != puzzle[i][j]) {
					break;
				}
				if (i == (row - len) + 1) { // A match was found
					foundMatch = true;
					return(word);
				}
				wordPos++;
				j--;
			}
		}
		
		if ((row - len) >= -1 && (column + len) <= puzzle[0].length) { // The word can exist up and to the right
			int wordPos = 0;
			int j = column;
			for (int i = row; i >= (row - len) + 1; i--) {
				if (word.charAt(wordPos) != puzzle[i][j]) {
					break;
				}
				if (i == (row - len) + 1) { // A match was found
					foundMatch = true;
					return(word);
				}
				wordPos++;
				j++;
			}
		}
		
		if ((row + len) <= puzzle[0].length && (column - len) >= -1) { // The word can exist down and to the left
			int wordPos = 0;
			int j = column;
			for (int i = row; i <= (row + len) - 1; i++) {
				if (word.charAt(wordPos) != puzzle[i][j]) {
					break;
				}
				if (i == (row + len) - 1) { // A match was found
					foundMatch = true;
					return(word);
				}
				wordPos++;
				j--;
			}
		}
		
		if ((row + len) <= puzzle[0].length && (column + len) <= puzzle[0].length) { // The word can exist down and to the right
			int wordPos = 0;
			int j = column;
			for (int i = row; i <= (row + len) - 1; i++) {
				if (word.charAt(wordPos) != puzzle[i][j]) {
					break;
				}
				if (i == (row + len) - 1) { // A match was found
					foundMatch = true;
					return(word);
				}
				wordPos++;
				j++;
			}
		}
		
		return null;
	}
	
	
}