package com.huang.springbootdemo.Controller;
import com.huang.springbootdemo.Service.StudentService;
import com.huang.springbootdemo.domain.Student;
import com.huang.springbootdemo.Mapper.StudentMapper;
import com.huang.springbootdemo.utils.JWTUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @RequestMapping("/login")
    public Map<String,Object> login(String id, String name)
     {
         Map<String,Object>map=new HashMap<>();
         try {
         Map<String,Object>payload=new HashMap<>();
         payload.put("id",id);
         payload.put("name",name);
         String token=JWTUtils.getToken(payload);
         System.out.println(token);
         map.put("message","认证成功");
          }catch (Exception e){
             map.put("message",false);
          }
        return map;
     }

     @RequestMapping("/test")
      public Map<String,Object> test()
      {
          Map<String,Object>map=new HashMap<>();
          map.put("message","成功");
          return map;
      }


}
