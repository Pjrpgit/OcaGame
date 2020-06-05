package org.vipsion.oca.modelo;

/**
 * <h1>Jugador</h1>
 * <p>
 * Encargado de almacenar el <code>ultimoValorDado</code> que proporciona
 * {@link org.vipsion.oca.modelo.Dado} y ejecutar <code>Juega()</code> el cual
 * esta orquestado por {@link org.vipsion.oca.modelo.Juego} además poseé un
 * metodo para establecer al <code>jugador</code> como ganador de la
 * partida.</p>
 *
 * @see org.vipsion.oca.modelo.Dado#dameNumero()
 * @see org.vipsion.oca.modelo.Tablero#mueveFicha(org.vipsion.oca.modelo.Ficha,
 * int)
 * @see org.vipsion.oca.modelo.Juego#juega()
 */
public class Jugador {

    private final Ficha ficha;
    private int ultimoValorDado;

    public Jugador() {
        this.ficha = new Ficha();
    }

    /**
     * Solicita al dado un valor que almacena en <code>ultimoValorDado</code>,
     * se llama al metodo del <code>Tablero</code> que mueve la
     * <code>Ficha</code>.
     *
     * @param tablero {@link org.vipsion.oca.modelo.Tablero}
     * @param dado {@link org.vipsion.oca.modelo.Dado}
     * @return <code>posicion</code> que ocupa la ficha tras su movimiento.
     *
     */
    public int juegaTurno(Tablero tablero, Dado dado) {
        ultimoValorDado = dado.dameNumero();
        tablero.mueveFicha(ficha, ultimoValorDado);
        return ficha.getPosicion();
    }

    /**
     * Retorna el <code>ultimoValorDado</code> que proporciona
 * {@link org.vipsion.oca.modelo.Dado}
     * @return {@link org.vipsion.oca.modelo.Dado}
     */
    public int getUltimoValorDado() {
        return ultimoValorDado;
    }

    /**
     * Establece el <code>ultimoValorDado</code>
     * @param ultimoValorDado {@link org.vipsion.oca.modelo.Dado#dameNumero()}
     */
    public void setUltimoValorDado(int ultimoValorDado) {
        this.ultimoValorDado = ultimoValorDado;
    }

    /**
     * Retorna la última <code>posicion</code> de la <code>ficha</code>
     * @return {@link org.vipsion.oca.modelo.Ficha#posicion}
     */
    public int getUltimaPosicionTablero() {
        return ficha.getPosicion();
    }

    /**
     * Devuelve los turnos extra que tenga la ficha almacenados.
     *
     * @return entero que por defecto sera 0.
     * @see org.vipsion.oca.modelo.Ficha#setTurnosExtra(int)
     * @see org.vipsion.oca.modelo.Oca
     */
    public int getTurnosExtra() {
        return (ficha.getTurnosExtra());
    }

    /**
     * Llamá al método {@link org.vipsion.oca.modelo.Ficha#decrementaTurnosExtra()
     * }
     */
    public void decrementaTurnosExtra() {
        ficha.decrementaTurnosExtra();
    }

    /**
     * Llamá al método {@link org.vipsion.oca.modelo.Ficha#getFin()} de
     * <code>ficha</code>
     * @return {@link org.vipsion.oca.modelo.Ficha#getFin() }
     */
    public Boolean esGanador() {
        return ficha.getFin();
    }
}
