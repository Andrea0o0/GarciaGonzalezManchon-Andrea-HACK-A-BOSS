package practicalexercises.exercise1;

import practicalexercises.exercise1.models.Student;
import practicalexercises.exercise1.persistence.ControllerPersistence;


public class Exercise1 {

    public static void main(String[] args) {
        ControllerPersistence controller = new ControllerPersistence();
        Student student = new Student(
                1, 
                "Andrea",
                23, 
                10.0);
        
        // Command to reset testing:
        controller.destroyStudents();
        
        controller.createStudent(student);
        controller.allStudents();
        controller.findStudent(1);
        
    }
}
