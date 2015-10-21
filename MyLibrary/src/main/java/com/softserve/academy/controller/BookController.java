package com.softserve.academy.controller;

import java.util.List;

import javax.validation.Valid;

import org.omg.PortableInterceptor.ServerRequestInterceptor;
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
@RequestMapping({ "authors/{id}" })
public class BookController {

    @Autowired
    BookService service;
     
    @Autowired
    MessageSource messageSource;
 
    @Autowired
    AuthorService authorService;
    /*
     * This method will list all existing authors.
     */
    @RequestMapping(value = { "/books" }, method = RequestMethod.GET)
    public String listBooks(ModelMap model) {
 
        List<Book> books = service.findAllBooks();
        model.addAttribute("books", books);
        return "books/allBooks";
    }
 
    /*
     * This method will provide the medium to add a new author.
     */
    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newBook(ModelMap model) {
    	Book book = new Book();

    	choiceAuthor(model);
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
     * saving employee in database. It also validates the user input
     */
    @RequestMapping(value = { "/books/new" }, method = RequestMethod.POST)
    public String saveBook(@Valid Book book, BindingResult result, ModelMap model, @PathVariable Long id) {
 
        if (result.hasErrors()) {
            return "books/addBook";
        }
 
        
        
        Author author = authorService.findById(id);
		author.getBooks().add(book);
		book.setAuthorId(author);
		service.saveBook(book);

		
		return "redirect:/authors/{id}";
         
//        service.saveBook(book);
// 
//        model.addAttribute("success", "Book " + book.getName() + " saved successfully");
//        return "success";
    }
    
   

 
 
    /*
     * This method will provide the medium to update an existing employee.
     */
    @RequestMapping(value = { "/books/{id}" }, method = RequestMethod.GET)
    public String editBook(@PathVariable Long id, ModelMap model) {
        Book book = service.findById(id);
        Author author = book.getAuthorId();
//        choiceAuthor(model);
        model.addAttribute("author", author);
        model.addAttribute("book", book);
        model.addAttribute("edit", true);
        return "books/addBook";
    }
     
    /*
     * This method will be called on form submission, handling POST request for
     * updating employee in database. It also validates the user input
     */
    @RequestMapping(value = { "/books/{id}" }, method = RequestMethod.POST)
    public String updateBook(@Valid Book book, BindingResult result,
            ModelMap model, @PathVariable Long id) {
 
        if (result.hasErrors()) {
            return "books/addBook";
        }
 
       
        service.updateBook(book);
 
        model.addAttribute("success", "Book " + book.getName() + " updated successfully");
        model.addAttribute("bookList",true);
        return "success";
    }
 
     
    /*
     * This method will delete an books by it's SSN value.
     */
    @RequestMapping(value = { "/books/{id}" }, method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable Long id) {
        service.deleteBookById(id);
        return "redirect:/books/";
    }
 
}
