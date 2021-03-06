package com.bsbiproject.demo.domain;

import com.huaban.analysis.jieba.SegToken;

import java.util.List;

/**
 * Author     : WindAsMe
 * File       : Tuple.java
 * Time       : Create on 18-10-9
 * Location   : ../Home/BSBIProject/Tuple.java
 */
// Data first normalization
public class Tuple {

    private int id;
    private String url;
    private List<SegToken> tokens;

    public Tuple() {
    }

    public Tuple(int id, String url, List<SegToken> tokens) {
        this.id = id;
        this.url = url;
        this.tokens = tokens;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setTokens(List<SegToken> tokens) {
        this.tokens = tokens;
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", tokens=" + tokens +
                '}';
    }
}
