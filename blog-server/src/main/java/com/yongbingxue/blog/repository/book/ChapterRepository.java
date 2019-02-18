package com.yongbingxue.blog.repository.book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yongbingxue.blog.entity.book.Book;
import com.yongbingxue.blog.entity.book.Chapter;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {
	@Query("SELECT o FROM Chapter o WHERE o.book = :book ORDER BY o.priority ASC")
	public List<Chapter> readByBook(@Param("book") Book book);
}
