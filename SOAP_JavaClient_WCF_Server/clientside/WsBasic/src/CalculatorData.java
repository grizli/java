
/**
 *
 * @author IvanT
 */
public class CalculatorData {

    private String brojka="";
    private double n1;
    private double n2;
    private String operacija;
    private boolean datacontracts;

    public String dodajBroj(String zn){
        this.brojka=this.brojka.concat(zn);
        return this.brojka;
    }
    public void brojDouble(int br){
        if(br==1){
            this.n1=Double.parseDouble(brojka);
        }else if(br==2){
            this.n2=Double.parseDouble(brojka);
        }
    }
    public void reset(){
        this.brojka="";
    }
    public void zadajOp(String str){
        this.operacija=str;
    }

    public void CalculatorDataNormal(){
        
    }

    public void CalculatorDataDC(boolean set){
        if(set){
            this.datacontracts=true;
        }else{
            this.datacontracts=false;
        }
    }

    public String Execute(){
      if(!this.datacontracts){
        ICalculator port=null;
        Proxy proxy = new Proxy();
        port = proxy.connectToServer();

        if(this.operacija.equals("add")){
            return port.add(this.n1, this.n2).toString();
        }
        if(this.operacija.equals("sub")){
            return port.sub(this.n1, this.n2).toString();
        }
        if(this.operacija.equals("mul")){
            return port.mul(this.n1, this.n2).toString();
        }
        if(this.operacija.equals("div")){
            return port.div(this.n1, this.n2).toString();
        }
        port=null;

        }else{
            ICalculatorDC port=null;
            ProxyDC proxy = new ProxyDC();
            port = proxy.connectToServer();

            CalcNumbers nums=new CalcNumbers();
            CalcNumbers res=new CalcNumbers();

            if(this.operacija.equals("add")){
                nums.setBr1(n1);
                nums.setBr2(n2);
                res=port.addDC(nums);
                return res.getBr1().toString();
            }
            if(this.operacija.equals("sub")){
                nums.setBr1(n1);
                nums.setBr2(n2);
                res=port.subDC(nums);
                return res.getBr1().toString();
            }
            if(this.operacija.equals("mul")){
                nums.setBr1(n1);
                nums.setBr2(n2);
                res=port.mulDC(nums);
                return res.getBr1().toString();
            }
            if(this.operacija.equals("div")){
                nums.setBr1(n1);
                nums.setBr2(n2);
                res=port.divDC(nums);
                return res.getBr1().toString();
            }
        port=null;
        }
        return "error";


    }
    
}
