/**
 * Autora: Andrea Marcela Cáceres Avitia (Temas especiales de computación I 2025-II)
 * Proyecto: CRUD Spring MVC. Animales del mundo      Fecha: 05/06/2025
 * Archivo: Reptil.java
 * Descripción: Clase de entidad JPA que representa a un mamífero dentro del sistema.
 *              Mapea la tabla "reptiles" e incluye atributos relevantes.
 */
package mx.unam.aragon.ico.te.animalesmvc.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "reptiles")
public class Reptil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String especie;

    @Column(length = 100)
    private String habitat;

    @Column(name = "tipo_alimentacion", length = 50)
    private String tipoAlimentacion;

    @Column(name = "zona_geografica", length = 100)
    private String zonaGeografica;

    @Column(name = "esperanza_vida")
    private int esperanzaVida; // en años

    @Column(name = "estado_conservacion", length = 50)
    private String estadoConservacion;

    @Column(name = "es_venenoso")
    private boolean esVenenoso;

    @Column(name = "es_oviparo")
    private boolean esOviparo;

    @Column(name = "longitud_promedio")
    private double longitudPromedio; // en metros

    @Column(name = "url_informacion", length = 255)
    private String urlInformacion;

    @Column(length = 255)
    private String imagen;

    public Reptil() {
    }

    public Reptil(Integer id, String especie, String habitat, String tipoAlimentacion,
                  String zonaGeografica, int esperanzaVida, String estadoConservacion,
                  boolean esVenenoso, boolean esOviparo, double longitudPromedio,
                  String urlInformacion, String imagen) {
        this.id = id;
        this.especie = especie;
        this.habitat = habitat;
        this.tipoAlimentacion = tipoAlimentacion;
        this.zonaGeografica = zonaGeografica;
        this.esperanzaVida = esperanzaVida;
        this.estadoConservacion = estadoConservacion;
        this.esVenenoso = esVenenoso;
        this.esOviparo = esOviparo;
        this.longitudPromedio = longitudPromedio;
        this.urlInformacion = urlInformacion;
        this.imagen = imagen;
    }

    // Getters y Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getTipoAlimentacion() {
        return tipoAlimentacion;
    }

    public void setTipoAlimentacion(String tipoAlimentacion) {
        this.tipoAlimentacion = tipoAlimentacion;
    }

    public String getZonaGeografica() {
        return zonaGeografica;
    }

    public void setZonaGeografica(String zonaGeografica) {
        this.zonaGeografica = zonaGeografica;
    }

    public int getEsperanzaVida() {
        return esperanzaVida;
    }

    public void setEsperanzaVida(int esperanzaVida) {
        this.esperanzaVida = esperanzaVida;
    }

    public String getEstadoConservacion() {
        return estadoConservacion;
    }

    public void setEstadoConservacion(String estadoConservacion) {
        this.estadoConservacion = estadoConservacion;
    }

    public boolean isEsVenenoso() {
        return esVenenoso;
    }

    public void setEsVenenoso(boolean esVenenoso) {
        this.esVenenoso = esVenenoso;
    }

    public boolean isEsOviparo() {
        return esOviparo;
    }

    public void setEsOviparo(boolean esOviparo) {
        this.esOviparo = esOviparo;
    }

    public double getLongitudPromedio() {
        return longitudPromedio;
    }

    public void setLongitudPromedio(double longitudPromedio) {
        this.longitudPromedio = longitudPromedio;
    }

    public String getUrlInformacion() {
        return urlInformacion;
    }

    public void setUrlInformacion(String urlInformacion) {
        this.urlInformacion = urlInformacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Reptil{" +
                "id=" + id +
                ", especie='" + especie + '\'' +
                ", habitat='" + habitat + '\'' +
                ", tipoAlimentacion='" + tipoAlimentacion + '\'' +
                ", zonaGeografica='" + zonaGeografica + '\'' +
                ", esperanzaVida=" + esperanzaVida +
                ", estadoConservacion='" + estadoConservacion + '\'' +
                ", esVenenoso=" + esVenenoso +
                ", esOviparo=" + esOviparo +
                ", longitudPromedio=" + longitudPromedio +
                ", urlInformacion='" + urlInformacion + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
