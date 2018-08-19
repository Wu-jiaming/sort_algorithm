package quickSort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import com.sun.org.apache.xalan.internal.xsltc.runtime.Parameter;
import com.sun.xml.internal.ws.server.provider.ProviderInvokerTube;

import sun.awt.SunHints.Value;

public class quickSortStack {
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
	
	//��stackȡ���ݹ���п���
	public static void quicksort(int[] arr, int startIndex, int endIndex) {
		//�½�һ��Stack<>,��map��ջ��map�����ʼindex��ĩ��index
		Stack<Map<String, Integer>> QSStack = new Stack<Map<String, Integer>>();
		//�������ʼindex��ջ����hashmap
		Map rootParam = new HashMap<String, Integer>();
		rootParam.put("startIndex", startIndex);
		rootParam.put("endIndex", endIndex);
		QSStack.push(rootParam);
		//ѭ������������ջΪ��
		while(!QSStack.isEmpty()){
			//ջ��Ԫ�س�ջ
			Map<String, Integer> param = QSStack.pop();
			//���ÿ����㷨��������ȡ��׼Ԫ�ص�����
			int pivot = partition(arr, param.get("startIndex"), param.get("endIndex"));
			
			//pivot������ж��Ƿ���Խ���һ�ַ���
			//pivot-1����Ϊ��pivot�������startIndex2λ����-1�Ļ���ֻ��һ������û����
			if(pivot-1 > param.get("startIndex")){
				//������һ�ַ��Σ�����ʼindexѹ��stack
				Map<String, Integer> leftParam = new HashMap<String, Integer>();
				leftParam.put("startIndex", param.get("startIndex"));
				leftParam.put("endIndex", pivot-1);
				QSStack.push(leftParam);
			}
			
			//pivot�ұ��ٽ����ж��Ƿ���Խ�һ�ַ���
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
