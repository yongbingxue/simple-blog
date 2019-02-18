import { EntityBase } from './entity-base';
import { Book } from './book';

export interface Chapter extends EntityBase {
  name: string;
  book: Book;
}
