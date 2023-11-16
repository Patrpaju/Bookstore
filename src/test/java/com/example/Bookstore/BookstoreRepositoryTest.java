package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Bookstore.model.BookRepository;
import com.example.Bookstore.model.Category;
import com.example.Bookstore.model.CategoryRepository;
import com.example.Bookstore.model.AppUser;
import com.example.Bookstore.model.AppUserRepository;
import com.example.Bookstore.model.Book;
import org.junit.jupiter.api.Test;

//@ExtendWith(SpringExtension.class)
@DataJpaTest

// @ExtendWith(SpringExtension.class)
// @SpringBootTest(classes = BookstoreApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookstoreRepositoryTest {

	@Autowired
	private BookRepository repository;

	@Autowired
	private CategoryRepository crepository;
	
	@Autowired
	private AppUserRepository arepository;

	@Test
	public void findByTitle() {
		List<Book> books = repository.findByTitle("Animal Farm");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("George Orwell");
	}

	@Test
	public void createNewBook() {
		Book book = new Book("12353451-21", "To Kill a Mockingbird", "Harper Lee", 1960, 49,new Category("Drama"));
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test
	public void deleteNewBook() {
		List<Book> books = repository.findByTitle("Animal Farm");
		Book book = books.get(0);
		repository.delete(book);
		List<Book> newBooks = repository.findByTitle("Animal Farm");
		assertThat(newBooks).hasSize(0);
	}
	
	@Test
	public void findByCategory() {
		List<Category> categories = crepository.findByName("Drama");
		assertThat(categories).hasSize(1);
	}

	@Test
	public void createNewCategory() {
		Category category = new Category("Southern Gothic");
		crepository.save(category);
		assertThat(category.getCategoryid()).isNotNull();
	}

	@Test
	public void deleteNewCategory() {
		List<Category> categories = crepository.findByName("Drama");
		Category category = categories.get(0);
		crepository.delete(category);
		List<Category> newCategories = crepository.findByName("Drama");
		assertThat(newCategories).hasSize(0);
	}
	
	@Test
	public void findByAppUser() {
		AppUser Appuser = arepository.findByUsername("user");
		assertThat(Appuser).isNotNull();
	}
	
	@Test
	public void createNewAppUser() {
		AppUser appUser = new AppUser("test", "test", "test");
		arepository.save(appUser);
		assertThat(appUser.getUsername()).isNotNull();
	}
	@Test 
	public void deleteNewAppUser() {
		AppUser appUser = arepository.findByUsername("user");
		arepository.delete(appUser);
		AppUser newappUser = arepository.findByUsername("user");
		assertThat(newappUser).isNull();
		
	}
}
