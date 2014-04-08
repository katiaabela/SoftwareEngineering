/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jenkins;

/**
 *
 * @author Christopher
 */
public class Calculator {
    
   public int add(int a, int b)
{
    return a+b;
}

public int subtract(int a, int b)
{
    return a-b;
}

public int multiply(int a, int b)
{
    return a*b;
}

public int divide(int a, int b)
{
    if(b == 0){
        return -999;}
    else{
        return a/b;}
}

public String getMessage(int n)
{
    String s = "";
    for(int i = 0; i < n; i++){
        s = s +  "Hello World!\n";}
    
    return s;
}

public int addString(String numbers)
{
    return 0;
}
}
