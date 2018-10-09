package com.bsbiproject.demo.util;

import com.bsbiproject.demo.domain.model.JDModel;
import com.bsbiproject.demo.domain.service.JDService;
import com.huaban.analysis.jieba.JiebaSegmenter;

import javax.annotation.Resource;
import java.util.*;

/**
 * Author     : WindAsMe
 * File       : BSBIUtil.java
 * Time       : Create on 18-9-29
 * Location   : ../Home/BSBIProject/BSBIUtil.java
 */
public class BSBIUtil {

    @Resource
    private JDService service;

    // Emulate the common dictionary
    private Set<String> set;

    // NLP need structure
    private List<JDModel> list;
    private List<String> tities;
    private JiebaSegmenter segmenter;

    public BSBIUtil() {
        list = service.selectJDModelAll();
        tities = new ArrayList<>();
        segmenter = new JiebaSegmenter();

        this.set = new HashSet<>();
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


    // trim the String
    private String trim(String s) {
        s = s.toLowerCase();
        s = s.replace('\'', ' ');
        s = s.replace(':', ' ');
        s = s.replace(',', ' ');
        s = s.replace('.', ' ');
        s = s.replace('-', ' ');
        s = s.replace('[', ' ');
        s = s.replace(']', ' ');
        s = s.replace('(', ' ');
        s = s.replace(')', ' ');
        s = s.replace('“', ' ');
        s = s.replace('‘', ' ');
        s = s.replace('-', ' ');
        return s;
    }

    private void split() {
        for (JDModel model : list) {
            String s = trim(segmenter.process(model.getTitle(), JiebaSegmenter.SegMode.INDEX).toString());

        }
    }

}
