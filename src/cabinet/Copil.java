package cabinet;

public class Copil extends Pacient {

    private String tel_tutore;

    public Copil(String nume, String cnp, int sex, int varsta, String[] fisa, String tel) {

        super(nume, cnp, sex, varsta, fisa);
        this.tel_tutore = tel;

    }

    public void setTel_tutore(String tel_tutore) {
        this.tel_tutore = tel_tutore;
    }
    public String getTel_tutore() {
        return tel_tutore;
    }

    @Override
    public String toString() {
        return super.toString() + " Pacientul este un copil. Tel. tutore: " + tel_tutore + '.';
    }
}
