/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizable;

import java.util.LinkedList;
import java.util.Random;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Brandon
 */
public class DIPQuiz implements Quiz{
    private int[] questionOrder;
    private int index = -1;
    
    private static final String[] QUESTIONS = {
        "What Is The FIRST Rule of DIP?",
        "What Is The SECOND Rule of DIP?",
        "What Does DIP Stand For?",
        "Which is Better Abstractions or Interfaces?"
    };
    
    private static final String[] ANSWERS = {
        "High level moduels should not depend on low level moduels",
        "Abstractions should not depend on details",
        "Dependency Inversion Principle",
        "Interfaces"        
    };
    
    public DIPQuiz(){
        questionOrder = new int[QUESTIONS.length];
        Random random = new Random();
        LinkedList<Integer> numList = new LinkedList<>();
        for(int i=0; i<QUESTIONS.length; i++) numList.add(i);
        for(int i=0; i<questionOrder.length; i++) questionOrder[i] = numList.remove(random.nextInt(numList.size()));
    }
    @Override
    public final String[] getAllQuestions() {return QUESTIONS;}

    @Override
    public final String[] getAllAnswers() {return ANSWERS;}
    
    @Override
    public final int getQuestionCount() {return QUESTIONS.length;} 
   
    @Override
    public final boolean hasNextQuestion() {return (index+1 < QUESTIONS.length);}
    
    @Override
    public final String getNextQuestion() {index++; return QUESTIONS[questionOrder[index]];}
    
    @Override
    public final boolean checkAnswer(String answer) {
        String[] correctBox = ANSWERS[questionOrder[index]].toLowerCase().split("\\s+");
        String[] answerBox = answer.toLowerCase().split("\\s+");
        if(correctBox.length != answerBox.length) return false;
        
        for(int i=0; i<correctBox.length; i++){
            String correctWord = correctBox[i];
            String answerWord = answerBox[i];
            int distance = StringUtils.getLevenshteinDistance(correctWord, answerWord);
            if(distance > 6) return false;
        }
        return true;
    }
    
    public final String getCurrentAnswer(){return ANSWERS[questionOrder[index]];}
    
}
