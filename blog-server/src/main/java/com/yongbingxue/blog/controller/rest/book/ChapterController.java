package com.yongbingxue.blog.controller.rest.book;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.yongbingxue.blog.entity.book.Book;
import com.yongbingxue.blog.entity.book.Chapter;
import com.yongbingxue.blog.jackson.views.Views;
import com.yongbingxue.blog.repository.book.BookRepository;
import com.yongbingxue.blog.repository.book.ChapterRepository;

@RestController
@RequestMapping(value = "/chapter")
public class ChapterController {
	private static final Logger logger = LogManager.getLogger(ChapterController.class);

	@Autowired
	private ChapterRepository chapterRepository;

	@Autowired
	private BookRepository bookRepository;

	@JsonView(Views.Public.class)
	@CrossOrigin
	@GetMapping(value = "/read-by-book", produces = "application/json;charset=UTF-8")
	public List<Chapter> readByBook(@RequestParam(name = "bookId") Long bookId) {
		logger.info("readByBook-bookId:{}", bookId);
		Book book = bookRepository.findOne(bookId);
		return chapterRepository.readByBook(book);
	}
}
