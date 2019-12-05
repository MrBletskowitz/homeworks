package myPackage;

import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.factory.ILabFactory;
import ru.vsu.lab.repository.IPersonRepository;
import ru.vsu.lab.repository.IRepository;

public class Factory implements ILabFactory {
    public IPerson createPerson(){
        return new Person();
    }
    public IDivision createDivision(){
        return new Division();
    }
    public IPersonRepository createPersonRepository(){
        return (IPersonRepository) new Repository();
    }
}
