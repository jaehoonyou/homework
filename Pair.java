package report;


/**
 *  equals() 메소드를 override 했다면
 *  hashCode()메소드도 override해주어야 한다.
 */
public class Pair<T1, T2>{
	T1 t1;
	T2 t2;
	
	private volatile  int hashCode;


	public Pair(T1 t1, T2 t2) {
		this.t1 = t1;
		this.t2 = t2;
	}

	/** 
	* 31은 소수이면서 홀수이다. 소수를 사용하는 장점은 명확하지는 않지만 전통적이다.
	* 31이 좋은 속성은 곱셉 변화 및 성능 향상을 위한 감산에의해 대체될 수 있다.
	* 문자열의 각각 Byte의 ASCII 코드 공식을 통해 더해진
	* 총합을 hash값으로 사용하고 있다.
	*/

	@Override public int hashCode() {
		int result = hashCode;
        if (result == 0) {
            result = 17;
            result = 31 * result + t1.hashCode();
            result = 31 * result + t2.hashCode();
            
            hashCode = result;
        }
        return result;
	}
	
	/** 
	* 확장 제너릭을 통한 equals 재정의 
	*/
	@Override public boolean equals(Object obj) {
		boolean result = false;
		
		if(obj instanceof Pair)	{
			Pair<?, ?> pr = (Pair<?, ?>) obj;
			result = ((obj instanceof Pair) &&  pr.t1.equals(t1) && pr.t2.equals(t2));
		}
		
		return result;
	}
}