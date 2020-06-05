package org.vipsion.oca.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import org.vipsion.oca.controlador.Coordinador;

/**
 * <h1>OcaGUI</h1>
 * <p>
 * Ayudará a distribuir los dos paneles de <code>jugador</code> con el frame y
 * el comportamiento del mismo en la propia aplicación.
 *
 */

public class OcaGUI extends JFrame {

    private List<PanelJugador> panelesJugador;
    private JLabel label;
    private Coordinador coordinador;

    /**
     * Establece el <code>coordinador</code>
     *
     * @param coordinador {@link org.vipsion.oca.controlador.Coordinador}
     */
    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
        for (PanelJugador panelJugador : panelesJugador) {
            panelJugador.setCoordinador(coordinador);
        }
    }

    /**
     * Ejecuta {@link org.vipsion.oca.vista.OcaGUI#initComponents()} e
     * inicializa la configuración del frame.
     *
     * @see java.awt.Toolkit
     * @see java.awt.Image
     */

    public OcaGUI() {
        initComponents();
        setTitle("OCA THE GAME");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Toolkit mipantalla = Toolkit.getDefaultToolkit();
        Image miIcono = mipantalla.getImage("src/img/oca.png");
        setIconImage(miIcono);
    }

    /**
     * Establece el valor pasado por parametro en
     * {@link org.vipsion.oca.vista.PanelJugador#setValorDado(int)}
     *
     * @param turno {@link org.vipsion.oca.modelo.Juego#setTurno(int) }
     * @param valor {@link org.vipsion.oca.modelo.Dado#dameNumero() }
     */
    public void setValorDado(int turno, int valor) {
        PanelJugador panelJugador = panelesJugador.get(turno);
        panelJugador.setValorDado(valor);
    }

    /**
     * Establece la posición pasado por parametro en {@link org.vipsion.oca.vista.PanelJugador#setPosicionTablero(int)
     * }
     *
     * @param turno {@link org.vipsion.oca.modelo.Juego#setTurno(int) }
     * @param valor {@link org.vipsion.oca.modelo.Dado#dameNumero() }
     */
    public void setPosicionTablero(int turno, int valor) {
        PanelJugador panelJugador = panelesJugador.get(turno);
        panelJugador.setPosicionTablero(valor);
    }

    /**
     * Desactiva el <code>PanelJugador</code> en el momento en que el jugador no
     * esta activo.
     *
     * @param turno {@link org.vipsion.oca.modelo.Juego#setTurno(int) }
     * @see org.vipsion.oca.vista.PanelJugador
     */
    public void disableTurno(int turno) {
        PanelJugador panelJugador = panelesJugador.get(turno);
        panelJugador.disableTiraDado();
    }

    /**
     * Llama <code>enableTiraDado()</code> en función del proximo
     * <code>jugador</code> en jugar.
     *
     * @param turno {@link org.vipsion.oca.modelo.Juego#setTurno(int)}
     * @see org.vipsion.oca.modelo.Dado
     * @see org.vipsion.oca.vista.PanelJugador
     */

    public void sigTurno(int turno) {
        for (PanelJugador panelJugador : panelesJugador) {
            panelJugador.disableTiraDado();
        }
        panelesJugador.get(turno).enableTiraDado();
    }

    /**
     * Llama <code>enableTiraDado()</code> para habilitar el elemento
     * <code>JButton</code> del <code>jugador</code> activo.
     *
     * @param turno {@link org.vipsion.oca.modelo.Juego#setTurno(int)}
     * @see org.vipsion.oca.vista.PanelJugador
     */

    public void enableTurno(int turno) {
        PanelJugador panelJugador = panelesJugador.get(turno);
        panelJugador.enableTiraDado();
    }

    /**
     * Establece el ganador de la partida, lo cual produce cambios en el
     * <code>PanelJugador</code>
     *@param turno {@link org.vipsion.oca.modelo.Juego#turno}
     */
    public void setGanador(int turno) {
        PanelJugador panelJugador = panelesJugador.get(turno);
        panelJugador.setGanador();
    }

    /**
     * Cambiara el estado de cada jugador en función de si es su turno o no.
     * @param turno {@link org.vipsion.oca.modelo.Juego#turno}
     * @param msj Contenido textual que se mostrara en el estado del jugador.
     */
    public void cambiaEstado(int turno, String msj) {

        PanelJugador panelJugador = panelesJugador.get(turno);
        panelJugador.setOpaque(false);
        panelJugador.cambiaEstado(msj);

    }

    /**
     * Inicializa todos los componentes que conforman el <code>GUI</code>
     */

    @SuppressWarnings("unchecked")
    private void initComponents() {
        panelesJugador = new ArrayList<>();
        PanelJugador panelJugador1 = new PanelJugador(1);
        PanelJugador panelJugador2 = new PanelJugador(2);
        panelesJugador.add(panelJugador1);
        panelesJugador.add(panelJugador2);
        label = new JLabel();
        label.setText("OCA \"the game\"");
        label.setFont(new Font("Serif", Font.PLAIN, 36));
        label.setForeground(Color.blue);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(panelJugador1, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelJugador2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(label)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(panelJugador1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(panelJugador2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))));
        pack();
    }

    /**
     * Inicializa toda la aplicación GUI, respetando así el modelo MVC.
     *
     * @param args No utilizados.
     */
    public static void main(String args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OcaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OcaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OcaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OcaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new OcaGUI().setVisible(true);
            }
        });
    }
}
