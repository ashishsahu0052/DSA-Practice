class Solution {
    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");
        if (pattern.length() != words.length)
            return false;
        HashMap<Character, String> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char letter = pattern.charAt(i);

            if (map.containsKey(letter)) {
                if (!map.get(letter).equals(words[i])) {
                    return false;
                } else {
                    continue;
                }
            } else {
                if (map.containsValue(words[i])) {
                    return false;
                }
                map.put(letter, words[i]);
            }

        }
        return true;
    }
}