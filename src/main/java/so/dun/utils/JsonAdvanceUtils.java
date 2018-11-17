package so.dun.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * @Author dunso
 * @Date 2018/11/17 2:09 PM
 */
public class JsonAdvanceUtils {

  /**
   * string to jsonObject
   *
   * @param jsonString the string to be parsed
   * @return the target jsonObject
   */
  public static JsonObject string2JsonObject(String jsonString) {
    JsonParser parser = new JsonParser();
    JsonObject jsonObject = parser.parse(jsonString).getAsJsonObject();
    return jsonObject;
  }

  /**
   * string to jsonArray
   *
   * @param jsonString the string to be parsed
   * @return the target jsonArray
   */
  public static JsonArray string2JsonArray(String jsonString) {
    JsonParser parser = new JsonParser();
    JsonArray jsonArray = parser.parse(jsonString).getAsJsonArray();
    return jsonArray;
  }

  /**
   * string to pojo
   *
   * @param jsonElement the json to be parsed
   * @param <T> which class to parse to
   * @return the target pojo
   */
  public static <T> T json2POJO(JsonElement jsonElement, Class<T> clazz) {
    Gson gson = new Gson();
    T pojo = gson.fromJson(jsonElement, clazz);
    return pojo;
  }
}
