import { Component, signal } from '@angular/core';
import { Paraula } from '../../models';
import { ParaulaService } from '../../services/paraula.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-llista-paraules',
  imports: [FormsModule],
  templateUrl: './llista-paraules.html',
  styleUrl: './llista-paraules.css',
})
export class LlistaParaules {
  paraula = signal<Paraula | null>(null);
  carregant = signal(false);
  error = signal<string | null>(null);
  errorCode = signal<string | null>(null);

  cerca: string = '';

  constructor(private paraulaService: ParaulaService) {}

  // Buscar palabra
  cercarParaula() {
    this.carregant.set(true);
    this.error.set(null);

    // Service
    this.paraulaService.getParaula(this.cerca).subscribe({
      next: (data) => {
        this.paraula.set(data);
        this.carregant.set(false);
      },

      error: (err) => {
        this.error.set(err.message || 'Error al cargar la palabra');
        this.errorCode.set(err.status);
        this.carregant.set(false);
      }
    })
  }
}
