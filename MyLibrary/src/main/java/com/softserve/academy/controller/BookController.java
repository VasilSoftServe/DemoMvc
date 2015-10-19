package com.softserve.academy.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softserve.academy.model.Book;
import com.softserve.academy.service.BookService;

@Controller
@RequestMapping({ "/books" })
public class BookController {

    @Autowired
    BookService service;
     
    @Autowired
    MessageSource messageSource;
 
    /*
     * This method will list all existing authors.
     */
    @RequestMapping(value = { "/allBooks" }, method = RequestMethod.GET)
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
        model.addAttribute("book", book);
        model.addAttribute("edit", false);
        return "books/addBook";
    }
 
    /*
     * This method will be called on form submission, handling POST request for
     * saving employee in database. It also validates the user input
     */
    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveBook(@Valid Book book, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) {
            return "books/addBook";
        }
 
        /*
         * It will be update a current author. 
         * 
         * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
         * framework as well while still using internationalized messages.
         * 
         */
//        if(!service.isEmployeeSsnUnique(employee.getId(), employee.getSsn())){
//            FieldError ssnError =new FieldError("employee","ssn",messageSource.getMessage("non.unique.ssn", new String[]{employee.getSsn()}, Locale.getDefault()));
//            result.addError(ssnError);
//            return "registration";
//        }
         
        service.saveBook(book);
 
        model.addAttribute("success", "Book " + book.getName() + " saved successfully");
        return "success";
    }
 
 
    /*
     * This method will provide the medium to update an existing employee.
     */
    @RequestMapping(value = { "/edit-{id}-book" }, method = RequestMethod.GET)
    public String editBook(@PathVariable Long id, ModelMap model) {
        Book book = service.findById(id);
        model.addAttribute("book", book);
        model.addAttribute("edit", true);
        return "books/addBook";
    }
     
    /*
     * This method will be called on form submission, handling POST request for
     * updating employee in database. It also validates the user input
     */
    @RequestMapping(value = { "/edit-{id}-book" }, method = RequestMethod.POST)
    public String updateBook(@Valid Book book, BindingResult result,
            ModelMap model, @PathVariable Long id) {
 
        if (result.hasErrors()) {
            return "books/addBook";
        }
 
       
        service.updateBook(book);
 
        model.addAttribute("success", "Book " + book.getName() + " updated successfully");
        return "success";
    }
 
     
    /*
     * This method will delete an books by it's SSN value.
     */
    @RequestMapping(value = { "/delete-{id}-book" }, method = RequestMethod.GET)
    public String deleteBook(@PathVariable Long id) {
        service.deleteBookById(id);
        return "redirect:/books/allBooks";
    }
 
}
