/**
 * 
 */
package com.code.leet;

/**
 * Jiaxu
 * Jun 6, 2017
 * 
 */
public class TwoSumII {

	public static void main(String[] args) {
		// TODO 
		int nums[] = new int[]{1,3,4,5,7,8,11};
		int result[] = twoSum3(nums, 11);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
	//2ms
	public int[] twoSum(int[] numbers, int target) {
		int i=0,j=numbers.length-1;
		while(i<j){
			if (numbers[i]+numbers[j]==target) {
				break;
			}else if (numbers[i]+numbers[j]>target) {
				j--;
			}else {
				i++;
			}
		}
		return new int[]{i+1,j+1};
    }
	
	//0ms
	public int[] twoSum2(int[] numbers, int target) {
		//high：寻找比target小，但是其右边比target大的坐标
	    //low：寻找比target大，但是左边比target小的坐标
	        int low = 0;
	        int high = numbers.length-1;
	        while(low < high) {
	        	if((numbers[low] + numbers[high]) > target) {
	        		int start = low+1;
	        		int end = high;
	        		while(start < end) {
	        			int mid = (start+end)/2;
	        			if((numbers[low] + numbers[mid]) > target) {
	        				end = mid-1;
	        			}else if((numbers[low] + numbers[mid]) < target) {
	        				start = mid+1;
	        			}else{
	        				end = mid;
	        				break;
	        			}
	        		}
	        		if((numbers[low] + numbers[end]) > target) end--;
	        		high = end;
	        	}else if((numbers[low] + numbers[high]) < target) {
	        		int start = low;
	        		int end = high-1;
	        		while(start < end) {
	        			int mid = (start+end)/2;
	        			if((numbers[high] + numbers[mid]) > target) {
	        				end = mid-1;
	        			}else if((numbers[high] + numbers[mid]) < target) {
	        				start = mid+1;
	        			}else{
	        				end = mid;
	        				break;
	        			}
	        		}
	        		if((numbers[end] + numbers[high]) < target) end++;
	        		low = end;
	        	}else{
	        		break;
	        	}
	        }
	        return new int[]{low+1, high+1};
	    }
	
	//0ms
		public static int[] twoSum3(int[] numbers, int target) {
			int i=0,j=numbers.length-1;
			while(numbers[i]+numbers[j]!=target){
				if (numbers[i]+numbers[j]>target) {
					int l = i+1,r=j;
					while(l<r){
						int  m=(l+r)/2;
						if(numbers[i]+numbers[m]>target){
							r=m;
						}else if (numbers[i]+numbers[m]<target) {
							l=m+1;
						}else {
							break;
						}
					}
					j=r-1;
				}else {
					int l = i,r=j-1;
					while(l<r){
						int  m=(l+r+1)/2;
						if(numbers[j]+numbers[m]>target){
							r=m-1;
						}else if (numbers[j]+numbers[m]<target) {
							l=m;
						}else {
							break;
						}
					}
					i=l+1;
				}
			}
			return new int[]{i+1,j+1};
	    }
}
