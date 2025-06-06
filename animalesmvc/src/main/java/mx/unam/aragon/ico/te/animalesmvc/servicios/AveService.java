/**
 * Autora: Andrea Marcela Cáceres Avitia (Temas especiales de computación I 2025-II)
 * Proyecto: CRUD Spring MVC. Animales del mundo      Fecha: 05/06/2025
 * Archivo: AveService.java
 * Descripción: Clase de servicio que gestiona la lógica para la entidad Ave.
 *              Provee métodos para guardar, buscar, listar y eliminar registros en la base de datos.
 */
package mx.unam.aragon.ico.te.animalesmvc.servicios;

import mx.unam.aragon.ico.te.animalesmvc.modelos.Ave;
import mx.unam.aragon.ico.te.animalesmvc.repositorios.AveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AveService {

    @Autowired
    private AveRepository aveRepository;

    public boolean guardarAve(Ave ave) {
        Ave resultado = aveRepository.save(ave);
        return resultado != null;
    }

    public Ave buscarPorId(Integer id) {
        Optional<Ave> optional = aveRepository.findById(id);
        return optional.orElse(null);
    }

    public List<Ave> obtenerTodas() {
        return aveRepository.findAll();
    }

    public boolean eliminarPorId(Integer id) {
        if (aveRepository.existsById(id)) {
            aveRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
