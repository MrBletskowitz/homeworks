package myPackage;

import ru.vsu.lab.entities.IPerson;

import java.util.Comparator;

public interface ISorter<T> {
    /*public void BubbleSort(Repository<T> rep, Comparator<IPerson> comparator);

    public  void QuickSort(Repository<T> rep, Comparator<IPerson> comparator, int low, int high);*/

    public void Sort(Repository<T> rep, Comparator<IPerson> comparator, int low, int high);
}
