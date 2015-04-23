package net.avicus.atlas.manager.event;

import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;

@ToString
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
