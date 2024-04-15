package com.example.nettyserver.utils;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.Map;

import static com.example.nettyserver.content.Contents.*;

/**
 * 图片/视频云上传保存服务工具类
 *
 * @author gengjihui
 */
public class CloudinaryUtils {
  private static final Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
    CLOUD_NAME, CLOUD_NAME_VALUE,
    API_KEY, API_KEY_VALUE,
    API_SECRET, API_SECRET_VALUE));
  ;


  /**
   * 文件上传
   *
   * @param file 文件
   * @param name 文件命名
   * @return 返回包含文件的url
   */
  public static String upload(Object file, String name) throws IOException {
    Map upload = cloudinary.uploader().upload(file, ObjectUtils.asMap(PUBLIC_ID, name));
    if (CollectionUtils.isEmpty(upload)) {
      return null;
    }
    return upload.get(URL).toString();
  }

}
