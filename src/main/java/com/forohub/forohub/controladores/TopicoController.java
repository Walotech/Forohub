package com.forohub.forohub.controladores;

import com.forohub.forohub.dtos.DatosRegistroTopico;
import com.forohub.forohub.dtos.DatosRespuestaTopico;
import com.forohub.forohub.entidades.Autor;
import com.forohub.forohub.entidades.Curso;
import com.forohub.forohub.entidades.Topico;
import com.forohub.forohub.repositorios.AutorRepository;
import com.forohub.forohub.repositorios.CursoRepository;
import com.forohub.forohub.repositorios.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                                                UriComponentsBuilder uriComponentsBuilder) {

        // Busca el autor y el curso usando los IDs proporcionados en el DTO
        // Usamos los IDs del DTO para encontrar las entidades completas.
        Autor autor = autorRepository.getReferenceById(datosRegistroTopico.autorId());
        Curso curso = cursoRepository.getReferenceById(datosRegistroTopico.cursoId());

        // Crea una nueva instancia de Topico con los datos del DTO y las entidades completas
        Topico topico = new Topico(datosRegistroTopico.titulo(), datosRegistroTopico.mensaje(), autor, curso);

        // Guarda el nuevo topico en la base de datos y obtiene el ID generado
        // La entidad devuelta por .save() ahora tiene el ID.
        topico = topicoRepository.save(topico);

        // Convierte la entidad Topico a un DTO de respuesta
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico);

        // Retorna una respuesta exitosa con el topico creado y la URI de ubicacion
        // El metodo getId() ya estará disponible en la entidad 'topico'.
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }
}
