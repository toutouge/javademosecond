package com.csdnspringmvc.controller;

import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by toutou on 2018/4/27.
 */
@Controller
public class uploadController {
    @RequestMapping(value="/lxf/upload/sc", method= RequestMethod.GET)
    public String toSC(){
        return "autohome/sc";
    }

    /** 上传目录名*/
    private static final String uploadFolderName = "uploadFiles";

    /** 允许上传的扩展名*/
    private static String [] extensionPermit = {"txt","jpg","xls","zip"};

    @RequestMapping(value = "/lxf/upload/mvc/upload", method = RequestMethod.POST)
    public @ResponseBody String fileUpload(@RequestParam("file") CommonsMultipartFile file,
                                           HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception{
        String curProjectPath = session.getServletContext().getRealPath("/");
        String saveDirectoryPath = curProjectPath + uploadFolderName;
        File saveDirectory = new File(saveDirectoryPath);
        //logger.debug("Project real path [" + saveDirectory.getAbsolutePath() + "]");

        // 判断文件是否存在

            String fileName = file.getOriginalFilename();
            String fileExtension = FilenameUtils.getExtension(fileName);
        FileUtils.copyInputStreamToFile(file.getInputStream(), new File(saveDirectoryPath,System.currentTimeMillis()+file.getOriginalFilename()));
        //logger.info("UploadController#fileUpload() end");
        return "{'status':200,'msg':'上传成功'}";

    }
}
