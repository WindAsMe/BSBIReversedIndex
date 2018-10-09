package com.bsbiproject.demo.domain.model;

import com.huaban.analysis.jieba.SegToken;

/**
 * Author     : WindAsMe
 * File       : Tuple.java
 * Time       : Create on 18-10-9
 * Location   : ../Home/BSBIProject/Tuple.java
 */
public class Tuple {

    private String url;
    private SegToken token;

    public Tuple() {
    }

    public Tuple(String url, SegToken token) {
        this.url = url;
        this.token = token;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public SegToken getToken() {
        return token;
    }

    public void setToken(SegToken token) {
        this.token = token;
    }
}
