package report;

public class SomeOneClass2 implements IPrintable{ 
	
	@Override 
	public void printName() { 
 		System.out.println(this.getClass().getName()); 
	} 
		
}
