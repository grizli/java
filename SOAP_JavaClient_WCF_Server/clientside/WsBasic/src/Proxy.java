/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author IvanT
 */
public class Proxy{
    ICalculator port=null;
    public ICalculator connectToServer(){
        System.out.println("Connecting...");
        try{
            CalculatorServiceBasic client = new CalculatorServiceBasic(new URL("http://localhost:8000/Calculator/?wsdl"), new QName("http://tempuri.org/","CalculatorServiceBasic"));
            port=client.getBasic();
            ((BindingProvider) port).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8000/Calculator/basic");
            System.out.println("Connected!");
            return this.port;
        }catch(Exception ex){
            System.out.println(ex.toString());
            return null;
        }
    }
    public ICalculator disconnectFromServer(){
        this.port=null;
        System.out.println("Disconnected!");
        return this.port;
    }
    public boolean isConnected(){
        if(this.port!=null) return true;
        else return false;
    }
}
