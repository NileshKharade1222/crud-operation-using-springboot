package crud.operation.student.managment.system;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class studentController {
	
	
	@Autowired
    SessionFactory sf;

    @RequestMapping("API")
    public String myName() {
        return "Nilesh";
    }

    @GetMapping("showSingleRecord/{id}")
    public student one(@PathVariable int id) {
        Session s = sf.openSession();
        student d = s.get(student.class, id);
        return d;
    }

    
    @PostMapping("insertrecords")
    public String insertData(@RequestBody List<student> list) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            for (student getsms : list) {
                session.save(getsms); 
            }
            transaction.commit();
            return "records inserted successfully";
        } catch (Exception e) {
            transaction.rollback();
            return "Error while inserting records: " + e.getMessage();
        } finally {
            session.close(); 
        }
            
    }   
    @PutMapping("updaterecords/{id}")
    public String updateData(@PathVariable String id, @RequestBody student updatedStudent) {
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            student existingStudent = session.get(student.class, id);
            if (existingStudent == null) {
                return "Student not found with ID: " + id;
            }

            existingStudent.setName(updatedStudent.getName());
            existingStudent.setLastname(updatedStudent.getLastname());
            existingStudent.setDob(updatedStudent.getDob());
            existingStudent.setGender(updatedStudent.getGender());
            existingStudent.setPhoneno(updatedStudent.getPhoneno());
            existingStudent.setEmail(updatedStudent.getEmail());

            transaction.commit();
            return "Record updated successfully";
        } catch (Exception e) {
            return "Error while updating record: " + e.getMessage();
        }
    }
    
    @DeleteMapping("deletedata/{stdid}")
    public String deleteData(@PathVariable String id) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            student sms = session.get(student.class, id);
            if (sms != null) {
               
                session.delete(sms);
                transaction.commit(); 
                return "Record deleted successfully: " + sms;
            } else {
                return "Record not found with ID: " + id;
            }
        } catch (Exception e) {
            transaction.rollback();
            return "Error while deleting record: " + e.getMessage();
        } finally {
            session.close(); 
        }
    }

}
