package mx.unam.aragon.ico.te.animalesmvc.servicios;

import mx.unam.aragon.ico.te.animalesmvc.modelos.Reptil;
import mx.unam.aragon.ico.te.animalesmvc.repositorios.ReptilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReptilService {

    @Autowired
    private ReptilRepository reptilRepository;

    // CREATE o UPDATE
    public boolean guardarReptil(Reptil reptil) {
        Reptil resultado = reptilRepository.save(reptil);
        return resultado != null;
    }

    // READ - Obtener uno por ID
    public Reptil buscarPorId(Integer id) {
        Optional<Reptil> optional = reptilRepository.findById(id);
        return optional.orElse(null);
    }

    // READ - Obtener todos
    public List<Reptil> obtenerTodos() {
        return reptilRepository.findAll();
    }

    // DELETE
    public boolean eliminarPorId(Integer id) {
        if (reptilRepository.existsById(id)) {
            reptilRepository.deleteById(id);
            return true;
        }
        return false;
    }
}