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
        int correctAnswers = 0;
        while (quiz.hasNextQuestion()){
            //Ask Quiz Question
            inputSource.setQuizQuestion(quiz.getNextQuestion());
            String answer = messageService.receiveMessageFromSource();
            
            //Null Answer == End Quiz Eairly
            if (answer == null) {break;}
            
            //Check Answer
            if(quiz.checkAnswer(answer)){
                //True
                correctAnswers++;
                outputSource.setAnswerWasCorrect(true);
                messageService.sendMessageToSource("Correct!");
            }else{
                //False
                String wrongMsg = "Wrong! Should Be: \n" + quiz.getCurrentAnswer();
                outputSource.setAnswerWasCorrect(false);
                messageService.sendMessageToSource(wrongMsg);
            }
        }//end of Quiz While Loop
        double c = (double) correctAnswers;
        double t = (double) quiz.getQuestionCount();
        double score = (c / t) * 100;

        String finalMessage = "You got " + correctAnswers + " out of " + quiz.getQuestionCount() + " (%" + score + ")";
        outputSource.setAnswerWasCorrect(score >= 50);
        messageService.sendMessageToSource(finalMessage);
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
        messageService.setMessageInputSource(inputSource);
    }

    public final QuizMessageOutputSource getQuizMessageOutputSource() {
        return outputSource;
    }

    public final void seQuizMessageOutputSource(QuizMessageOutputSource outputSource) {
        if(outputSource == null) throw new IllegalArgumentException("Output Source May Not Be Null");
        this.outputSource = outputSource;
        messageService.setMessageOutputSource(outputSource);
    }

    public final Quiz getQuiz() {
        return quiz;
    }

    public final void setQuiz(Quiz quiz) {
        if(quiz == null) throw new IllegalArgumentException("Quiz May Not Be Null");
        this.quiz = quiz;
    }
        
    
}
