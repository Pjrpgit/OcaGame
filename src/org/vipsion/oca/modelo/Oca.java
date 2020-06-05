package org.vipsion.oca.modelo;

/**
 * <h1>Oca</h1>
 * <p>
 * Proporciona un movimiento en el {@link org.vipsion.oca.modelo.Tablero} y un
 * turno extra</p>
 *
 * @see <a href="https://es.wikipedia.org/wiki/Juego_de_la_oca#La_oca">Oca
 * Wikipedia</a>
 * @see org.vipsion.oca.modelo.Ficha#posicion
 *
 */
public class Oca extends Casilla {

    private final int desplazamiento;
    private final int turnosExtra;

    /**
     * Tendrá una <code>posicion</code> ya que es una <code>Casilla</code> y un
     * <code>desplazamiento</code>
     *
     * @param posicion Establece la posicion en el tablero
     * @param desplazamiento Establece que posición pasará a ocupar la
     * <code>ficha</code> tras caer en ella.
     */
    public Oca(int posicion, int desplazamiento) {
        super(posicion);
        this.desplazamiento = desplazamiento;
        this.turnosExtra = 1;
    }

    /**
     * Sobrescribe el metodo padre teniendo en cuenta el desplazamiento.
     *
     * @param ficha {@link org.vipsion.oca.modelo.Ficha}
     * @see org.vipsion.oca.modelo.Casilla#posaFicha
     */
    @Override
    public void posaFicha(Ficha ficha) {
        ficha.setPosicion(posicion + desplazamiento);
        ficha.setTurnosExtra(turnosExtra);
    }
}
