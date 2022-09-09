/**
 * @author Elifse
 * @Description
 * @Create 2022/6/2
 **/
public class test {

    public static void main(String[] args) {
        // 冒泡排序
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("冒泡排序");
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int j : arr) {
            System.out.print(j + " ");
        }

    }
}
