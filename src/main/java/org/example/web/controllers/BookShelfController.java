package org.example.web.controllers;

import org.apache.log4j.Logger;
import org.example.app.services.BookService;
import org.example.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/books")
public class BookShelfController {
	
	private Logger logger =Logger.getLogger(BookShelfController.class);
	private BookService bookService;	
	
	@Autowired
	public BookShelfController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("/shelf")
	public String books(Model model) {
		logger.info("got book shelf");
		model.addAttribute("book", new Book());
		model.addAttribute("bookList", bookService.getAllBooks());
		return "book_shelf";
	}
	
	@PostMapping("/save")
	public String saveBook(Book book) {
		bookService.saveBook(book);
		logger.info("current repository size: " + bookService.getAllBooks().size());
		return "redirect:/books/shelf";
	}
	@PostMapping("/remove")
	public String removeBook(@RequestParam(value = "bookIdToRemove") Integer bookIdToRemove) {
		if(bookService.removeBookById(bookIdToRemove)) {
			return "redirect:/books/shelf";
		} else {
			return "redirect:/books/shelf";
		}		
	}
	
	@PostMapping("/delete")
	public String deleteBook(@RequestParam(value = "dataOfBook") String dataOfBook) {
		bookService.deleteDataOfBook(dataOfBook); 		
		return "redirect:/books/shelf";				
	}
	
	@PostMapping("/deletesize")
	public String deleteBookBySize(@RequestParam(value = "sizeBook") Integer sizeBook) {
		bookService.delBookBySize(sizeBook); 		
		return "redirect:/books/shelf";				
	}
	
	@PostMapping("/sortingByAuthors")
	public String sortingByAuthors() {
		bookService.sortingAuthors(); 		
		return "redirect:/books/shelf";				
	}
	
	@PostMapping("/sortingByTitle")
	public String sortingByTitle() {
		bookService.sortingTitles(); 		
		return "redirect:/books/shelf";				
	}
	
	@PostMapping("/sortingBySize")
	public String sortingBySize() {
		bookService.sortingSizes(); 		
		return "redirect:/books/shelf";				
	}
}
