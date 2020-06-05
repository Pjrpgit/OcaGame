package org.vipsion.oca.modelo;

/**
 * <h1>Dado</h1>
 * <p>
 * Proporciona un entero random del 1 al 6 que usara el
 * {@link org.vipsion.oca.controlador.Coordinador} en su metodo
 * <code>juega()</code>.</p>
 *
 * @see java.lang.Math#random()
 */
public class Dado {

    /**
     * Genera de manera aleatorea un numero del 1 al 6 mediante
     * {@link java.lang.Math#random()}
     *
     * @return int
     */
    public int dameNumero() {
        return (int) (Math.random() * 6) + 1;
    }
}
