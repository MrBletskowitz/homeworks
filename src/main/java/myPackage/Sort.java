package myPackage;

import ru.vsu.lab.entities.IPerson;
import java.util.Comparator;
import java.util.function.Predicate;

public class Sort {
    public void SortById(){
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Person obj1 = (Person)o1;
                Person obj2 = (Person)o2;
                if(obj1.getId() > obj2.getId()){
                    return 1;
                }
                else if(obj1.getId() < obj2.getId()){
                    return -1;

                }
                else{
                    return 0;
                }
            }
        };

    }

    public void SortByName(){
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Person obj1 = (Person)o1;
                Person obj2 = (Person)o2;
                if(obj1.getFirstName().charAt(0) > obj2.getFirstName().charAt(0)){
                    return 1;
                }
                else if(obj1.getFirstName().charAt(0) < obj2.getFirstName().charAt(0)){
                    return -1;

                }
                else{
                    return 0;
                }
            }
        };
    }
}
