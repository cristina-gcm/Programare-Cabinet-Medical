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

    public Reteta(String cod_reteta, String cnp_pacient, String id_medic, String data, int nr_med, String[] medicamente, int pret) {

        this.cnp_pacient = cod_reteta;
        this.cnp_pacient = cnp_pacient;
        this.id_medic = id_medic;
        this.data = data;
        this.nr_med = nr_med;
        this.medicamente = medicamente;
        this.pret = pret;

    }

    public String getCod_reteta() {
        return cod_reteta;
    }
    public void setCod_reteta(String cod_reteta) {
        this.cod_reteta = cod_reteta;
    }

    public String getCnp_pacient() {
        return cnp_pacient;
    }
    public void setCnp_pacient(String cnp_pacient) {
        this.cnp_pacient = cnp_pacient;
    }

    public String getId_medic() {
        return id_medic;
    }
    public void setId_medic(String id_medic) {
        this.id_medic = id_medic;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    public int getNr_med() {
        return nr_med;
    }
    public void setNr_med(int nr_med) {
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
