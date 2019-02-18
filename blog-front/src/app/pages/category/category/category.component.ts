import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

import { switchMap } from 'rxjs/operators';
import { Observable } from 'rxjs';

import { Book, Category } from '../../../entities';
import { BookService, CategoryService } from '../../../services';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  public books$: Observable<Book[]>;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private bookService: BookService,
  ) { }

  ngOnInit() {
    this.books$ = this.route.paramMap.pipe(
      switchMap((params: ParamMap) => this.bookService.readPageByCategory$(params.get('id'), 0))
    );
  }

}
