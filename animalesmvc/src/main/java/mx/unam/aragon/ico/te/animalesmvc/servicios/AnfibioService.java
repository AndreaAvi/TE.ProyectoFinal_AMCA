package mx.unam.aragon.ico.te.animalesmvc.servicios;

import mx.unam.aragon.ico.te.animalesmvc.modelos.Anfibio;
import mx.unam.aragon.ico.te.animalesmvc.repositorios.AnfibioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Autora: Andrea Marcela Cáceres Avitia (Temas especiales de computación I 2025-II)
 * Proyecto: CRUD Spring MVC. Animales del mundo      Fecha: 05/06/2025
 * Archivo: AnfibioService.java
 * Descripción: Clase de servicio que gestiona la lógica para la entidad Anfibio.
 *              Provee métodos para guardar, buscar, listar y eliminar registros en la base de datos.
 */

@Service
public class AnfibioService {

    @Autowired
    private AnfibioRepository anfibioRepository;

    // CREATE o UPDATE
    public boolean guardarAnfibio(Anfibio anfibio) {
        Anfibio resultado = anfibioRepository.save(anfibio);
        return resultado != null;
    }

    // READ - Obtener uno por ID
    public Anfibio buscarPorId(Integer id) {
        Optional<Anfibio> optional = anfibioRepository.findById(id);
        return optional.orElse(null);
    }

    // READ - Obtener todos
    public List<Anfibio> obtenerTodos() {
        return anfibioRepository.findAll();
    }

    // DELETE
    public boolean eliminarPorId(Integer id) {
        if (anfibioRepository.existsById(id)) {
            anfibioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}