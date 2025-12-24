package ifc33b.dwesc.diccionari.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifc33b.dwesc.diccionari.dto.ParaulaRequest;
import ifc33b.dwesc.diccionari.dto.ParaulaResponse;
import ifc33b.dwesc.diccionari.service.ParaulaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/diccionari")
public class DiccionariController {
    @Autowired
    private ParaulaService paraulaService;

    @GetMapping("/terme") // Devolver una palabra exacta
    public ResponseEntity<ParaulaResponse> getParaula(@PathVariable String terme) {
        // Service
        ParaulaResponse response = paraulaService.getParaula(terme);

        // HTTP Response
        return ResponseEntity.ok(response);
    }

    @PostMapping() // Crear una palabra
    public ResponseEntity<ParaulaResponse> createParaula(@RequestBody ParaulaRequest request) {
        // Service
        ParaulaResponse response = paraulaService.createParaula(request);

        // HTTP Response
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
