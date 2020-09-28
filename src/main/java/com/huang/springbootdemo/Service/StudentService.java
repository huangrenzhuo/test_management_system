package com.huang.springbootdemo.Service;
import com.huang.springbootdemo.Mapper.StudentMapper;
import com.huang.springbootdemo.domain.Student;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentService {
    @Resource
    StudentMapper studentMapper;

   public List<Student> findAllStudent()
   {
       return studentMapper.findALL();

   }

   public void deleteById(String id)
   {
       studentMapper.deleteById(id);
   }
    public void update(Student student)
    {
       studentMapper.updateStudent(student);
    }
    public void insert(Student student)
    {

        studentMapper.insertStudent(student);

    }

}
