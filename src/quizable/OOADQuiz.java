package quizable;

import java.util.LinkedList;
import java.util.Random;
import org.apache.commons.lang3.StringUtils;

public class OOADQuiz implements Quiz{

    private int[] questionOrder;
    private int index = -1;
    
    private static final String[] QUESTIONS = {
        "What is Generic Analysis?",
        "What is Generic Design?",
        "What is Object-Oriented Analysis?",
        "What is Object-Oriented Design?",
        "What is the most important OOP Skill?"
    };
    
    private static final String[] ANSWERS = {
        "Identifying the problem and its requirements",
        "Finding a conceptual solution to the problem",
        "Finding the conceptual objects in the problem domain",
        "Skillfuly assigning responsibilities to objects",
        "Skillfuly assigning responsibilities to objects"
    };
    
    public OOADQuiz(){
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
