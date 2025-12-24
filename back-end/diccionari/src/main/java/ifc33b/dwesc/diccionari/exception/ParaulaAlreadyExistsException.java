package ifc33b.dwesc.diccionari.exception;

public class ParaulaAlreadyExistsException extends RuntimeException {
    public ParaulaAlreadyExistsException(String paraula) {
        super("La siguiente palabra ya existe en el diccionario:" + paraula);
    }
}
