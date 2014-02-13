/**
 * 
 */
package util;

import java.util.Arrays;

/**
 * @author 司明仑 --2014-1-19
 *
 */
public class SortDemo {
	/**
	 * 它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
	 * @param args
	 * @return
	 */
	public static int[] bubbleSort(int[] args) {//冒泡排序算法
		for (int i = 0; i < args.length - 1; i++) {
			System.out.println("=============================================");
			System.out.println("当前循环开始索引指向：" + i + ";值是：" + args[i]);
			for (int j = i + 1; j < args.length; j++) {
				if (args[i] > args[j]) {
					int temp = args[i];
					args[i] = args[j];
					args[j] = temp;
				}
				System.out.println("             外循环[" + i + "]内循环[" + j + "]"
						+ i + "数组为：" + Arrays.toString(args));
			}
			System.out.println("第" + i + "次循环后数组为：" + Arrays.toString(args));
		}
		return args;
	}

	/**
	 * 每一趟从待排序的数据元素中选出最小（或最大）的一个元素，顺序放在已排好序的数列的最后，直到全部待排序的数据元素排完。 选择排序是不稳定的排序方法。
	 * @param args
	 * @return
	 */
	public static int[] selectSort(int[] args) {//选择排序算法
		for (int i = 0; i < args.length - 1; i++) {
			int min = i;
			System.out.println("=============================================");
			System.out.println("当前MIN指向：" + min + ";值是：" + args[min]);
			for (int j = i + 1; j < args.length; j++) {
				if (args[min] > args[j]) {
					min = j;
				}
			}
			System.out.println("索引[" + i + "]" + "循环后MIN指向：" + min + ";值是："
					+ args[min]);
			if (min != i) {
				int temp = args[i];
				args[i] = args[min];
				args[min] = temp;
			}
			System.out.println("索引[" + i + "]" + "循环后数组为："
					+ Arrays.toString(args));
		}
		return args;
	}

	public static int[] insertSort(int[] args) {//插入排序算法
		for (int i = 1; i < args.length; i++) {
			for (int j = i; j > 0; j--) {
				if (args[j] < args[j - 1]) {
					int temp = args[j - 1];
					args[j - 1] = args[j];
					args[j] = temp;
				} else {
					break;
				}
			}
		}
		return args;
	}

	public static void main(String[] args) {
		System.err.println("\r***************选择排序运行过程是***************\r");
		int[] as = { 8, 7, 9, 14, 4, 2, 10 };
		SortDemo.selectSort(as);
		System.err.println("\r***************冒泡排序运行过程是***************\r");
		int[] as2 = { 8, 7, 9, 14, 4, 2, 10 };
		SortDemo.bubbleSort(as2);
	}
}
