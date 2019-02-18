import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';

import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

import { Category } from '../entities';
import { environment } from '../../environments/environment';

const baseUrl = environment.apiEndpoint + '/category';
@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  public categories: Category[] = [];

  constructor(
    private http: HttpClient
  ) {
    this.readAll();
  }

  public readAll(): void {
    this.categories.splice(0, this.categories.length);
    this.readAll$().subscribe(
      data => {
        for (let i = 0; i < data.length; i++) {
          this.categories.push(data[i]);
        }
      }
    );
  }

  public readAll$(): Observable<Category[]> {
    return this.http.get<Category[]>(baseUrl + '/all')
      .pipe(
      retry(3), // retry a failed request up to 3 times
      catchError(this.handleError) // then handle the error
      );
  }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    // return an observable with a user-facing error message
    return throwError(
      'Something bad happened; please try again later.');
  };


}
