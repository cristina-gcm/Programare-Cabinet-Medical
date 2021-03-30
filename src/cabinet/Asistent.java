package cabinet;

public class Asistent {

    private String id_asistent;
    private String nume;
    private String medic;

    public Asistent(String id_asistent, String nume, String medic) {
        this.id_asistent = id_asistent;
        this.medic = medic;
        this.nume = nume;
    }

    public String getId_asistent() {
        return id_asistent;
    }
    public void setId_asistent(String id_asistent) {
        this.id_asistent = id_asistent;
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
