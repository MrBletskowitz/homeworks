package myPackage;

import ru.vsu.lab.entities.enums.Gender;

import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.entities.enums.Gender;
import ru.vsu.lab.repository.IRepository;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CSV_reader {
    public IRepository<IPerson> readCSV(String path) throws IOException {
        File f1 = new File(path);
        f1.setReadable(true);
        BufferedReader br = new BufferedReader(new FileReader(f1));
        Repository rep1 = new Repository();
        String a = new String();
        a = br.readLine();
        for (int i = 0; i < 30000; i++) {
            String aa = new String();
            aa = br.readLine();
            if (aa == null) {
                break;
            }
            int id;
            String name;
            Gender gender;
            LocalDate birthDate;
            Division division;
            BigDecimal salary;
            String[] subStr = new String[6];
            int curr = 0;
            for (int j = 0; j < 6; j++) {
                subStr[j] = "";
                for (int d = 0; d < aa.length(); d++) {
                    if (aa.charAt(curr) != ';') {
                        subStr[j] += aa.charAt(curr);
                        curr++;
                    } else {
                        curr++;
                        break;
                    }
                    if (curr == aa.length() - 1) {
                        break;
                    }
                }
            }
            id = Integer.parseInt(subStr[0]);
            name = subStr[1];
            if (subStr[2] == "Male") {
                gender = Gender.MALE;
            } else {
                gender = Gender.FEMALE;
            }
            CharSequence cs = subStr[3];
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            birthDate = LocalDate.parse(cs, dateTimeFormatter);

            division = new Division(subStr[4]);
            salary = BigDecimal.valueOf(Integer.parseInt(subStr[5]));
            Person newPers = new Person(id, name, " ", birthDate, gender, salary, division);
            rep1.add(newPers);
        }
        return rep1;
    }
}
