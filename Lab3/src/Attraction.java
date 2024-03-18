public abstract class Attraction implements Comparable<Attraction>, Visitable {
    private String name;

    public Attraction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Attraction{" +
                "name='" + name + '\'' +
                '}';
    }

    public int
    compareTo(Attraction other) {
        if(this.name!=null && other.name!= null)
            return this.name.compareTo(other.name);
        return 0;
    }


}
