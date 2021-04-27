package cabinet;
import java.util.*;

import cabinet.readwriteservice.WriteService;
import cabinet.exceptions.FileWritingException;

public class ProgramareService {

    public static void meniuProgramari(){
        System.out.println("--- Meniu pentru gestionarea programarilor ---");
        System.out.println("1. Afisare toate programarile.");
        System.out.println("2. Cautare programare");
        System.out.println("3. Modificare programare");
        System.out.println("4. Anulare programare");
        System.out.println("5. Adaugare programare");
        System.out.println("0. Inchidere");
    }

    public static void afisareProgramari(Map<Integer, Programare> programariMap){

        System.out.println("Lista programarilor:\n");

        for(Map.Entry<Integer,Programare> pair : programariMap.entrySet())
            System.out.println("programarea "+pair.getKey() + " : "+pair.getValue());

        //scriu in istoric
        WriteService.writeIstoric("afisareListaProgramari",true);
    }


    public static Map<Integer, Programare> adaugaProgramare(Map<Integer, Programare>programariMap)  {

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

        Integer k = 0;
        for(Map.Entry<Integer,Programare> pair : programariMap.entrySet())
            k = pair.getKey();

        programariMap.put(k+1,programare);

        // scriu in istoric

        WriteService.writeIstoric("adaugareProgramare",true);

        return programariMap;

    }

    public static Map<Integer, Programare> stergeProgramare(Map<Integer, Programare>programariMap){
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Introduceti numarul programarii pe care doriti sa o anulati :");
        Integer key = scanner1.nextInt();
        if (programariMap.containsKey(key)){
            programariMap.remove(key);
        }
        else {
            System.out.println("Nu s-a gasit nicio programare cu acest numar!");
        }

        //afisez in istoric
        WriteService.writeIstoric("eliminareProgramare",true);

        return programariMap;

    }

    public static void cautaProgramare(Map<Integer, Programare> programareMap){
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Introduceti numarul programarii pe care doriti sa o gasiti :");
        Integer key = scanner2.nextInt();
        if (programareMap.containsKey(key)) {
            for(Map.Entry<Integer,Programare> pair : programareMap.entrySet()) {
                if (key == pair.getKey()){
                    System.out.println("programarea "+pair.getKey() + " : "+pair.getValue());
                }
            }
        } else {
            System.out.println("Nu s-a gasit nicio programare cu acest numar!");
        }

    }
}
