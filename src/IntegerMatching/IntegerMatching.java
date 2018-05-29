package IntegerMatching;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class IntegerMatching {
	
	
	public static void printCombination(int [] arr , int num) {
		
		List<List<Integer>> li = new ArrayList<>();
		
		for(int i = 0 ; i <= arr.length - 3 ; i++) {
			int count = i+2;
			while(count <= arr.length-1) {
				List<Integer> list = new ArrayList<>();
				list.add(arr[i]);
				list.add(arr[i+1]);
				list.add(arr[count]);
				count++;
				li.add(list);
			}
		}
		
		ListIterator<List<Integer>> list=  li.listIterator();
		
		while(list.hasNext()) {
			int sum = 0;
			for(Integer n : list.next()) {
				sum += n;
			}
			if(sum != num) {
				list.remove();
			}
		}
		
		List<List> ansList = new ArrayList<>();
		
		for(List<Integer> newList : li) {
			List<Integer> intList = new ArrayList<>();
			for(Integer number : newList) {
				
				for(int i = 0 ; i < arr.length ; i++) {
					if(number == arr[i]) {
						if(intList.isEmpty()) {
							intList.add(i);
							break;
						}else if(intList != null  && !intList.contains(i)) {
							intList.add(i);
							break;
						}
						
					}
				}
				
			}
			ansList.add(intList);
		}
		System.out.println(ansList);
	}
	
	public static void main(String[] args) {
		int [] arr = {1,4,5,-6,1,7};
		int sum = 6;
		printCombination(arr, sum);
	}
	
}
