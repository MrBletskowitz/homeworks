package myPackage;

import org.junit.Test;

import static org.junit.Assert.*;

public class RepositoryTest {
    @Test
    public void add() {
        Repository a = new Repository();
        Person b = new Person();
        b.setId(15);
        a.add(b);
        if(a.get(0).getId().equals(b.getId())){
            System.out.println("add is ok");
        }
    }

    @Test
    public void testAdd() {
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
        if(a.get(1).getId().equals(b.getId())){
            System.out.println("add with id is ok");
        }
    }

    @Test
    public void get() {
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
    }

    @Test
    public void set() {
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
    }

    @Test
    public void toList() {
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
    }

    @Test
    public void delete() {
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
    }

    @Test
    public void sortById() {
        Repository a = new Repository();
        Person b = new Person();
        Person c = new Person();
        b.setId(12);
        c.setId(22);
        a.add(c);
        a.add(b);
        a.sortById();
        if(a.get(0).getId().equals(b.getId())){
            System.out.println("sortById is ok");
        }
    }

    @Test
    public void sortByName() {
        Repository a = new Repository();
        Person b = new Person();
        Person c = new Person();
        b.setFirstName("Alexa");
        c.setFirstName("Robert");
        a.add(c);
        a.add(b);
        a.sortByName();
        if(a.get(0).getFirstName().equals(b.getFirstName())){
            System.out.println("sortByName is ok");
        }
    }

    @Test
    public void searchById() {

    }

    @Test
    public void searchByName() {


    }
}