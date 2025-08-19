package com.forohub.forohub.repositorios;

import com.forohub.forohub.entidades.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    // Spring Data JPA ya proporciona los métodos CRUD básicos.
    // Puedes agregar aquí métodos de búsqueda personalizados si los necesitas.
}

