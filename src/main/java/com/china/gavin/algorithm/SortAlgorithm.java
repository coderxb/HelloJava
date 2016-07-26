package com.china.gavin.algorithm;

public class SortAlgorithm {

	public int recusionBinarySearch(int[] array, int data, int beginIndex,
			int endIndex) {
		int midIndex = (beginIndex + endIndex) >>> 1;
		if (data < array[beginIndex] || data > array[endIndex]
				|| beginIndex > endIndex) {
			return -1;
		}
		if (data < array[midIndex]) {
			return recusionBinarySearch(array, data, beginIndex, midIndex - 1);
		} else if (data > array[midIndex]) {
			return recusionBinarySearch(array, data, midIndex + 1, endIndex);
		} else {
			return midIndex;
		}
	}

	/**
	 * @param array
	 *            int[]
	 * @param data
	 *            int
	 * @return return index value of data, if don't find it then return -1
	 */
	public int nonrecusionBinarySearch(int data, int[] dataSet) {
		int low = 0, high = dataSet.length - 1;
		if (data < dataSet[low] || data > dataSet[high] || low > high) {
			return -1;
		}
		while (low <= high) {
			int mid = (low + high) >>> 1;
			if (data < dataSet[mid]) {
				high = mid - 1;
			} else if (data > dataSet[mid]) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
