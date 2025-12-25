import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { Paraula, ParaulaRequest } from '../models';

@Injectable({
  providedIn: 'root',
})
export class ParaulaService {
  private apiURL = 'http://localhost:8080/api/diccionari'

  constructor(private http: HttpClient) {};

  // Obtener una palabra
  getParaula(paraula: string): Observable<Paraula> {
    return this.http.get<Paraula>(`${this.apiURL}/${paraula}`)
      .pipe(
        catchError(this.handleError)
      )
  }

  // Crear una palabra
  createParaula(request: ParaulaRequest) {
    return this.http.post<Paraula>(this.apiURL, request)
      .pipe(
        catchError(this.handleError)
      )
  }

  // Gestión de errores
  private handleError(error: HttpErrorResponse) {
    let errorMessage = 'Error desconocido';

    if (error.error instanceof ErrorEvent) {
      // Error del cliente
      errorMessage = `Error: ${error.error.message}`
    } else {
      // Error del servidor
      errorMessage = `Codigo de error: ${error.status}, Mensaje: ${error.message}`;
    }

    console.log(errorMessage);
    return throwError(() => Error(errorMessage))
  }
}
