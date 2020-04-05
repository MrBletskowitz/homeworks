package myPackage;

public class CustomInjectionExeption extends Exception {
    CustomInjectionExeption(String message){
        super(message);
    }
    CustomInjectionExeption(Throwable excCause){
        super(excCause);
    }
    CustomInjectionExeption(Throwable excCause, String message){
        super(message, excCause);
    }
}
