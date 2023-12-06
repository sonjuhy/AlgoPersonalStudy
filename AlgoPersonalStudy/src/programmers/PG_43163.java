package programmers;

import java.io.*;
import java.util.*;

public class PG_43163 {
    static int wordsLen = 0, minAnswer = Integer.MAX_VALUE;
    static String targetWord;
    static List<String> wordList;
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"dot", "dog", "hot", "cog"};

        int result = solution(begin, target, words);
        System.out.println(result);
    }
    public static int solution(String begin, String target, String[] words){
        int answer = 0;
        wordList = List.of(words);
        wordsLen = words.length;
        targetWord = target;
        if(!wordList.contains(target)) return 0;

        for(int w=0;w<wordsLen;w++){
            String word = wordList.get(w);
            if(compareWords(begin, word)){
                boolean[] visited = new boolean[wordsLen];
                visited[w] = true;
                DFS(1, word, visited);
            }
        }
        if(minAnswer != Integer.MAX_VALUE) answer = minAnswer;
        return answer;
    }
    public static void DFS(int deps, String begin, boolean[] visited){
        if(begin.equals(targetWord)){
            minAnswer = Math.min(deps, minAnswer);
            return;
        }
        if(deps == wordsLen) return;

        for(int w=0;w<wordsLen;w++){
            String word = wordList.get(w);
            if(compareWords(begin, word) && !visited[w]){
                boolean[] newVisited = visited.clone();
                newVisited[w] = true;
                DFS(deps+1, word, newVisited);
            }
        }
    }
    public static boolean compareWords(String word1, String word2){
        int sameCharCount = 0, wordLen = word1.length();
        char[] word1Char = word1.toCharArray();
        char[] word2Char = word2.toCharArray();
        for(int i=0;i<wordLen;i++){
            if(word1Char[i] != word2Char[i]) sameCharCount++;
            if(sameCharCount > 1) return false;
        }
        return sameCharCount == 1;
    }
}
