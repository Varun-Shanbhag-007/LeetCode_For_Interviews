/*Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.

 

Example:

Input: 
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation: 
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"), 
and that "hit" isn't the answer even though it occurs more because it is banned.
 

Note:

1 <= paragraph.length <= 1000.
0 <= banned.length <= 100.
1 <= banned[i].length <= 10.
The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
There are no hyphens or hyphenated words.
Words only consist of letters, never apostrophes or other punctuation symbols.*/

class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        paragraph=paragraph.replace(","," ");
		paragraph=paragraph.replace("!"," ");
	    paragraph=paragraph.replace("?"," ");
	    paragraph=paragraph.replace("'"," ");
	    paragraph=paragraph.replace(";"," ");
	    paragraph=paragraph.replace("."," ");
        
        String[] words  = paragraph.split(" ");

	    HashMap<String,Integer> m = new HashMap<>();

	    for(String word : words){
		word = word.trim();

		if(word.isEmpty()){
			continue;
		}
		if(m.containsKey(word.toLowerCase())){
			m.put(word.toLowerCase(),m.get(word.toLowerCase())+1);
		}
		else{
			m.put(word.toLowerCase(),1);
		}
	}
		for(String ban : banned){
			m.remove(ban.toLowerCase());
		}
		int high =0;
		String val ="";
		for(Map.Entry<String,Integer> e :m.entrySet()){
			if(e.getValue() > high){
				high=e.getValue();
				val = e.getKey();
			}
		}

		return val;
        
    }
}