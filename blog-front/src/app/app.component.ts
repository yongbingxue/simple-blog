import { Component } from '@angular/core';

import { CategoryService } from './services';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'front';

  constructor(
    public categoryService: CategoryService
  ) {
  }
}
