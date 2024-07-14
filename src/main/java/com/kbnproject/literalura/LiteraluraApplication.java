package com.kbnproject.literalura;

import com.kbnproject.literalura.controller.BooksController;
import com.kbnproject.literalura.model.Book;
import com.kbnproject.literalura.model.BookResponse;
import com.kbnproject.literalura.model.DataBook;
import com.kbnproject.literalura.service.RequestService;
import org.apache.logging.log4j.CloseableThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		BooksController controller = applicationContext.getBean(BooksController.class);
		System.out.println(controller.getBook(""));
		while(true){
			Scanner scanner = new Scanner(System.in);
			System.out.println("""
                    Choose one option:\s
                    1: Search a book\s
                    2: Show books\s
                    3: Show authors\s
                    4: Show authors by year\s
                    5: Show books by language\s
                    6: Exit""");
			int optionSelected = scanner.nextInt();
			switch(optionSelected){
				case 1:
					System.out.println("Write the title: ");
//					String book = controller.getBook(scanner.next());
//					System.out.println(book);
					String book = "{\"count\":6,\"next\":null,\"previous\":null,\"results\":[{\"id\":2000,\"title\":\"Don Quijote\",\"authors\":[{\"name\":\"Cervantes Saavedra, Miguel de\",\"birth_year\":1547,\"death_year\":1616}],\"translators\":[],\"subjects\":[\"Knights and knighthood -- Spain -- Fiction\",\"Picaresque literature\",\"Romances\",\"Spain -- Social life and customs -- 16th century -- Fiction\"],\"bookshelves\":[\"6 Best Loved Spanish Literary Classics\",\"Best Books Ever Listings\",\"Harvard Classics\"],\"languages\":[\"es\"],\"copyright\":false,\"media_type\":\"Text\",\"formats\":{\"text/html\":\"https://www.gutenberg.org/ebooks/2000.html.images\",\"text/html; charset=utf-8\":\"https://www.gutenberg.org/files/2000/2000-h/2000-h.htm\",\"application/epub+zip\":\"https://www.gutenberg.org/ebooks/2000.epub3.images\",\"application/x-mobipocket-ebook\":\"https://www.gutenberg.org/ebooks/2000.kf8.images\",\"text/plain; charset=utf-8\":\"https://www.gutenberg.org/files/2000/2000-0.txt\",\"application/rdf+xml\":\"https://www.gutenberg.org/ebooks/2000.rdf\",\"image/jpeg\":\"https://www.gutenberg.org/cache/epub/2000/pg2000.cover.medium.jpg\",\"application/octet-stream\":\"https://www.gutenberg.org/cache/epub/2000/pg2000-h.zip\",\"text/plain; charset=us-ascii\":\"https://www.gutenberg.org/ebooks/2000.txt.utf-8\"},\"download_count\":16728},{\"id\":66263,\"title\":\"Don Quijote de la Mancha\",\"authors\":[{\"name\":\"Cervantes Saavedra, Miguel de\",\"birth_year\":1547,\"death_year\":1616}],\"translators\":[{\"name\":\"Győry, Vilmos\",\"birth_year\":1838,\"death_year\":1885}],\"subjects\":[\"Knights and knighthood -- Spain -- Fiction\",\"Picaresque literature\",\"Romances\",\"Spain -- Social life and customs -- 16th century -- Fiction\"],\"bookshelves\":[],\"languages\":[\"hu\"],\"copyright\":false,\"media_type\":\"Text\",\"formats\":{\"text/html\":\"https://www.gutenberg.org/ebooks/66263.html.images\",\"application/epub+zip\":\"https://www.gutenberg.org/ebooks/66263.epub3.images\",\"application/x-mobipocket-ebook\":\"https://www.gutenberg.org/ebooks/66263.kf8.images\",\"application/rdf+xml\":\"https://www.gutenberg.org/ebooks/66263.rdf\",\"image/jpeg\":\"https://www.gutenberg.org/cache/epub/66263/pg66263.cover.medium.jpg\",\"application/octet-stream\":\"https://www.gutenberg.org/files/66263/66263-0.zip\",\"text/plain; charset=us-ascii\":\"https://www.gutenberg.org/ebooks/66263.txt.utf-8\"},\"download_count\":341},{\"id\":60884,\"title\":\"El Quijote apócrifo\",\"authors\":[{\"name\":\"Fernández de Avellaneda, Alonso\",\"birth_year\":null,\"death_year\":null}],\"translators\":[],\"subjects\":[\"Quixote, Don (Fictitious character) -- Fiction\"],\"bookshelves\":[],\"languages\":[\"es\"],\"copyright\":false,\"media_type\":\"Text\",\"formats\":{\"text/plain; charset=us-ascii\":\"https://www.gutenberg.org/ebooks/60884.txt.utf-8\",\"text/html\":\"https://www.gutenberg.org/ebooks/60884.html.images\",\"text/html; charset=utf-8\":\"https://www.gutenberg.org/files/60884/60884-h/60884-h.htm\",\"application/epub+zip\":\"https://www.gutenberg.org/ebooks/60884.epub3.images\",\"application/x-mobipocket-ebook\":\"https://www.gutenberg.org/ebooks/60884.kf8.images\",\"text/plain; charset=utf-8\":\"https://www.gutenberg.org/files/60884/60884-0.txt\",\"application/rdf+xml\":\"https://www.gutenberg.org/ebooks/60884.rdf\",\"image/jpeg\":\"https://www.gutenberg.org/cache/epub/60884/pg60884.cover.medium.jpg\",\"application/octet-stream\":\"https://www.gutenberg.org/cache/epub/60884/pg60884-h.zip\"},\"download_count\":296},{\"id\":57448,\"title\":\"Meditaciones del Quijote\",\"authors\":[{\"name\":\"Ortega y Gasset, José\",\"birth_year\":1883,\"death_year\":1955}],\"translators\":[],\"subjects\":[\"Aesthetics\",\"Cervantes Saavedra, Miguel de, 1547-1616. Don Quixote\",\"Fiction\"],\"bookshelves\":[],\"languages\":[\"es\"],\"copyright\":false,\"media_type\":\"Text\",\"formats\":{\"text/plain; charset=us-ascii\":\"https://www.gutenberg.org/ebooks/57448.txt.utf-8\",\"text/html\":\"https://www.gutenberg.org/ebooks/57448.html.images\",\"text/html; charset=utf-8\":\"https://www.gutenberg.org/files/57448/57448-h/57448-h.htm\",\"application/epub+zip\":\"https://www.gutenberg.org/ebooks/57448.epub3.images\",\"application/x-mobipocket-ebook\":\"https://www.gutenberg.org/ebooks/57448.kf8.images\",\"text/plain; charset=utf-8\":\"https://www.gutenberg.org/files/57448/57448-0.txt\",\"application/rdf+xml\":\"https://www.gutenberg.org/ebooks/57448.rdf\",\"image/jpeg\":\"https://www.gutenberg.org/cache/epub/57448/pg57448.cover.medium.jpg\",\"application/octet-stream\":\"https://www.gutenberg.org/cache/epub/57448/pg57448-h.zip\"},\"download_count\":209},{\"id\":45203,\"title\":\"Älykkään ritarin Don Quijote de la Manchan elämänvaiheet\",\"authors\":[{\"name\":\"Cervantes Saavedra, Miguel de\",\"birth_year\":1547,\"death_year\":1616}],\"translators\":[{\"name\":\"Joutsen, O. A. (Otto Aleksanteri)\",\"birth_year\":1878,\"death_year\":1936}],\"subjects\":[\"Knights and knighthood -- Spain -- Fiction\",\"Picaresque literature\",\"Romances\",\"Spain -- Social life and customs -- 16th century -- Fiction\"],\"bookshelves\":[],\"languages\":[\"fi\"],\"copyright\":false,\"media_type\":\"Text\",\"formats\":{\"text/html\":\"https://www.gutenberg.org/ebooks/45203.html.images\",\"application/epub+zip\":\"https://www.gutenberg.org/ebooks/45203.epub3.images\",\"application/x-mobipocket-ebook\":\"https://www.gutenberg.org/ebooks/45203.kf8.images\",\"text/plain; charset=iso-8859-1\":\"https://www.gutenberg.org/files/45203/45203-8.txt\",\"application/rdf+xml\":\"https://www.gutenberg.org/ebooks/45203.rdf\",\"image/jpeg\":\"https://www.gutenberg.org/cache/epub/45203/pg45203.cover.medium.jpg\",\"text/plain; charset=us-ascii\":\"https://www.gutenberg.org/ebooks/45203.txt.utf-8\",\"application/octet-stream\":\"https://www.gutenberg.org/cache/epub/45203/pg45203-h.zip\"},\"download_count\":108},{\"id\":63871,\"title\":\"El \\\"Tirant lo Blanch\\\" i \\\"D. Quijote de La Mancha\\\"\",\"authors\":[{\"name\":\"Givanel Mas, J. (Juan)\",\"birth_year\":1868,\"death_year\":1946}],\"translators\":[],\"subjects\":[\"Cervantes Saavedra, Miguel de, 1547-1616. Don Quixote\",\"Martorell, Joanot, -1468. Tirant lo Blanch\"],\"bookshelves\":[],\"languages\":[\"ca\"],\"copyright\":false,\"media_type\":\"Text\",\"formats\":{\"text/plain; charset=us-ascii\":\"https://www.gutenberg.org/ebooks/63871.txt.utf-8\",\"text/html\":\"https://www.gutenberg.org/ebooks/63871.html.images\",\"text/html; charset=utf-8\":\"https://www.gutenberg.org/files/63871/63871-h/63871-h.htm\",\"application/epub+zip\":\"https://www.gutenberg.org/ebooks/63871.epub3.images\",\"application/x-mobipocket-ebook\":\"https://www.gutenberg.org/ebooks/63871.kf8.images\",\"text/plain; charset=utf-8\":\"https://www.gutenberg.org/files/63871/63871-0.txt\",\"application/rdf+xml\":\"https://www.gutenberg.org/ebooks/63871.rdf\",\"image/jpeg\":\"https://www.gutenberg.org/cache/epub/63871/pg63871.cover.medium.jpg\",\"application/octet-stream\":\"https://www.gutenberg.org/cache/epub/63871/pg63871-h.zip\"},\"download_count\":104}]}";
					System.out.println(book);
					BookResponse object = controller.toObject(book, BookResponse.class);
					List<Book> books = object.results().stream()
							.map(Book::new)
							.toList();
					books.forEach(controller::saveBook);
				case 2:
					System.out.println("Write the book name: ");
					System.out.println(controller.getBookRepository(scanner.next()));
				case 3:
					System.out.println("Write the authors name: ");
					System.out.println(controller.getAuthorRepository("Ortega y Gasset, José"));
				case 4:
					System.out.println("Write the authors birth year: ");
					System.out.println(controller.getAuthorByYear(scanner.nextInt()));
				case 5:
					System.out.println("Write the language: ");
					System.out.println(controller.getBookByLanguage(scanner.next().toLowerCase()));
				case 6:
					return;
				default:
					System.out.println("Invalid option");
			}
		}
	}
}
