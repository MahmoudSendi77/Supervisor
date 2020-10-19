package calculatrice;



public class Modele  {
	private static final long serialVersionUID = 1L;
	String value="0";
	public Modele(){}
	public String getValue(){
		return value;
	}
	public void setValue(String value){
		this.value=value;
	}
	public double getDouble(){
		return Double.valueOf(value).doubleValue();
	}
}
