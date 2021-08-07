package org.example.app.services;

import java.util.List;

public interface ProjectRepository<T> {
	List<T> retreiveAll();
	
	void store(T book);

	boolean removeItemById(Integer bookIdToRemove);
	
	void deleteData(String dataOfBook);

	void deleteBooksBySize(Integer sizeBook);

	void sortAuthors();

	void sortTitles();

	void sortSizes();
}
