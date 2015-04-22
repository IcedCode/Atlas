package net.avicus.atlas.manager.event;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.xml.components.Condition;

import javax.annotation.Nullable;

@ToString
public abstract class Check<C extends Condition> {

    @Getter Class<C> conditionType;

    public Check(Class<C> conditionType) {
        this.conditionType = conditionType;
    }

    public abstract CheckResult check(C condition, @Nullable Object against);

}
