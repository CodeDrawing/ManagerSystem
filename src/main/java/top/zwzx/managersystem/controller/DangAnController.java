package top.zwzx.managersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import top.zwzx.managersystem.pojo.DangAn;
import top.zwzx.managersystem.pojo.Student;
import top.zwzx.managersystem.service.IDangAnSerivce;
import top.zwzx.managersystem.service.IFileService;
import top.zwzx.managersystem.service.IStudentService;

import java.util.Date;
import java.util.List;

/**
 * @Author zx
 * @Date 2020/10/16 15:40
 */
@Controller
@RequestMapping("/dangAn")
public class DangAnController {
    @Autowired
    IStudentService iStudentService;
    @Autowired
    IDangAnSerivce iDangAnSerivce;
@Autowired
    IFileService iFileService;

    @RequestMapping("/showDangAnForStudentId/{id}")
    public String showDangAnForStudentId(@PathVariable("id") Integer id, Model model){
        Student student = iStudentService.showOneStudent(id);
        model.addAttribute("student",student);
        List<DangAn> dangAns = iDangAnSerivce.showClassRecord(id);
        model.addAttribute("classRecords",dangAns);
        List<DangAn> dangAns1 = iDangAnSerivce.showImage(id);
        model.addAttribute("imageStyles",dangAns1);
        return "crud/dangAn";
    }
    @RequestMapping("/toUpdateClassRecord/{id}")
    public String toUpdateClassRecord(@PathVariable("id") Integer id,Model model){
        DangAn dangAn = iDangAnSerivce.showOneClassRecord(id);
        model.addAttribute("dangAn",dangAn);
        List<DangAn> dangAn1 = iDangAnSerivce.showStudentOfImage(dangAn);
        model.addAttribute("imageStyles",dangAn1);
        return "crud/updateDangAn";
    }
    @RequestMapping("/updateClassRecord")
    public String updateClassRecord(DangAn dangAn){
        iDangAnSerivce.updateClassRecord(dangAn);
        return "redirect:/dangAn/showDangAnForStudentId/"+dangAn.getStudentId();
    }
    @RequestMapping("/addImage")

    public String addImage(@RequestParam("file")MultipartFile file,DangAn dangAn){
        String s = iFileService.fileUpload(file);
        dangAn.setImage(s);
        dangAn.setDateTime(new Date());
        iDangAnSerivce.addImage(dangAn);
        return "redirect:/dangAn/toUpdateClassRecord/"+dangAn.getClassRecordId();
    }
}
