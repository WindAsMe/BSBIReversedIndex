package com.bsbiproject.demo;


import java.util.*;

public class DemoApplication {

	public static void main(String[] args) {
		List<String> titles = new ArrayList<>();
		List<String> contexts = new ArrayList<>();
		// map2: index map
		Map<String, List<Tuple>> map = new HashMap<>();

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
				bsbi.createMap(titles, titlesMap, titlesTupleMap, time, 1);
				bsbi.createMap(contexts, contextsMap, contextsTupleMap, time, 2);
				time++;
				map = bsbi.mapTupleMerge(map, bsbi.mapTupleMerge(titlesTupleMap, contextsTupleMap));
				titles.clear();
				contexts.clear();
			}
//			 System.out.println("map1: " + map1.toString());
//			 System.out.println("map2: " + map2.toString());
			System.out.println("Input searching word: ");
			Scanner scanner = new Scanner(System.in);
			String s = scanner.nextLine().toLowerCase();
			System.out.println("Map get word: " + s +"\n" + map.get(s) + "\n");
			List<Map.Entry<String, List<Tuple>>> listSequence = bsbi.createReversedIndex(map);
			System.out.println("Create Reversed Index\n" + listSequence.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
