package myPackage;

import org.junit.Test;
import ru.vsu.lab.entities.IPerson;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Comparator;

import static org.junit.Assert.*;

public class InjectorTest {
    @LabInject
    ISorter<IPerson> sorter;
    @Test
    public void inject() throws IOException, CustomInjectionExeption {
        Repository a = new Repository();
        Person b = new Person();
        Person c = new Person();
        b.setFirstName("Michael");
        c.setFirstName("Alfred");
        c.setId(10);
        a.add(c);
        b.setId(15);
        a.add(b);

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
        Injector injector = new Injector();
        injector.inject(this.getClass());
        sorter.Sort(a, comparator, 0, 0);

        System.out.println(a.toList().get(0));
    }
}