package com.bsbiproject.demo.domain;

import com.huaban.analysis.jieba.SegToken;

import java.util.List;

/**
 * Author     : WindAsMe
 * File       : Tuple.java
 * Time       : Create on 18-10-9
 * Location   : ../Home/BSBIProject/Tuple.java
 */
public class Tuple {

    private String url;
    private List<SegToken> tokens;

    public Tuple() {
    }

    public Tuple(String url, List<SegToken> tokens) {
        this.url = url;
        this.tokens = tokens;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<SegToken> getTokens() {
        return tokens;
    }

    public void setToken(List<SegToken> tokens) {
        this.tokens = tokens;
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "url='" + url + '\'' +
                ", tokens=" + tokens +
                '}';
    }
}
