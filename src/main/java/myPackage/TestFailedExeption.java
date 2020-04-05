package myPackage;

public class TestFailedExeption extends Exception {
    private String funcName;
    public String getFuncName(){
        return funcName;
    }
    public TestFailedExeption(String message, String func){
        super(message);
        this.funcName = func;
    }
}
