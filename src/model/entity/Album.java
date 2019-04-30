package model.entity;

import java.util.List;
import javafx.scene.image.Image;

/**
 *
 * @author 8rux40
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
    private List<Integer> midiasDisponiveis;
    private Image capa;

    public Album() {
    }
    
    public Album(String titulo, String artista, Integer anoLancamento, List<Integer> midiasDisponiveis, Image capa) {
        this.titulo = titulo;
        this.artista = artista;
        this.anoLancamento = anoLancamento;
        this.midiasDisponiveis = midiasDisponiveis;
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

    public List<Integer> getMidiasDisponiveis() {
        return midiasDisponiveis;
    }

    public void setMidiasDisponiveis(List<Integer> midiasDisponiveis) {
        this.midiasDisponiveis = midiasDisponiveis;
    }

    public Image getCapa() {
        return capa;
    }

    public void setCapa(Image capa) {
        this.capa = capa;
    }
    
}
