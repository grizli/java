package icr;

import java.lang.Math;


public class operation {
	private float firstOperand, secondOperand, result, ans;
	private boolean first=true;
        private boolean trigonometric=false;
        private boolean nextNagativ;
        private String trigonometricOperation;
	private String operation;
	
	public void setNumber (String number,subdata data){
                        if (number.isEmpty()){
                            data.seeError();
                            return;
                        }
                        for (char c: number.toCharArray()){
                           if(Character.isLetter(c)){
                               data.seeError();
                               return;
                           }
                        }

			if (this.first){
				this.firstOperand=Float.parseFloat(number);
				this.first=false;
                                if(this.nextNagativ){
                                    this.firstOperand=this.firstOperand*(-1);
                                }
			}else{
				this.secondOperand=Float.parseFloat(number);
                                if(this.nextNagativ){
                                    this.secondOperand=this.secondOperand*(-1);
                                }
			}
	}
	public void setAns(){
		this.firstOperand=this.result;
		this.first=false;
	}
	public void setOperation(String operation,subdata data){
                
                for (char c: operation.toCharArray()){
                           if(Character.isDigit(c)){
                               data.seeError();
                               return;
                           }
                        }
                
                if (operation.charAt(0)=='+' || operation.charAt(0)=='-' || operation.charAt(0)=='*' || operation.charAt(0)=='/'){
                        this.operation=operation.substring(0,1);   
                    if (operation.length()>1 && operation.charAt(1)!='-'){
                    this.trigonometricOperation = operation.substring(1, operation.length());
                    this.trigonometric=true;
                    }
                }else{
                    this.operation=operation;
                }
                if(operation.length()>1 && operation.charAt(operation.length()-1)=='-'){ //ukoliko je slijedeci broj negativan
                    this.nextNagativ=true;
                }else{
                    this.nextNagativ=false;
                }
                
                if(operation.length()>1){
                    if(operation.charAt(operation.length()-1)=='-' && operation.charAt(operation.length()-2)=='-'){
                        data.seeError();
                    }
                }
		
		if(this.first){
			this.firstOperand=this.ans;
			this.first=false;
		}
	}
	public void calculate(subdata data){
            if(this.trigonometric){ //ovo su zapravo funkcije koje se vezu uz prethodni broj
                if (this.trigonometricOperation.compareTo("sin")==0){
			this.secondOperand=(float)Math.sin(Math.toDegrees(this.secondOperand));
		} 
                else if (this.trigonometricOperation.compareTo("cos")==0){
			this.secondOperand=(float)Math.cos(Math.toDegrees(this.secondOperand));
		}
                else if (this.trigonometricOperation.compareTo("tan")==0){
			this.secondOperand=(float)Math.tan(Math.toDegrees(this.secondOperand));
		}
                else if (this.trigonometricOperation.compareTo("ctg")==0){
			this.secondOperand=(float)Math.tan(Math.toDegrees(this.secondOperand));
		}
                else if(this.trigonometricOperation.compareTo("log10")==0){
                        this.secondOperand=(float)Math.log10(this.secondOperand);
                }
                else if(this.trigonometricOperation.compareTo("pow")==0){
                        this.secondOperand=(float)Math.pow(this.firstOperand, this.secondOperand);
                }
                else if(this.trigonometricOperation.compareTo("ln")==0){
                        this.secondOperand=(float)Math.log(this.secondOperand)/(float)Math.log(Math.E);
                }
                else{
                    data.seeError();
                    return;
                }
		this.trigonometric=false;
            }
                
		if(this.operation.compareTo("+")==0){
			this.result=this.firstOperand+this.secondOperand;
		}else if (this.operation.compareTo("-")==0){
			this.result=this.firstOperand-this.secondOperand;
		}else if (this.operation.compareTo("*")==0){
			this.result=this.firstOperand*this.secondOperand;
		}else if (this.operation.compareTo("/")==0){
			this.result=this.firstOperand/this.secondOperand;
		}else if (this.operation.compareTo("sin")==0){
			this.result=(float)Math.sin(Math.toDegrees(this.secondOperand));
		}else if (this.operation.compareTo("cos")==0){
			this.result=(float)Math.cos(Math.toDegrees(this.secondOperand));
		}
		else if (this.operation.compareTo("tan")==0){
			this.result=(float)Math.tan(Math.toDegrees(this.secondOperand));
		}
		else if (this.operation.compareTo("ctg")==0){
			this.result=(float)(1/Math.tan(Math.toDegrees(this.secondOperand)));
		}
                else if(this.operation.compareTo("log10")==0){
                        this.result=(float)Math.log10(this.secondOperand);
                }
                else if(this.operation.compareTo("pow")==0){
                        this.result=(float)Math.pow(this.firstOperand, this.secondOperand);
                }
                else if(this.operation.compareTo("ln")==0){
                        this.result=(float)Math.log(this.secondOperand)/(float)Math.log(Math.E);
                }
                else{
                    data.seeError();
                    return;
                }
		this.first=true;
	}
	public float getResult(){
		return this.result;
	}
	public void reset(){
		this.first=true;
		this.ans=0;
	}

}