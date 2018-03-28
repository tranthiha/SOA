/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnu.library.data;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

/**
 *
 * @author trant
 */
public class ServerAPI {
    public static final String LINK_GET_LIST_BOOKS = "http://localhost:3000/api/v1/librarian/book_managements";
    public static final String LINK_UPDATE_BOOK = "http://localhost:3000/api/v1/librarian/book_managements";
    public static final String LINK_DELETE_BOOK = "http://localhost:3000/api/v1/librarian/book_managements";
    public static final String LINK_ADD_BOOK = "http://localhost:3000/api/v1/librarian/book_managements";
    
    //GET: for get all books
    public static String sendGetRequestWidthPage(String url, int page){
        try {
            URIBuilder builder = new URIBuilder(url);
            builder.setParameter("page", page + "");
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(builder.build());
            HttpResponse response = client.execute(request);
            
            System.out.println("Response Code : "
                    + response.getStatusLine().getStatusCode());
            
            return EntityUtils.toString(response.getEntity());
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(ServerAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    //GET: for get the specified book info
    public static String sendGetRequest(String url, int id){
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(url + "/" + id);
            HttpResponse response = client.execute(request);
            
            System.out.println("Response Code : "
                    + response.getStatusLine().getStatusCode());
            
            return EntityUtils.toString(response.getEntity());
        } catch (IOException ex) {
            Logger.getLogger(ServerAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    //POST: for creating the new book
    public static String sendPostRequest(String url, BookInfo bookInfo){
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpPost post = new HttpPost(url);
            String json = new Gson().toJson(bookInfo);
            post.setEntity(new StringEntity(json));
            post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
            
            HttpResponse response = client.execute(post);
            System.out.println("Response Code : "
                    + response.getStatusLine().getStatusCode());
            
            String result = EntityUtils.toString(response.getEntity());
            return result;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ServerAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServerAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    //PUT: for updating the specified book
    public static String sendPutRequest(String url, BookInfo bookInfo){
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpPut put = new HttpPut(url + "/" + bookInfo.getId());
            String json = new Gson().toJson(bookInfo);
            put.setEntity(new StringEntity(json));
            put.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
            
            HttpResponse response = client.execute(put);
            System.out.println("Response Code : "
                    + response.getStatusLine().getStatusCode());
            
            String result = EntityUtils.toString(response.getEntity());
            return result;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ServerAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServerAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //DELETE: for deleting the specified book
    public static String sendDeleteRequest(String url, int id){
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpDelete delete = new HttpDelete(url + "/" + id);
            
            HttpResponse response = client.execute(delete);
            System.out.println("Response Code : "
                    + response.getStatusLine().getStatusCode());
            
            String result = EntityUtils.toString(response.getEntity());
            return result;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ServerAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServerAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
