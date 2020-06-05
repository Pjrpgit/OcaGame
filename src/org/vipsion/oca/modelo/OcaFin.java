package org.vipsion.oca.modelo;
/**
 * <h1>OcaFin</h1>
 * Determina que la casilla que cae en ella se establece automaticamente como ganadora y avanza 4 casillas.
 * 
 */

public class OcaFin extends Casilla {

    private final int desplazamiento;
    
    /**
     * Construye la última Oca que es una <code>casilla</code> que implica la victoria directa. 
     * @param posicion {@link org.vipsion.oca.modelo.Casilla#posicion}
     * @param desplazamiento {@link org.vipsion.oca.modelo.Casilla#posicion}
     */

    public OcaFin(int posicion, int desplazamiento) {
        super(posicion);
        this.desplazamiento = desplazamiento;
    }
    /**
     * Establece la posición de la <code>ficha</code> en la última casilla y llama a <code>setFin()</code>
     * @param ficha {@link org.vipsion.oca.modelo.Ficha}
     * @see org.vipsion.oca.modelo.Ficha#setFin(java.lang.Boolean) 
     */

    @Override
    public void posaFicha(Ficha ficha) {
        ficha.setPosicion(posicion + desplazamiento);
        ficha.setFin(true);
    }
}
