package cabinet;
import java.util.*;


public class ProgramareService {

    public static void meniuProgramari(){
        System.out.println("--- Meniu pentru gestionarea programarilor ---");
        System.out.println("1. Afisare toate programarile.");
        System.out.println("2. Cautare programare");
        System.out.println("3. Modificare programare");
        System.out.println("4. Anulare programare");
        System.out.println("5. Adaugare programare");
        System.out.println("6. Inchidere");
    }

    public static void afisareProgramari(Programare[] lista){

        System.out.println("Lista programarilor");
        for (Programare p : lista )
            System.out.println(p.toString());
    }

    public static Programare[] adaugaProgramare(Programare[] lista, Programare p) {

        Programare[] newLista = new Programare[lista.length + 1];
        for(int i =0;i <lista.length;i++)
            newLista[i] = lista[i];
        newLista[lista.length] = p;
        return newLista;
    }

    public static Programare[] adaugaDateProgramare(Programare[] lista, Programare p) {

        System.out.println("Introduceti datele pentru programarea pe care doriti sa o adaugati:");

        Scanner scanner = new Scanner(System.in);

        System.out.println("COD PROGRAMARE: ");
        String cod = scanner.nextLine();

        System.out.println("NUME PACIENT: ");
        String nume_p = scanner.next();

        System.out.println("NUME DOCTOR: ");
        String nume_d = scanner.next();

        System.out.println("DATA: ");
        String data = scanner.next();

        System.out.println("ORA: ");
        String ora = scanner.next();

        System.out.println("PRET:");
        int suma = scanner.nextInt();

        Programare programare = new Programare(cod, nume_p, nume_d, data, ora, suma);
        System.out.println(programare.toString());

        Programare[] listaNew= adaugaProgramare(lista,programare);
        return listaNew;

    }

    public static Programare[] stergeProgramare(Programare[] lista){
        Programare[] newList = new Programare[lista.length - 1];

        Scanner scanner1 = new Scanner(System.in);

        System.out.println("Introduceti codul programarii care urmeaza sa fie eliminate: ");
        String id_p = scanner1.nextLine();

        int index = -1;

        int ok = 0;

        for (int i = 0; i < lista.length; i++) {

            if (lista[i].getCod_prog().equals(id_p)) {

                index = i;
                ok = 1;
                break;
            }

        }

        if ( ok == 0) {
            System.out.println("Nu s-a gasit programarea cu acest cod!");
            return lista;
        }
        else {

            for (int i = 0, j = 0; i < lista.length; i++) {
                if (i != index) {
                    newList[j++] = lista[i];
                }
            }
        return newList;
        }
    }
}
