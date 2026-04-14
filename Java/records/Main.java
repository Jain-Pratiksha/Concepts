package records;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Person p = new Person("John", 25);

        System.out.println(p.name());
        System.out.println(p.age());
        p.accessAllFields(p);
    }
}
