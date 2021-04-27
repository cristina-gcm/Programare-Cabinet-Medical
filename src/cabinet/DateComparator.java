package cabinet;

import java.util.Comparator;

public class DateComparator implements Comparator<Programare> {

    @Override
    public int compare(Programare p1, Programare p2) {
        return (p1.getData().compareTo(p2.getData()));
    }
}
