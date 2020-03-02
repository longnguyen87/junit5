package chap1.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookShelf {
	private List<String> books = new ArrayList<>();
	public List<String> books (){
		return Collections.emptyList();
	}
	public void add( String bookTitle) {
		books.add(bookTitle);
	}
}
