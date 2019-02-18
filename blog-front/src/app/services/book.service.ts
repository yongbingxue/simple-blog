import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpErrorResponse, HttpResponse, HttpParams } from '@angular/common/http';

import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

import { Book, Category } from '../entities';
import { environment } from '../../environments/environment';

const baseUrl = environment.apiEndpoint + '/book';
@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(
    private http: HttpClient
  ) {
  }

  public readPageByCategory$(categoryId: string, page: number): Observable<Book[]> {
    let options = {
      params: new HttpParams().set('categoryId', categoryId).set('page', page.toString())
    };
    return this.http.get<Book[]>(baseUrl + '/read-page-by-category', options)
      .pipe(
      retry(3), // retry a failed request up to 3 times
      catchError(this.handleError) // then handle the error
      );
  }

  public readForCategories$(): Observable<Book[]> {
    return this.http.get<Book[]>(baseUrl + '/read-for-categories')
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
