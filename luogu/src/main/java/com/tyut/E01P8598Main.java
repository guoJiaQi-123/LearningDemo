package com.tyut;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author OldGj 2024/03/19
 * @version v1.0
 * @apiNote P8598 [蓝桥杯 2013 省 AB] 错误票据
 */
public class E01P8598Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = scan.nextLine();
            for (String s : str.split(" ")) {
                list.add(Integer.parseInt(s));
            }
        }
        int[] nums = list.stream()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();

//        Integer[] nums = new Integer[list.size()];
//        nums = list.toArray(nums);
//        Arrays.sort(nums);
        int m = 0;
        int c = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i + 1] - nums[i] > 1) {
                m = nums[i] + 1;
            }
            if (nums[i] == nums[i + 1]) {
                c = nums[i];
            }
            if (m * c > 0) {
                System.out.println(m + " " + c);
                break;
            }
        }
        scan.close();
    }
}
