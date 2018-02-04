package predictive;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;


class PredictivePrototypeTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();
	// test for isValidWord method,
	@Test
	public void Test1() {
	// all alphebat
	assertEquals(true,PredictivePrototype.isValidWord("abc"));
	// with non-alphebat
	assertEquals(false,PredictivePrototype.isValidWord("#kk"));
	// with uppercase
	assertEquals(true,PredictivePrototype.isValidWord("Llk"));
	// empty
	assertEquals(true,PredictivePrototype.isValidWord(""));
	
	}
	
	// test for wordToSignature method
	@Test
	public void Test2() {
	// all lowercase alphebat
	assertEquals("43556",PredictivePrototype.wordToSignature("hello").toString());
	// with non-alphebat
	assertEquals(" ",PredictivePrototype.wordToSignature("a*c2").toString());
	// with uppercase alphebat
	assertEquals("222",PredictivePrototype.wordToSignature("Abc").toString());
	// empty
	exception.expect(IllegalArgumentException.class);
	PredictivePrototype.wordToSignature("").toString();
	}
	
	// test for signatureToWords method
	@Test
    public void Test3() {
	// empty
	Set<String> expected1=new HashSet<>();
	assertEquals(expected1,PredictivePrototype.signatureToWords(""));
	// with non-numeric 
	Set<String> expected2=new HashSet<>();
	assertEquals(expected2,PredictivePrototype.signatureToWords("asdfasf"));
	}

}
