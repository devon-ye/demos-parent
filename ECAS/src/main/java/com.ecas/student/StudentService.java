package student;

import enties.Student;

import java.util.List;

/**
 * Created by lenovo on 2017/12/9.
 */
public interface StudentService {

    Student getStudentById(long id);

    List<Student> getStudentsByIds(List<Long> ids);
}
