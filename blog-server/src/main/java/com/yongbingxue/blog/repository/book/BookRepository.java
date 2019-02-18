package com.yongbingxue.blog.repository.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yongbingxue.blog.entity.book.Book;
import com.yongbingxue.blog.entity.book.Category;

public interface BookRepository extends JpaRepository<Book, Long> {
	@Query("SELECT o FROM Book o WHERE o.category = :category ORDER BY o.priority ASC")
	public Page<Book> readPageByCategory(@Param("category") Category category, Pageable pageable);
}
