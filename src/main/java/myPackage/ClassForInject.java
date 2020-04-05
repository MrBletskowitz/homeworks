package myPackage;

import ru.vsu.lab.entities.IPerson;

import java.util.Comparator;

public class ClassForInject {
    @LabInject
    public ISorter<IPerson> sorter;

    public void sort(Repository<IPerson> rep, Comparator<IPerson> comparator, int low, int high){
        sorter.Sort(rep, comparator, low, high);
    }
}
