//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.List;

public abstract class Pieza {
    private boolean esBlanca;
    private String tipoDePieza;
    private int coordenadasFila;
    private int coordenadasColumna;

    public Pieza(boolean esBlanca, String tipoDePieza, int coordenadasFila, int coordenadasColumna) {
        this.esBlanca = esBlanca;
        this.tipoDePieza = tipoDePieza;
        this.coordenadasColumna = coordenadasColumna;
        this.coordenadasFila = coordenadasFila;
    }

    public abstract List<Movimiento> posiblesMovimientos(Board var1);

    public boolean movimientoValido(Movimiento movimiento, Board board) {
        return false;
    }
}