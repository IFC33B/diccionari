package ifc33b.dwesc.diccionari.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "paraula")
public class Paraula {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String terme;

    @Column(nullable = false)
    private String definicio;

    // Constructor
    public Paraula() {}

    public Paraula(String terme, String definicio) {
        this.setTerme(terme);
        this.setDefinicio(definicio);
    }
}
