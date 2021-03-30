package cabinet;

public class Salariat extends Pacient {

    private boolean adev_venit;
    private String angajator;

    public Salariat(String nume, String cnp, boolean sex, int varsta, String[] fisa, boolean adeverinta, String ang) {

        super(nume, cnp, sex, varsta, fisa);
        this.adev_venit = adeverinta;
        this.angajator = ang;

    }

    public void setAdev_venit(boolean adev_venit) {
        this.adev_venit = adev_venit;
    }
    public boolean getAdev_venit() {
        return adev_venit;
    }

    public void setAngajator(String angajator) {
        this.angajator = angajator;
    }
    public String getAngajator() {
        return angajator;
    }

    @Override
    public String toString()
    {
        if (getAdev_venit())
            return super.toString() + "Pacientul este salariat, fiind angajat la: " + angajator + ". ";
        else
            return super.toString() + "Pacientul este salariat, fiind angajat la: " + angajator + ". Trebuie sa aduca adeverinta de venit.";
    }
}
