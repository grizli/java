/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author IvanT
 */
public class ProxyDC{
    ICalculatorDC port=null;
    public ICalculatorDC connectToServer(){
        System.out.println("Connecting...");
        try{
            CalculatorServiceBasicDC client = new CalculatorServiceBasicDC(new URL("http://localhost:8000/CalculatorDC/?wsdl"), new QName("http://tempuri.org/","CalculatorServiceBasicDC"));
            port=client.getBasicDC();
            ((BindingProvider) port).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8000/CalculatorDC/basicDC");
            System.out.println("Connected!");
            return this.port;
        }catch(Exception ex){
            System.out.println(ex.toString());
            return null;
        }
    }
    public ICalculatorDC disconnectFromServer(){
        this.port=null;
        System.out.println("Disconnected!");
        return this.port;
    }
    public boolean isConnected(){
        if(this.port!=null) return true;
        else return false;
    }
}
