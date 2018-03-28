package com.vnu.library;

import com.google.gson.Gson;
import com.vnu.library.data.BookInfo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author trant
 */
public class ReadBookJson {
     public static void main(String[] args) {
        try {
            List<BookInfo> listBooks = new ArrayList<>();
            Gson gson = new Gson();
            listBooks = gson.fromJson(new BufferedReader(new FileReader(new File("G:\\assg1\\student\\Resources\\books.json"))), List.class);
            System.out.println(listBooks.toString());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadBookJson.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
