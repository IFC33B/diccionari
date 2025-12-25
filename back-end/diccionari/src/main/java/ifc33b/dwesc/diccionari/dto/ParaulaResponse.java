package ifc33b.dwesc.diccionari.dto;

import ifc33b.dwesc.diccionari.model.Paraula;
import lombok.Data;

@Data
public class ParaulaResponse {
    // Atributos
    private Long id;
    private String terme;
    private String definicio;

    // Constructor
    public ParaulaResponse(Paraula paraula) {
        this.setId(paraula.getId());
        this.setTerme(paraula.getTerme());
        this.setDefinicio(paraula.getDefinicio());
    }
}
