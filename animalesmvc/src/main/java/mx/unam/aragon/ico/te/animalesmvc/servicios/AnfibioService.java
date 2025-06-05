package mx.unam.aragon.ico.te.animalesmvc.servicios;

import mx.unam.aragon.ico.te.animalesmvc.modelos.Anfibio;
import mx.unam.aragon.ico.te.animalesmvc.repositorios.AnfibioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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