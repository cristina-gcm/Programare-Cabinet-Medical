package cabinet.readwriteservice;

import cabinet.*;
import cabinet.exceptions.FileReadingException;
import cabinet.exceptions.FileWritingException;

import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Map;

public class ReadService {

    //citesc informatii din fisier despre un pacient
    public static Pacient[] readPacient(Pacient[] listaPacienti) throws FileReadingException {
        try (BufferedReader buffer = new BufferedReader(new FileReader("src/cabinet/files/PacientIn.txt"))) {
            String line = buffer.readLine();
            ArrayList<Pacient> pacienti = new ArrayList<>();
            while (line != null) {
                String[] lines = line.split(",");
                Pacient pacient = new Pacient();
                pacient.setNume(lines[0]);
                pacient.setCnp(lines[1]);
                pacient.setSex(Integer.parseInt(lines[2]));
                pacient.setVarsta(Integer.parseInt(lines[3]));

                String[] fisa = new String[lines.length - 4];
                int k = 0;
                for (int j = 4; j < lines.length; j++) {
                    fisa[k] = lines[j];
                    k += 1;
                }

                pacient.setFisaMedicala(fisa);

                pacienti.add(pacient);

                //citesc linia urmatoare
                line = buffer.readLine();
            }
            for (Pacient pacient : pacienti) {
                listaPacienti = PacientService.adaugaPacient(listaPacienti, pacient);
            }
            return listaPacienti;
        } catch (IOException e) {
            throw new FileReadingException("Pacient: reading error!", e);
        }
    }

    // citesc informatii din fisier despre un doctor

    public static ArrayList<Medic> readMedic (ArrayList<Medic> medicArrayList) throws FileReadingException {
        try (BufferedReader buffer = new BufferedReader(new FileReader("src/cabinet/files/MedicIn.txt"))) {
            String line = buffer.readLine();

            while (line!= null) {
                String[] lines = line.split(",");
                Medic medic = new Medic();
                medic.setIdMedic(lines[0]);
                medic.setNumeMedic(lines[1]);
                medic.setSpecializare(lines[2]);
                medic.setNrPacienti(Integer.parseInt(lines[3]));
                medic.setTipCabinet(Integer.parseInt(lines[4]));

                medicArrayList.add(medic);

                //next line

                line = buffer.readLine();
            }

            return medicArrayList;
        } catch (IOException e) {
            throw new FileReadingException("Medic: error at reading!", e);
        }
    }

    // citesc informatii despre o reteta

    public static ArrayList<Reteta> readReteta (ArrayList <Reteta> retetaArrayList) throws FileReadingException {
        try (BufferedReader buffer = new BufferedReader(new FileReader("src/cabinet/files/RetetaIn.txt"))) {
            String line = buffer.readLine();
            while (line != null) {
                String[] lines = line.split(",");
                Reteta reteta = new Reteta();
                reteta.setCodReteta(lines[0]);
                reteta.setCnpPacient(lines[1]);
                reteta.setIdMedic(lines[2]);
                reteta.setData(lines[3]);
                reteta.setNrMed(Integer.parseInt(lines[4]));

                // citesc medicamentele de pe reteta

                String[] med = new String[lines.length - 5];
                int k = 0;
                for (int j = 5; j < lines.length; j++) {
                    med[k] = lines[j];
                    k += 1;
                }

                reteta.setMedicamente(med);

                // adaug in array dupa setarea atributelor

                retetaArrayList.add(reteta);

                line = buffer.readLine();

            }

            return retetaArrayList;
        } catch (IOException e) {
            throw new FileReadingException("Reteta: Error at reading!");
        }
    }

    // citesc datele unei programari din fisier

    public static Map<Integer, Programare> readProgramare (Map<Integer, Programare> programariMap) throws FileReadingException {
        try (BufferedReader buffer = new BufferedReader(new FileReader("src/cabinet/files/ProgramareIn.txt"))) {
            String line = buffer.readLine();

            Integer k = 0;

            for (Map.Entry<Integer, Programare> pair : programariMap.entrySet())
                k = pair.getKey();

            while (line != null) {

                String[] lines = line.split(",");

                Programare programare = new Programare();

                programare.setCodProg(lines[0]);
                programare.setNumePacient(lines[1]);
                programare.setNumeDoctor(lines[2]);
                programare.setData(lines[3]);
                programare.setOra(lines[4]);
                programare.setPret(Integer.parseInt(lines[5]));

                k += 1;
                programariMap.put(k, programare);

                line = buffer.readLine();;

            }

            return programariMap;

        } catch (IOException e) {
            throw new FileReadingException("Programare: Error at reading!", e);
        }
    }



}
