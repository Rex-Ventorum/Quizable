package Messaging;

/**
 *
 * @author Brandon
 */
public interface QuizMessageInputSource extends MessageInputSource{
    public abstract void setQuizQuestion(String question);
    public abstract String getQuizQuestion();
}
