package top.zwzx.managersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import top.zwzx.managersystem.pojo.Student;
import top.zwzx.managersystem.service.IFileService;
import top.zwzx.managersystem.service.IStudentService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @Author zx
 * @Date 2020/10/13 10:27
 */
@Controller
public class FileController {
    @Autowired
    IFileService iFileService;
    @Autowired
    IStudentService iStudentService;
    //上传图片
    @PostMapping(value = "/fileUpload")
    public String fileUpload(@RequestParam(value = "file") MultipartFile file, Model model, HttpServletRequest request) throws IOException {
        String s = iFileService.fileUpload(file);
        model.addAttribute("file",s);
        return "11";
    }

}
