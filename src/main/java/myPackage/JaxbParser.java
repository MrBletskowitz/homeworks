package myPackage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class JaxbParser {
    public Repository fromXmlToObject(String filePath) {
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(CustomXmlType.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            List<Person> people =  ((CustomXmlType)un.unmarshal(new File(filePath))).getPeople();
            Repository rep = new Repository();
            Iterator<Person> iterator = people.iterator();
            Person cashe;
            while(iterator.hasNext()){
                cashe = iterator.next();
                rep.add(cashe);
            }
            return rep;
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // сохраняем объект в XML файл
    public void convertObjectToXml(Repository rep, String filePath) {
        try {
            CustomXmlType list = new CustomXmlType();
            list.setPeople(rep.toList());
            JAXBContext context = JAXBContext.newInstance(CustomXmlType.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // маршаллинг объекта в файл
            marshaller.marshal(list, new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
