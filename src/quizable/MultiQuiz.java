package quizable;

import java.util.LinkedList;
import java.util.Random;
import org.apache.commons.lang3.StringUtils;

public class MultiQuiz implements Quiz{
    private int[] questionOrder;
    private int index = -1;
    private String[] allQuestions;
    private String[] allAnswers;
    public MultiQuiz(Quiz... quizs){
        LinkedList<String> questionList = new LinkedList<>();
        LinkedList<String> answerList = new LinkedList<>();
        for(Quiz quiz : quizs){
            while(quiz.hasNextQuestion()){
                questionList.add(quiz.getNextQuestion());
                answerList.add(quiz.getCurrentAnswer());
            }
        }
        allQuestions = questionList.toArray(new String[0]);
        allAnswers = answerList.toArray(new String[0]);
        
        questionOrder = new int[allQuestions.length];
        Random random = new Random();
        LinkedList<Integer> numList = new LinkedList<>();
        for(int i=0; i<allQuestions.length; i++) numList.add(i);
        for(int i=0; i<questionOrder.length; i++) questionOrder[i] = numList.remove(random.nextInt(numList.size()));
    }
    @Override
    public final String[] getAllQuestions() {return allQuestions;}

    @Override
    public final String[] getAllAnswers() {return allAnswers;}
    
    @Override
    public final int getQuestionCount() {return allQuestions.length;} 
   
    @Override
    public final boolean hasNextQuestion() {return (index+1 < allQuestions.length);}
    
    @Override
    public final String getNextQuestion() {index++; return allQuestions[questionOrder[index]];}
    
    @Override
    public final boolean checkAnswer(String answer) {
        String[] correctBox = allAnswers[questionOrder[index]].toLowerCase().split("\\s+");
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
    
    public final String getCurrentAnswer(){return allAnswers[questionOrder[index]];}
}
