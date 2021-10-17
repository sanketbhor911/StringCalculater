package calculator;


import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class StringCalculatorTest {
	
    @Test
    public void twoNumbersShouldBeAdded() {
        StringCalculator sut = new StringCalculator();
        assertEquals(7, sut.calculate("2,5"));
    }

    @Test
    public void supportNewLineAsSeparator() {
        StringCalculator sut = new StringCalculator();
        assertEquals(6, sut.calculate("1\n2,3"));
    }
    
    @Test
    public void allowNnumersAsInput() {
        StringCalculator sut = new StringCalculator();
        assertEquals(45, sut.calculate("1,2,3,4,5,6,7,8,9"));
    }
   //Support different delimiters
    @Test
    public void supportForCustomDelimiter() {
        StringCalculator sut = new StringCalculator();
        assertEquals(10, sut.calculate(";\n1;2;3;4"));
    }
    
    //Calling Add with a negative number will throw an exception
    @Test
    public void negativeNotSupported() {
        StringCalculator sut = new StringCalculator();
        try {
            sut.calculate("-1;4");
            fail("exception should have been thrown");
        }
        catch (IllegalArgumentException e) {
            assertEquals("negatives not allowed -1", e.getMessage());
        }
    }
    @Test
    public void moreDigitsSupported() {
        StringCalculator sut = new StringCalculator();
        assertEquals(77, sut.calculate("22,55"));
    }
    
}
