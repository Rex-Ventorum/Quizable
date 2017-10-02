package Messaging;

import javax.swing.JOptionPane;

/**
 *
 * @author Brandon
 */
public class QuizGUIMessageInputSource implements QuizMessageInputSource{
    private static final String DEFAULT_QUESTION = "<No Question>";
    private String quizQuestion;
    
    public QuizGUIMessageInputSource(){
        quizQuestion = DEFAULT_QUESTION;
    }
    
    @Override
    public final String recieveMessage() {
        return JOptionPane.showInputDialog(quizQuestion);
    }
   
    @Override
    public final void setQuizQuestion(String question){
        if(question == null) throw new IllegalArgumentException("Question May Not Be Null");
        quizQuestion = question;
    }
    
    @Override
    public final String getQuizQuestion(){
        return quizQuestion;
    }
}
