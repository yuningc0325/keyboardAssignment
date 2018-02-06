/**
 * The class is about a list storing the words and corresponding signatures from the dictionary 
 * and contains the method which can return a set of corresponding words as a signature is given.
 * @author YU-NING,CHAGN
 */
package predictive;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class ListDictionary implements Dictionary{
	
	public List<WordSig> pairList =new  ArrayList<WordSig>();
	
	/**
	 * contructor of ListDictionary
	 * It is uesed to initialise the list
	 */
	public ListDictionary() {
		try {
			FileReader reader = new FileReader("/usr/share/dict/words");
			// FileReader reader = new FileReader("/Users/rickchang/eclipse-workspace/WS2-3/words");
			Scanner scanner = new Scanner(reader);
			String content;
			
			while (scanner.hasNextLine()) {
				content = scanner.nextLine().toLowerCase();
				// store word and it's signature in list of pair (WordSig object)
				pairList.add(new WordSig
						(content,PredictivePrototype.wordToSignature(content).toString()));
			}
			// sort the elements in the list 
			Collections.sort(pairList);
			scanner.close();
		} catch (IOException exception) {
			System.out.println("can't get the file");
		}
	}
	
	/**
	 * @return the pairList
	 */
	public List<WordSig> getPairList() {
		return pairList;
	}
	
	/**
	 * When using binary search, it costs O(log n) in worse case for each search rather than O(n).
	 * Additionally, the file is only read at the first time so it can perform more efficiently. 
	 * @param signature- String for any format (ususally we put numeric string)
	 * @return Set<String>- A set contains the possible strings based on given signature.
	 */
	public Set<String> signatureToWords (String signature){
		Set<String> result=new HashSet<String>();
		WordSig checked =new WordSig("",signature);
		// using binary search. the 
		int index =Collections.binarySearch(pairList,checked);
		// precondition, when index is smaller than 0, 
		//it means that there is no correspoding result.
		if(index<0) {
			return new HashSet<String>();
		}
		else {
	
		// search forward
		for(int i=index;getPairList().get(i).getSignature().equals(signature);i++) {
			result.add(getPairList().get(i).getWords());
		}
		
		// search backward, deduct the index position for avoiding from duplicate
		for(int j=index-1;getPairList().get(j).getSignature().equals(signature);j--) {
			result.add(getPairList().get(j).getWords());
		}
		}
		return result;
	}
	
//	public static void main(String[] args) {
//		ListDictionary k =new ListDictionary();
//		//print all el from dictionary
//		for(int i=0;i<k.getPairList().size();i++) {
//			System.out.println(k.getPairList().get(i).getWords()+" "
//						+k.getPairList().get(i).getSignature());
//		}
//		System.out.println(k.signatureToWords("999"));
//	}
	
}

