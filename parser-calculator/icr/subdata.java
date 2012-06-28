package icr;

public class subdata {
	private float middleResult;
	private int offset;
        private boolean error=false;
	
	public void setVars(float middleResult, int offset){
		this.middleResult=middleResult;
		this.offset=offset;
	}
        
        public void seeError(){
            this.error=true;
        }
	
	public String getMiddleResult(){
            if (this.error) return "Greska u izrazu!";
            else return String.valueOf(this.middleResult);
	}
        
        public boolean isError(){
            return this.error;
        }
        
	public int getOffset(){
		return this.offset;
	}

}
