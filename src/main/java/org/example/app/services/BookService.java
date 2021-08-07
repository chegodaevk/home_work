package org.example.app.services;

import java.util.List;
import org.example.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	private final ProjectRepository<Book> bookRepo;
	
	@Autowired
	public BookService(ProjectRepository<Book> bookRepo) {
		this.bookRepo = bookRepo;
	}

	public List<Book> getAllBooks() {		
		return bookRepo.retreiveAll();
	}

	public void saveBook(Book book) {
		bookRepo.store(book);		
	}

	public boolean removeBookById(Integer bookIdToRemove) {
		return bookRepo.removeItemById(bookIdToRemove);
	}
	
	public void deleteDataOfBook(String dataOfBook) {
		bookRepo.deleteData(dataOfBook);		
	}

	public void delBookBySize(Integer sizeBook) {
		bookRepo.deleteBooksBySize(sizeBook);		
	}

	public void sortingAuthors() {
		bookRepo.sortAuthors();		
	}

	public void sortingTitles() {
		bookRepo.sortTitles();
		
	}

	public void sortingSizes() {
		bookRepo.sortSizes();
		
	}	

}
