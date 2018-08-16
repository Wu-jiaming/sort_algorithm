package quickSort;

import java.util.Arrays;

public class quickSort {
	//��һ�ַ�����������
	private static int  partition(int[] arr, int startIndex, int endIndex){
		int pivot = arr[startIndex];
		int left = startIndex;
		int right = endIndex;
		
		while(left != right){
			//arr[right]>=pivot��׼Ԫ��ʱ������һλ
			while(left < right && arr[right] >= pivot){
				right--;
			}
			//arr[left]<=pivot��׼Ԫ��ʱ������һλ			
			while(left < right && arr[left] <= pivot){
				left++;
			}
			//����λ��
			if(left < right){
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}

		}
		//����ѭ��ʱ��left==right,�滻pivot��ָ���غ�Ԫ��
		int temp = arr[left];
		arr[left] = arr[startIndex];
		arr[startIndex] = temp;
		return left;
	}
	
	//��������ж��ַ���������
	public static void quicksort(int[] arr, int startIndex, int endIndex) {
		//�ݹ�Լ��������startIndex>=endIndex,left��rightָ���ص���ʱ���˳�����
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
