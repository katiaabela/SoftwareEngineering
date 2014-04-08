package jenkins;

import org.junit.Test;
import static org.junit.Assert.*;

public class Jenkins {
    /**
     * @param args the command line arguments
     */
    
    @Test
    public static void TestCalc()
    {
        Calculator calc = new Calculator();
        //assertEquals("4/0 = ", -999, calc.divide(4,0));
        assertEquals("Hello World!\n", calc.getMessage(1));
        //calc.divide(4,0 World);
    }
    
    //@Test
    //public static void 
    
    public static void main(String[] args) {
        // TODO code application logic here
        /*Calculator calc = new Calculator();
        
        System.out.println(calc.divide(4,0));*/
        TestCalc();
    }
}
