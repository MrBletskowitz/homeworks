package myPackage;

import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.factory.ILabFactory;
import ru.vsu.lab.repository.IRepository;

public class Factory implements ILabFactory {
    public IPerson createPerson(){
        return new Person();
    }
    public IDivision createDivision(){
        return new Division();
    }
    public <T> IRepository<T> createRepository(Class<T> clazz)
    {
        return new Repository();
    }
}
