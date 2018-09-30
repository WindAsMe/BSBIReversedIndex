package com.bsbiproject.demo;


import java.util.*;

public class DemoApplication {

	public static void main(String[] args) {
		List<String> titles = new ArrayList<>();
		List<String> contexts = new ArrayList<>();
		// map1: context map
		Map<String, Integer> map1 = new HashMap<>();
		// map2: index map
		Map<String, List<Tuple>> map2 = new HashMap<>();

		BSBI bsbi = new BSBI();
		try {
			int i = 1;
			int time = 0;
			for (; i <= 40; i += 10) {
				bsbi.readExcel(titles, contexts, i, i + 10);
				Map<String, Integer> titlesMap = new HashMap<>();
				Map<String, Integer> contextsMap = new HashMap<>();
				Map<String, List<Tuple>> titlesTupleMap = new HashMap<>();
				Map<String, List<Tuple>> contextsTupleMap= new HashMap<>();
				bsbi.createContextMap(titles, titlesMap, titlesTupleMap, time, 1);
				bsbi.createContextMap(contexts, contextsMap, contextsTupleMap, time, 2);
				time++;
				map1 = bsbi.mapMerge(map1, titlesMap, contextsMap);
				map2 = bsbi.mapTupleMerge(map2, titlesTupleMap, contextsTupleMap);
				titles.clear();
				contexts.clear();
			}
			System.out.println("map1: " + map1.toString());
			System.out.println("map2: " + map2.toString());
			System.out.println(map2.get("abstract"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
