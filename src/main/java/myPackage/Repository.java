/**
 * Repository for storing IPerson interfaces
 * @Author MrBletskowitz
 * @Version 0.1
 */
package myPackage;

import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.repository.IRepository;
import myPackage.Factory;
import java.util.*;
import java.util.function.Predicate;

public class Repository<T> implements IRepository<IPerson> {
    private IPerson [] objects;
    private Factory factory;
    private int size;

    /**
     * Constructor of Repository
     */
    Repository() {
        objects = new IPerson[10];
        size = 0;
    }

    /**
     * increasing size of Repository
     * @param currentSize size of array before changing
     */
    private void increaseSize(int currentSize){
        IPerson [] old = new IPerson[currentSize];
        old = objects.clone();
        objects = new IPerson[(int)(size*1.5f)];
        for(int i = 0; i < old.length; i++){
            objects[i] = old[i];
        }
    }

    /**
     * Replacing elements of array after removing
     * @param from index of first replaced element
     */
    private void replace(int from){
        IPerson [] repl = new Person[size-from+1];
        for(int i = 0; i < size-from+1; i++) {
            repl[i] = objects[from+i];
        }
        if(from == 0){
            for(int i = from, j = 0; i < size; i++, j++) {
                objects[i] = repl[j];
            }
        }
        else {
            for (int i = from - 1, j = 0; i < size; i++, j++) {
                objects[i] = repl[j];
            }
        }
        size--;
    }

    /**
     * Add new element to repository
     * @param Person new element
     */
    public void add(IPerson Person) {
        if(objects.length == size) {
            increaseSize(size);
        }
        objects[size] = Person;
        size++;
    }

    /**
     * add new element to [index] position
     * @param index index of new element
     * @param person insertable object
     */
    public void add(int index, IPerson person){
        if(objects.length == size) {
            increaseSize(size);
            size++;
        }
        IPerson [] repl = new Person[size-index+1];
        for(int i = 0; i < size-index+1; i++) {
            repl[i] = objects[index+i];
        }
        if(index == 0){
            for(int i = index+1, j = 0; i < size; i++, j++) {
                objects[i] = repl[j];
            }
        }
        else {
            objects[index] = person;
            for (int i = index + 1, j = 0; i < size; i++, j++) {
                objects[i] = repl[j];
            }
        }
    }

    /**
     * Get element of [id] index
     * @param id - index of element
     * @return - required element
     */
    public IPerson get(int id){
        return this.objects[id];
    }

    /**
     * Change element of [index] index
     * @param index - index of element
     * @param person - new element
     */
    public void set(int index, IPerson person){
        this.objects[index] = person;
    }

    /**
     * Convert repository from array to list
     * @return list of Persons
     */
    public List<IPerson> toList(){
        List<IPerson> objectList = new LinkedList<>();
        for(int i = 0; i < size; i++) {
            objectList.add(objects[i]);
        }
        return objectList;
    }

    /**
     * delete element of [index] index
     * @param index - index of element to delete
     */
    public IPerson delete(int index){
                IPerson del = new Person();
                del = objects[index];
                objects[index] = null;
                replace(index+1);
                return del;
    }

    /**
     * Sorting array by IPerson's id
     */
    public void sortById(){
        Comparator<IPerson> comparator = new Comparator<IPerson>() {
            @Override
            public int compare(IPerson o1, IPerson o2) {

                if(o1.getId() > o2.getId()){
                    return 1;
                }
                else if(o1.getId() < o2.getId()){
                    return -1;

                }
                else{
                    return 0;
                }
            }
        };
        sortBy(comparator);
    }

    /**
     * sorting array by IPerson's first name
     */
    public void sortByName(){
        Comparator<IPerson> comparator = new Comparator<IPerson>(){
            @Override
            public int compare(IPerson o1, IPerson o2) {
                if(o1.getFirstName().charAt(0) > o2.getFirstName().charAt(0)){
                    return 1;
                }
                else if(o1.getFirstName().charAt(0) < o2.getFirstName().charAt(0)){
                    return -1;
                }
                else{
                    for(int i = 1; i < 4;i++){
                        if(o1.getFirstName().charAt(i) > o2.getFirstName().charAt(i)){
                            return 1;
                        }
                        else if(o1.getFirstName().charAt(i) < o2.getFirstName().charAt(i)){
                            return -1;
                        }
                    }
                    return 0;
                }
            }
        };
        sortBy(comparator);
    }

    /**
     * universal function of bubble sorting
     * @param comparator - comparator which have the parameter to compare
     */
    public void sortBy(Comparator<IPerson> comparator) {
        if(size != 0) {
            IPerson [] sort = new IPerson[size];
            for(int i = 0; i < size-1; i++){
                if(comparator.compare(objects[i], objects[i+1]) > 0){
                    IPerson reserved = new Person();
                    reserved = objects[i];
                    objects[i] = objects[i+1];
                    objects[i+1] = reserved;
                    sortBy(comparator);
                }
            }
            return;
        }
    }

    /**
     * search element by his id
     * @param id - id of element
     * @return Repository with results
     */
    public IRepository<IPerson> searchById(int id){
        Predicate<IPerson> predicate = new Predicate<IPerson>() {
            @Override
            public boolean test(IPerson person) {
                return person.getId().equals(id);
            }
        };
        return searchBy(predicate);
    }
    /**
     * search element by his first name
     * @param name - first name of person
     * @return Repository with the results
     */
    public IRepository<IPerson> searchByName(String name){
        Predicate<IPerson> predicate = new Predicate<IPerson>() {
            @Override
            public boolean test(IPerson person) {
                return person.getFirstName().equals(name);
            }
        };
        return searchBy(predicate);
    }
    /**
     * Searching of elements in the array
     * @param condition - predicate with condition to search
     * @return Repository with the results
     */
    public IRepository searchBy(Predicate<IPerson> condition){
        Repository withResults = new Repository();
        for(int i = 0; i < size; i++){
            if(condition.test(objects[i])){
                withResults.add(objects[i]);
            }
        }
        return withResults;
    }
//клонировать через maven, через dependency подгружать интерфейсы
}
