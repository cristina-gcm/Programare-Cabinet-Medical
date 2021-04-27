package cabinet.readwriteservice;

import cabinet.exceptions.FileWritingException;
import cabinet.exceptions.FileReadingException;

import cabinet.Programare;
import cabinet.Pacient;
import cabinet.Medic;
import cabinet.Reteta;

import java.io.BufferedInputStream;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Map;
import java.util.Date;
import java.sql.Timestamp;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;


public class WriteService {

    // afisez date despre pacienti
    public static void writePacient (Pacient[] listaPacient, boolean append) throws FileWritingException {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter("src/cabinet/files/PacientOut.txt",append))) {
            for (Pacient pacient : listaPacient) {
                String text = pacient.toString() + '\n';
                buffer.write(text);
            }
        } catch (IOException e) {
            throw new FileWritingException("Pacient: error at writing!", e);
        }
    }

    // afisez date despre un medic
    public static void writeMedic (ArrayList<Medic> medicArrayList, boolean append) throws FileWritingException {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter("src/cabinet/files/MedicOut.txt", append))) {
            for (Medic medic : medicArrayList) {
                String text = medic.toString() + '\n';
                buffer.write(text);
            }
        } catch (IOException e) {
            throw new FileWritingException("Medic: error at writing!", e);
        }
    }

    // afisez date despre reteta

    public static void writeReteta (ArrayList<Reteta> retetaArrayList, boolean append) throws FileWritingException {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter("src/cabinet/files/RetetaOut.txt", append))) {
            for (Reteta reteta : retetaArrayList) {
                String text = reteta.toString() + '\n';
                buffer.write(text);
            }
        } catch (IOException e) {
            throw new FileWritingException("Reteta: error at writing!", e);
        }
    }

    // afisez datele unei programari

    public static void writeProgramare (Map<Integer, Programare> programareMap, boolean append) throws FileWritingException {
        try (BufferedWriter buffer = new BufferedWriter (new FileWriter("src/cabinet/files/ProgramareOut.txt", append))) {
            for (Map.Entry<Integer, Programare> pair : programareMap.entrySet()) {
                String text = "programarea "+ pair.getKey() + " : " + pair.getValue().toString() + '\n';
                buffer.write(text);
            }
        } catch (IOException e) {
            throw new FileWritingException("Programare: error at writing!", e);
        }
    }

    // scriu in fisierul Istoric.txt de fiecare data cand se efectueaza o comanda din partea I
    public static void writeIstoric (String text, boolean append)  {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter("src/cabinet/files/Istoric.txt",append)))  {
            Date data = new Date();

            // timpul in milisecunde
            long time = data.getTime();

            Timestamp timest = new Timestamp(time);

            String timestamp = timest.toString();

            String scrie = text + "," + timestamp + '\n';

            buffer.write(scrie);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
