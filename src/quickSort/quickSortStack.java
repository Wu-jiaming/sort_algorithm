package quickSort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import com.sun.org.apache.xalan.internal.xsltc.runtime.Parameter;
import com.sun.xml.internal.ws.server.provider.ProviderInvokerTube;

import sun.awt.SunHints.Value;

public class quickSortStack {
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
	
	//用stack取代递归进行快排
	public static void quicksort(int[] arr, int startIndex, int endIndex) {
		//新建一个Stack<>,用map进栈，map保存初始index和末端index
		Stack<Map<String, Integer>> QSStack = new Stack<Map<String, Integer>>();
		//数组的起始index进栈，以hashmap
		Map rootParam = new HashMap<String, Integer>();
		rootParam.put("startIndex", startIndex);
		rootParam.put("endIndex", endIndex);
		QSStack.push(rootParam);
		//循环结束条件：栈为空
		while(!QSStack.isEmpty()){
			//栈顶元素出栈
			Map<String, Integer> param = QSStack.pop();
			//调用快排算法函数，获取基准元素的索引
			int pivot = partition(arr, param.get("startIndex"), param.get("endIndex"));
			
			//pivot左边再判断是否可以进行一轮分治
			//pivot-1是因为，pivot必须大于startIndex2位，不-1的话，只有一个数，没法比
			if(pivot-1 > param.get("startIndex")){
				//进行下一轮分治，将起始index压进stack
				Map<String, Integer> leftParam = new HashMap<String, Integer>();
				leftParam.put("startIndex", param.get("startIndex"));
				leftParam.put("endIndex", pivot-1);
				QSStack.push(leftParam);
			}
			
			//pivot右边再进行判断是否可以斤一轮分治
			if (pivot+1 < param.get("endIndex")) {
				Map<String, Integer> rightParam = new HashMap<String, Integer>();
				rightParam.put("startIndex", pivot + 1);
				rightParam.put("endIndex", param.get("endIndex"));
				QSStack.push(rightParam);
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{3,8,2,4,1,3,3,5,7,8,9,4,2,845,4,14,8,6,814,};
		quicksort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}
