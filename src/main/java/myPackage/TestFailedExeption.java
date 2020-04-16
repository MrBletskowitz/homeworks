package myPackage;

import java.util.logging.Logger;

public class TestFailedExeption extends Exception {
    Logger logger = Logger.getLogger(TestFailedExeption.class.getName());
    private String funcName;
    public String getFuncName(){
        return funcName;
    }
    public TestFailedExeption(String message, String func){
        super(message);
        this.funcName = func;

    }
}
