/**
 * 
 */
package com.code.leet;

/**
 * Jiaxu
 * Aug 30, 2016
 * 
 */
public class FindTheDifference {

	public static void main(String[] args) {
		// TODO 
		FindTheDifference findTheDifference = new FindTheDifference();
		String s = "shvebczgpvovlofgnkerphjyvzpwvwpnoolxeowklvcklqggkaqzwpkzkprlrzbxtswcuwebojczilbzqovzekcycbjrlxpyehqjzobswtnuhhiqaivfyoeilgvwxhycxfkoaysofjefplatpohkgmpxunxbaoxdkgzpxjyqqvdcvkgdveollsaguuvdnelcuapicgzplckfirmlweeycualzzsvkxdsfjclhnokhanmoqwzdhjxdjdyjznggafgcnfihughjdvlstuwdsshvurolkrfjvffrrvklgggmnppnhgqeyjuhyshyhmoxuqebhpyyjmiqobajvyebiiczmoxcilatandzbewccthfbemaayctrnsfycgbdxqcedapgxwtjqgyahoycutbnhuljtvkgwlmyejguuemsoqxzcbpbempxxeqsznejtiyoqolcmnfmuvrtiqfhgvpoajgagazsneplvmpitgugfnehppyaqqeaieymusfbzbermaafmdyhwylzzmxfllsrihqufabzvyrndwiuuovgjinhfivvrmsoxvuqefzwqqtfbfhnhrnnsyfujcwiseeiqakklrdejjfrtzssikdnfudwobyqljwijjvvbufnnmvjkjiamrsnucermhzxfnyzxeoflwbmdraidcgvkjvidqblxmkffrrsseccxolpflknenldwsnmuwtndwbcihzdrhvorjbffxenrflkblghzpzxfqsswgolqfhyusrhzbuuodledysbieptjewyyjhqypyynbiincpcizextkqqbwyswqnphxrrbxehzourxlcxkwbfjidhgghsfttgispyrskwwlwpqrsxfkvxkdlkekcmwrvqwznwqkdmfvkflpkbnjnfvmhkjqjmkoeqgyjswvhsyefsnmhykvhexogxfklaoawmnlmnjgoeosqteakpqyltvqpisaktvafyfurkduwcht";
		String t ="eybpzmzdkyhtuxqyttosknolzfjdbyckipwvzuhhsrpuwkglnugfjuturwpkvealqjiqknkbwhnbeloqfxrsgffcqjeseeoxizkrcdbqwwxcqpsfreggqgyhbwsyafsdiuulrsffrrvqhkdrvmkzecwmscaphhywadsiysemeweervioomhbopetjjgugvvnhrwomdkjwooghcestgyiqrlketzxyvsajzvfqnttudneydfianydlqdwbdwccgqqqflaxejaarnpeewkhdbkjvrpncfospnnjgqnecsztrhvrpilpynogvtwswhfsfmyjsqwahzbojuwufzxaidlbolfmdkwnjedasjeqcywncbejysmtmnqfmaxbxqgcyyfdducmptprwkhrslmsfkmhihmeuarccocixhhjvovfmgmhvhfaijklzwomebjhikihyxerfispgmoqcdvmliluxwzedypmpqsxaisnxnnxulajchvsklyfforvqtjonecihiwpupobznlfeuagmdlckoevaxlvhnomamhwehkzgaakrnpvfmkjquocbycxypgychfhcltowiboivphclzncoxsydwjxojvxskggsxwrudsvnlrfilvjpadrlkuneqxkebnzgfzeyhpzejdyqlvegygnxbzxskplgdyrflwjbbelntodjlkgeqawistgrlbfdjpozkrjyvypbboapglaudvqxiuyanaxrpilmfveeuuekwvhkpholgflbkcxsfwpluaokhchyvuhtyzyvbfyircfltjguqguwimqyzhenveqmjnytmecnnqjoflkszylofxnbqvkorvbfzbxiqmtztsfzwegswqnkhbgxfiyklqkelfzgclbaqbvsvvakdzvzomgzlzrhtzfykiwauhfpysxxqgeapuxpjjkirjpfxvycnxibctufofnvjfhelmgqhwrvnbsnnsuzjjoqgiuazl";
		long start1 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			char ch = findTheDifference.findTheDifference(s, t);
		}
		long end1 = System.currentTimeMillis();
		System.out.println(end1-start1);
		long start2 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			char ch2 = findTheDifference.findTheDifference4(s, t);
		}
		long end2 = System.currentTimeMillis();
		System.out.println(end2-start2);
//		System.out.println(ch);
	}
	
	//7ms
	public char findTheDifference(String s, String t) {
        int result = 0;
        for(int i=0;i<s.length();i++){
        	result += t.charAt(i) - s.charAt(i);
        }
        result += t.charAt(t.length()-1);
        return (char)result;
        
    }
	//7ms
	public char findTheDifference3(String s, String t) {
		int result = 0;
		for(int i=0;i<s.length();i++){
			result ^= t.charAt(i)^s.charAt(i);
		}
		result ^= t.charAt(t.length()-1);
		return (char)result;
		
	}
	//7ms
	public char findTheDifference5(String s, String t) {
		int result = 0;
		for (char c : s.toCharArray()) {
			result ^= c;
		}
		for (char c : t.toCharArray()) {
			result ^= c;
		}
		return (char)result;
		
	}
	//9ms
	public char findTheDifference2(String s, String t) {
		int[] index1 = new int[26];
		int[] index2 = new int[26];
		
		for(int i=0;i<s.length();i++){
		     index1[s.charAt(i)-97]++;
		}
		for(int j=0;j<t.length();j++){
	          index2[t.charAt(j)-97]++;
		}
		for(int k=0;k<index1.length;k++){
		     if(index1[k]!=index2[k]){
			 return (char)(k+97);
		     }
		}
	 
	 return '0';
	}
	
	//7ms
	public char findTheDifference4(String s, String t) {
	       int [] charMap = new int[256];
	        for (char c : s.toCharArray()) {
	            charMap[c] ^= c;
	        }
	        for (char c : t.toCharArray()) {
	            charMap[c] ^= c;
	        }
	        for (int i = 0; i < 256; i++) {
	            if (charMap[i] != 0) {
	                return (char) i;
	            }
	        }
	        return '-';
	    }
}
