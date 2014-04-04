import static org.junit.Assert.*;
import org.junit.Test;


public class CalcTest {

	@Test
	public void newTest(){
		Calculator clc = new Calculator();
		assertEquals(4, clc.add(2,2));
		assertEquals(1, clc.subtract(5, 4));
		assertEquals(25, clc.multiply(5, 5));
		assertEquals(5, clc.divide(10, 2));
		assertEquals(-999, clc.divide(10, 0));
	}
	
}