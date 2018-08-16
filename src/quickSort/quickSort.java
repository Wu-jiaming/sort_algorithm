package quickSort;

import java.util.Arrays;

public class quickSort {
	//第一轮分区交换数据
	private static int  partition(int[] arr, int startIndex, int endIndex){
		int pivot = arr[startIndex];
		int left = startIndex;
		int right = endIndex;
		
		while(left != right){
			//arr[right]>=pivot基准元素时，左移一位
			while(left < right && arr[right] >= pivot){
				right--;
			}
			//arr[left]<=pivot基准元素时，右移一位			
			while(left < right && arr[left] <= pivot){
				left++;
			}
			//交换位置
			if(left < right){
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}

		}
		//跳出循环时，left==right,替换pivot和指针重合元素
		int temp = arr[left];
		arr[left] = arr[startIndex];
		arr[startIndex] = temp;
		return left;
	}
	
	//对数组进行多轮分区，迭代
	public static void quicksort(int[] arr, int startIndex, int endIndex) {
		//递归约束条件，startIndex>=endIndex,left和right指针重叠的时候，退出迭代
		if (startIndex >= endIndex) {
			return;
		}
		int pivotIndex = partition(arr, startIndex, endIndex);
		quicksort(arr, startIndex, pivotIndex-1);
		quicksort(arr, pivotIndex+1, endIndex);
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{3,8,2,4,1,3,3,5,7,8,9,4,2,845,4,14,8,6,814,};
		quicksort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}
