package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sound.midi.Soundbank;

import interview.top100.IsPalindrome_9;
import interview.top100.LetterCombinations_17;
import interview.top100.Trap_42;

public class mainApplication {
    public static void main(String[] args) {
        IsPalindrome_9 isPalindrome_9 = new IsPalindrome_9();
        Trap_42 trap_42 = new Trap_42();
//        int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
//        int height[] = {4,2,0,3,2,5};
//        System.out.println(trap_42.trap_2(height));
//      int height[] = {4,2,0,3,2,5};
//        List<Character> list = new ArrayList<Character>();
        
//        list.add('a');
//        list.add('b');
//        list.add('c');
//        list.add('e');
//        StringBuilder sb = new StringBuilder();
//        sb.append('a');
//        sb.append('c');
//   	 	System.out.println(sb.toString());
        
        LetterCombinations_17 letterCombinations_17 = new LetterCombinations_17();
        String string = "";
//        System.out.println(string.charAt(2));
        List<String> list = letterCombinations_17.letterCombinations(string);
        System.out.println(list);

    }
}

