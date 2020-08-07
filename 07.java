/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
	public List<List<Integer>> verticalTraversal(TreeNode root) {
		TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
		helper(root, 0, 0, map);
		List<List<Integer>> res = new ArrayList<>();
		int index = 0;

		for (TreeMap<Integer, List<Integer>> cols: map.values()) {
			res.add(new ArrayList<>());
			for (List<Integer> rows: cols.values()) {
				Collections.sort(rows);
				for (int val: rows) res.get(index).add(val);
			}
			index++;
		}
		return res;
	}

	public void helper(TreeNode root, int index, int depth, TreeMap<Integer, TreeMap<Integer, List<Integer>>> map) {
		if (root == null) return;
		if (!map.containsKey(index)) {
			map.put(index, new TreeMap<>());
		}
		if (!map.get(index).containsKey(depth)) {
			map.get(index).put(depth, new ArrayList<>());
		}
		map.get(index).get(depth).add(root.val);

		helper(root.left, index - 1, depth + 1, map);
		helper(root.right, index + 1, depth + 1, map);
	}
}