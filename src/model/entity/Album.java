package model.entity;

import java.util.Objects;
import javafx.scene.image.Image;

/**
 *
 * @author 8rux40
 * @github https://github.com/8rux40
 */
public class Album {
    // Enumeração dos tipos de mídia disponíveis
    public static final int CD     = 1;
    public static final int DVD    = 2;
    public static final int Vinil  = 3;
    public static final int BluRay = 4;
    public static final int K7     = 5;
    
    private String titulo;
    private String artista;
    private Integer anoLancamento;
    private Image capa;

    public Album() {
    }
    
    public Album(String titulo, String artista, Integer anoLancamento, Image capa) {
        this.titulo = titulo;
        this.artista = artista;
        this.anoLancamento = anoLancamento;
        this.capa = capa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Image getCapa() {
        return capa;
    }

    public void setCapa(Image capa) {
        this.capa = capa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.titulo);
        hash = 97 * hash + Objects.hashCode(this.artista);
        hash = 97 * hash + Objects.hashCode(this.anoLancamento);
        hash = 97 * hash + Objects.hashCode(this.capa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Album other = (Album) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.artista, other.artista)) {
            return false;
        }
        if (!Objects.equals(this.anoLancamento, other.anoLancamento)) {
            return false;
        }
        if (!Objects.equals(this.capa, other.capa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Album{" + "titulo=" + titulo + ", artista=" + artista + ", anoLancamento=" + anoLancamento + ", capa=" + capa + '}';
    }
    
    
}
