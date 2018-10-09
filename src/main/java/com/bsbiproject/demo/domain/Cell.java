package com.bsbiproject.demo.domain;

import com.huaban.analysis.jieba.SegToken;

/**
 * Author     : WindAsMe
 * File       : Cell.java
 * Time       : Create on 18-10-9
 * Location   : ../Home/BSBIProject/Cell.java
 */
// Data first normalization
public class Cell {

    // The cell data
    private int id;
    private String url;
    private SegToken token;

    public Cell() {
    }

    public Cell(int id, String url, SegToken token) {
        this.id = id;
        this.url = url;
        this.token = token;
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

    public SegToken getToken() {
        return token;
    }

    public void setToken(SegToken token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", token=" + token +
                '}';
    }
}
