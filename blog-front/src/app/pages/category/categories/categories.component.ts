import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

import { Book, Category } from '../../../entities';
import { BookService, CategoryService } from '../../../services';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {

  private books: Book[] = [];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private bookService: BookService,
    public categoryService: CategoryService
  ) {
  }

  ngOnInit() {
    this.bookService.readForCategories$().subscribe(
      data => {
        for (let i = 0; i < data.length; i++) {
          this.books.push(data[i]);
        }
      }
    )
  }



}
