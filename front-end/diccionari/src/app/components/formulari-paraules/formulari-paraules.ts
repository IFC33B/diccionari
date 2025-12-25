import { HttpErrorResponse } from '@angular/common/http';
import { Component, signal } from '@angular/core';
import { ParaulaService } from '../../services/paraula.service';
import { ParaulaRequest } from '../../models';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-formulari-paraules',
  imports: [FormsModule, RouterLink],
  templateUrl: './formulari-paraules.html',
  styleUrl: './formulari-paraules.css',
})
export class FormulariParaules {
  carregant = signal(false);
  error = signal<HttpErrorResponse | null>(null);

  // datos del formulario
  terme: string = '';
  definicio: string = '';

  constructor(private paraulaService: ParaulaService) {}
  
  // Añadir palabra
  afegirParaula(form: any) {
    this.carregant.set(true);
    this.error.set(null);

    // Request
    const request: ParaulaRequest = {terme: this.terme, definicio: this.definicio};

    // Service
    this.paraulaService.createParaula(request).subscribe({
      next: (data) => {
        this.carregant.set(false);
      },

      error: (err) => {
        this.error.set(err);
        this.carregant.set(false);
        console.log(err);
      }
    })

    form.resetForm();
  }

  // Recargar página
  reload() {
    window.location.reload()
  }
}
