import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpErrorResponse, HttpResponse, HttpParams } from '@angular/common/http';

import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

import { Chapter } from '../entities';
import { environment } from '../../environments/environment';

const baseUrl = environment.apiEndpoint + '/chapter';
@Injectable({
  providedIn: 'root'
})
export class ChapterService {

  constructor(
    private http: HttpClient
  ) {
  }


  public readByBook$(bookId: string): Observable<Chapter[]> {
    let options = {
      params: new HttpParams().set('bookId', bookId)
    };
    return this.http.get<Chapter[]>(baseUrl + '/read-by-book', options)
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
