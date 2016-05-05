package report;

public class SomeOneClass3 implements IPrintable{ 
	
	@Override 
	public void printName() { 
 		System.out.println(this.getClass().getName()); 
	} 
		
}
