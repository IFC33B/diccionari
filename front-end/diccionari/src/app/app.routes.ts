import { Routes } from '@angular/router';
import { LlistaParaules } from './components/llista-paraules/llista-paraules';
import { FormulariParaules } from './components/formulari-paraules/formulari-paraules';

export const routes: Routes = [
    { path: '', redirectTo: '/paraules', pathMatch: 'full' },
    { path: 'paraules', component: LlistaParaules },
    { path: 'formulari', component: FormulariParaules }
];
