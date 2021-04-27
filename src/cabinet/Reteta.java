package cabinet;

import java.util.Arrays;


public class Reteta {

    private String cod_reteta;
    private String cnp_pacient;
    private String id_medic;
    private String data;
    private int nr_med;
    private String[] medicamente;
    private int pret;

    public Reteta() {
    }

    public Reteta(String cod_reteta, String cnp_pacient, String id_medic, String data, int nr_med, String[] medicamente, int pret) {

        this.cod_reteta = cod_reteta;
        this.cnp_pacient = cnp_pacient;
        this.id_medic = id_medic;
        this.data = data;
        this.nr_med = nr_med;
        this.medicamente = medicamente;
        this.pret = pret;

    }

    public String getCodReteta() {
        return cod_reteta;
    }
    public void setCodReteta(String cod_reteta) {
        this.cod_reteta = cod_reteta;
    }

    public String getCnpPacient() {
        return cnp_pacient;
    }
    public void setCnpPacient(String cnp_pacient) {
        this.cnp_pacient = cnp_pacient;
    }

    public String getIdMedic() {
        return id_medic;
    }
    public void setIdMedic(String id_medic) {
        this.id_medic = id_medic;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    public int getNrMed() {
        return nr_med;
    }
    public void setNrMed(int nr_med) {
        this.nr_med = nr_med;
    }

    public String[] getMedicamente() {
        return medicamente;
    }
    public void setMedicamente(String[] medicamente) {
        this.medicamente = medicamente;
    }

    public int getPret() {
        return pret;
    }
    public void setPret(int pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Reteta cu codul " + cod_reteta + " din data " + data + ", in valoare de " + pret + ", prescrie medicamentele: " + Arrays.toString(medicamente);
    }
}
