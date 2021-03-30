package cabinet;

public class Medic {

    private String id_medic;
    private String nume_medic;
    private String specializare;
    private int nr_pacienti;
    private int tip_cabinet;

    public Medic (String id_medic, String nume_medic, String specializare, int nr_pacienti, int tip_cabinet) {

        this.id_medic = id_medic;
        this.nume_medic = nume_medic;
        this.specializare = specializare;
        this.nr_pacienti = nr_pacienti;
        this.tip_cabinet = tip_cabinet;
    }

    // tip_cabinet ---> 1 pt privat, 0 pt stat


    public String getId_medic() {
        return id_medic;
    }
    public void setId_medic(String id_medic) {
        this.id_medic = id_medic;
    }

    public String getNume_medic() {
        return nume_medic;
    }
    public void setNume_medic(String nume_medic) {
        this.nume_medic = nume_medic;
    }

    public String getSpecializare() {
        return specializare;
    }
    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

    public int getNr_pacienti() {
        return nr_pacienti;
    }
    public void setNr_pacienti(int nr_pacienti) {
        this.nr_pacienti = nr_pacienti;
    }

    public int getTip_cabinet() {
        return tip_cabinet;
    }
    public void setTip_cabinet(int tip_cabinet) {
        this.tip_cabinet = tip_cabinet;
    }

    @Override
    public String toString() {
        if (getTip_cabinet() == 0)
            return "Medicul " + nume_medic + " cu specializare in " + specializare + "lucreaza in domeniul " + "de stat.";
        else
            return "Medicul " + nume_medic + " cu specializare in " + specializare + "lucreaza in domeniul " + "privat.";
    }
}
