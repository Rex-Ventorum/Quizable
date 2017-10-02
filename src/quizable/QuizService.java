package quizable;
import Messaging.*;

public class QuizService {
    private QuizMessageInputSource inputSource;
    private QuizMessageOutputSource outputSource;
    private MessagingService messageService;
    private Quiz quiz;
    
    public QuizService(Quiz quiz){
        setQuiz(quiz);
        inputSource = new QuizGUIMessageInputSource();
        outputSource = new QuizGUIMessageOutputSource();
        messageService = new MessagingService(inputSource,outputSource);
    }

    
    
    public final void startQuiz(){
        
    }
    
    //--------------------------//
    //--- GETTER AND SETTERS ---//
    //--------------------------//
    
    public final QuizMessageInputSource getQuizMessageInputSource() {
        return inputSource;
    }

    public final void setQuizMessageInputSource(QuizMessageInputSource inputSource) {
        if(inputSource == null) throw new IllegalArgumentException("Input Source May Not Be Null");
        this.inputSource = inputSource;
    }

    public final QuizMessageOutputSource getQuizMessageOutputSource() {
        return outputSource;
    }

    public final void seQuizMessageOutputSource(QuizMessageOutputSource outputSource) {
        if(outputSource == null) throw new IllegalArgumentException("Output Source May Not Be Null");
        this.outputSource = outputSource;
    }

    public final Quiz getQuiz() {
        return quiz;
    }

    public final void setQuiz(Quiz quiz) {
        if(quiz == null) throw new IllegalArgumentException("Quiz May Not Be Null");
        this.quiz = quiz;
    }
        
    
}
