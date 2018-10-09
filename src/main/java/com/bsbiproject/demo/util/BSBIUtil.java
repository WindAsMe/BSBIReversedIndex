package com.bsbiproject.demo.util;

import com.bsbiproject.demo.domain.JDModel;
import com.bsbiproject.demo.domain.Tuple;
import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;
import java.util.*;

/**
 * Author     : WindAsMe
 * File       : BSBIUtil.java
 * Time       : Create on 18-9-29
 * Location   : ../Home/BSBIProject/BSBIUtil.java
 */
public class BSBIUtil {

    // Emulate the common dictionary
    private Set<String> set;

    // NLP need structure
    private List<Tuple> tuples;
    private JiebaSegmenter segmenter;

    public List<Tuple> getTuples() {
        return tuples;
    }

    public void setTuples(List<Tuple> tuples) {
        this.tuples = tuples;
    }

    public BSBIUtil() {
        tuples = new ArrayList<>();
        segmenter = new JiebaSegmenter();

        this.set = new HashSet<>();
        set.add("，");
        set.add("。");
        set.add("“");
        set.add("");
        set.add(" ");
        set.add("①");
        set.add("的");
        set.add("你");
        set.add("我");
        set.add("他");
        set.add("她");
        set.add("它");
        set.add("我们");
        set.add("你们");
        set.add("他们");
        set.add("她们");
        set.add("它们");
        set.add("一下");
        set.add("一个");
        set.add("一些");
        set.add("一何");
        set.add("一切");
        set.add("一则");
        // ...
    }


    // NLP split the word
    public void split(List<JDModel> models) {
        for (JDModel model : models) {
            List<SegToken> tokens = segmenter.process(model.getTitle(), JiebaSegmenter.SegMode.INDEX);
            System.out.println(tokens.toString());
            // trim the stop-word
            if (tokens.size() == 0)
                continue;
            for (int i = 0; i < tokens.size(); i++) {
                if (set.contains(tokens.get(i).word))
                    tokens.remove(i);
            }

            Tuple tuple = new Tuple(model.getUrl(), tokens);
            tuples.add(tuple);
        }
    }
}
