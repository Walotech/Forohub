package com.forohub.forohub.dtos;

import com.forohub.forohub.entidades.Topico;
import com.forohub.forohub.entidades.Autor;
import com.forohub.forohub.entidades.Curso;
import java.time.LocalDateTime;

// Se corrige el record para que tome directamente los campos que necesita de la entidad Topico.
// Esto evita la necesidad de llamar a getAutor() y getCurso() dentro del constructor del record.
public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String status,
        Long autorId,
        String autorNombre,
        Long cursoId,
        String cursoNombre
) {
    public DatosRespuestaTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus().toString(),
                topico.getAutor().getId(),
                topico.getAutor().getNombre(),
                topico.getCurso().getId(),
                topico.getCurso().getNombre()
        );
    }
}
