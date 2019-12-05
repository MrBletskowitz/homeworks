package myPackage;

import ru.vsu.lab.entities.IDivision;

public class Division implements IDivision {
    private Integer id;
    private String name;
    private static Division [] divisionArray = new Division[10];
    private static int size = 0;
    Division(String name){
        this.name = name;
    }
    Division(){

    }

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }
}
