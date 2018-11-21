package so.dun.utils;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @Author dunso
 * @Date 2018/11/17 1:53 PM
 */
public class FileAdvanceUtils {

  public static String readResourceFile(String fileName) {
    try {
      Enumeration<URL> resources = getClassLoader().getResources(fileName);
      while (resources.hasMoreElements()) {
        URL url = resources.nextElement();
        String str = Resources.toString(url, Charsets.UTF_8);
        // get the specified file
        return str;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  private static ClassLoader getClassLoader() {
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    if (classLoader != null) {
      return classLoader;
    }
    return FileAdvanceUtils.class.getClassLoader();
  }

}
