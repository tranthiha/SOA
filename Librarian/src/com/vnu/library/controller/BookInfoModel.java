/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnu.library.controller;

import com.vnu.library.data.BookInfo;
import com.vnu.library.ui.ColumnData;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author trant
 */
public class BookInfoModel extends AbstractTableModel{
	public static final int NUM_BOOK_PER_PAGE = 15;
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final public ColumnData m_columns[] = {
		new ColumnData( "STT", 50, JLabel.CENTER ),
	    new ColumnData( "Title", 200, JLabel.CENTER ),
	    new ColumnData( "Author", 100, JLabel.CENTER ),
	    new ColumnData( "Country", 100, JLabel.CENTER ),
	 };
    private final List<BookInfo> listBooks;
    private int currentPage = 1;
    private int offsetIndex = 1;
    
    public BookInfoModel(List<BookInfo> listBooks) {
        this.listBooks = listBooks;
    }
    
    @Override
    public int getRowCount() {
        return listBooks.size();
    }

    @Override
    public int getColumnCount() {
    	return m_columns.length;    
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return rowIndex + 1 + offsetIndex;
            case 1:
                return listBooks.get(rowIndex).getTitle();
            case 2:
                return listBooks.get(rowIndex).getAuthor();
            default: 
                return listBooks.get(rowIndex).getCountry();
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
    	return  m_columns[columnIndex].title;
    }
    
    public BookInfo getBook(int index){
        return listBooks.get(index);
    }
    
    public void deleteBook(int index){
    	listBooks.remove(index);
    	fireTableRowsDeleted(index, index);
    }
    
    public void updateBook(BookInfo bookInfo){
    	for (int i = 0, len = listBooks.size(); i < len; i++) {
			if(listBooks.get(i).getId() == bookInfo.getId()){
				listBooks.set(i, bookInfo);
		    	fireTableRowsUpdated(i, i);
		    	return;
			}
		}
    	
    }
    
    public void addBook(BookInfo bookInfo){
    	listBooks.add(bookInfo);
    	int idx = listBooks.indexOf(bookInfo);
    	fireTableRowsInserted(idx, idx);
    }
    
    public List<BookInfo> getBookInfos(){
        return listBooks;
    }

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		offsetIndex = NUM_BOOK_PER_PAGE * (currentPage - 1);
	}

	public int getOffsetIndex() {
		return offsetIndex;
	}

	public void setOffsetIndex(int offsetIndex) {
		this.offsetIndex = offsetIndex;
	}
}
