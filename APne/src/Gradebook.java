import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Gradebook {
	static Map<String, Double> gradeBook = new HashMap<String, Double>();

	final static int ADD = 1;
	final static int UPDATE = 2;
	final static int REMOVE = 3;
	final static int CLASS_AVERAGE = 4;
	final static int NUMBER_IN_RANGE = 5;
	final static int PRINT_GRADE_BOOK =6;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		while (true) {

			System.out.println(
					"Welcome to the grade book, what would you like to do?(choose a number)\n1. add\n2. update\n3. remove\n4. class average\n5. number in range\n");

			int optionNum = readInteger();

			if (optionNum == ADD) {
				add();
			} else if (optionNum == UPDATE) {
				update();
			} else if (optionNum == REMOVE) {
				remove();
			} else if (optionNum == CLASS_AVERAGE) {
				classAverage();
			} else if (optionNum == NUMBER_IN_RANGE) {
				countInRange();
			} else if (optionNum == PRINT_GRADE_BOOK) {
				getGradeBook();
			} else {
				System.out.println("You entered an invalid option, try again next time.");

			}
		}
	}

	public static void add() {
		System.out.println("Please enter the name of the student");
		String s = readString();
		System.out.println("Please enter the current grade he or she has.");
		Double grade = readDouble();

		if (!gradeBook.containsKey(s)) {// if the map does not containsKe(s))
										// the
			// map puts the string paired with 1
			gradeBook.put(s, grade);
		} else {
			System.out.println("This student is already in the grade book.");

		}

	}

	public static void update() {
		System.out.println("What is the name of the student you want to update the score for?");
		String response = readString();
		System.out.println("What is the new grade of the student?");
		Double newGrade = readDouble();

		if (gradeBook.containsKey(response)) {
			gradeBook.put(response, newGrade);

		} else {
			System.out.println("This student isn't in the grade book so you will need to add them");
		}

	}

	public static void getGradeBook() {
		for (Map.Entry<String, Double> entry : gradeBook.entrySet()) {// for
																		// loop

			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}

	public static void remove() {
		System.out.println("What is the name of the student you want to remove from the grade book?");
		String response = readString();

		if (gradeBook.containsKey(response)) {
			gradeBook.remove(response);

		} else {
			System.out.println("This student does not exist so you cannot remove them");
		}

	}

	public static Double classAverage() {

		int numOfStudents = gradeBook.size();
		Double sum = 0.0;
		for (Map.Entry<String, Double> entry : gradeBook.entrySet()) {
			sum += entry.getValue();
		}

		return sum / numOfStudents;

	}

	public static String readString() {
		String option = null;

		try { // attempts to do this set of code
			option = br.readLine(); // reads the text in the console

			// System.out.println(optionNum); // prints out the file name in
			// console

		} catch (IOException E) { // when the program catches this it will do
									// the code inside the brackets
		}
		return option;
	}

	public static int readInteger() {

		String option = null;// sets filename to blank
		int optionNum = 0;
		try { // attempts to do this set of code
			option = br.readLine(); // reads the text in the console
			optionNum = Integer.parseInt(option);
			// System.out.println(optionNum); // prints out the file name in
			// console

		} catch (IOException E) { // when the program catches this it will do
									// the code inside the brackets
		}
		return optionNum;
	}

	public static Double readDouble() {

		String option = null;// sets filename to blank
		Double optionNum = 0.0;
		try { // attempts to do this set of code
			option = br.readLine(); // reads the text in the console
			optionNum = Double.parseDouble(option);
			// System.out.println(optionNum); // prints out the file name in
			// console

		} catch (IOException E) { // when the program catches this it will do
									// the code inside the brackets
		}
		return optionNum;
	}

	public static int countInRange() {
		System.out.println("Enter the mininum score");
		Double minScore = readDouble();
		System.out.println("Enter the maximum score");
		Double maxScore = readDouble();
		int count = 0;
		for (Map.Entry<String, Double> entry : gradeBook.entrySet()) {
			if (entry.getValue() >= minScore && entry.getValue() <= maxScore) {
				count++;
			}
		}

		return count;

	}
}
