package predictive;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PredictivePrototype {

	// public static final char[] alphabet =
	// new char[] {'a','b','c','d','e','f','g','h','i','j','k','l',
	// 'm','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	// helper function
	public static boolean isValidWord(String word) {
		return word.matches("[a-zA-Z]*");
	}

	public static StringBuffer wordToSignature(String word) {

		ArrayList<String> resultArr = new ArrayList<>();
		StringBuffer result = new StringBuffer();
		String wordToLowerCase = word.toLowerCase();
		
		if(wordToLowerCase.equals(null)) {
			throw new IllegalArgumentException("empty value in argument");
		}

		if (isValidWord(word)) {

			for (int i = 0; i < word.length(); i++) {
				char checkChar = wordToLowerCase.charAt(i);
			
				if (checkChar == 'a' || checkChar == 'b' || checkChar == 'c') {
					// number2
					resultArr.add("2");
				} else if (checkChar == 'd' || checkChar == 'e' || checkChar == 'f') {
					// number3
					resultArr.add("3");
				} else if (checkChar == 'g' || checkChar == 'h' || checkChar == 'i') {
					// number4
					resultArr.add("4");
				} else if (checkChar == 'j' || checkChar == 'k' || checkChar == 'l') {
					// number5
					resultArr.add("5");
				} else if (checkChar == 'm' || checkChar == 'n' || checkChar == 'o') {
					// number6
					resultArr.add("6");
				} else if (checkChar == 'p' || checkChar == 'q' || checkChar == 'r' || checkChar == 's') {
					// number 7
					resultArr.add("7");
				} else if (checkChar == 't' || checkChar == 'u' || checkChar == 'v') {
					// number 8
					resultArr.add("8");
				} else if (checkChar == 'w' || checkChar == 'x' || checkChar == 'y' || checkChar == 'z') {
					// number 9
					resultArr.add("9");
				} else {
					resultArr.add(" ");

				}
			}
		} else {
			resultArr.add(" ");
		}

		for (int i = 0; i < resultArr.size(); i++) {
			result.append(resultArr.get(i));
		}

		return result;

	}

	public static Set<String> signatureToWords(String signature) {

		Set<String> possibleResult = new HashSet<>();
		
		try {
			FileReader reader = new FileReader("words");
			Scanner scanner = new Scanner(reader);
			String content;
			while (scanner.hasNextLine()) {
				content = scanner.nextLine().toLowerCase();
				if (signature.equals(wordToSignature(content).toString())) {
					possibleResult.add(content);
				}
			}
			scanner.close();
		} catch (IOException exception) {
			System.out.println("can't get the file");
		}
		return possibleResult;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(wordToSignature(""));
		System.out.println("" + isValidWord("aaaaa"));
		System.out.println("" + signatureToWords(""));
	}

}
