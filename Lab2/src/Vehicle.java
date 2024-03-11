import java.util.Objects;

abstract class Vehicle {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return an == vehicle.an && Objects.equals(marca, vehicle.marca) && Objects.equals(culoare, vehicle.culoare);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, culoare, an);
    }
}
