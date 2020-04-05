package myPackage;

import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.repository.IRepository;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiClass {
    private Repository<IPerson> rep1;
    String path = "C:\\Users\\Msi PC\\IdeaProjects\\HW\\src\\main\\resources\\persons.csv";
    List<IPerson> lab5;
    StreamApiClass() throws IOException {
        CSV_reader csv_reader = new CSV_reader();
        Repository<IPerson> rep1 = (Repository<IPerson>)csv_reader.readCSV(path);
        lab5 = new LinkedList<>();
        lab5 = Arrays.stream(rep1.getObjects()).filter((s) ->s != null && s.getAge()>30 && s.getFirstName().contains("A") && s.getSalary().intValue() > 500).collect(Collectors.toList());
    }


	public void method1() throws IOException {
        for(int i = 0; i < lab5.size(); i++){
            System.out.println(lab5.get(i).getFirstName());
        }
    }
	public void method2(){
        System.out.println(lab5.stream().anyMatch((p) -> p.getFirstName().contains("aa")));
    }
	public void method3(){
            //lab5.stream().collect(Collectors.toMap((lab5.stream().map((s) -> s.getBirthdate().getYear()).distinct()), lab5.stream().map((s) -> s.getBirthdate().getYear()).distinct().count()));
    }
}
