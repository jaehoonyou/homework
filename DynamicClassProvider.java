package report;
import java.util.Map;
import java.util.WeakHashMap;

/**  
 * @Class Name : DynamicClassProvider.java
 * @Description : 
 * 네임 정보 서비스 제공 Provider
 * @Modification Information  
 * @
 * @  수정일		수정자		수정내용
 * @ ---------	---------	-------------------------------
 * @ 2016.05.02  유재훈		최초생성
 * 
 * @author 
 * @since 2016. 05.02
 * @version 1.0
 * @see
 * 
 *  Copyright (C) by 유재훈 All right reserved.
 */
public class DynamicClassProvider{
	
	private static Map<Pair<String, String>, String>     m_cls = new WeakHashMap<Pair<String, String>, String>();
	private static Map<Pair<String, String>, Class<?>> m_cache = new WeakHashMap<Pair<String, String>, Class<?>>();
	
	/**
	 *  nick 네임 과 creator 정보 , 경로 정보를 받아 등록 한다. 
	 * @param nick
	 * @param creator
	 * @param path
	 */
	public static void register(String nick, String creator, String path){
		Pair<String, String> newPair = new Pair<String, String>(nick, creator);
		if(m_cls.put(newPair, path) != null){
			try {
				m_cache.put(newPair, Class.forName(path));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * nick 네임 과 creator 정보 를 입력 받는고 클래스를 m_cache(캐쉬 맵)에서 먼저 찾는다
	 * 캐시에 someOneClass의 정보가 있는지 확인
	 * @param nick
	 * @param creator
	 * @return someOneClass instance Object를 반환한다.
	 */
	public static Object newInstance(String nick, String creator){
		
		Pair<String, String> pair = new Pair<String, String>(nick, creator);
		Object obj                = null; // 캐시맵에 없을 경우 null을 반환
		String classPath          = null;
		Class <?> sameClassType   = null; // 동일한 클래스가 있는지 여부를 위한 확장 제너릭 클래스 
		
		try {
			
			if( ((sameClassType = m_cache.get(pair)) != null)) {
				System.out.print("캐시에서 찾는다 ::: ");
				return (Object) sameClassType.newInstance();
			}

			if((classPath = m_cls.get(pair)) != null) {
				obj = (Object) (Class.forName(classPath)).newInstance();
				System.out.print("맵 정보에서 찾는다 :::  ");
			} else {
				System.out.println("등록된 정보 없음 :::");
			}
			
			if(obj != null && classPath != null){
				sameClassType = Class.forName(classPath);
				m_cache.put(pair, sameClassType);  // 같은 클래스가 있으면 캐시에 등록한다.
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}
}

