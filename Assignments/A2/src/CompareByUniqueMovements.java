
/**
 * Comparator used for comparing Flights by the number of Unique Movements.
 * 
 * @author Diego Dorantes-Ferreira 260854063
 */

import java.util.Comparator;

public class CompareByUniqueMovements implements Comparator<Flight> {

    @Override
    public int compare(Flight o1, Flight o2) {
        return o1.queryFlightUniqueMovements() - o2.queryFlightUniqueMovements();
    }

}