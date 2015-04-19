package net.avicus.atlas.xml.assembler;

import net.avicus.atlas.xml.Map;

public interface Assembler {

    public void assemble(Map map) throws AssemblerException;

}
