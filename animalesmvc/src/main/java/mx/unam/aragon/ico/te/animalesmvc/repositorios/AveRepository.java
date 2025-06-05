/**
 * Autora: Andrea Marcela Cáceres Avitia (Temas especiales de computación I 2025-II)
 * Proyecto: CRUD Spring MVC. Animales del mundo      Fecha: 05/06/2025
 * Archivo: AveRepository.java
 * Descripción: Interfaz que extiende JpaRepository para proporcionar operaciones
 *              CRUD automáticas sobre la entidad Ave.
 */
package mx.unam.aragon.ico.te.animalesmvc.repositorios;

import mx.unam.aragon.ico.te.animalesmvc.modelos.Ave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AveRepository extends JpaRepository<Ave, Integer> {
}
