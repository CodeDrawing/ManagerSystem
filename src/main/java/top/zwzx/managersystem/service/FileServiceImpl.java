package top.zwzx.managersystem.service;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author zx
 * @Date 2020/10/13 16:29
 */
@Service
public class FileServiceImpl implements IFileService {
    @Override
    public String fileUpload(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            System.out.println("文件为空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
//        String filePath = "\\uploadFile\\"; // 上传后的路径
        String filePath = "/Volumes/studentText/uploadFile/"; // 上传后的路径
//        String filePath = request.getSession().getServletContext().getRealPath("F://代码//ManagerSystem//src//main//resources//static//uploadFiles//");
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
//            压缩图片
            Thumbnails.of(dest)
                    .scale(1f)
                    .outputQuality(0.25f)
                    .outputFormat("jpg")
                    .toFile(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
//返回一个路径
        return "/studentText/uploadFile/"+ fileName;
    }
}
