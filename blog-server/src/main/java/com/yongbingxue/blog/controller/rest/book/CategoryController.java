package com.yongbingxue.blog.controller.rest.book;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.yongbingxue.blog.entity.book.Category;
import com.yongbingxue.blog.jackson.views.Views;
import com.yongbingxue.blog.repository.book.CategoryRepository;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {
	private static final Logger logger = LogManager.getLogger(CategoryController.class);

	@Autowired
	private CategoryRepository categoryRepository;

	@JsonView(Views.Public.class)
	@CrossOrigin
	@GetMapping(value = "/all", produces = "application/json;charset=UTF-8")
	public List<Category> readAll() {
		logger.info("readAll");
		return categoryRepository.findAll();
	}
}
