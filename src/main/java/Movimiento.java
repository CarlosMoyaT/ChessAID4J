//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Movimiento {
    private Pieza pieza;
    private int inicioFila;
    private int inicioColumna;
    private int finalFila;
    private int finalColumna;
    private boolean piezaCapturada;

    public Movimiento(Pieza pìeza, int inicioFila, int inicioColumna, int finalFila, int finalColumna, boolean piezaCapturada) {
        this.pieza = this.pieza;
        this.inicioFila = inicioFila;
        this.inicioColumna = inicioColumna;
        this.finalFila = finalFila;
        this.finalColumna = finalColumna;
        this.piezaCapturada = piezaCapturada;
    }

    public Pieza getPieza() {
        return this.pieza;
    }

    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    }

    public int getInicioFila() {
        return this.inicioFila;
    }

    public void setInicioFila(int inicioFila) {
        this.inicioFila = inicioFila;
    }

    public int getInicioColumna() {
        return this.inicioColumna;
    }

    public void setInicioColumna(int inicioColumna) {
        this.inicioColumna = inicioColumna;
    }

    public int getFinalFila() {
        return this.finalFila;
    }

    public void setFinalFila(int finalFila) {
        this.finalFila = finalFila;
    }

    public int getFinalColumna() {
        return this.finalColumna;
    }

    public void setFinalColumna(int finalColumna) {
        this.finalColumna = finalColumna;
    }

    public boolean isPiezaCapturada() {
        return this.piezaCapturada;
    }

    public void setPiezaCapturada(boolean piezaCapturada) {
        this.piezaCapturada = piezaCapturada;
    }
}