package cabinet;

public class Pensionar extends Pacient{

    private int pensie;
    private String id_cupon;
    private int reducere;

    public Pensionar(String nume, String cnp, boolean sex, int varsta, String[] fisa, String id_cupon, int pensie, int reducere) {

        super(nume, cnp, sex, varsta, fisa);
        this.id_cupon = id_cupon;
        this.pensie = pensie;
        this.reducere = reducere;

    }

    public void setId_cupon(String id_cupon) {
        this.id_cupon = id_cupon;
    }
    public String getId_cupon(String id_cupon) {
        return id_cupon;
    }

    public void setPensie(int pensie) {
        this.pensie = pensie;
    }
    public int getPensie() {
        return pensie;
    }

    public void setReducere(int reducere) {
        this.reducere = reducere;
    }
    public int getReducere() {
        return reducere;
    }

    @Override
    public String toString()
    {
            return super.toString() + "Pacientul este pensionar, beneficiind de o reducere de " + reducere + "%. ";
    }
}
