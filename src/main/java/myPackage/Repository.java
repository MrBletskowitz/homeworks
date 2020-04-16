/**
 * Repository for storing IPerson interfaces
 * @Author MrBletskowitz
 * @Version 0.1
 */
package myPackage;


import myPackage.Factory;
import org.apache.log4j.Logger;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.repository.IRepository;

import javax.xml.bind.annotation.*;
import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;
import java.util.logging.Level;


@XmlRootElement
public class Repository<T> implements IRepository<IPerson> {
    Logger logger = Logger.getLogger(Repository.class.getName());
    //FileHandler fh = new FileHandler("C:\\Users\\Msi PC\\IdeaProjects\\HW\\src\\main\\resources\\logfile.log");
    //SimpleFormatter sf = new SimpleFormatter();
    private IPerson [] objects;
    private Factory factory;
    private int size;

    /**
     * Constructor of Repository
     */
    Repository() throws IOException{
        try {
            objects = new IPerson[10];
            size = 0;
            logger.debug("Repository created");
        } catch (Throwable t) {
            logger.error(t.getMessage());
            t.printStackTrace();
        }
    }
    public IPerson[] getObjects(){
        logger.debug("Objects got");
        return objects;
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
        logger.debug("Size of repository increased to " + objects.length + " objects");
    }

    public int getSize(){
        logger.debug("Size got");
        return size;
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
        logger.debug("Person " + Person.getFirstName() + " " + Person.getLastName() + " added");
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
        IPerson [] repl = new Person[size-index];
        for(int i = 0; i < repl.length; i++) {
            repl[i] = objects[index+i];
        }
        if(index == 0){
            objects[index] = person;
            size++;
            for(int i = index+1, j = 0; i < size; i++, j++) {
                objects[i] = repl[j];
            }
        }
        else {
            objects[index] = person;
            size++;
            for (int i = index + 1, j = 0; i < size; i++, j++) {
                objects[i] = repl[j];
            }
        }
        logger.debug("Person " + person.getFirstName() + " " + person.getLastName() + " added to " + index + " position");
    }

    /**
     * Get element of [id] index
     * @param id - index of element
     * @return - required element
     */
    public IPerson get(int id){
        logger.debug("Person with id=" + id + " got");
        return this.objects[id];
    }

    /**
     * Change element of [index] index
     * @param index - index of element
     * @param person - new element
     */
    public void set(int index, IPerson person){
        this.objects[index] = person;
        logger.debug("Person " + person.getFirstName() + " " + person.getLastName() + " was set to " + index + " position");
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
        logger.debug("Repository was converted to list");
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
                logger.debug("Person with index=" + index + " was deleted");
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
        logger.debug("Repository was sorted");
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
        logger.debug("Repository was sorted by name");
    }

    /**
     * universal function of bubble sorting
     * @param comparator - comparator which have the parameter to compare
     */
    public void sortBy(Comparator<IPerson> comparator) {
        if(size != 0) {
           BubbleSort<IPerson> sort = new BubbleSort<IPerson>();
           sort.Sort((Repository<IPerson>) this, comparator, 0, 0);
            //sort.QuickSort((Repository<IPerson>) this, comparator, 0, size-1);
            logger.debug("Repository was sorted");
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
        logger.debug("Searching for person with id=" + id);
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
        logger.debug("Searching for person with name=" + name);
        return searchBy(predicate);
    }
    /**
     * Searching of elements in the array
     * @param condition - predicate with condition to search
     * @return Repository with the results
     */
    public IRepository searchBy(Predicate<IPerson> condition){
        Repository withResults = null;
        try {
            withResults = new Repository();
        } catch (IOException e) {
            logger.error("Exception " + e.getMessage());
            e.printStackTrace();
        }
        for(int i = 0; i < size; i++){
            if(condition.test(objects[i])){
                withResults.add(objects[i]);
            }
        }
        logger.debug( "Searching with predicate");
        return withResults;
    }
//клонировать через maven, через dependency подгружать интерфейсы
}
