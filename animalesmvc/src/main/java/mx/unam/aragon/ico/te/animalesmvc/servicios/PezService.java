package mx.unam.aragon.ico.te.animalesmvc.servicios;

import mx.unam.aragon.ico.te.animalesmvc.modelos.Pez;
import mx.unam.aragon.ico.te.animalesmvc.repositorios.PezRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PezService {

    @Autowired
    private PezRepository pezRepository;

    // CREATE o UPDATE
    public boolean guardarPez(Pez pez) {
        Pez resultado = pezRepository.save(pez);
        return resultado != null;
    }

    // READ - Obtener uno por ID
    public Pez buscarPorId(Integer id) {
        Optional<Pez> optional = pezRepository.findById(id);
        return optional.orElse(null);
    }

    // READ - Obtener todos
    public List<Pez> obtenerTodos() {
        return pezRepository.findAll();
    }

    // DELETE
    public boolean eliminarPorId(Integer id) {
        if (pezRepository.existsById(id)) {
            pezRepository.deleteById(id);
            return true;
        }
        return false;
    }
}