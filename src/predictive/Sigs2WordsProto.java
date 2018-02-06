/** 
 * @author YU-NING,CHANG
 */
package predictive;

public class Sigs2WordsProto {

	public static void main(String[] args) {	
		for(int i=0;i<args.length;i++) {
			System.out.println(args[i]+": "+
					PredictivePrototype.signatureToWords(args[i]));
		}
//		ChangRickdeMacBook-Pro:predictive rickchang$ time java -cp .. predictive.Sigs2WordsProto 
//		9474636684323 94746377 9474647 9475 94752 94748 9476 94764254 9477 94773 947735 9477464 9478 948 22
//			9474636684323: [xiphodontidae]
//			94746377: [wishness, wiriness]
//			9474647: [wirings]
//			9475: [yirk, wirl]
//			94752: [ziska, wisla]
//			94748: [wisht]
//			9476: [yirm, yirn, wipo]
//			94764254: [wisnicki]
//			9477: [wips, wirr, wiss, wisp, yirr, yips, zips]
//			94773: [wisse]
//			947735: [wissel, zippel]
//			9477464: [zipping, wisping, yirring, wissing, yipping]
//			9478: [wist]
//			948: [wit, xiv, zit, ziv]
//			22: [aa, bb, cc, ab, bc, ac, ca, ba, cb]
//			real	0m10.109s
//			user	0m10.940s
//			sys	0m0.307s
	}

}

