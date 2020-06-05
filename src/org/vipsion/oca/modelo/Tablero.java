package org.vipsion.oca.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Tablero</h1>
 * <p>
 * Recoge la colección de <code>Casilla</code> así como el total de las que se
 * compone y establece las casillas con un comportamiento diferente: {@link org.vipsion.oca.modelo.Oca},
 * {@link org.vipsion.oca.modelo.OcaFin},{@link org.vipsion.oca.modelo.Fin}.</p>
 *
 * @see #casillas
 * @see numCasillas
 *
 */
public class Tablero {

    private List<Casilla> casillas;

    private final int numCasillas = 63;

    /**
     * Instancia en un ArrayList todas las casillas y establece aquellas que son
     * de un tipo especial.
     */
    public Tablero() {
        this.casillas = new ArrayList<>();
        for (int i = 0; i < numCasillas; i++) {
            this.casillas.add(new Casilla(i + 1));
        }
        casillas.set(8, new Oca(9, 5));
        casillas.set(17, new Oca(18, 5));
        casillas.set(26, new Oca(27, 5));
        casillas.set(35, new Oca(36, 5));
        casillas.set(44, new Oca(45, 5));
        casillas.set(53, new Oca(54, 5));
        casillas.set(4, new Oca(5, 4));
        casillas.set(13, new Oca(14, 4));
        casillas.set(22, new Oca(23, 4));
        casillas.set(31, new Oca(32, 4));
        casillas.set(40, new Oca(41, 4));
        casillas.set(49, new Oca(50, 4));
        casillas.set(54, new OcaFin(59, 4));
        casillas.set(62, new Fin(63));
    }

    /**
     * Establece la nueva posición que tendra la ficha, en caso de superar
     * {@link numCasillas} se restará.
     *
     * @param ficha {@link org.vipsion.oca.modelo.Ficha}
     * @param numDado {@link org.vipsion.oca.modelo.Dado#dameNumero()}
     * @see
     * org.vipsion.oca.modelo.Jugador#juegaTurno(org.vipsion.oca.modelo.Tablero,
     * org.vipsion.oca.modelo.Dado)
     */

    public void mueveFicha(Ficha ficha, int numDado) {

        int numCasilla = ficha.getPosicion() + numDado;

        if (numCasilla > numCasillas) {
            numCasilla = (numCasillas - ((ficha.getPosicion() + numDado) - numCasillas));
        }
        casillas.get(numCasilla - 1).posaFicha(ficha);
    }

}
