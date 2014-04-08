import static org.junit.Assert.*;

import org.junit.Test;


public class tester {

	@Test
	public void test() {
		launcher calc = new launcher();
		assertEquals(calc.add(1,1), 2);	
	}

}
