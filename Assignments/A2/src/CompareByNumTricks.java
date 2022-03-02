
/**
 * Comparator used for comparing Flights by the number of Tricks.
 * 
 * @author Diego Dorantes-Ferreira 260854063
 */

import java.util.Comparator;

public class CompareByNumTricks implements Comparator<Flight> {

    @Override
    public int compare(Flight o1, Flight o2) {
        return o1.getTricks().size() - o2.getTricks().size();
    }

}