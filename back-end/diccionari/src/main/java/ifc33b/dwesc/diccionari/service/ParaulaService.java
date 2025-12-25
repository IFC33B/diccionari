package ifc33b.dwesc.diccionari.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifc33b.dwesc.diccionari.dto.ParaulaRequest;
import ifc33b.dwesc.diccionari.dto.ParaulaResponse;
import ifc33b.dwesc.diccionari.exception.ParaulaAlreadyExistsException;
import ifc33b.dwesc.diccionari.exception.ParaulaNotFoundException;
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
        Paraula paraula = paraulaRepository.findByTermeIgnoreCase(cerca)
                .orElseThrow(() -> new ParaulaNotFoundException(cerca));

        return new ParaulaResponse(paraula);
    }

    // Crear palabra
    public ParaulaResponse createParaula(ParaulaRequest request) {
        if (paraulaRepository.existsByTermeIgnoreCase(request.getTerme())) {
            throw new ParaulaAlreadyExistsException(request.getTerme());
        }

        Paraula paraula = new Paraula(request.getTerme(), request.getDefinicio());
        paraulaRepository.save(paraula);
        return new ParaulaResponse(paraula);
    }
}
