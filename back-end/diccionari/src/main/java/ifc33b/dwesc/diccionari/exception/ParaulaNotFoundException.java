package ifc33b.dwesc.diccionari.exception;

public class ParaulaNotFoundException extends RuntimeException {
    public ParaulaNotFoundException(String paraula) {
        super("No se ha encontrado la palabra: " + paraula);
    }
}
