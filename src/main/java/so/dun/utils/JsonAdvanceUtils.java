package so.dun.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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
   * Convert json to pojo
   *
   * @param jsonElement the json to be converted
   * @param clazz which class to convert to
   * @param <T> the type of the pojo
   * @return the target pojo
   */
  public static <T> T json2Pojo(JsonElement jsonElement, Class<T> clazz) {
    Gson gson = new Gson();
    T pojo = gson.fromJson(jsonElement, clazz);
    return pojo;
  }

  /**
   * Convert json String to pojo
   *
   * @param jsonStr the String to be converted
   * @param clazz which class to convert to
   * @param <T> the type of the pojo
   * @return the target pojo
   */
  public static <T> T jsonString2Pojo(String jsonStr, Class<T> clazz) {
    Gson gson = new Gson();
    T pojo = gson.fromJson(jsonStr, clazz);
    return pojo;
  }

  /**
   * Read json file and then convert the json to pojo
   *
   * @param filePath the json file path
   */
  public static <T> T jsonFile2Pojo(String filePath, Class<T> clazz) {
    Gson gson = new Gson();
    T pojo = null;
    try {
      pojo = gson.fromJson(new FileReader(filePath), clazz);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return pojo;
  }

  /**
   * Convert pojo to json
   *
   * @param pojo the pojo to be converted
   * @param <T> the type of the pojo
   * @return the converted json String
   */
  public static <T> String pojo2Json(T pojo) {
    Gson gson = new Gson();
    return gson.toJson(pojo);
  }

  /**
   * Convert pojo to json and write it to file
   *
   * @param pojo the pojo to be converted
   * @param filePath the target file to write the json to
   * @param <T> the type of the pojo
   */
  public static <T> void pojo2JsonAndWrite2File(T pojo, String filePath) {
    Gson gson = new Gson();
    try {
      gson.toJson(pojo, new FileWriter(filePath));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Convert json string array to list
   *
   * @param jsonStr the json string to be converted
   * @param <T> the type of the list specify
   * @return the target list
   */
  public static <T> List<T> jsonStringArray2List(String jsonStr) {
    Gson gson = new Gson();
    List<T> list = gson.fromJson(jsonStr, new TypeToken<List<T>>() {
    }.getType());
    return list;
  }

  /**
   * Convert json string to map
   *
   * @param jsonStr the json string to be converted
   * @param <T> the type of the list specify
   * @return the target list
   */
  public static <T> Map<String, T> json2Map(String jsonStr) {
    Gson gson = new Gson();
    Map<String, T> map = gson.fromJson(jsonStr, new TypeToken<Map<String, T>>() {
    }.getType());
    return map;
  }

}
