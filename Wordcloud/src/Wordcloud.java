import java.io.BufferedReader; //imports the necessities for our program to work
import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Wordcloud {
	static Map<String, Integer> myMap = new HashMap<String, Integer>(); // creates
																		// a new
																		// hash
																		// map
																		// to
																		// keep
																		// track
																		// of
																		// the
																		// count
																		// of
																		// certain
																		// words

	public static void main(String[] args) { // creates the main in the program
												// so we can run it
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));// creates
																					// a
																					// bufferedreader
																					// so
																					// we
																					// can
																					// read
																					// in
																					// input
		System.out.println("Enter the word list file");// welcomes the person
														// with a message
		String fileName = null;// sets filename to blank
		try { // attempts to do this set of code
			fileName = br.readLine(); // reads the text in the console
			System.out.println(fileName); // prints out the file name in console

		} catch (IOException E) { // when the program catches this it will do
									// the code inside the brackets
		}
		Scanner sc2 = null; // sets the scanner sc2 to nothing
		try { // attempts to do this set of code
			sc2 = new Scanner(new File(fileName)); // sc2 gets a new scanner set
													// to read a file with name fileName
		} catch (FileNotFoundException e) {// if this error appears then it will
											// run a certain code
			e.printStackTrace();// gives us info on the error
		}
		while (sc2.hasNextLine()) {// while the scanner has a next line it will
									// run the code below
			Scanner s2 = new Scanner(sc2.nextLine());// scanner s2 becomes a new
														// scanner that reads
														// the next line of sc2
			while (s2.hasNext()) {// while s2 hasNext() it will run the code
									// below

				String s = s2.next();// the string s is set to scanner s2 next()

				map(s);// puts the string into the hash map
			}
		}
		for (Map.Entry<String, Integer> entry : myMap.entrySet()) {// for loop
																	// that
																	// reads the
																	// map of a
																	// certain
																	// string
																	// and how
																	// many
																	// times it
																	// appears
																	// and sets
																	// the entry
																	// to the
																	// map
			System.out.println(entry.getKey() + " : " + entry.getValue());// Shows
																			// the
																			// user
																			// the
																			// statistics
																			// of
																			// the
																			// word
			
		}
		String [] sortedKeys= theArray (myMap);//Creates an array called the theArray which is sorted in a specific way
		System.out.println(Arrays.toString(sortedKeys));//Prints out the string in the specific sorted key
		System.out.println(Arrays.toString(flipArray(sortedKeys)));//Prints out the array which is opposite to the first array
	}

	public static void map(String s) {// Creates a function called map with parameter String s that updates the map with s

		if (!myMap.containsKey(s)) {// if the map does not containsKe(s)) the
									// map puts the string paired with 1
			myMap.put(s, 1);
		} else {// or else the map will get the string and add 1 to the number
				// of times it appears
			myMap.put(s, myMap.get(s) + 1);
		}

	}

	public static String[] theArray(Map<String, Integer> aMap) {//constructor
		String[] anArray = new String [aMap.size()]; //Creates an array with a certain size
		String max = null;//sets max string to nothing
		int maxNumber = 0;//sets max number to 0
		int index=0;//index will start at position 0
		while (!aMap.isEmpty()) {//while loop stating that map is not empty
//			System.out.println(aMap.size());
			maxNumber=0;//maxnumber will be set to 0
			
			for (Map.Entry<String, Integer> entry : aMap.entrySet()) {//for loop collecting data for map
				if (entry.getValue() > maxNumber) {//checks if value is greater than max number
					max = entry.getKey();//gets key for the entry
					maxNumber = entry.getValue();//maxNumber is assigned to value
				}
			}
//			System.out.println(max);
			anArray [index]=max;
			index++;
			aMap.remove(max);
		}

		return anArray;

	}
	
	public static String [] flipArray(String [] firstArray)//constructs a new array but with opposite values
	{
	  String [] newArray = new String [firstArray.length];//creates the array
	  for (int index=0; index<firstArray.length; index++)//for loop creating our index	
	  {
		  newArray[firstArray.length-1-index] = firstArray [index];//assigns newArray to firstarray but with opposite values
		  
	  }
	  return newArray;
	}

}