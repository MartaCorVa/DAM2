package cat.paucasesnovescifp.spaad.utilitats;

import cat.paucasesnovescifp.spaad.dades.Pilot;
import com.db4o.query.Predicate;

public class ComparaPunts extends Predicate<Pilot> {

    private int minimPunts;
    public ComparaPunts(int minimPunts) {
        this.minimPunts = minimPunts;
    }
    @Override
    public boolean match(Pilot pilot) {
        return pilot.getPunts() >= minimPunts;
    }

}
