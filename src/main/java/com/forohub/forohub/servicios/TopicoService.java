package com.forohub.forohub.servicios;

import com.forohub.forohub.entidades.Topico;
import com.forohub.forohub.repositorios.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    // Método para listar tópicos con paginación
    public Page<Topico> listarTopicos(Pageable paginacion) {
        // Usa el repositorio para buscar todos los tópicos con paginación
        return topicoRepository.findAll(paginacion);
    }
}

