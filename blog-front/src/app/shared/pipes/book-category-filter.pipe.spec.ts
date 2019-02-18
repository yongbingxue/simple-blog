import { BookCategoryFilterPipe } from './book-category-filter.pipe';

describe('BookCategoryFilterPipe', () => {
  it('create an instance', () => {
    const pipe = new BookCategoryFilterPipe();
    expect(pipe).toBeTruthy();
  });
});
