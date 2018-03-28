/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnu.library.data;


public class BookInfoBuilder {

    private int id;
    private String author;
    private String country;
    private String language;
    private int pages;
    private String title;
    private String publishDate;
    private int quantityInStock;
    private String createdAt;
    private String updatedAt;

    public BookInfoBuilder() {
    }

    public BookInfoBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public BookInfoBuilder setAuthor(String author) {
        this.author = author;
        return this;
    }

    public BookInfoBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    public BookInfoBuilder setLanguage(String language) {
        this.language = language;
        return this;
    }

    public BookInfoBuilder setPages(int pages) {
        this.pages = pages;
        return this;
    }

    public BookInfoBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public BookInfoBuilder setPublishDate(String publishDate) {
        this.publishDate = publishDate;
        return this;
    }

    public BookInfoBuilder setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
        return this;
    }

    public BookInfoBuilder setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public BookInfoBuilder setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public BookInfo createBookInfo() {
        return new BookInfo(id, author, country, language, pages, title, publishDate, quantityInStock, createdAt, updatedAt);
    }
    
}
