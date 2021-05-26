package cabinet;
import java.util.*;
import java.util.Scanner;

import cabinet.repository.PacientRepository;

import com.sun.jdi.event.ClassUnloadEvent;
import cabinet.exceptions.FileWritingException;
import cabinet.readwriteservice.WriteService;


public class PacientService {

    public static void meniuPacienti() {
        System.out.println("--- Meniu pentru optiunile pacientilor ---");
        System.out.println("1. Afisare toti pacientii.");
        System.out.println("2. Afisare pacienti pensionari.");
        System.out.println("3. Afisare pacienti copii.");
        System.out.println("4. Adauga pacient.");
        System.out.println("5.Editare varsta pacient.");
        System.out.println("6.Stergere pacient.");
        System.out.println("0. Inchidere");
    }
    public static Pacient[] adaugaPacient(Pacient[] lista, Pacient p) {

        Pacient[] newLista = new Pacient[lista.length + 1];
        for(int i =0; i < lista.length; i++)
            newLista[i] = lista[i];
        newLista[lista.length] = p;
        WriteService.writeIstoric("adaugaPacient",true);
        return newLista;
    }

    public static Pacient[] adaugaDatePacient(Pacient[] lista) {
        System.out.println("Introduceti datele pentru pacientul pe care doriti sa il adaugati:");

        Scanner scanner = new Scanner(System.in);

        System.out.println("NUME PACIENT:");
        String nume = scanner.nextLine();

        System.out.println("CNP PACIENT: ");
        String cnp = scanner.next();

        System.out.println("SEX PACIENT - introduceti 0 pentru sex maculin, 1 pentru sex feminim: ");
        int sex = scanner.nextInt();

        System.out.println("VARSTA: ");
        int varsta = scanner.nextInt();

        System.out.println("NR. DIAGNOSTICE: ");
        int nrDiagnostice = scanner.nextInt();

        System.out.println("DIAGNOSTICE: ");
        String[] fisa = new String[nrDiagnostice];
        for (int i = 0; i < nrDiagnostice; i++) {
            String afectiune = scanner.next();
            fisa[i] = afectiune;}

        Pacient pacient = new Pacient(nume, cnp, sex, varsta, fisa);
        //System.out.println(pacient.toString());


        Pacient[] listaNew = adaugaPacient(lista, pacient);

        PacientRepository pacientRepository= new PacientRepository();
        pacientRepository.insertPacient(pacient);

        return listaNew;
    }

    public static void afisarePacienti(Pacient[] listaPacienti){
        System.out.println("--- Lista tututror pacientilor --- ");
        for (Pacient pacient : listaPacienti)
            System.out.println(pacient.toString());
        WriteService.writeIstoric("afisareListaClienti",true);
    }

    public static void afisarePensionari(Pacient[] listaPacienti) {
        System.out.println("---Lista pacientilor pensionari ---");
        for (Pacient pacient : listaPacienti)
            if(pacient.getClass().equals(Pensionar.class)) {
                System.out.println(pacient.toString());
            }
        WriteService.writeIstoric("afisarePensionari",true);
    }

    public static void afisareCopii(Pacient[] listaPacienti) {
        System.out.println("---Lista pacientilor copii ---");
        for (Pacient pacient : listaPacienti)
            if(pacient.getClass().equals(Copil.class)) {
                System.out.println(pacient.toString());
            }
        WriteService.writeIstoric("afisareCopii",true);
    }

    public static void eliminarePacient(){
        System.out.println("Introdceti id-ul clientului pe care doriti sa il eliminati :");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();

        PacientRepository clientRepository = new PacientRepository();
        clientRepository.deletePacient(id);

        WriteService.writeIstoric("eliminarePacient",true);
    }

    public static void editareVarstaPacient() {

        System.out.println("Introduceti id-ul persoanei careia doriti sa ii actualizati varsta :");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        System.out.println("Introduceti noua valoare :");
        int varsta = scanner.nextInt();

        PacientRepository pacientRepository = new PacientRepository();
        pacientRepository.updatePacientVarsta(id, varsta);

        WriteService.writeIstoric("editareVarstaPacient",true);
    }
}
