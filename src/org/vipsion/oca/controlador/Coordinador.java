package org.vipsion.oca.controlador;

import org.vipsion.oca.modelo.Juego;
import org.vipsion.oca.vista.OcaGUI;

/**
 * <h1>Coordinador</h1>
 * <p>
 * Sirve de enlace entre los eventos que se producen en el
 * {@link org.vipsion.oca.vista.OcaGUI} y la información que se procesa a través
 * de {@link org.vipsion.oca.modelo.Juego}</p>
 * <p>
 * Un ejemplo sería <code>juega()</code> que será el método que se ejecute en el
 * momento de pulsar sobre el elemento <code>JButton tiraDado</code></p>
 *
 * @see org.vipsion.oca.vista.OcaGUI
 * @see org.vipsion.oca.modelo.Juego
 */
public class Coordinador {

    private OcaGUI GUI;
    private Juego juego;

    /**
     * Establece el valor del <code>GUI</code>
     *
     * @param GUI {@link org.vipsion.oca.vista.OcaGUI}
     * @see org.vipsion.oca.vista.OcaGUI
     */
    public void setGUI(OcaGUI GUI) {
        this.GUI = GUI;
    }

    /**
     * Establece el valor del <code>juego</code>
     *
     * @param juego {@link org.vipsion.oca.modelo.Juego}
     * @see org.vipsion.oca.vista.OcaGUI
     */
    public void setLogica(Juego juego) {
        this.juego = juego;
    }

    /**
     * Establece la configuración inicial de la aplicación en la que el jugador
     * 1 inicia su turno.
     */
    /*Se podria añadir una funcionabilidad para que esto no se lanzase automaticamente si no que fuese al
    pulsar un botón, al igual que resetear el juego en caso de que se desease.*/
    public void inicia() {
        int turnoInicio = juego.getTurno();
        GUI.sigTurno(turnoInicio);
        int turno = juego.getTurno();
        GUI.cambiaEstado(turno, "Jugando turno");
    }

    /**
     * Establece la acción principal del turno, coordinado con
     * <code>juego</code> y <code>GUI</code>
     *
     * @see org.vipsion.oca.modelo.Juego
     * @see org.vipsion.oca.vista.OcaGUI
     * @see org.vipsion.oca.vista.PanelJugador
     */
    public void juega() {
        juego.juega();
        int posicionTablero = juego.ultimaPosicionTablero();
        int valorDado = juego.ultimoValorDado();
        int turno = juego.getTurno();
        GUI.setValorDado(turno, valorDado);
        GUI.setPosicionTablero(turno, posicionTablero);
        if (juego.esFin()) {
            GUI.setGanador(turno);
        } else {
            int sigTurno = juego.avanzaTurno();
            GUI.sigTurno(sigTurno);
            GUI.cambiaEstado(turno, "Esperando al otro jugador");
            GUI.cambiaEstado(sigTurno, "Jugando turno");
        }

    }

}
