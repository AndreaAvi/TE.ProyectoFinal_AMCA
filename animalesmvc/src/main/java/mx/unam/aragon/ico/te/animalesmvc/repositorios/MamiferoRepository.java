package mx.unam.aragon.ico.te.animalesmvc.repositorios;

import mx.unam.aragon.ico.te.animalesmvc.modelos.Mamifero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MamiferoRepository extends JpaRepository<Mamifero,Integer> {
}
