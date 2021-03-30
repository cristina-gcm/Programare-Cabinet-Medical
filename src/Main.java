import cabinet.*;
import java.util.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //System.out.println("Hello World!");

        ProgramareService.meniuProgramari();

        Programare programare1 = new Programare("12", "Andrei Popescu", "Alexandrina Maurer", "31.10.2021", "10:30", 100);
        //System.out.println(programare1.toString());

        Programare programare2 = new Programare("20", "Mirela Popescu", "Adina Micuda", "01.12.2021", "15:00", 15);
        //System.out.println(programare2.toString());

        Programare programare3 = new Programare("11", "Alexandru Postolescu", "Alexandrina Maurer", "10.01.2022", "08:00", 275);
        //System.out.println(programare3.toString());

        Programare[] listaProgramari = new Programare[]{programare3, programare1, programare2};

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



    }
}
