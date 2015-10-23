package com.softserve.academy.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softserve.academy.model.Author;
import com.softserve.academy.model.Book;
import com.softserve.academy.service.author.AuthorService;
import com.softserve.academy.service.book.BookService;

@Controller
@RequestMapping({ "/authors/{id}" })
public class BookController {

    @Autowired
    BookService bookService;
     
    @Autowired
    MessageSource messageSource;
 
    @Autowired
    AuthorService authorService;
    /*
     * This method will list all existing book.
     */
    @RequestMapping(value = { "/books" }, method = RequestMethod.GET)
    public String listBooks(@PathVariable Long id,ModelMap model) {
 
    	Author author = authorService.findById(id);
        Set<Book> books = author.getBooks();
        model.addAttribute("books", books);
        model.addAttribute("author", author);
        return "books/allBooks";
    }
 
    /*
     * This method will provide the medium to add a new book.
     */
    @RequestMapping(value = { "/books/new" }, method = RequestMethod.GET)
    public String newBook(ModelMap model) {
    	Book book = new Book();
//    	Author author = authorService.findById(id);
//    	choiceAuthor(model);
    	
        model.addAttribute("book", book);
        model.addAttribute("edit", false);
        return "books/addBook";
    }
    
    public void choiceAuthor(ModelMap model){
    	List<Author> authors = authorService.findAllAuthors();
        model.addAttribute("authors", authors);
    }
 
    
//    @RequestMapping(value = {"/edit-{id}-book"}, method = RequestMethod.GET)
//    public String AuthorService(ModelMap model){
//        List<Author> authors = authorService.findAllAuthors();
//        model.addAttribute("authors", authors);
//        return "books/addBooks";
//    }
    /*
     * This method will be called on form submission, handling POST request for
     * saving book in database.
     */
    @RequestMapping(value = { "/books/new" }, method = RequestMethod.POST)
    public String saveBook(@Valid Book book, BindingResult result, ModelMap model, @PathVariable Long id) {
 
        if (result.hasErrors()) {
            return "books/addBook";
        }
 
        
        
        Author author = authorService.findById(id);
		author.getBooks().add(book);
		book.setAuthor(author);
		bookService.saveBook(book);

		
		return "redirect:/authors/{id}/books";
    }
    
   

 
 
    /*
     * This method will provide the medium to update an existing book.
     */
    @RequestMapping(value = { "/books/{id_book}" }, method = RequestMethod.GET)
    public String editBook(@PathVariable Long id,@PathVariable Long id_book, ModelMap model) {
        Book book = bookService.findById(id_book);
        Author author = book.getAuthor();
//        choiceAuthor(model);
        model.addAttribute("author", author);
        model.addAttribute("book", book);
        model.addAttribute("edit", true);
        return "books/addBook";
    }
     
    /*
     * This method will be called on form submission, handling PUT request for
     * updating book in database. It also validates the user input
     */
    @RequestMapping(value = { "/books/{id_book}" }, method = RequestMethod.PUT)
    public String updateBook(@Valid Book book, BindingResult result,
            ModelMap model, @PathVariable Long id, @PathVariable Long id_book) {
 
        if (result.hasErrors()) {
            return "books/addBook";
        }
  
		Author author = authorService.findById(id);
		book = bookService.findById(id_book);

		
		bookService.updateBook(book);
		author.getBooks().add(book);
		
		return "redirect:/authors/{id}/books";
    }
 
     
    /*
     * This method will delete an books by it's Id value.
     */
    @RequestMapping(value = { "/books/{id_book}" }, method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable Long id, @PathVariable Long id_book) {
    	
    			Book book = bookService.findById(id_book);
    			Author author = authorService.findById(id);
    			
    			author.getBooks().remove(book);
    			bookService.deleteBook(book);    			
    			return "redirect:/authors/{id}/books";
    }
}
