package interfaceExample;

/**
 * Not implemented default method
 * Output:
 * Student details:
 * Pratiksha, I like Maths, I'm of class 5
 *
 * Implemented default method
 * Output:
 * Student details:
 * Pratiksha, I like English, I'm of class 5
 */
public class Student implements IStudent {

    @Override
    public String name(String name) {
        return name;
    }

    @Override
    public String subject(){
        return "I like English";
    }
//    If you don't want to implement your own logic for default method then interface logic will be used

    public static void main(String[] args) {
        Student s = new Student();
        System.out.printf("Student details:\n%s, %s, %s" ,s.name("Pratiksha"),s.subject(), IStudent.standard());
    }

}
