package quizable;
import Messaging.*;

public class QuizService {
    private MessagingService messageService;
    private Quiz quiz;
    
    public QuizService(Quiz quiz){
        setQuiz(quiz);
        MessageInputSource inputSource = null;
        MessageOutputSource outputSource = null;
        messageService = new MessagingService(inputSource,outputSource);
    }
    
    
}
