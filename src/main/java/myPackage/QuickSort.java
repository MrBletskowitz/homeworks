package myPackage;

import ru.vsu.lab.entities.IPerson;

import java.util.Comparator;

public class QuickSort<T> implements ISorter<T>{
    Factory fct = new Factory();
    @Override
    public void Sort(Repository<T> rep, Comparator<IPerson> comparator, int low, int high) {
            int leftMarker = low;
            int rightMarker = high;
            IPerson pivot = rep.get((leftMarker + rightMarker) / 2);
            do {
                // Двигаем левый маркер слева направо пока элемент меньше, чем pivot
                while (comparator.compare(rep.get(leftMarker), pivot) < 0) {
                    leftMarker++;
                }
                // Двигаем правый маркер, пока элемент больше, чем pivot
                while (comparator.compare(rep.get(rightMarker), pivot) > 0) {
                    rightMarker--;
                }
                // Проверим, не нужно обменять местами элементы, на которые указывают маркеры
                if (leftMarker <= rightMarker) {
                    // Левый маркер будет меньше правого только если мы должны выполнить swap
                    if (leftMarker < rightMarker) {
                        IPerson tmp = rep.get(leftMarker);
                        rep.set(leftMarker, rep.get(rightMarker));
                        rep.set(rightMarker, tmp);
                    }
                    // Сдвигаем маркеры, чтобы получить новые границы
                    leftMarker++;
                    rightMarker--;
                }
            } while (leftMarker <= rightMarker);

            // Выполняем рекурсивно для частей
            if (leftMarker < high) {
                Sort(rep, comparator, leftMarker, high);
            }
            if (low < rightMarker) {
                Sort(rep,comparator, low, rightMarker);
            }
    }
}
