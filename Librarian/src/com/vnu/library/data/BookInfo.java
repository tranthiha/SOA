/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnu.library.data;

import com.google.gson.Gson;

/**
 *
 * @author trant
 */
public class BookInfo {
    //{"id":1,"author":"Chinua Achebe","country":"Nigeria","language":"English","pages":"209",
    //"title":"Things Fall Apart","publish_date":"1958-01-01T00:00:00.000+07:00","quantity_in_stock":0,"created_at":"2018-03-25T21:23:20.000+07:00",
    //"updated_at":"2018-03-25T21:23:20.000+07:00"}
    private int id;
    private String author;
    private String country;
    private String language;
    private int pages;
    private String title;
    private String publish_date;
    private int quantity_in_stock;
    private String created_at;
    private String updated_at;

    public BookInfo() {
    }

    public BookInfo(int id, String author, String country, String language, int pages, String title, String publishDate, int quantityInStock, String createdAt, String updatedAt) {
        this.id = id;
        this.author = author;
        this.country = country;
        this.language = language;
        this.pages = pages;
        this.title = title;
        this.publish_date = publishDate;
        this.quantity_in_stock = quantityInStock;
        this.created_at = createdAt;
        this.updated_at = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishDate() {
        return publish_date;
    }

    public void setPublishDate(String publishDate) {
        this.publish_date = publishDate;
    }

    public int getQuantityInStock() {
        return quantity_in_stock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantity_in_stock = quantityInStock;
    }

    public String getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(String createdAt) {
        this.publish_date = createdAt;
    }

    public String getUpdatedAt() {
        return updated_at;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updated_at = updatedAt;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return new Gson().toJson(this);
    }
    
    public void copyData(BookInfo bookInfo){
    	this.title = bookInfo.title;
    	this.author = bookInfo.author;
    	this.country = bookInfo.country;
    	this.language = bookInfo.language;
    	this.pages = bookInfo.pages;
    	this.quantity_in_stock = bookInfo.quantity_in_stock;
    	this.publish_date = bookInfo.publish_date;
    }
}
