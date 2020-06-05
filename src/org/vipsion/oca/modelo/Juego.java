package org.vipsion.oca.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Juego</h1>
 * <p>
 * Establecera la comunicación entre el Coordinador y el resto de clases de
 * {@link org.vipsion.oca.modelo}. así como almacenara tanto
 * <code>jugadores</code> y el máximo de estos, <code>turno</code>,
 * {@link org.vipsion.oca.modelo.Tablero} y {@link org.vipsion.oca.modelo.Dado}
 * </p>
 *
 * @see org.vipsion.oca.controlador.Coordinador
 * @see org.vipsion.oca.modelo.Tablero
 * @see org.vipsion.oca.modelo.Jugador
 */
public class Juego {

    private List<Jugador> jugadores;
    private int turno = 0;
    private Tablero tablero;
    private Dado dado;
    private int numJugadores = 2;

    /**
     * Establece un <code>ArrayList</code> de <code>jugadores</code>, inicializa
     * dos instancias de {@link org.vipsion.oca.modelo.Jugador} y las añade a
     * este último. Inicializa {@link org.vipsion.oca.modelo.Tablero} y
     * {@link org.vipsion.oca.modelo.Dado}
     */
    public Juego() {
        jugadores = new ArrayList<>();
        tablero = new Tablero();
        dado = new Dado();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
    }

    /**
     * Proporciona la información al <code>Coordinador</code> para que
     * establezca el siguiente <code>jugador</code> que jugará su
     * <code>turno</code>
     *
     * @return entero 1 ó 0 en función de si jugará el mismo jugador o el
     * siguiente.
     */
    public int sigTurno() {
        int sigTurno;
        sigTurno = (turno + 1) % numJugadores;
        if (jugadores.get(turno).getTurnosExtra() > 0) {
            sigTurno = turno;
            jugadores.get(turno).decrementaTurnosExtra();
        }
        return (sigTurno);
    }

    /**
     * Llamá a <code>sigTurno()</code> y retorná su valor.
     *
     * @return entero 1 ó 0 en función de si jugará el mismo jugador o el
     * siguiente.
     */
    public int avanzaTurno() {
        turno = sigTurno();
        return turno;
    }

    /**
     * Establece el jugador activo.
     *
     * @param turno {@link org.vipsion.oca.modelo.Juego#setTurno(int) }
     */
    public void setTurno(int turno) {
        this.turno = turno;
    }

    /**
     * Retorna el jugador activo.
     *
     * @return {@link org.vipsion.oca.modelo.Juego#setTurno(int) }
     */
    public int getTurno() {
        return (turno);
    }

    /**
     * Retorna el valor del <code>dado</code> que almacena el jugador activo.
     *
     * @return entero con un rango del 1 al 6.
     * @see org.vipsion.oca.modelo.Jugador#ultimoValorDado
     */
    public int ultimoValorDado() {
        return jugadores.get(turno).getUltimoValorDado();
    }

    /**
     * Retorna el valor de la <code>posicion</code> que almacena el jugador
     * activo.
     *
     * @return entero con un rango del 1 al 6.
     * @see org.vipsion.oca.modelo.Jugador#getUltimaPosicionTablero()
     */
    public int ultimaPosicionTablero() {
        return jugadores.get(turno).getUltimaPosicionTablero();
    }

    /**
     * Llamá al método <code>juegaTurno</code> del jugador activo.
     *
     * @see
     * org.vipsion.oca.modelo.Jugador#juegaTurno(org.vipsion.oca.modelo.Tablero,
     * org.vipsion.oca.modelo.Dado)
     */
    public void juega() {
        jugadores.get(turno).juegaTurno(tablero, dado);
    }

    /**
     * Establece el ganador de la partida.
     *
     * @return <code>true</code> en caso de que la ficha alcance
     * <code>Fin</code> ó <code>OcaFin</code> <code>false</code>en cualquier
     * otro caso.
     */
    public Boolean esFin() {
        return jugadores.get(turno).esGanador();
    }
}
