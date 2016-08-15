/**
 * Created by Useradmin on 2016/8/4.
 */
public class StringTest {
    public static void main(String[] args) {
        String str ="1,2,3,4,5,6";
        String[] arr = str.split(",");
        System.out.println(arr[arr.length-1]);
    }
}
