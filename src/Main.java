import cabinet.*;
import java.util.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void servicePacienti(Pacient[] listaPacienti) {
        PacientService.meniuPacienti();
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Alegeti o optiune :");
        int op = scanner.nextInt();
        while (op != 0) {
        if (op == 1){
            PacientService.afisarePacienti(listaPacienti);
            System.out.println("Urmatoarea optiune: ");
            op = scanner.nextInt();
        } else if (op == 2) {
            PacientService.afisarePensionari(listaPacienti);
            System.out.println("Urmatoarea optiune: ");
            op = scanner.nextInt();
        } else if (op == 3) {
            PacientService.afisareCopii(listaPacienti);
            System.out.println("Urmatoarea optiune: ");
            op = scanner.nextInt();
        } else if (op == 4) {
            listaPacienti = PacientService.adaugaDatePacient(listaPacienti);
            //PacientService.afisarePacienti(listaPacienti);
            System.out.println("Urmatoarea optiune: ");
            op = scanner.nextInt();
        } else if (op != 0) {
            System.out.println("Optiune invalida. Introduceti alta optiune!");
            op = scanner.nextInt();
        }
    }}

    public static void serviceProgramari(Programare[] listaProgramari){
        ProgramareService.meniuProgramari();
    }

    public static void main(String[] args) {
        //System.out.println("Hello World!");


        Programare programare1 = new Programare("12", "Andrei Popescu", "Alexandrina Maurer", "31.10.2021", "10:30", 100);
        //System.out.println(programare1.toString());

        Programare programare2 = new Programare("20", "Mirela Popescu", "Adina Micuda", "01.12.2021", "15:00", 15);
        //System.out.println(programare2.toString());

        Programare programare3 = new Programare("11", "Alexandru Postolescu", "Alexandrina Maurer", "10.01.2022", "08:00", 275);
        //System.out.println(programare3.toString());

        Pacient pacient1 = new Pacient("Marian Dobrescu", "124587369", 0, 30, new String[] {"hipertensiune", "diabet"});
        System.out.println(pacient1.toString());

        Salariat salariat1 = new Salariat("Mirela Popescu", "2021099141231", 1, 21, new String[] {"astigmatism"}, false,"Micropop" );
        System.out.println(salariat1.toString());

        Copil copil1 = new Copil("Tudor Dumitru", "6030320111222", 0, 1, new String[] {"vaccin1", "vaccin2"}, "07324258111");
        System.out.println(copil1.toString());

        Copil copil2 = new Copil("Maia Barbu", "5250106222333", 1, 15, new String[]{"astm", "deficit vitamina D"}, "0712345678");
        System.out.println(copil2.toString());

        Pensionar pensionar1 = new Pensionar("Vasile Codru", "1210345000111", 0, 76, new String[]{"guta","fractura sold"}, "111", 3000, 10);
        System.out.println(pensionar1.toString());

        Pensionar pensionar2 = new Pensionar("Angela Codru", "2220545000111", 1, 75, new String[]{"diabet"}, "110", 3500, 5);
        System.out.println(pensionar2.toString());


        Programare[] listaProgramari = new Programare[]{programare3, programare1, programare2};
        Pacient[] listaPacienti = new Pacient[]{salariat1,copil1,copil2,pensionar1,pensionar2};
        //PacientService.adaugaPacient(listaPacienti, pacient1);
        //PacientService.afisarePacienti(listaPacienti);

        // sortare programari dupa data

        DateComparator comp = new DateComparator();

        System.out.println("Lista programarilor inainte de sortare: ");
        for (Programare p : listaProgramari) {
            System.out.println(p.toString());
        }

        System.out.println();

        Arrays.sort(listaProgramari, comp);

        System.out.println("Lista programarilor dupa sortare: ");
        for (Programare p : listaProgramari) {
            System.out.println(p.toString());
        }

        System.out.println();

        servicePacienti(listaPacienti);




    }
}
