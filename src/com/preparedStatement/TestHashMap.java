package com.preparedStatement;

import java.util.HashMap;
import java.util.Map;

import java.util.Iterator;

public class TestHashMap {
	public static void main(String[] args) {
		
		Map<Integer,String> map = new HashMap<Integer,String>();
		
		map.put(1, "Amar");
		map.put(2, "Akbar");
		map.put(3, "Anthony");
		
		System.out.println(map);
		
		System.out.println("========================================================");
		
		System.out.println("Keys: Values");
		for (Map.Entry<Integer, String> m:map.entrySet())
		{
			System.out.print(m.getKey() +":");
			System.out.println(m.getValue() +" ");
		}
		
		System.out.println("========================================================");
		for (Integer key:map.keySet())
		{
			System.out.println("Key set: "+key);
		}
		
		System.out.println("========================================================");
		for (String val:map.values())
		{
			System.out.println("Values: "+val);
		}
		
		System.out.println("========================================================");
		System.out.println("Using Iterator");
		Iterator<Map.Entry<Integer,String>> iterator = map.entrySet().iterator();
		
		while (iterator.hasNext())
		{
			Map.Entry<Integer, String> m = iterator.next();
			System.out.print(m.getKey() +":");
			System.out.println(m.getValue() +" ");
		}
	}
}
