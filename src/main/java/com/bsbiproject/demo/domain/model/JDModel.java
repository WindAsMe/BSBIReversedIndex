package com.bsbiproject.demo.domain.model;

/**
 * Author     : WindAsMe
 * File       : JDModel.java
 * Time       : Create on 18-10-9
 * Location   : ../Home/BSBIProject/JDModel.java
 */
public class JDModel {

    private int id;
    private int page;
    private String url;
    private String title;
    private String price;

    public JDModel() {
    }

    public JDModel(int id, String url, int page, String title, String price) {
        this.id = id;
        this.url = url;
        this.page = page;
        this.title = title;
        this.price = price;
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

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
