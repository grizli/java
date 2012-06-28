/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package icr;

/**
 *
 * @author ivan
 */
public class Icr {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        parseInput test = new parseInput();
        /*
         * BE AWARE!!!!!
         * ZA SVAKI NOVI RACUN IDE NOVA INSTANCA!!!! INACE DETEKCIJE GRESKE NE RADE!
         */
		subdata data = new subdata();
         
		String expression = "1.512+200*200-500";
	/*	data = test.parse(expression, 0,expression.length());
		System.out.println(data.getMiddleResult());
                System.out.println(data.getOffset());
          
                expression = "200*(400/3)+10-1";
		data = test.parse(expression, 0,expression.length());
		System.out.println(data.getMiddleResult());
                System.out.println(data.getOffset());
             
                expression = "10+(2*sin(10))";
		data = test.parse(expression, 0,expression.length());
		System.out.println(data.getMiddleResult());
                System.out.println(data.getOffset());
              
 
                
                expression = "sin(10)";
		data = test.parse(expression, 0,expression.length());
		System.out.println(data.getMiddleResult());
                System.out.println(data.getOffset());
               
                expression = "(10)";
		data = test.parse(expression, 0,expression.length());
		System.out.println(data.getMiddleResult());
                System.out.println(data.getOffset());
         */    
                expression = "(5/4)*3";
		data = test.parse(expression, 0,expression.length());
		System.out.println(data.getMiddleResult());
                System.out.println(data.getOffset());
                
                
    }
}
