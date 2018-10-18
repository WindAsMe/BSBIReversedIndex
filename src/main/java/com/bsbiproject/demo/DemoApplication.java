package com.bsbiproject.demo;


import com.bsbiproject.demo.domain.Cell;
import com.bsbiproject.demo.domain.JDModel;
import com.bsbiproject.demo.domain.Tuple;
import com.bsbiproject.demo.util.BSBIUtil;
import com.bsbiproject.demo.util.ConUtil;
import com.bsbiproject.demo.util.StopWordUtil;
import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;

import java.util.*;

public class DemoApplication {


	public static void main(String[] args) {
		Map<String, List<Cell>> map = new HashMap<>();

		// Connection of Mysql
		ConUtil conUtil = new ConUtil();
		BSBIUtil bsbiUtil = new BSBIUtil();
		List<JDModel> models = conUtil.getSelect();

		bsbiUtil.split(models);
		List<Tuple> tuples = bsbiUtil.getTuples();
		for (Tuple tuple : tuples) {
			for (SegToken token : tuple.getTokens()) {
				// data normalization
				Cell cell = new Cell(tuple.getId(), tuple.getUrl(), token);
				if (map.get(cell.getToken().word) != null) {
					List<Cell> list = map.get(cell.getToken().word);
					list.add(cell);
					map.put(cell.getToken().word, list);
				} else {
					List<Cell> list = new ArrayList<>();
					list.add(cell);
					map.put(cell.getToken().word, list);
				}
			}
		}

		// Create the Reversed Index
		List<Map.Entry<String, List<Cell>>> listReversed = new ArrayList<>(map.entrySet());
		listReversed.sort((o1, o2) -> {
            if (o1.getValue().size() == o2.getValue().size())
                return o1.getKey().compareTo(o2.getKey());
            else
                return o1.getValue().size() - o2.getValue().size();
        });


		// System.out.println(map.toString());
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input the word: ");
		if (scanner.hasNext()) {
			String s = scanner.next();
            JiebaSegmenter segmenter = new JiebaSegmenter();
            StopWordUtil util = new StopWordUtil();
            List<SegToken> tokens = segmenter.process(s, JiebaSegmenter.SegMode.INDEX);
            List<String> words = new ArrayList<>();
            List<Cell> list = new ArrayList<>();
            for (SegToken token : tokens) {
                if (!util.stop(token.word))
                    words.add(token.word);
            }

            for (String word : words)
                list.addAll(map.get(word));
            System.out.println("The input word after spilt:");
            for (String word : words)
                System.out.print(word + ", ");
            System.out.println("The correlative essay:");
			for (Cell c : list)
				System.out.println(c.toString());
		}
		scanner.close();
	}
}
