package com.itbaizhan.paymentdemo.utils;


import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
/**
 * @version v1.0
 * @author OldGj 2024/04/18
 * @apiNote HttpUtils 将请求参数转换为JSON字符串工具类
 */
public class HttpUtils {
  /**
   * 将通知参数转化为字符串
   */
  public static String readData(HttpServletRequest request) {
    BufferedReader br = null;
    try {
      StringBuilder result = new StringBuilder();
      br = request.getReader();
      for (String line; (line = br.readLine()) != null; ) {
        if (result.length() > 0) {
          result.append("\n");
         }
        result.append(line);
       }
      return result.toString();
     } catch (IOException e) {
      throw new RuntimeException(e);
     } finally {
      if (br != null) {
        try {
          br.close();
         } catch (IOException e) {
          e.printStackTrace();
         }
       }
     }
   }
}
