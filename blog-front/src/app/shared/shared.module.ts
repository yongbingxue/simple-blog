import { NgModule } from '@angular/core';
import { BookCategoryFilterPipe } from './pipes/book-category-filter.pipe';

@NgModule({
  imports: [
  ],
  exports: [
    BookCategoryFilterPipe
  ],
  declarations: [BookCategoryFilterPipe]
})
export class SharedModule { }
