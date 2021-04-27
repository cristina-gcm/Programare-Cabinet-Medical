package cabinet;

import java.util.Objects;

public class Programare {

    private String cod_prog;
    private String nume_pacient;
    private String nume_doctor;
    private String data;
    private String ora;
    private int pret;

    public Programare(){

    }

    public Programare(String cod,String pacient, String doctor, String data, String ora, int tarif) {

        this.cod_prog = cod;
        this.nume_pacient = pacient;
        this.nume_doctor = doctor;
        this.data = data;
        this.ora = ora;
        this.pret = tarif;
    }

    public String getCodProg() {
        return cod_prog;
    }
    public void setCodProg(String cod_prog) {
        this.cod_prog = cod_prog;
    }

    public String getNumePacient() {
        return nume_pacient;
    }
    public void setNumePacient(String nume_pacient) {
        this.nume_pacient = nume_pacient;
    }

    public String getNumeDoctor() {
        return nume_doctor;
    }
    public void setNumeDoctor(String nume_doctor) {
        this.nume_doctor = nume_doctor;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    public String getOra() {
        return ora;
    }
    public void setOra(String ora) {
        this.ora = ora;
    }

    public int getPret() {
        return pret;
    }
    public void setPret(int pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Pacientul " + nume_pacient + " are programare " + cod_prog + " pe data de " + data + " ora " + ora + ", la medicul " + nume_doctor + ". ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Programare)) return false;
        Programare programare = (Programare) o;
        return getCodProg() == programare.getCodProg();
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getCodProg(), getNumePacient());
        result = 31 * result + getOra().hashCode();
        return result;
    }

}
