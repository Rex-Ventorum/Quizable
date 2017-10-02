
package Messaging;

import javax.swing.JOptionPane;

public class QuizGUIMessageOutputSource implements MessageOutputSource{

    private int messageType;
    
    public QuizGUIMessageOutputSource(){
        messageType = JOptionPane.PLAIN_MESSAGE;
    }
    
    @Override
    public final void sendMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "", messageType);
    }
    
    public void setJOptionMessageType(int messageType){
        if(messageType != JOptionPane.ERROR_MESSAGE || messageType != JOptionPane.PLAIN_MESSAGE)
            throw new IllegalArgumentException("Message Type Must Be JOptionPane.ERROR_MESSAGE or JOptionPane.PLAIN_MESSAGE");
        this.messageType = messageType;
    }
   
}
