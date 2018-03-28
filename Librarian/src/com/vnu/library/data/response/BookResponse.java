/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnu.library.data.response;

/**
 *
 * @author trant
 */
public class BookResponse {
    //code":1,"message":"Thành công","data":"data":{"page":null,"per_page":15,"books":
    private int code;
    private String message;

    public BookResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public boolean isSuccess(){
    	return code == 1;
    }
}
