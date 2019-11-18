public class CountVowelsConsonants {

  public static void main(String[] args) {

    String input = "I am happy";
   int vowels =0;
   int consonants = 0;
   input = input.toLowerCase();
    for (char c : input.toCharArray()){
      if(c == 97 || c ==101 || c ==105 || c ==111 ||c ==117 || c== 121){
        vowels++;
      }else if(c >97 && c<123){
        consonants++;
      }
    }

    System.out.println("Vowels: " + vowels + " , Consonants: " + consonants);
  }
}