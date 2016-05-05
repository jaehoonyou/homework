package report;

public class Test {

public static void main(String[] args) {
		
		DynamicClassProvider.register("Trident", "M1", SomeOneClass1.class.getName());
		DynamicClassProvider.register("Trident", "M2", SomeOneClass2.class.getName());
		DynamicClassProvider.register("Trident", "M3", SomeOneClass3.class.getName());
		DynamicClassProvider.register("Trident", "M4", SomeOneClass4.class.getName());
		DynamicClassProvider.register("Trident", "M5", SomeOneClass5.class.getName());
		
		// test 1 
		System.out.println("정상");
		Object obj01 = DynamicClassProvider.newInstance("Trident", "M1");
		if(obj01 != null) ((IPrintable)obj01).printName();
		
		System.out.println("/////////////////////////////////////////////////////////");
		
		// test 2 
		//  같은 정보를 등록 했을경우 같은 클래스 네임을 반환
		System.out.println("캐시");
		Object obj02 = DynamicClassProvider.newInstance("Trident", "M2");
		if(obj02 != null) ((IPrintable)obj02).printName();
		
		Object obj03 = DynamicClassProvider.newInstance("Trident", "M2");
		if(obj03 != null) ((IPrintable)obj03).printName();
		
		System.out.println("/////////////////////////////////////////////////////////");
		
		// test 3 
		// 기 등록된 정보를  등록 햇을경우 오버라이트 한다.
		System.out.println("오버라이트");
		
		Object obj04 = DynamicClassProvider.newInstance("Trident", "M3");
		if(obj04 != null) 
			((IPrintable)obj04).printName(); 
		    DynamicClassProvider.register("Trident", "M3", Test.class.getName());
		
		Object obj05 = DynamicClassProvider.newInstance("Trident", "M3");
		if(obj05 != null) ((IPrintable)obj05).printName();
		
	}

}
