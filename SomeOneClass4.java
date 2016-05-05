package report;

public class SomeOneClass4 implements IPrintable{ 
	
	@Override 
	public void printName() { 
 		System.out.println(this.getClass().getName()); 
	} 
		
}
