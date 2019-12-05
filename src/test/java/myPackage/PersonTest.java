package myPackage;

import org.junit.Test;
import ru.vsu.lab.entities.enums.Gender;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class PersonTest {
    @Test
    public void getId() {
        LocalDate p1bd = LocalDate.of(1998, 5, 3);
        int n = 10;
        Person person1 = new Person(n, "Alex", "Lololo", p1bd, Gender.MALE, new BigDecimal(20000), new Division("D"));
        person1.getId().equals(n);
    }

    @Test
    public void getFirstName() {
        Person a = new Person();
        String name = "Mitchel";
        a.setFirstName(name);
        if(a.getFirstName().equals(name)){
            System.out.println("FirstName is ok");
        }
    }

    @Test
    public void getLastName() {
        Person a = new Person();
        String name = "Jones";
        a.setLastName(name);
        if(a.getLastName().equals(name)){
            System.out.println("LastName is ok");
        }
    }

    @Test
    public void getBirthdate() {
        Person a = new Person();
        LocalDate bd = LocalDate.of(1998, 5,3);
        a.setBirthdate(bd);
        if(a.getBirthdate().equals(bd)){
            System.out.println("birthdate is Ok");
        }
    }

    @Test
    public void getGender() {
        Person a = new Person();
        Gender aG = Gender.MALE;
        a.setGender(aG);
        if(a.getGender().equals(aG)){
            System.out.println("Gender is Ok");
        }
    }

    @Test
    public void getAge() {
        Person a = new Person();
        LocalDate age = LocalDate.of(1998, 5,3);
        a.setBirthdate(age);
        if(a.getAge().equals(21)){
            System.out.println("Age is ok");
        }
    }

    @Test
    public void getSalary() {
        Person a = new Person();
        BigDecimal sal = new BigDecimal(20000);
        a.setSalary(sal);
        if(a.getSalary().equals(sal)){
            System.out.println("Salary is Ok");
        }
    }

    @Test
    public void getDivision() {
        Person a = new Person();
        Division div = new Division("D");
        a.setDivision(div);
        if(a.getDivision().getName().equals(div.getName())){
            System.out.println("Division is OK");
        }
    }
}