import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

import { switchMap } from 'rxjs/operators';
import { Observable } from 'rxjs';

import { Chapter } from '../../../entities';
import { ChapterService } from '../../../services';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {

  public chapters$: Observable<Chapter[]>;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private chapterService: ChapterService
  ) { }

  ngOnInit() {
    this.chapters$ = this.route.paramMap.pipe(
      switchMap((params: ParamMap) => this.chapterService.readByBook$(params.get('id')))
    );
  }

}
