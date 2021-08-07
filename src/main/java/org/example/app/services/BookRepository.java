package org.example.app.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.log4j.Logger;
import org.example.web.dto.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository implements ProjectRepository<Book> {
	
	private final Logger logger = Logger.getLogger(BookRepository.class);
	private final List<Book> repo = new ArrayList<>();
	
	@Override
	public List<Book> retreiveAll() {
		return new ArrayList<>(repo) ;
	}

	@Override
	public void store(Book book) {
		if(book.getSize()!=null || book.getAuthor()!="" || book.getTitle()!="") {
			book.setId(book.hashCode());
			logger.info("store new book: " + book);
			repo.add(book);		
		}
	}

	@Override
	public boolean removeItemById(Integer bookIdToRemove) {
		for(Book book : retreiveAll()) {
			if(book.getId().equals(bookIdToRemove)) {
				logger.info("remove book completed: " + book);
				return repo.remove(book);
			}			
		}
		return false;
	}

	@Override
	public void deleteData(String dataOfBook) {
		for(Book book : retreiveAll()) {
			if(dataOfBook != "" && (book.getAuthor().equals(dataOfBook) || book.getTitle().equals(dataOfBook))) {
				repo.remove(book);				
			}
		}
	}

	@Override
	public void deleteBooksBySize(Integer sizeBook) {
		for(Book book : retreiveAll()) {
			if(sizeBook!=null && book.getSize().equals(sizeBook)) {
				repo.remove(book);				
			}
		}
	}

	@Override
	public void sortAuthors() {
		for(int k=0; k < repo.size(); k++){
            int mindex = k;
            for(int j=k+1; j < repo.size(); j++){
                if (repo.get(j).getAuthor().compareTo(repo.get(mindex).getAuthor()) < 0) {
                    mindex = j;
                }
            }
            Collections.swap(repo, k, mindex);
        }
	}

	@Override
	public void sortTitles() {
		for(int k=0; k < repo.size(); k++){
            int mindex = k;
            for(int j=k+1; j < repo.size(); j++){
                if (repo.get(j).getTitle().compareTo(repo.get(mindex).getTitle()) < 0) {
                    mindex = j;
                }
            }
            Collections.swap(repo, k, mindex);
        }
		
	}

	@Override
	public void sortSizes() {
		for(int k=0; k < repo.size(); k++){
            int mindex = k;
            for(int j=k+1; j < repo.size(); j++){
                if (repo.get(j).getSize() < repo.get(mindex).getSize()) {
                    mindex = j;
                }
            }
            Collections.swap(repo, k, mindex);
        }
	}
	
	
}
