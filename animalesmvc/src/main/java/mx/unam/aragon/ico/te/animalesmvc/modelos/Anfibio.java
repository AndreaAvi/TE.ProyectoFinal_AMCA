package mx.unam.aragon.ico.te.animalesmvc.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "anfibios")
public class Anfibio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String especie;

    @Column(name = "tamanio_promedio", nullable = false)
    private double tamanioPromedio; // en metros

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

    @Column(name = "tipo_reproduccion", length = 50)
    private String tipoReproduccion; // ovíparo, vivíparo, etc.

    @Column(name = "metamorfosis")
    private boolean metamorfosis; // si presenta metamorfosis completa

    @Column(name = "respiracion_cutanea")
    private boolean respiracionCutanea; // si respira por la piel

    @Column(name = "url_informacion", length = 255)
    private String urlInformacion;

    @Column(length = 255)
    private String imagen; // ruta o URL a imagen

    public Anfibio() {
    }

    public Anfibio(Integer id, String especie, double tamanioPromedio, String habitat,
                   String tipoAlimentacion, String zonaGeografica, int esperanzaVida,
                   String estadoConservacion, String tipoReproduccion, boolean metamorfosis,
                   boolean respiracionCutanea, String urlInformacion, String imagen) {
        this.id = id;
        this.especie = especie;
        this.tamanioPromedio = tamanioPromedio;
        this.habitat = habitat;
        this.tipoAlimentacion = tipoAlimentacion;
        this.zonaGeografica = zonaGeografica;
        this.esperanzaVida = esperanzaVida;
        this.estadoConservacion = estadoConservacion;
        this.tipoReproduccion = tipoReproduccion;
        this.metamorfosis = metamorfosis;
        this.respiracionCutanea = respiracionCutanea;
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

    public double getTamanioPromedio() {
        return tamanioPromedio;
    }

    public void setTamanioPromedio(double tamanioPromedio) {
        this.tamanioPromedio = tamanioPromedio;
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

    public String getTipoReproduccion() {
        return tipoReproduccion;
    }

    public void setTipoReproduccion(String tipoReproduccion) {
        this.tipoReproduccion = tipoReproduccion;
    }

    public boolean isMetamorfosis() {
        return metamorfosis;
    }

    public void setMetamorfosis(boolean metamorfosis) {
        this.metamorfosis = metamorfosis;
    }

    public boolean isRespiracionCutanea() {
        return respiracionCutanea;
    }

    public void setRespiracionCutanea(boolean respiracionCutanea) {
        this.respiracionCutanea = respiracionCutanea;
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
        return "Anfibio{" +
                "id=" + id +
                ", especie='" + especie + '\'' +
                ", tamanioPromedio=" + tamanioPromedio +
                ", habitat='" + habitat + '\'' +
                ", tipoAlimentacion='" + tipoAlimentacion + '\'' +
                ", zonaGeografica='" + zonaGeografica + '\'' +
                ", esperanzaVida=" + esperanzaVida +
                ", estadoConservacion='" + estadoConservacion + '\'' +
                ", tipoReproduccion='" + tipoReproduccion + '\'' +
                ", metamorfosis=" + metamorfosis +
                ", respiracionCutanea=" + respiracionCutanea +
                ", urlInformacion='" + urlInformacion + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}