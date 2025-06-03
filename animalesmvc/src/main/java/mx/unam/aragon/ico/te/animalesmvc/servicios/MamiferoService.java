package mx.unam.aragon.ico.te.animalesmvc.servicios;

import mx.unam.aragon.ico.te.animalesmvc.modelos.Mamifero;
import mx.unam.aragon.ico.te.animalesmvc.repositorios.MamiferoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MamiferoService {

    @Autowired
    private MamiferoRepository mamiferoRepository;

    // CREATE o UPDATE
    public boolean guardarMamifero(Mamifero mamifero) {
        Mamifero resultado = mamiferoRepository.save(mamifero);
        return resultado != null;
    }

    // READ - Obtener uno por ID
    public Mamifero buscarPorId(Integer id) {
        Optional<Mamifero> optional = mamiferoRepository.findById(id);
        return optional.orElse(null);
    }

    // READ - Obtener todos
    public List<Mamifero> obtenerTodos() {
        return mamiferoRepository.findAll();
    }

    // DELETE
    public boolean eliminarPorId(Integer id) {
        if (mamiferoRepository.existsById(id)) {
            mamiferoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
