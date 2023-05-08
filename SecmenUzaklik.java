package Assesment;

public  class SecmenUzaklik implements Comparable<SecmenUzaklik> {
    public Secmen Secmen;
    public double Uzaklik;

    public SecmenUzaklik(Secmen Secmen, double Uzaklik) {
        this.Secmen = Secmen;
        this.Uzaklik = Uzaklik;
    }

    public int compareTo(SecmenUzaklik other) {
        return Double.compare(Uzaklik, other.Uzaklik);
    }
}
