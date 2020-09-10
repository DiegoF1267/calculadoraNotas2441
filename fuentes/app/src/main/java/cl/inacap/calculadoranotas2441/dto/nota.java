package cl.inacap.calculadoranotas2441.dto;

public class nota {
    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }


    public double getValor() {
        return valor;
    }

    public double getPromedio() {
        return promedio;
    }
    private double valor;
    private double promedio;
}
