package ifc33b.dwesc.diccionari.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifc33b.dwesc.diccionari.model.Paraula;

@Repository
public interface ParaulaRepository extends JpaRepository<Paraula, Long> {
    Optional<Paraula> findByTermeIgnoreCase(String terme);
    Optional<Paraula> existsByTermeIgnoreCase(String terme);
}
