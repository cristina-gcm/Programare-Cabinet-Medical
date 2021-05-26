package cabinet;

public class Asistent {


    private String nume;
    private String medic;

    public Asistent(String nume, String medic) {

        this.medic = medic;
        this.nume = nume;
    }



    public String getMedic() {
        return medic;
    }
    public void setMedic(String medic) {
        this.medic = medic;
    }

    public String getNume() {
        return nume;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public String toString() {
        return "Asistentul " + nume + " lucreaza in cabinetul doctorului " + medic + " .";
    }
}
