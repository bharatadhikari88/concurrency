package org.eagle.concurrency;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/** iterator of ConcurrentHashMap is fail safe where as iterator of others are fail fast **/
/** fail fast mean modification to structure while iterating throw concurrentmodification exception **/
/** special case:- hashmap not failing for last element **/
public class ConcurrentMapFailFast {

	public static void main(String[] args) {
		ConcurrentHashMap<Integer, String> cMap = new ConcurrentHashMap<>();
		//HashMap<Integer, String> cMap = new HashMap<Integer, String>();
		cMap.put(1, "one");
		cMap.put(2, "two");
		cMap.put(3, "three");
		
		Iterator<Map.Entry<Integer, String>> itr = cMap.entrySet().iterator();
		while(itr.hasNext()){
			if(itr.next().getKey() == 2){
				cMap.put(4, "four");
			}
		}
		
		System.out.println(cMap.size());
	}

}
