package predictive;


public class Sigs2WordsProto {

	public static void main(String[] args) {
		for(int i=0;i<args.length;i++) {
			System.out.println(args[i]+": "+
					PredictivePrototype.signatureToWords(args[i]));
		}
	}

}

