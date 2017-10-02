package Messaging;

import javax.swing.JOptionPane;

/**
 *
 * @author Brandon
 */
public class QuizGUIMessageInputSource implements MessageInputSource{
    private static final String DEFAULT_QUESTION = "<No Question>";
    private String quizQuestion;
    
    public QuizGUIMessageInputSource(){
        quizQuestion = DEFAULT_QUESTION;
    }
    
    @Override
    public final String recieveMessage() {
        return JOptionPane.showInputDialog(quizQuestion);
    }
   
    public final void setQuestQuestion(String question){
        if(question == null) throw new IllegalArgumentException("Question May Not Be Null");
        quizQuestion = question;
    }
    
    public final String getQuizQuestion(){
        return quizQuestion;
    }
}
