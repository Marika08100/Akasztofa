package hu.progamtic.gallows.service;

import model.Word;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GallowsService {
    // List<Word> words = new ArrayList<>();
    private String result = "kecske";
    private int counter = 10;

    private char[] wordsToArray;
    private Set<Character> usedCharacters;
    private char character;


    public GallowsService() {
        this.wordsToArray = new char[result.length()];
        Arrays.fill(wordsToArray, '_');
        this.usedCharacters = new HashSet<>();
    }

    public boolean isContain(char character) {
        for (int i = 0; i < result.length(); i++) {
            if (character == result.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    public char[] charFinder(char character) {
        if(isContain(character)) {
            for (int i = 0; i < result.length(); i++) {
                if (character == result.charAt(i)) {
                    wordsToArray[i] = character;
                }
            }
        } else {
            this.usedCharacters.add(character);
            this.counter--;
        }
        return wordsToArray;
    }
    public boolean win() {
        for (int i = 0; i < this.wordsToArray.length; i++) {
            if (this.wordsToArray[i] != this.result.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public char[] getWordsToArray() {
        return wordsToArray;
    }

    public void setWordsToArray(char[] wordsToArray) {
        this.wordsToArray = wordsToArray;
    }

    public Set<Character> getUsedCharacters() {
        return usedCharacters;
    }

    public void setUsedCharacters(Set<Character> usedCharacters) {
        this.usedCharacters = usedCharacters;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }
}

