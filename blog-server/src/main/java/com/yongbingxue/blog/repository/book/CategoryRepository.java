package com.yongbingxue.blog.repository.book;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yongbingxue.blog.entity.book.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
