package icr;
/*
 * ako nailazi na brojku na charat() onda pomice index+1, inace pretvori u broj, i ako je ( 
 * ponovno zove sebe, ans je sve do tog trenutka, selektira operaciju  ipovratak je drugi 
 * argument operacije, te vraca midle rezultat i pomak obradjenih znakova.
 * U funkciji u while petlji se sece po stringu sve dok ne dodje do kraja il do svoje zagrade )
 * pri tome nalazi brojeve, zbraja, sumira itd td, i na kraju vrati isti entitet.
 * 
 */


public class parseInput {
	private int i=0;
	private int first,second;
	private parseInput leveling;
	private subdata data = new subdata();
	private String oper,num;
	private boolean firstArg=true;
	private operation operation = new operation();
	
	public String oper(String expression, int start, int size){
		int i=start,end=start;
		while(i<size){
			if(expression.charAt(i)!='(' && !(expression.charAt(i)<='9' && expression.charAt(i)>='0')){
				end++;
			}else break;
			i++;
		}
		return expression.substring(start, end);
	}
	
	public subdata parse(String expression, int start, int size){
		this.i=this.first=this.second=start;
		while(this.i< size && !this.data.isError()){ //prolaz po stringu 
			if(( expression.charAt(this.i)<='9' && expression.charAt(this.i)>='0') || expression.charAt(this.i)=='.') { //ako je brojka
				this.second++;
			}else{ //naisli na operaciju ili (
				if(expression.charAt(this.i)=='('){
                                     if(this.firstArg){
                                         this.operation.setOperation("+",this.data);
                                         this.operation.setNumber("0", data);
                                     }
					this.leveling = new parseInput();
					this.data = this.leveling.parse(expression, this.i+1, size);
					this.first = this.first + 1 + this.data.getOffset(); 
                                        this.i=this.first-1;
                                        this.second=this.first;
                                        this.operation.setNumber(this.data.getMiddleResult(), this.data);
                                        this.operation.calculate(this.data);
                                        this.operation.setAns();
                                        continue;
				}else{
					if(this.firstArg){
						this.operation.setNumber("0",this.data);
                                                if (this.data.isError()) break;
                                                this.operation.setOperation("+",this.data);
						this.firstArg=false;
                                                if(this.second < size && expression.charAt(this.second)==')'){
                                                    this.data.setVars(Float.parseFloat(expression.substring(this.first, this.second)), expression.substring(this.first, this.second).length()+1);
                                                    return this.data;
                                                }else if (this.second==size-1){
                                                    this.data.setVars(Float.parseFloat("0"), 0);
                                                    return this.data;
                                                }
					}
                                        if (this.first==this.second){
                                            this.num="0";
                                        }else{
                                            this.num = expression.substring(this.first, this.second);
                                        }
                                        this.oper = this.oper(expression, this.second, size);
                                     
                                        this.operation.setNumber(this.num,this.data);
                                        if (this.data.isError()) break;
					this.operation.calculate(this.data);
					//postaviti operaciju
					//postaviti ans
					this.operation.setAns();
                                        if (this.oper.length()==0){
                                            this.data.seeError();
                                            break;
                                        }
					this.operation.setOperation(this.oper,this.data);
					
					if(expression.charAt(this.second)==')'){
						this.data.setVars(this.operation.getResult(), this.i-start+1);
						return this.data;
					}else{
                                            /////////////////
                                            this.first=this.second+this.oper.length();
                                            this.i=this.first-1;
                                            this.second=this.first;
                                        }
				}
			}
			this.i=this.i+1;
		}
                if(!this.data.isError() && this.i==size && expression.charAt(this.i-1)!=')'){
                    this.operation.setNumber(expression.substring(this.first, this.second),this.data);
                    if(!this.data.isError()) this.operation.calculate(this.data);
                }
                this.data.setVars(this.operation.getResult(), this.i - start);
		return this.data;
	}

}
