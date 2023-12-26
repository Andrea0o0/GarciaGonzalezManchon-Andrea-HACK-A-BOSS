package practicalexercises.exercise1.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import practicalexercises.exercise1.models.Student;
import practicalexercises.exercise1.persistence.exceptions.NonexistentEntityException;

public class ControllerPersistence {
    StudentJpaController studentJPA = new StudentJpaController();
    
    public void createStudent(Student stud) {
        studentJPA.create(stud);
    }
    
    public List<Student> allStudents (){
       List<Student> allstud = studentJPA.findStudentEntities();
        for (int i = 0; i< allstud.size() ;i++){
            System.out.println("Student " + (i+1) + ": " + allstud.get(i)); 
        }
        return allstud;
    }
    
    public Student findStudent(int id){
        System.out.println(studentJPA.findStudent(id));
        return studentJPA.findStudent(id);
    }     
    
    public void destroyStudents(){
        try {
            List<Student> allstud = studentJPA.findStudentEntities();
            List<Integer> indexes = new ArrayList<>();
            for (Student student : allstud) {
                indexes.add(student.getId());
            };
            for (Integer id : indexes) {
                studentJPA.destroy(id);
            }    
        } catch (NonexistentEntityException ex) {
          Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
      }
       
    }
    
    
}
