package net.avicus.atlas.xml.assembler;

public class AssemblerException extends Exception {

    public AssemblerException(String message) {
        super(message);
    }

    public AssemblerException(String message, Exception e) {
        super(message, e);
    }

}
