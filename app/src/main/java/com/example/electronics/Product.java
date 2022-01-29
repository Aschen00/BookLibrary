package com.example.electronics;

public class Product {
    private String name;
    private String author;
    private String link;
    private String url;

    Product(){
    }

    public Product(String name, String author, String link, String url) {
        this.name = name;
        this.author = author;
        this.link = link;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
