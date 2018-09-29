package com.bsbiproject.demo;


import java.util.*;

public class DemoApplication {

	public static void main(String[] args) {
		List<String> titles = new ArrayList<>();
		List<String> contexts = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();

		BSBI bsbi = new BSBI();
		try {
			for (int i = 1; i <= 40; i += 10) {
				bsbi.readExcel(titles, contexts, i, i + 10);
				System.out.println(titles.toString());
				System.out.println(contexts.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
