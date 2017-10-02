
package Messaging;

import javax.swing.JOptionPane;

public class QuizGUIMessageOutputSource implements QuizMessageOutputSource{

    private static final int CORRECT_MESSAGE_TYPE = JOptionPane.INFORMATION_MESSAGE;
    private static final int INCORRECT_MESSAGE_TYPE = JOptionPane.ERROR_MESSAGE;
    private int messageType;
    
    public QuizGUIMessageOutputSource(){
        messageType = CORRECT_MESSAGE_TYPE;
    }
    
    @Override
    public final void sendMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "", messageType);
    }
    
    @Override
    public final void setAnswerWasCorrect(boolean wasCorrect){
        if(wasCorrect) messageType = CORRECT_MESSAGE_TYPE;
        else messageType = INCORRECT_MESSAGE_TYPE;
    }
   
}
