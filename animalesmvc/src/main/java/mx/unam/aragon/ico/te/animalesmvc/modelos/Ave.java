package mx.unam.aragon.ico.te.animalesmvc.modelos;

import jakarta.persistence.*;

/**
 * Autora: Andrea Marcela Cáceres Avitia (Temas especiales de computación I 2025-II)
 * Proyecto: CRUD Spring MVC. Animales del mundo      Fecha: 05/06/2025
 * Archivo: Mamifero.java
 * Descripción: Clase de entidad JPA que representa a un ave dentro del sistema.
 *              Mapea la tabla "aves" e incluye atributos relevantes.
 */

@Entity
@Table(name = "aves")
public class Ave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String especie;

    @Column(name = "envergadura_alas", nullable = false)
    private double envergaduraAlas; // en metros

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

    @Column(name = "vuelo", length = 50)
    private String vuelo; // Ej. "planeador", "rápido", "no vuela"

    @Column(name = "es_migratoria")
    private boolean esMigratoria;

    @Column(name = "url_informacion", length = 255)
    private String urlInformacion;

    @Column(length = 255)
    private String imagen;

    public Ave() {
    }

    public Ave(Integer id, String especie, double envergaduraAlas, String habitat,
               String tipoAlimentacion, String zonaGeografica, int esperanzaVida,
               String estadoConservacion, String vuelo, boolean esMigratoria,
               String urlInformacion, String imagen) {
        this.id = id;
        this.especie = especie;
        this.envergaduraAlas = envergaduraAlas;
        this.habitat = habitat;
        this.tipoAlimentacion = tipoAlimentacion;
        this.zonaGeografica = zonaGeografica;
        this.esperanzaVida = esperanzaVida;
        this.estadoConservacion = estadoConservacion;
        this.vuelo = vuelo;
        this.esMigratoria = esMigratoria;
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

    public double getEnvergaduraAlas() {
        return envergaduraAlas;
    }

    public void setEnvergaduraAlas(double envergaduraAlas) {
        this.envergaduraAlas = envergaduraAlas;
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

    public String getVuelo() {
        return vuelo;
    }

    public void setVuelo(String vuelo) {
        this.vuelo = vuelo;
    }

    public boolean isEsMigratoria() {
        return esMigratoria;
    }

    public void setEsMigratoria(boolean esMigratoria) {
        this.esMigratoria = esMigratoria;
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
        return "Ave{" +
                "id=" + id +
                ", especie='" + especie + '\'' +
                ", envergaduraAlas=" + envergaduraAlas +
                ", habitat='" + habitat + '\'' +
                ", tipoAlimentacion='" + tipoAlimentacion + '\'' +
                ", zonaGeografica='" + zonaGeografica + '\'' +
                ", esperanzaVida=" + esperanzaVida +
                ", estadoConservacion='" + estadoConservacion + '\'' +
                ", vuelo='" + vuelo + '\'' +
                ", esMigratoria=" + esMigratoria +
                ", urlInformacion='" + urlInformacion + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
