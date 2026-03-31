import java.util.LinkedHashSet;
import java.util.Scanner;

public class LexicalTwish {
	public static void main(String args[]) {
		
		
		//Create Scanner Object
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter first word");
		String str1 = sc.next().toLowerCase();
		
		System.out.println("Enter second word");
		String str2 = sc.next().toLowerCase();

		
		//Sample 1
		boolean same = true;
		
		if(str1.length()==str2.length()) {
			for(int i=0;i<str1.length();i++) {
				if(str1.charAt(i)!=str2.charAt(str1.length()-1-i)){
					same=false;
					break;
				}
			}
		}
		
		else {
			same = false;
		}
		
		System.out.println("True for Same || False for not same"+"\n "+same);
	
		//sample 2
		if(same) {
			StringBuffer st = new StringBuffer(str1);
			st.reverse();
			str1=st.toString();
		
			String str= "";
			for(int i=0;i<str1.length();i++) {
				if(str1.charAt(i)=='a' || str1.charAt(i)=='e' || str1.charAt(i)=='i' || str1.charAt(i)=='o' || str1.charAt(i)=='u' ) {
					str+='@';
				}
				else {
					str+=str1.charAt(i);
				}
			}
			System.out.println(str);
		}
		
		else {
			String combineString = (str1+str2).toUpperCase();
			int vowel = 0;
			int consonants = 0;
			
			for(int i=0;i<combineString.length();i++) {
				if(combineString.charAt(i)=='a' || combineString.charAt(i)=='e' || combineString.charAt(i)=='i' || combineString.charAt(i)=='o' || combineString.charAt(i)=='u' ) {
						vowel++;
				}
				else {
					consonants++;
				}
			}
			
			  if (vowel > consonants) {
		            LinkedHashSet<Character> vowels = new LinkedHashSet<>();

		            for (char ch : combineString.toCharArray()) {
		                if (isVowel(ch)) vowels.add(ch);
		                if (vowels.size() == 2) break;
		            }

		            vowels.forEach(System.out::print);

		        } else if (consonants > vowel) {
		            LinkedHashSet<Character> consonant = new LinkedHashSet<>();

		            for (char ch : combineString.toCharArray()) {
		                if (Character.isLetter(ch) && !isVowel(ch))
		                    consonant.add(ch);

		                if (consonant.size() == 2) break;
		            }

		            consonant.forEach(System.out::print);

		        } else {
		            System.out.println("Vowels and consonants are equal");
		        }
		    }
		}

	 static boolean isVowel(char ch) {
	        return "AEIOU".indexOf(ch) != -1;
	    }
		

	}

