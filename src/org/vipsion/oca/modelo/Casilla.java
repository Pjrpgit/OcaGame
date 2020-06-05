package org.vipsion.oca.modelo;

/**
 * <h1>Casilla</h1>
 * <p>
 * Clase genérica de la que partiran el resto de casillas que seran integradas
 * en {@link org.vipsion.oca.modelo.Tablero}</p>
 *
 * @see #posicion
 * @see Ficha
 * @see #posaFicha(org.vipsion.oca.modelo.Ficha)
 */
public class Casilla {

    /**
     * Entero,determinará la <code>posición</code> del tablero que tiene que
     * ocupar la <code>Casilla</code>
     */
    protected int posicion;

    /**
     * Establece la <code>posición</code> recibida.
     *
     * @param posicion <code>posicion</code> que ocupara la <code>ficha</code>
     * en el {@link org.vipsion.oca.modelo.Tablero}
     */
    public Casilla(int posicion) {
        this.posicion = posicion;
    }

    /**
     * Establece la <code>posición</code> del <code>Tablero</code> que ocupa la
     * <code>Ficha</code>
     *
     * @param ficha {@link org.vipsion.oca.modelo.Ficha}
     */
    public void posaFicha(Ficha ficha) {
        ficha.setPosicion(posicion);
    }

}
