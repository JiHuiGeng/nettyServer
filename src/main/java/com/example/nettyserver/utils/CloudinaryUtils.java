package com.example.nettyserver.utils;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.Map;

/**
 * 图片/视频云上传保存服务工具类
 *
 * @author gengjihui
 */
public class CloudinaryUtils {
  private static final Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
    "cloud_name", "da2gp9dxb",
    "api_key", "689889562369121",
    "api_secret", "PzwW3vu-_s7a-luKeqpBsebY-8E"));
  ;
  private static final String PUBLIC_ID = "public_id";


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
    return upload.get("url").toString();
  }

}
