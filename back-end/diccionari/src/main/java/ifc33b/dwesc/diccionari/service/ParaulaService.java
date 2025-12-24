package ifc33b.dwesc.diccionari.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifc33b.dwesc.diccionari.dto.ParaulaRequest;
import ifc33b.dwesc.diccionari.dto.ParaulaResponse;
import ifc33b.dwesc.diccionari.model.Paraula;
import ifc33b.dwesc.diccionari.repository.ParaulaRepository;

@Service
public class ParaulaService {
    @Autowired
    private ParaulaRepository paraulaRepository;

    // Devolver todas las palabras
    public List<ParaulaResponse> getParaules() {
        return paraulaRepository.findAll().stream()
                .map(ParaulaResponse::new)
                .collect(Collectors.toList());
    }

    // Devolver palabra exacta
    public ParaulaResponse getParaula(String cerca) {
        Paraula paraula = paraulaRepository.findByTerme(cerca)
                .orElseThrow(() -> new NoSuchElementException("No se ha encontrado la palabra: " + cerca));

        return new ParaulaResponse(paraula);
    }

    // Crear palabra
    public ParaulaResponse createParaula(ParaulaRequest request) {
        Paraula paraula = new Paraula(request.getTerme(), request.getDefinicio());
        paraulaRepository.save(paraula);
        return new ParaulaResponse(paraula);
    }
}
