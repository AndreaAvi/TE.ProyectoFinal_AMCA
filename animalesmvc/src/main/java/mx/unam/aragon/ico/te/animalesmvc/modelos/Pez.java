package mx.unam.aragon.ico.te.animalesmvc.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "peces")
public class Pez {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String especie;

    @Column(name = "tamanio_promedio", nullable = false)
    private double tamanioPromedio; // en metros

    @Column(length = 100)
    private String habitat; // arrecife, aguas profundas, río, lago, etc.

    @Column(name = "tipo_alimentacion", length = 50)
    private String tipoAlimentacion; // carnívoro, herbívoro, omnívoro, planctívoro

    @Column(name = "zona_geografica", length = 100)
    private String zonaGeografica;

    @Column(name = "esperanza_vida")
    private int esperanzaVida; // en años

    @Column(name = "estado_conservacion", length = 50)
    private String estadoConservacion;

    @Column(name = "url_informacion", length = 255)
    private String urlInformacion;

    @Column(length = 255)
    private String imagen; // ruta o URL a imagen

    // Atributos específicos de peces
    @Column(name = "tipo_agua", length = 50, nullable = false)
    private String tipoAgua; // dulce, salada, salobre

    @Column(name = "profundidad_maxima")
    private int profundidadMaxima; // en metros

    @Column(name = "forma_cuerpo", length = 50)
    private String formaCuerpo; // fusiforme, comprimido, deprimido, anguiliforme

    @Column(name = "es_venenoso")
    private boolean esVenenoso;

    public Pez() {
    }

    public Pez(Integer id, String especie, double tamanioPromedio, String habitat,
               String tipoAlimentacion, String zonaGeografica, int esperanzaVida,
               String estadoConservacion, String urlInformacion, String imagen,
               String tipoAgua, int profundidadMaxima, String formaCuerpo, boolean esVenenoso) {
        this.id = id;
        this.especie = especie;
        this.tamanioPromedio = tamanioPromedio;
        this.habitat = habitat;
        this.tipoAlimentacion = tipoAlimentacion;
        this.zonaGeografica = zonaGeografica;
        this.esperanzaVida = esperanzaVida;
        this.estadoConservacion = estadoConservacion;
        this.urlInformacion = urlInformacion;
        this.imagen = imagen;
        this.tipoAgua = tipoAgua;
        this.profundidadMaxima = profundidadMaxima;
        this.formaCuerpo = formaCuerpo;
        this.esVenenoso = esVenenoso;
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

    public String getTipoAgua() {
        return tipoAgua;
    }

    public void setTipoAgua(String tipoAgua) {
        this.tipoAgua = tipoAgua;
    }

    public int getProfundidadMaxima() {
        return profundidadMaxima;
    }

    public void setProfundidadMaxima(int profundidadMaxima) {
        this.profundidadMaxima = profundidadMaxima;
    }

    public String getFormaCuerpo() {
        return formaCuerpo;
    }

    public void setFormaCuerpo(String formaCuerpo) {
        this.formaCuerpo = formaCuerpo;
    }

    public boolean isEsVenenoso() {
        return esVenenoso;
    }

    public void setEsVenenoso(boolean esVenenoso) {
        this.esVenenoso = esVenenoso;
    }

    @Override
    public String toString() {
        return "Pez{" +
                "id=" + id +
                ", especie='" + especie + '\'' +
                ", tamanioPromedio=" + tamanioPromedio +
                ", habitat='" + habitat + '\'' +
                ", tipoAlimentacion='" + tipoAlimentacion + '\'' +
                ", zonaGeografica='" + zonaGeografica + '\'' +
                ", esperanzaVida=" + esperanzaVida +
                ", estadoConservacion='" + estadoConservacion + '\'' +
                ", urlInformacion='" + urlInformacion + '\'' +
                ", imagen='" + imagen + '\'' +
                ", tipoAgua='" + tipoAgua + '\'' +
                ", profundidadMaxima=" + profundidadMaxima +
                ", formaCuerpo='" + formaCuerpo + '\'' +
                ", esVenenoso=" + esVenenoso +
                '}';
    }
}