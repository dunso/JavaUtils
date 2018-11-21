package so.dun.utils;

/**
 * Integer Advanced Tool
 *
 * @Author dunso
 */
public class IntegerAdvanceUtil {

  /**
   * Judge an int is pow of 2
   *
   * @return if val is pow of 2 return true, else false
   */
  public static boolean isPowOf2(int val) {
    return (val & -val) == val;
  }


}
