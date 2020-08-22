class Solution {

	int sums[];
	Random rand = new Random();

	int arrs[][];

	public Solution(int[][] rects) {

		this.sums = new int[rects.length];
		arrs = rects;
		int sum = 0;
		for (int i = 0; i<arrs.length; i++) {
			int rect[] = arrs[i];
			sum += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
			sums[i] = sum;

		}

	}

	public int[] pick() {

		int target = rand.nextInt(sums[sums.length - 1]);

		int low = 0;
		int high = sums.length - 1;

		while (low<high) {
			int mid = low + (high - low) / 2;
			if (target<sums[mid]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}

		return pickFromRect(arrs[low]);

	}

	private int[] pickFromRect(int rect[]) {
		int left = rect[0];
		int right = rect[2];
		int top = rect[3];
		int bottom = rect[1];

		return new int[] {
			left + rand.nextInt((right - left + 1)), bottom + rand.nextInt(top - bottom + 1)
		};
	}
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */