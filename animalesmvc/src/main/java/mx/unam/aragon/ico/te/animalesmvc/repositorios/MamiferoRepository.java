/**
 * Autora: Andrea Marcela Cáceres Avitia (Temas especiales de computación I 2025-II)
 * Proyecto: CRUD Spring MVC. Animales del mundo      Fecha: 05/06/2025
 * Archivo: MamiferoRepository.java
 * Descripción: Interfaz que extiende JpaRepository para proporcionar operaciones
 *              CRUD automáticas sobre la entidad Mamifero.
 */

package mx.unam.aragon.ico.te.animalesmvc.repositorios;

import mx.unam.aragon.ico.te.animalesmvc.modelos.Mamifero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MamiferoRepository extends JpaRepository<Mamifero,Integer> {
}
