package com.vnu.library.data.response;

import com.vnu.library.data.BookInfo;

public class UpdatingBookResponse extends BookResponse{
	private BookInfo data;
	
	public UpdatingBookResponse(int code, String message, BookInfo data) {
		super(code, message);
		this.data = data;
	}

	public BookInfo getData() {
		return data;
	}

	public void setData(BookInfo data) {
		this.data = data;
	}

}
