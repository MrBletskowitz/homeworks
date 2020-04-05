package myPackage;

import ru.vsu.lab.entities.IPerson;

import java.util.Comparator;

public class BubbleSort<T> implements ISorter<T> {
    Factory fct = new Factory();
    @Override
    public void Sort(Repository<T> rep, Comparator<IPerson> comparator, int low, int high) {
        for (int i = 0; i < rep.getSize() - 1; i++) {
            if (comparator.compare(rep.get(i), rep.get(i + 1)) > 0) {
                IPerson reserved = fct.createPerson();
                reserved = rep.get(i);
                rep.set(i, rep.get(i + 1));
                rep.set(i + 1, reserved);
                Sort(rep, comparator, 0,0);
            }
        }

        return;
    }
}
