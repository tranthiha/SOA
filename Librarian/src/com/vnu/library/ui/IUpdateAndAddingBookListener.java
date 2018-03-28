/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnu.library.ui;

import com.vnu.library.data.BookInfo;

/**
 *
 * @author trant
 */

public interface IUpdateAndAddingBookListener{
    public void onUpdate(BookInfo bookInfo);
    public void onAddNew(BookInfo bookInfo);
}
