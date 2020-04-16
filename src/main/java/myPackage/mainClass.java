/**
 * Главный класс для работы с Repository и Person
 * @Author MrBletskowitz
 * @Version 0.1
 */
package myPackage;


import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.entities.enums.Gender;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.LogManager;



public class mainClass {

public static void main(String[] args) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException, CustomInjectionExeption {
	StreamApiClass streamApiClass = new StreamApiClass();

	//streamApiClass.method1();
	/*System.out.println("-------------------");
	streamApiClass.method2();
	System.out.println("-------------------");
	streamApiClass.method3();
	 */
	Injector injector = new Injector();
	Repository<IPerson> rep = new Repository<>();

	Person a = new Person(0, "Ben", "Afflek", LocalDate.of(1998, Month.AUGUST, 1), Gender.MALE, BigDecimal.valueOf(1500), null);
	Person b = new Person(1, "Carl", "Johnson", LocalDate.of(1988, Month.SEPTEMBER, 13), Gender.MALE, BigDecimal.valueOf(2132), null);
	Person c = new Person(2, "Anna", "Karenina", LocalDate.of(1976, Month.MAY, 21), Gender.FEMALE, BigDecimal.valueOf(678), null);
	Person d = new Person(3, "Dora", "Schleiterburg", LocalDate.of(1966, Month.FEBRUARY, 2), Gender.FEMALE, BigDecimal.valueOf(3421), null);
	c.setFirstName("Lol");
	a.setFirstName("Ben");
	d.setFirstName("Mike");
	b.setFirstName("Carl");
	rep.add(c);
	rep.add(a);
	rep.add(d);
	rep.add(b);

	ClassForInject cl = new ClassForInject();
	injector.inject(cl);
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

	cl.sort(rep, comparator, 0, 0);

	System.out.println(rep.toList().get(0).getFirstName());

	JaxbParser parser = new JaxbParser();
	parser.convertObjectToXml(rep, "C:\\Users\\Msi PC\\IdeaProjects\\HW\\src\\main\\resources\\people.xml");

	Repository xmlRep = parser.fromXmlToObject("C:\\Users\\Msi PC\\IdeaProjects\\HW\\src\\main\\resources\\people.xml");
	System.out.println(xmlRep.get(0).getFirstName());
}
}
