package com.huang.springbootdemo.Controller;
import com.huang.springbootdemo.Service.StudentService;
import com.huang.springbootdemo.domain.Student;
import com.huang.springbootdemo.Mapper.StudentMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
public class Controller {
   @Resource
    StudentService studentService;
@RequestMapping("/findAll")
    public List<Student> back()
{
     return studentService.findAllStudent();

}

@RequestMapping("/deleteById")
    public void deleteById(String id)
{
    studentService.deleteById(id);
}

@RequestMapping("/update")
    public void update(Student student)
{
   studentService.update(student);


}

@RequestMapping("/insert")
    public void insert(Student student)
{
    studentService.insert(student);


}
}
