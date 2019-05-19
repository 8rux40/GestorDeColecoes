package model.entity;

import java.io.File;
import java.util.Objects;
import javafx.scene.image.Image;

/**
 *
 * @author 8rux40
 * @github https://github.com/8rux40
 */
public class Album {

    
    private Integer id;
    private String titulo;
    private String artista;
    private Integer anoLancamento;
    private File capa;
    private String strCapa;
    private Integer status;

    public Album() {
    }
    
    public Album(Integer id, String titulo, String artista, Integer anoLancamento, File capa, Integer status) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.anoLancamento = anoLancamento;
        this.capa = capa;
        this.status = status;
//        this.capa = new Image("./view/img/capa/"+capa);
    }

    public void setCapa(File capa) {
        this.capa = capa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public String getStrCapa() {
        return strCapa;
    }

    public void setStrCapa(String strCapa) {
        this.strCapa = strCapa;
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

    public File getCapa() {
        return capa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.titulo);
        hash = 17 * hash + Objects.hashCode(this.artista);
        hash = 17 * hash + Objects.hashCode(this.anoLancamento);
        hash = 17 * hash + Objects.hashCode(this.capa);
        hash = 17 * hash + Objects.hashCode(this.strCapa);
        hash = 17 * hash + Objects.hashCode(this.status);
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
        if (!Objects.equals(this.strCapa, other.strCapa)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.anoLancamento, other.anoLancamento)) {
            return false;
        }
        if (!Objects.equals(this.capa, other.capa)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Album{" + "id=" + id + ", titulo=" + titulo + ", artista=" + artista + ", anoLancamento=" + anoLancamento + ", capa=" + capa + ", strCapa=" + strCapa + ", status=" + status + '}';
    }
    
    
}
