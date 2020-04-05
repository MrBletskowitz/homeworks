package myPackage;

import org.junit.Test;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.repository.IRepository;

import java.io.IOException;

import static org.junit.Assert.*;

public class RepositoryTest {
    @Test
    public void add() throws TestFailedExeption, IOException {
        Repository a = new Repository();
        Person b = new Person();
        Person c = new Person();
        c.setId(10);
        a.add(c);
        b.setId(15);
        a.add(b);
        if(a.get(1).getId().equals(b.getId())){
            System.out.println("add is ok");
        }
        else{
            throw new TestFailedExeption("Unit test failed on function add", "add()");
        }
    }

    @Test
    public void testAdd() throws TestFailedExeption, IOException {
        Repository a = new Repository();
        Person b = new Person();
        Person c = new Person();
        b.setId(12);
        c.setId(22);
        a.add(b);
        a.add(c);
        Person d = new Person();
        d.setId(30);
        a.add(1, d);
        if(a.get(2).getId().equals(c.getId())){
            System.out.println("add with id is ok");
        }
        else{
            throw new TestFailedExeption("Unit test failed on function add with id", "testAdd()");
        }
    }

    @Test
    public void get() throws TestFailedExeption, IOException {
        Repository a = new Repository();
        Person b = new Person();
        Person c = new Person();
        b.setId(12);
        c.setId(22);
        a.add(b);
        a.add(c);
        if(a.get(1).getId().equals(c.getId())){
            System.out.println("get is ok");
        }
        else{
            throw new TestFailedExeption("Unit test failed on function get", "get()");
        }
    }

    @Test
    public void set() throws TestFailedExeption, IOException {
        Repository a = new Repository();
        Person b = new Person();
        Person c = new Person();
        b.setId(12);
        c.setId(22);
        a.add(b);
        a.add(c);
        a.set(0, c);
        a.set(1, b);
        if(a.get(1).getId().equals(b.getId())){
            System.out.println("set is ok");
        }
        else{
            throw new TestFailedExeption("Unit test failed on function set", "set()");
        }
    }

    @Test
    public void toList() throws TestFailedExeption, IOException {
        Repository a = new Repository();
        Person b = new Person();
        Person c = new Person();
        b.setId(12);
        c.setId(22);
        a.add(b);
        a.add(c);
        if(a.toList().contains(c)){
            System.out.println("toList is ok");
        }
        else{
            throw new TestFailedExeption("Unit test failed on function toList", "toList()");
        }
    }

    @Test
    public void delete() throws TestFailedExeption, IOException {
        Repository a = new Repository();
        Person b = new Person();
        Person c = new Person();
        b.setId(12);
        c.setId(22);
        a.add(b);
        a.add(c);
        a.delete(0);
        if(a.get(0).getId().equals(c.getId())){
            System.out.println("delete is ok");
        }
        else{
            throw new TestFailedExeption("Unit test failed on function delete", "delete()");
        }
    }

    @Test
    public void sortById() throws TestFailedExeption, IOException {
        Factory fct = new Factory();
        Repository<IPerson> rep = new Repository<IPerson>();
        IPerson a = fct.createPerson();
        IPerson b = fct.createPerson();
        IPerson c = fct.createPerson();
        IPerson d = fct.createPerson();
        IPerson e = fct.createPerson();
        a.setId(12);
        b.setId(11);
        c.setId(10);
        d.setId(9);
        e.setId(8);
        rep.add(a);
        rep.add(b);
        rep.add(c);
        rep.add(d);
        rep.add(e);
        rep.sortById();
        System.out.println(rep.get(0).getId());
        System.out.println(rep.get(1).getId());
        System.out.println(rep.get(2).getId());
        System.out.println(rep.get(3).getId());
        System.out.println(rep.get(4).getId());
        if(rep.get(0).getId().equals(e.getId())){
            System.out.println("sortById is ok");
        }
        else{
            throw new TestFailedExeption("Unit test failed on function sortById", "sortById()");
        }
    }

    @Test
    public void sortByName() throws TestFailedExeption, IOException {
        Factory fct = new Factory();
        Repository<IPerson> rep = new Repository<IPerson>();
        IPerson a = fct.createPerson();
        IPerson b = fct.createPerson();
        b.setFirstName("Alexa");
        a.setFirstName("Robert");
        rep.add(a);
        rep.add(b);
        rep.sortByName();
        System.out.println(rep.get(0).getFirstName());
        System.out.println(rep.get(1).getFirstName());
        if(rep.get(0).getFirstName().equals(b.getFirstName())){
            System.out.println("sortByName is ok");
        }
        else{
            throw new TestFailedExeption("Unit test failed on function sortByName", "sortByName()");
        }
    }

    @Test
    public void searchById() throws TestFailedExeption, IOException {
        Factory fct = new Factory();
        Repository<IPerson> rep = new Repository<IPerson>();
        IPerson a = fct.createPerson();
        IPerson b = fct.createPerson();
        a.setId(12);
        b.setId(33);
        rep.add(a);
        rep.add(b);
        if(rep.searchById(33).get(0).getId().equals(b.getId())){
            System.out.println("search is OK");
        }
        else{
            throw new TestFailedExeption("Unit test failed on function searchById", "searchById()");
        }
    }

    @Test
    public void searchByName() throws TestFailedExeption, IOException {
        Factory fct = new Factory();
        Repository<IPerson> rep = new Repository<IPerson>();
        IPerson a = fct.createPerson();
        IPerson b = fct.createPerson();
        a.setFirstName("Natali");
        b.setFirstName("Joseph");
        rep.add(a);
        rep.add(b);
        if(rep.searchByName("Joseph").get(0).getFirstName().equals(b.getFirstName())){
            System.out.println("search is OK");
        }
        else{
            throw new TestFailedExeption("Unit test failed on function searchByName", "searchByName()");
        }
    }
}