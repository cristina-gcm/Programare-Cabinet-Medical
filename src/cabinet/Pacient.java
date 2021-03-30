package cabinet;
import java.util.Arrays;
import java.util.Objects;


public class Pacient {

    private boolean sex;
    private String cnp;
    private String nume;
    private int varsta;
    private String[] fisa_medicala;

    public Pacient() {
    }

    public Pacient(String nume, String cnp, boolean sex, int varsta, String[] fisa) {

        this.nume = nume;
        this.cnp = cnp;
        this.sex = sex;
        this.varsta = varsta;
        this.fisa_medicala = fisa;

    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return this.nume;
    }

    public void setSex(boolean s) {
        this.sex = s;
    }

    public boolean getSex() {
        return this.sex;
    }

    // 0 - sex masculin
    // 1 - sex feminim

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getCnp() {
        return this.cnp;
    }

    public void setVarsta(int v) {
        this.varsta = v;
    }

    public int getVarsta() {
        return this.varsta;
    }

    public void setFisa_medicala(String[] fisa) {
        this.fisa_medicala = fisa;
    }

    public String[] getFisa_medicala() {
        return this.fisa_medicala;
    }

    @Override
    public String toString() {
        return "Pacientul " + nume +
                ", cu CNP-ul : " + cnp +
                ", cu varsta de " + varsta +
                " ani, sex : " + sex +
                ", a fost diagnosticat cu: " + Arrays.toString(fisa_medicala) + ".";
    }
}


