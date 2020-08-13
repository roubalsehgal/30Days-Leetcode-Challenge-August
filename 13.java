class CombinationIterator {
	List<String> list;
	int index = 0;
	public CombinationIterator(String characters, int combinationLength) {
		list = new ArrayList<>();
		generateSeq(characters, "", 0, 0, combinationLength);
		Collections.sort(list);
	}
	void generateSeq(String characters, String current, int iterIndex, int count, int cLen) {
		if (count == cLen) {
			String newStr = new String(current);
			list.add(newStr);
			return;
		}
		if (iterIndex == characters.length()) {
			return;
		}
		generateSeq(characters, current + characters.charAt(iterIndex), iterIndex + 1, count + 1, cLen);
		generateSeq(characters, current, iterIndex + 1, count, cLen);
	}

	public String next() {
		String res = list.get(index);
		index++;
		return res;
	}

	public boolean hasNext() {
		if (index == list.size()) {
			return false;
		}
		return true;
	}
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */