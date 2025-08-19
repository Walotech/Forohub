package com.forohub.forohub.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DatosActualizarTopico(
        @NotNull
        Long id,
        @Size(max = 255)
        String titulo,
        @Size(max = 1000)
        String mensaje
) {
}

