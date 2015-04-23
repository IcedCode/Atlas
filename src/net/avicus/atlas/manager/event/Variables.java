package net.avicus.atlas.manager.event;

import lombok.Getter;

import java.util.HashMap;

public class Variables {

    @Getter HashMap<String,Object> map = new HashMap<String,Object>();

    public Variables add(String var, Object object) {
        map.put(var, object);
        return this;
    }

    public Object get(String var) {
        return map.get(var);
    }

}
