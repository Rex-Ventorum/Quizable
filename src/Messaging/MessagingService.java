package Messaging;

public class MessagingService{
    private String lastMessageRecieved;
    private String lastMessageSent;
    private MessageInputSource inputSource;
    private MessageOutputSource outputSource;
    
    public MessagingService(MessageInputSource inputSource, MessageOutputSource outputSource){
        setMessageInputSource(inputSource);
        setMessageOutputSource(outputSource);
    }
    /**
    * Receive String Message FROM MessageInputSoruce
    */
    public final String receiveMessageFromSource(){
        lastMessageRecieved = inputSource.recieveMessage();
        return lastMessageRecieved;
    }
    
    /**
     * Send Message FROM MessageInputSource TO MessageOutputSource
     */
    public final void sendMessageToSource(){
        sendMessageToSource(receiveMessageFromSource());
    }
    
    /**
    * Send Message TO MessageOutputSource
    * @param message String object sent to outputSource
    */
    public final void sendMessageToSource(String message){
        outputSource.sendMessage(message);
        lastMessageSent = message;
    }
    
    public final void setMessageInputSource(MessageInputSource inputSource){
        if(inputSource == null) throw new IllegalArgumentException("Input Source May Not Be Null!");
        this.inputSource = inputSource;
    }
    
    public final void setMessageOutputSource(MessageOutputSource outputSource){
        if(outputSource == null) throw new IllegalArgumentException("Output Source May Not Be Null!");
        this.outputSource = outputSource;
    }
    
    public final MessageOutputSource getMessageOutPutSource(){
        return outputSource;
    }
    
    public final MessageInputSource getMessageInputSource(){
        return inputSource;
    }
    
    //No Setters Needed for these they are set via send and recieve methods
    public final String getLastMessageRecieved(){return lastMessageRecieved;}
    public final String getLastMessageSent(){return lastMessageSent;}
}
