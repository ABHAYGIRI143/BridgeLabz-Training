
import java.util.*;

class ExamProctor {

    private Stack<Integer> navigationStack = new Stack<>();
    private HashMap<Integer, String> answers = new HashMap<>();
    private HashMap<Integer, String> correctAnswers = new HashMap<>();

    // Load correct answers (exam setup)
    public ExamProctor() {
        correctAnswers.put(1, "A");
        correctAnswers.put(2, "B");
        correctAnswers.put(3, "C");
        correctAnswers.put(4, "D");
    }

    // Track question navigation
    public void visitQuestion(int questionId) {
        navigationStack.push(questionId);
        System.out.println("Visited Question: " + questionId);
    }

    // Store answer
    public void submitAnswer(int questionId, String answer) {
        answers.put(questionId, answer);
        System.out.println("Answer saved for Q" + questionId);
    }

    // Go back to previous question
    public int goBack() {
        if (navigationStack.isEmpty()) {
            System.out.println("No previous question.");
            return -1;
        }
        return navigationStack.pop();
    }

    // Evaluate score
    public int calculateScore() {
        int score = 0;

        for (int qId : correctAnswers.keySet()) {
            if (answers.containsKey(qId) &&
                answers.get(qId).equals(correctAnswers.get(qId))) {
                score++;
            }
        }
        return score;
    }
}


public class ExamApp {

    public static void main(String[] args) {

        ExamProctor exam = new ExamProctor();

        exam.visitQuestion(1);
        exam.submitAnswer(1, "A");

        exam.visitQuestion(2);
        exam.submitAnswer(2, "B");

        exam.visitQuestion(3);
        exam.submitAnswer(3, "C");

        exam.visitQuestion(4);
        exam.submitAnswer(4, "A"); // wrong

        System.out.println("Final Score: " + exam.calculateScore());
    }
}
