/**
 * @author YU-NING,CHANG
 */
package predictive;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PredictivePrototype {
	
	
	/**
	 * helper function
	 * @param word- String for any format
	 * @return boolean- true if the given string is alphabet no matter upper case or lower case
	 * 					false if the given string is not an alphabet
	 */
	public static boolean isValidWord(String word) {
		return word.matches("[a-zA-Z]*");
	}

	/**
	 * @param word- String for any format
	 * @return StringBuffer- turn the given string into corresponding number as below:
	 * ----------------------
	 * 1      2(abc)  3(def)
	 * ----------------------
	 * 4(ghi) 5(jkl)  6(mno)
	 * ----------------------
	 * 7(pqr) 8(tuv)  9(wxyz)
	 * ----------------------
	 * *		  space   #			
	 * 
	 * We use "StringBuffer" instead of "String" because it allows us to add strings directly 
	 * by calling append method so that the computer is able to reduce the cost of memory
	 * when looping. 
	 */
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
	/**
	 * The scanenr will read the file every time when this method is given the signatures
	 * and it costs O(n) in worse case for each search so it may not so efficient.
	 * @param  signature- String for any format (ususally we put numeric string)
	 * @return Set<String>- A set contains the possible strings based on given signature.
	 */
	public static Set<String> signatureToWords(String signature) {
		
		Set<String> possibleResult = new HashSet<>();
		
		try {
			FileReader reader = new FileReader("/usr/share/dict/words");
			// FileReader reader = new FileReader("/Users/rickchang/eclipse-workspace/WS2-3/words");
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

//	public static void main(String[] args) {
//		System.out.println(""+signatureToWords("9667"));
//	}

}
