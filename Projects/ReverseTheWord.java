package Projects;

public class ReverseTheWord {
    public static void main(String[] args) {
        ReverseTheWord sentence = new ReverseTheWord();
        sentence.wordReverse("My name is saravana");
    
    }
    //1. Write a program to reverse the words in a string 

    public void wordReverse(String sentence){
        String reversedWords="";
        String word="";

        for(int i=0;i<=sentence.length();i++){
            if(sentence.length() == i || Character.isWhitespace(sentence.charAt(i))){
                for (int j=word.length()-1;j>=0;j--){
                    reversedWords+=word.charAt(j);
                }
                reversedWords+=" ";
                word ="";
            }
            else{
                word += sentence.charAt(i);
            }
        }
        System.out.println(reversedWords);
    }
}