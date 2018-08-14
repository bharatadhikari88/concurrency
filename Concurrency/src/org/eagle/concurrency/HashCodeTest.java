package com.spacetime.test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class HashCodeTest {
	private static class Test{
		int i;
		public Test(int hashcode) {
			i = hashcode;
		}
		@Override
		public boolean equals(Object obj) {
			return false;
		}
		@Override
		public int hashCode() {
			return i;
		}
	}
	
	private static class Test2{
		String i;
		String j;
		public Test2(String i) {
			this.i = i;
		}
		public void seti(String t){
			i = t;
		}
		public void setj(String t){
			j = t;
		}
	}

	public static void main(String[] args) {
		HashSet aset = new HashSet<>();
		aset.add(null);
		
		
		/*String s1 = "abc";
		String s2 = new String("abc");*/
		Test s1 = new Test(32);
		Test s2 = new Test(32);
		System.out.println("Equals :- " + s1.equals(s2));
		System.out.println("HashCode s1 :- " + s1.hashCode());
		System.out.println("HashCode s2 :- " + s2.hashCode());
		
		HashMap map = new HashMap<>();
		map.put(s1, "a");
		map.put(s2, "b");
		System.out.println(map.keySet().size());
		
		TreeSet set = new TreeSet<>(new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		set.add(null);
		set.add(null);
		
		TreeMap map1 = new TreeMap<>(new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		map1.put(null,"abc");
		map1.put(null,"abcd");
		System.out.println(set.first());
		System.out.println(map1.get(null));
		
		Test2 a = new Test2("abc");
		Test2 b = new Test2("dregdf");
		HashMap map3 = new HashMap<>();
		map3.put(a, "a");
		map3.put(b, "b");
		System.out.println(b.hashCode());
		b.setj("ffhfjhjfjhfjfj");
		System.out.println(b.hashCode());
		System.out.println(map3.get(new Test2("dregdf")));
		
	}

}
