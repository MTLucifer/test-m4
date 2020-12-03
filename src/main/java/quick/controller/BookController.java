package quick.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import quick.model.Book;
import quick.model.Category;
import quick.service.BookService;
import quick.service.CategoryService;

import java.util.List;
import java.util.Optional;

@Controller
 public class BookController {
 @Autowired
 private BookService bookService;

 @Autowired
 private CategoryService categoryService;

 @ModelAttribute("categories")
 public List<Category> provinces(){
  return categoryService.findAll();
 }

 @GetMapping("/books")
 public ModelAndView listCustomers(@RequestParam("search") Optional<String> search){
  List<Book> books = null;

  if (search.isPresent()){
   books = bookService.findByName(search.get());
  }else {
   books = bookService.findAll();
  }
  ModelAndView modelAndView= new ModelAndView("/books/list");
  modelAndView.addObject("books", books);
  return modelAndView;
 }

 @GetMapping("/create-book")
 public ModelAndView showCreateForm(){
  ModelAndView modelAndView = new ModelAndView("/books/create");
  modelAndView.addObject("book", new Book());
  return modelAndView;
 }

 @PostMapping("/create-book")
 public ModelAndView saveCustomer(@ModelAttribute("book") Book book){
  bookService.save(book);
  ModelAndView modelAndView = new ModelAndView("/books/create");
  modelAndView.addObject("book", new Book());
  modelAndView.addObject("message", "New book created successfully");
  return modelAndView;
 }

 @GetMapping("/edit-book/{id}")
 public ModelAndView showEditForm(@PathVariable Integer id){
  Book book = bookService.findById(id);
  if(book != null) {
   ModelAndView modelAndView = new ModelAndView("/books/edit");
   modelAndView.addObject("book", book);
   return modelAndView;

  }else {
   ModelAndView modelAndView = new ModelAndView("/error.404");
   return modelAndView;
  }
 }

 @PostMapping("/edit-book")
 public ModelAndView updateCustomer(@ModelAttribute("book") Book book){
  bookService.save(book);
  ModelAndView modelAndView = new ModelAndView("/books/edit");
  modelAndView.addObject("book", book);
  modelAndView.addObject("message", "Book updated successfully");
  return modelAndView;
 }

 @GetMapping("/delete-book/{id}")
 public ModelAndView showDeleteForm(@PathVariable Integer id){
  Book book = bookService.findById(id);
  if(book != null) {
   ModelAndView modelAndView = new ModelAndView("/books/delete");
   modelAndView.addObject("book", book);
   return modelAndView;

  }else {
   ModelAndView modelAndView = new ModelAndView("/error.404");
   return modelAndView;
  }
 }

 @PostMapping("/delete-book")
 public String deleteCustomer(@ModelAttribute("book") Book book){
  bookService.remove(book.getId());
  return "redirect:books";
 }
}
