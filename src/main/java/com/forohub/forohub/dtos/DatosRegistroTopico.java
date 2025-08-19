package com.forohub.forohub.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        String nombreAutor,
        @NotBlank
        String nombreCurso
) {
        // Este record solo contiene los datos necesarios para registrar un nuevo tópico.
        // La fecha de creación se genera en la clase Topico al crearse.
}