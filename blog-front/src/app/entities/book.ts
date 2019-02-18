import { EntityBase } from './entity-base';
import { Category } from './category';

export interface Book extends EntityBase {
  author: string;
  cover: string;
  description: string;
  name: string;
  //
  category: Category;
}
