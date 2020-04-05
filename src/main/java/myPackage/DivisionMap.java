package myPackage;

import ru.vsu.lab.entities.IDivision;

import java.util.HashMap;
import java.util.Map;

public class DivisionMap {
    private  Map<String, IDivision> divisions = new HashMap<>();
    public void addDivision(IDivision division){
        divisions.put(division.getName(), division);
    }

    public IDivision checkDivision(String name){
        if(divisions.containsKey(name)){
            return divisions.get(name);
        }
        else{
            IDivision div = new Division();
            div.setName(name);
            addDivision(div);
            return div;
        }
    }

}
