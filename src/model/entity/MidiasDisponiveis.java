package model.entity;

import java.util.Objects;

/**
 *
 * @author 8rux40
 * @github https://github.com/8rux40
 */
public class MidiasDisponiveis {
    private Album album;
    private TipoDeMidia tipoDeMidia;

    public MidiasDisponiveis() {
    }

    public MidiasDisponiveis(Album album, TipoDeMidia tipoDeMidia) {
        this.album = album;
        this.tipoDeMidia = tipoDeMidia;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public TipoDeMidia getTipoDeMidia() {
        return tipoDeMidia;
    }

    public void setTipoDeMidia(TipoDeMidia tipoDeMidia) {
        this.tipoDeMidia = tipoDeMidia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.album);
        hash = 67 * hash + Objects.hashCode(this.tipoDeMidia);
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
        final MidiasDisponiveis other = (MidiasDisponiveis) obj;
        if (!Objects.equals(this.album, other.album)) {
            return false;
        }
        if (!Objects.equals(this.tipoDeMidia, other.tipoDeMidia)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MidiasDisponiveis{" + "album=" + album + ", tipoDeMidia=" + tipoDeMidia + '}';
    }
    
    
}
