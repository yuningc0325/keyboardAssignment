/**
 * @author YU-NING,CHANG
 */
package predictive;
public class WordSig implements Comparable<WordSig>{
	private String words;
	private String signature;
	/**
	 * constructor of WordSig
	 * @param word- String for any format
	 * @param signature- String for any format (ususally we put numeric string)
	 */
	public WordSig(String words, String signature) {
		this.words=words;
		this.signature=signature;
	}
	
	/**
	 * @return the words
	 */
	public String getWords() {
		return words;
	}

	/**
	 * @return the signature
	 */
	public String getSignature() {
		return signature;
	}

	/**
	 * rewrite compareTo method
	 * @param s- tWordSig datatype
	 * @return int-  1 the previouse signature is greater than next signature
	 * 			    -1 the previouse signature is smaller than next signature
	 * 				 0 the previouse signature is equal to next signature
	 */
	public int compareTo(WordSig s) {
		if(this.signature.compareTo(s.getSignature())>0) {
			return 1;
		}
		if(this.signature.compareTo(s.getSignature())<0) {
			return -1;
		}		
		return 0;
	}
}
