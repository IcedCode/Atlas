package net.avicus.atlas.xml.transformers;

import org.simpleframework.xml.transform.Transform;

public class TransformException extends Exception {

    public TransformException(Transform transform, String input) {
        super(transform.getClass().getSimpleName() + " could not parse: \"" + input + "\"");
    }

}
