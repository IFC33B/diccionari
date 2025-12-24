package ifc33b.dwesc.diccionari.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ParaulaRequest {
    // Atributos
    @NotBlank(message = "Se requiere un nombre para el termino")
    private String terme;

    @NotBlank(message = "Se requiere una definición para el termino")
    private String definicio;

    // Constructor
    public ParaulaRequest(String terme, String definicio) {
        this.setTerme(terme);
        this.setDefinicio(definicio);
    }
}
