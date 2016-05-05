package report;

public class SomeOneClass5 implements IPrintable{ 
	
	@Override 
	public void printName() { 
 		System.out.println(this.getClass().getName()); 
	} 
		
}
