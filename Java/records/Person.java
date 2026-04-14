package records;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.RecordComponent;

public record Person(String name, int age) {

    public void accessAllFields(Person p) throws InvocationTargetException, IllegalAccessException {
        RecordComponent[] components = Person.class.getRecordComponents();

        for (RecordComponent rc : components) {
            System.out.println(rc.getName() + ":" + rc.getAccessor().invoke(p));
        }
    }
}

