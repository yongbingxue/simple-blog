import { Pipe, PipeTransform } from '@angular/core';

import { Book, Category } from '../../entities';

@Pipe({
  name: 'bookCategoryFilter',
  pure: false
})
export class BookCategoryFilterPipe implements PipeTransform {

  transform(books: Book[], category: Category): Book[] {
    if (!books || !category) {
      return books;
    }
    return books.filter(book => {
      return book.category.id == category.id;
    });
  }

}
