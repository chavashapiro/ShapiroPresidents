package shapiro.presidents;

import java.util.ArrayList;
import java.util.Collection;


public class PresidentList extends ArrayList<President> {

    public PresidentList() {

    }

    public PresidentList(Collection<? extends President> collection) {
        super(collection);
    }
}
