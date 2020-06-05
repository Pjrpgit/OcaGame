package org.vipsion.oca.modelo;

/**
 * <h1>Fin</h1>
 * <p>
 * Subclase de {@link org.vipsion.oca.modelo.Casilla}, es el objectivo del
 * juego.</p>
 *
 * @see org.vipsion.oca.modelo.Jugador#esGanador()
 */
public class Fin extends Casilla {
    
    /**
     * Contruye la casilla fin de {@link org.vipsion.oca.modelo.Tablero}
     * @param posicion {@link org.vipsion.oca.modelo.Casilla#posicion}
     */

    public Fin(int posicion) {
        super(posicion);
    }

    /**
     * Metodo heredado que establece el campo <code>fin</code> de la
     * <code>Ficha</code> pasada como parametro a true;
     *
     * @param ficha {@link org.vipsion.oca.modelo.Ficha}
     */

    @Override
    public void posaFicha(Ficha ficha) {
        ficha.setFin(true);
    }
}
