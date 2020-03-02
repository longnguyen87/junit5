package chap1.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;


@DisplayName("<= BookShelf Specification =>")
public class BookShelfSpec {
	@Test
	public void shelfEmptyWhenNoBookAdded () throws Exception {
		BookShelf shelf = new BookShelf();
		List<String> books = shelf.books();
		assertTrue(books.isEmpty(), ()-> "Bookshelf should be empty");
	}
	private BookShelfSpec (TestInfo testInfo) {
		System.out.println("Working on test " + testInfo.getDisplayName());
	}
	@Test
	void shouldCheckForEvenNumbers() {
	int number = new Random(10).nextInt();
	assertTrue(() -> number%2 == 0, number+ " is not an even number.");
	BiFunction<Integer, Integer, Boolean> divisible = (x, y) -> x % y == 0; 
	Function<Integer, Boolean> multipleOf2 = (x) -> divisible.apply(x, 2); 
	assertTrue(() -> multipleOf2.apply(number), () -> " 2 is not factor of " + number);
	}
	@Test
	void thisTestShouldFail() {
		fail(() -> "This test should fail"); 
	}
	@Test
	public void shelfToStringShouldPrintBookCountAndTitles() throws Exception {
		BookShelf shelf = new BookShelf();
		List<String> books = shelf.books();
		shelf.add("The Phoenix Project");
		shelf.add("Java 8 in Action");
		String shelfStr = shelf.toString();
		assertAll( () -> assertTrue(shelfStr.contains("The Phoenix Project"), "1st book title missing"),
				() -> assertTrue(shelfStr.contains("Java 8 in Action") , "2nd book title missing "),
				() -> assertTrue(shelfStr.contains("2 books found"), "Book count missing"));
	}
}
