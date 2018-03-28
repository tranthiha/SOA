package com.vnu.library.data.response;

import java.util.List;

import com.vnu.library.data.BookInfo;

public class GettingAllBooksResponse extends BookResponse {

	private Page data;

	public GettingAllBooksResponse(int code, String message, Page data) {
		super(code, message);
		this.data = data;
	}

	public Page getData() {
		return data;
	}

	public void setData(Page data) {
		this.data = data;
	}

	public class Page {
		private int page;
		private int pagePer;
		private List<BookInfo> books;

		public Page(int page, int pagePer, List<BookInfo> books) {
			this.page = page;
			this.pagePer = pagePer;
			this.books = books;
		}

		public int getPage() {
			return page;
		}

		public void setPage(int page) {
			this.page = page;
		}

		public int getPagePer() {
			return pagePer;
		}

		public void setPagePer(int pagePer) {
			this.pagePer = pagePer;
		}

		public List<BookInfo> getBooks() {
			return books;
		}

		public void setBooks(List<BookInfo> books) {
			this.books = books;
		}

	}
}
