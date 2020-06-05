package org.vipsion.oca;

import org.vipsion.oca.vista.OcaGUI;
import org.vipsion.oca.controlador.Coordinador;
import org.vipsion.oca.modelo.Juego;
import org.vipsion.oca.modelo.Dado;

/**
 * <h1>Principal</h1>
 * <p>
 * Instancia
 * {@link org.vipsion.oca.modelo.Juego},{@link org.vipsion.oca.vista.OcaGUI}, {@link org.vipsion.oca.modelo.Dado}
 * y {@link org.vipsion.oca.controlador.Coordinador} en el cual se establece de
 * forma recíproca tanto en <code>Juego</code> como en <code>OcaGUI</code>,
 * <code>Coordinador</code> establece el <code>Dado</code> y ejecuta {@link org.vipsion.oca.controlador.Coordinador#inicia()
 * }.</p>
 *
 * @author Pj
 * @version 1.0
 * @since 2019-03-7
 * @see <a href="https://es.wikipedia.org/wiki/Juego_de_la_oca">Wikipedia Juego
 * Oca</a>
 */

public class Principal {

    /**
     * Metodo principal
     *
     * @param args No usado.
     */
    public static void main(String[] args) {
        Coordinador miCoordinador = new Coordinador();
        Juego miJuego = new Juego();
        OcaGUI miGUI = new OcaGUI();
        Dado miDado = new Dado();
        miGUI.setCoordinador(miCoordinador);
        miCoordinador.setGUI(miGUI);
        miCoordinador.setLogica(miJuego);
        miGUI.setVisible(true);
        miCoordinador.inicia();

    }
}
