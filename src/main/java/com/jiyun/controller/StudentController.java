package com.jiyun.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiyun.entity.Students;
import com.jiyun.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("studentb")
public class StudentController {

    @Autowired
    private StudentService studentService;

    private Logger logger = LoggerFactory.getLogger(StudentService.class);

    @GetMapping("list")
    public String showStudent(Model model, Students student, @RequestParam(defaultValue = "1")Integer pageNum
        , @RequestParam(defaultValue = "2")Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Students> slist = studentService.getAllStudent(student);
//        if (student == null){
//            student.setName("");
//        }
        PageInfo<Students> page = new PageInfo<>(slist);
        model.addAttribute("page",page);
        model.addAttribute("stu",student);
        return "list";
    }

    @RequestMapping("toadd")
    public String addStudent(){
        return "add";
    }

    //去修改页面
    @RequestMapping("edit/{sno}")
    public String editStudent(@PathVariable("sno") Integer sno,Model model){
        Students student = studentService.getStudentById(sno);
        model.addAttribute("student",student);
        return "edit";
    }

    //修改跳转
    @RequestMapping("update")
    public String updateStudent(Students student){
        studentService.editStudentBySno(student);
        return "redirect:list";
    }
    //修改跳转
    @RequestMapping("del/{sno}")
    public String delStudent(@PathVariable("sno") Integer sno){
        studentService.delStudentBySno(sno);
        return "redirect:/student/list";
    }

     //添加跳转
    @RequestMapping("add")
    public String addStudent(Students student){
        studentService.addStudentBySno(student);
        return "login";
    }

    @RequestMapping("tologin")
    public String tologin(String sno,String name,Model model){
        System.out.println(sno);
        System.out.println(name);
        return "login";
    }

    @RequestMapping("login")
    public String login(HttpSession session, String pwd, String name, Model model){
        Students studentByName = studentService.getStudentByName(name);
        if (studentByName == null){
            model.addAttribute("msg","用户名错误");
            return "login";
        }
        if (!studentByName.getPwd().equals(pwd)){
            model.addAttribute("msg","密码错误");
            return  "login";
        }
        session.setAttribute("currentUser",studentByName);
        return "redirect:list";
    }

    @RequestMapping("npe")
    public String npe(){
        Students student = null;
        System.out.println(student.getName());
        return "";
    }

    @RequestMapping("ae")
    public String ae(){
        try {
            int a = 1/0;
        }catch (Exception e){
            logger.error("======================>>>>>>>>>>AtrimeticException");

        }
        return "login";
    }

    @RequestMapping("register")
    public String register(){
        return "register";
    }

    @RequestMapping("register/valiname/{name}")
    @ResponseBody
    public String registerValiname(@PathVariable("name") String name){
        Students studentByName = studentService.getStudentByName(name);
        if (studentByName == null){
            return "yes";
        }
        return "no";
    }


}
