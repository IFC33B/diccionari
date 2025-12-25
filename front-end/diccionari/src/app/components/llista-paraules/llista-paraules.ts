import { Component, signal } from '@angular/core';
import { Paraula } from '../../models';
import { FormControl } from '@angular/forms';
import { ParaulaService } from '../../services/paraula.service';

@Component({
  selector: 'app-llista-paraules',
  imports: [],
  templateUrl: './llista-paraules.html',
  styleUrl: './llista-paraules.css',
})
export class LlistaParaules {
  paraula = signal<Paraula | null>(null);
  carregant = signal(false);
  error = signal<string | null>(null);

  cerca = signal<string>('');

  constructor(private paraulaService: ParaulaService) {}

  // Buscar palabra
  cercarParaula() {
    this.carregant.set(true);
    this.error.set(null);

    // Service
    this.paraulaService.getParaula(this.cerca()).subscribe({
      next: (data) => {
        this.paraula.set(data);
        this.carregant.set(false);
      },

      error: (err) => {
        this.error.set('Error al cargar la palabra')
        this.carregant.set(false);
        console.log(err);
      }
    })
  }
}
