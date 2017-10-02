package quizable;
import Messaging.*;

public class QuizService {
    private MessagingService messageService;
    private Quiz quiz;
    
    public QuizService(Quiz quiz, MessagingService messageService){
        setQuiz(quiz);
        setMessagingService(messageService);
    }
    
    
}
