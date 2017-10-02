package Messaging;

public interface QuizMessageOutputSource extends MessageOutputSource {
   public abstract void setAnswerWasCorrect(boolean wasCorrect);
}
