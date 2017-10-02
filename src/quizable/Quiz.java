package quizable;
/**
 *
 * @author Brandon
 */
public interface Quiz {
    public abstract String[] getAllQuestions();
    public abstract String[] getAllAnswers();
    public abstract int getQuestionCount();
    
    public abstract boolean hasNextQuestion();
    public abstract String getNextQuestion();
    public abstract boolean checkAnswer(String answer);
    public abstract String getCurrentAnswer();
}
