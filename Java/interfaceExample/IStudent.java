package interfaceExample;

public interface IStudent {

//    This function is a must to be overridden (implemented) in implementing class.
    String name(String name);

//    default function are already implemented hence if any logic change is needed then they can be overridden.
    default String subject(){
        return "I like Maths";
    }

//    static methods are specific to the Parent class hence can be called by class name.
    static String standard() {
        return "I'm of class 5";
    }
}
