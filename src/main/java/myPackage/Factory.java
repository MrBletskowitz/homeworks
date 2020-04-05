package myPackage;

import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.factory.ILabFactory;
import ru.vsu.lab.repository.IRepository;

import java.io.IOException;

public class Factory implements ILabFactory {
    public IPerson createPerson(){
        return new Person();
    }
    public IDivision createDivision(){
        return new Division();
    }

    public IDivision createDivisionWithName(String name){
        Division a = new Division();
        return a.check(name);
    }
    public <T> IRepository<T> createRepository(/*Class<T> clazz*/) throws IOException {
        return new Repository();
    }
}
