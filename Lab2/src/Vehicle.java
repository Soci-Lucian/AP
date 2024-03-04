public class Vehicle {

    private String marca;
    private String culoare;
    private int an;


    public Vehicle(String marca, String culoare, int an) {
        this.marca = marca;
        this.culoare = culoare;
        this.an = an;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public int getAn() {
        return an;
    }

    public void setAn(int an) {
        this.an = an;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "marca='" + marca + '\'' +
                ", culoare='" + culoare + '\'' +
                ", an=" + an +
                '}';
    }
}
