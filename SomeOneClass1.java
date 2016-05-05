package report;

public class SomeOneClass1 implements IPrintable{ 
	
	@Override 
	public void printName() { 
 		System.out.println(this.getClass().getName()); 
	} 
		
}
