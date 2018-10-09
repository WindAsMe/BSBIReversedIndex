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

    }


    // NLP split the word
    public void split(List<JDModel> models) {
        StopWordUtil wordUtil = new StopWordUtil();
        int a = 1;
        for (JDModel model : models) {
            List<SegToken> tokens = segmenter.process(model.getTitle(), JiebaSegmenter.SegMode.INDEX);
            // trim the stop-word
            for (int i = 0; i < tokens.size(); i++) {
                if (wordUtil.stop(tokens.get(i).word)) {
                    tokens.remove(i);
                    i--;
                }
            }
            Tuple tuple = new Tuple(a, model.getUrl(), tokens);
            tuples.add(tuple);
            a++;
        }
    }
}
