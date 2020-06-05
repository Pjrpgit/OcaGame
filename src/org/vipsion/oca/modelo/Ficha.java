package org.vipsion.oca.modelo;

/**
 * <h1>Ficha</h1>
 * <p>Única para cada jugador, por eso tiene un <code>id</code>, almacena tanto la <code>posicion</code> como los turnos extra y si se ha llegado al final.</p>
 * @see org.vipsion.oca.modelo.Fin
 * @see org.vipsion.oca.modelo.Tablero
 * @see org.vipsion.oca.modelo.Jugador
 */

public class Ficha {
    

    private int posicion;

    private int id;

    private int turnosExtra;

    private Boolean fin;
    // private int turnosSinTirar; 
    
     /**
     * Retorna un flag que establece cuando se cae en <code>Fin</code>.
     * @return true en caso de que sea el final de la partida, false en caso de que aún no sea el final.
     */
    public Boolean getFin() {
        return fin;
    }
    /**
     * Establece cuando se cae en <code>Fin</code>.
     * @param fin {@link org.vipsion.oca.modelo.Fin}
     */

    public void setFin(Boolean fin) {
        this.fin = fin;
    }
    /**
     * Establece la posicion <code>inicial</code> de la <code>Ficha</code> en 1
     */

    public Ficha() {
        posicion = 1;
        fin = false;
        turnosExtra = 0;
    }
     /**
     * Retorna la <code>casilla</code> que ocupa la ficha en el tablero.
     * @return {@link org.vipsion.oca.modelo.Casilla#posicion}
     */

    public int getPosicion() {
        return posicion;
    }
    /**
     * Establece la <code>casilla</code> que ocupa la ficha en el tablero.
     * @param posicion {@link org.vipsion.oca.modelo.Casilla#posicion}
     */
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
     /**
     * Devuelve los turnos en los que se cae en la <code>Oca</code>.
     * @return entero que determina si se tienen turnos extra.
     */

    public int getTurnosExtra() {
        return turnosExtra;
    }
     /**
     * Establece los turnos en los que se cae en la <code>Oca</code>.
     * @param turnosExtra {@link org.vipsion.oca.modelo.Juego#setTurno(int) }
     */

    public void setTurnosExtra(int turnosExtra) {
        this.turnosExtra = turnosExtra;
    }
    /**
     * Reduce en uno los turnos que tiene por jugar <code>Ficha</code>
     */
    public void decrementaTurnosExtra() {
        turnosExtra--;
    }

}
