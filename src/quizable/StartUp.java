/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizable;

/**
 *
 * @author Brandon
 */
public class StartUp {
    public static void main(String[] args) {
        Quiz dipQuiz = new DIPQuiz();
        Quiz ooadQuiz = new OOADQuiz();
        Quiz quiz = new MultiQuiz(dipQuiz,ooadQuiz);
        QuizService quizMe = new QuizService(quiz);
        quizMe.startQuiz();
    }
}
