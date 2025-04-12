public class Auto {
    private String marca;
    private int anio;

    public Auto(String marca, int anio) {
        this.marca = marca;
        this.anio = anio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    public double calcularPago() {
        int anioActual = java.time.Year.now().getValue();
        int antiguedad = anioActual - anio;
        double pagoBase = 5000;
        double descuento = antiguedad * 200;
        double pagoFinal = pagoBase - descuento;
        return Math.max(pagoFinal, 1000); // No pagar menos de 1000
    }
    @Override
    public String toString() {
        return "\n---Auto---\n"+
                "Marca: "+marca+
                "\t Año: "+anio;
    }
}
