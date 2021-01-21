package top.zwzx.managersystem.service;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author zx
 * @Date 2020/10/13 16:27
 */
//插入图片
public interface IFileService {
    public String fileUpload(MultipartFile file) throws IOException;
}
