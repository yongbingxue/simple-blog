package com.yongbingxue.blog.controller.rest.book;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.yongbingxue.blog.entity.book.Book;
import com.yongbingxue.blog.entity.book.Category;
import com.yongbingxue.blog.jackson.views.Views;
import com.yongbingxue.blog.repository.book.BookRepository;
import com.yongbingxue.blog.repository.book.CategoryRepository;

@RestController
@RequestMapping(value = "/book")
public class BookController {
	private static final Logger logger = LogManager.getLogger(BookController.class);

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@JsonView(Views.Public.class)
	@CrossOrigin
	@GetMapping(value = "/read-page-by-category", produces = "application/json;charset=UTF-8")
	public List<Book> readPageByCategory(@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "categoryId") Long categoryId) {
		logger.info("readPageByCategory-page:{}, categoryId:{}", page, categoryId);
		Category category = categoryRepository.findOne(categoryId);
		return bookRepository.readPageByCategory(category, new PageRequest(page, 10)).getContent();
	}

	@JsonView(Views.Public.class)
	@CrossOrigin
	@GetMapping(value = "/read-for-categories", produces = "application/json;charset=UTF-8")
	public List<Book> readForCategories() {
		logger.info("readForCategories");
		List<Category> categories = categoryRepository.findAll();
		List<Book> books = Lists.newArrayList();
		for (Category category : categories) {
			books.addAll(bookRepository.readPageByCategory(category, new PageRequest(0, 4)).getContent());
		}
		return books;
	}

}
