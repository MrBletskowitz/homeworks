package myPackage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

public class Injector {
    public <T> void inject(T object) throws CustomInjectionExeption, IOException {
        T insObj = null;
        try {
            Class<?> objectClass = object.getClass();
            Field[] fields = objectClass.getFields();
            for(Field field : fields){
                if (field.isAnnotationPresent(LabInject.class)) {
                    field.setAccessible(true);
                    Class clazz = Class.forName(nameFromFile(field.getType().getName()));
                    insObj = (T) clazz.newInstance();
                    field.set(object, insObj);
                }
            }
        } catch (ClassNotFoundException | FileNotFoundException e) {
            throw new CustomInjectionExeption(e);
        } catch (IllegalAccessException e) {
            throw new CustomInjectionExeption(e);
        } catch (InstantiationException e) {
            throw new CustomInjectionExeption(e);
        }

    }

    String nameFromFile(String name) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Msi PC\\IdeaProjects\\HW\\src\\main\\java\\myPackage\\ForAnnotation.txt"));
        Map<String, String> fromTo = new HashMap<>();
        String line = ".";
        while(line != null){
            line = reader.readLine();
            if (line != null) {
                String[] names = line.split(" = ");
                fromTo.put(names[0], names[1]);
            }
        }
        if(fromTo.containsKey(name)){
            return fromTo.get(name);
        }
        else{
            return name;
        }
    }
}
