package com.bsbiproject.demo;


import com.bsbiproject.demo.util.BSBIUtil;
import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;
import org.springframework.data.redis.connection.RedisZSetCommands;

import java.util.*;

public class DemoApplication {

	public static void main(String[] args) {
		JiebaSegmenter segmenter = new JiebaSegmenter();
		String[] sentences =
				new String[] {"这是一个伸手不见五指的黑夜。我叫孙悟空，我爱北京，我爱Python和C++。", "我不喜欢日本和服。", "雷猴回归人间。",
						"工信处女干事每月经过下属科室都要亲口交代24口交换机等技术性器件的安装工作", "结果婚的和尚未结过婚的"};
		for (String sentence : sentences) {
			List<SegToken> list = segmenter.process(sentence, JiebaSegmenter.SegMode.INDEX);
			for (SegToken token : list) {
				System.out.println(token.);
			}
		}
//		List<String> titles = new ArrayList<>();
//		List<String> contexts = new ArrayList<>();
//		// map2: index map
//
//		BSBIUtil bsbiUtil = new BSBIUtil();
//		try {
//			int i = 1;
//			int time = 0;
//			for (; i <= 40; i += 10) {
//
//			}
////			 System.out.println("map1: " + map1.toString());
////			 System.out.println("map2: " + map2.toString());
//			System.out.println("Input searching word: ");
//			Scanner scanner = new Scanner(System.in);
//			String s = scanner.nextLine().toLowerCase();
//			System.out.println("Map get word: " + s +"\n"  + "\n");
//			List<Map.Entry<String, List<RedisZSetCommands.Tuple>>> listSequence = bsbiUtil.createReversedIndex(map);
//			System.out.println("Create Reversed Index\n" + listSequence.toString());
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

	}
}
