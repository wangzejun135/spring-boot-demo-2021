package start.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import start.service.MinIOService;
import start.util.FileTypeUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MinIO控制层
 */
@RequestMapping("/minio")
@RestController
public class MinIOController {

    @Autowired
    private MinIOService minIOService;

    /**
     * 上传文件
     *
     * @param file
     * @param bucketName
     * @return
     */
    @PostMapping("/upload")
    public String uploadFile(MultipartFile file, String bucketName) {
        String fileType = FileTypeUtils.getFileType(file);
        if (fileType != null) {
            return minIOService.putObject(file, bucketName, fileType);
        }
        return "不支持的文件格式。请确认格式，重新上传！！！";
    }

    /**
     * 下载文件
     *
     * @param response
     * @param bucketName
     * @param objectName
     */
    @RequestMapping("/download/{bucketName}/{objectName}")
    public void download(HttpServletResponse response, @PathVariable("bucketName") String bucketName, @PathVariable("objectName") String objectName) {
        InputStream in = null;
        try {
            in = minIOService.downloadObject(bucketName, objectName);
            response.setHeader("Content-Disposition", "attachment;filename="
                    + URLEncoder.encode(objectName, "UTF-8"));
            response.setCharacterEncoding("UTF-8");
            // 将字节从InputStream复制到OutputStream
            IOUtils.copy(in, response.getOutputStream());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 新增桶(文件夹)
     *
     * @param bucketName
     * @return
     */
    @PostMapping("/addBucket")
    public String addBucket(@RequestParam("bucketName") String bucketName) {
        minIOService.makeBucket(bucketName);
        return "创建成功！！！";
    }

    /**
     * 获取文件列表
     *
     * @param bucketName
     * @return
     */
    @GetMapping("/show/{bucketName}")
    public List<String> show(@PathVariable String bucketName) {
        return minIOService.listObjectNames(bucketName);
    }

    /**
     * 获取桶列表
     *
     * @return
     */
    @GetMapping("/showBucketName")
    public List<String> showBucketName() {
        return minIOService.listBucketName();
    }

    @GetMapping("/showListObjectNameAndDownloadUrl/{bucketName}")
    public Map<String, String> showListObjectNameAndDownloadUrl(@PathVariable String bucketName) {
        Map<String, String> map = new HashMap<>();
        List<String> listObjectNames = minIOService.listObjectNames(bucketName);
        String url = "http://localhost:8080/SpringBoot/minio/download/" + bucketName + "/";
        listObjectNames.forEach(System.out::println);
        for (int i = 0; i < listObjectNames.size(); i++) {
            map.put(listObjectNames.get(i), url + listObjectNames.get(i));
        }
        return map;
    }

    @DeleteMapping("/removeBucket/{bucketName}")
    public String delBucketName(@PathVariable String bucketName) {
        return minIOService.removeBucket(bucketName) == true ? "删除成功" : "删除失败";
    }

    @DeleteMapping("/removeObject/{bucketName}/{objectName}")
    public String delObject(@PathVariable("bucketName") String bucketName, @PathVariable("objectName") String objectName) {
        return minIOService.removeObject(bucketName, objectName) == true ? "删除成功" : "删除失败";
    }

    @DeleteMapping("/removeListObject/{bucketName}")
    public String delListObject(@PathVariable("bucketName") String bucketName, @RequestBody List<String> objectNameList) {
        return minIOService.removeListObject(bucketName, objectNameList) == true ? "删除成功" : "删除失败";
    }
}
