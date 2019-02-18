import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SharedModule } from '../../shared/shared.module';

import { CategoryRoutingModule } from './category-routing.module';
import { CategoryComponent } from './category/category.component';
import { CategoriesComponent } from './categories/categories.component';

@NgModule({
  imports: [
    CommonModule,

    SharedModule,
    CategoryRoutingModule,
  ],
  declarations: [CategoryComponent, CategoriesComponent]
})
export class CategoryModule { }
