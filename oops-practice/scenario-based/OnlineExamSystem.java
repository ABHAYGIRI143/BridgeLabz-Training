import java.util.*;

// ================= Custom Exception =================
class ExamTimeExpiredException extends Exception {
    public ExamTimeExpiredException(String msg) {
        super(msg);
    }
}

// ================= Evaluation Strategy =================
interface EvaluationStrategy {
    int evaluate(Question q, String answer);
}

// Objective exam (MCQ)
class ObjectiveEvaluation implements EvaluationStrategy {
    public int evaluate(Question q, String answer) {
        return q.correctAnswer.equalsIgnoreCase(answer) ? q.marks : 0;
    }
}

// Descriptive exam
class DescriptiveEvaluation implements EvaluationStrategy {
    public int evaluate(Question q, String answer) {
        // Simulated evaluation
        return answer.length() > 10 ? q.marks : q.marks / 2;
    }
}

// ================= Question =================
class Question {
    int id;
    String text;
    String correctAnswer;
    int marks;

    Question(int id, String text, String correctAnswer, int marks) {
        this.id = id;
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.marks = marks;
    }
}

// ================= Student =================
class Student {
    int id;
    String name;
    Map<Integer, String> answers = new HashMap<>();

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

// ================= Exam =================
class Exam {

    private List<Question> questions = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private long endTime;

    public Exam(int durationSeconds) {
        endTime = System.currentTimeMillis() + (durationSeconds * 1000);
    }

    // CREATE exam
    public void addQuestion(Question q) {
        questions.add(q);
    }

    // Enroll student
    public void enrollStudent(Student s) {
        students.add(s);
    }

    // Submit answer
    public void submitAnswer(Student s, int questionId, String answer)
            throws ExamTimeExpiredException {

        if (System.currentTimeMillis() > endTime)
            throw new ExamTimeExpiredException("Exam time over!");

        s.answers.put(questionId, answer);
    }

    // Result generation
    public void generateResult(Student s, EvaluationStrategy strategy) {
        int total = 0;

        for (Question q : questions) {
            String ans = s.answers.get(q.id);
            if (ans != null)
                total += strategy.evaluate(q, ans);
        }

        System.out.println(s.name + " scored " + total + " marks.");
    }
}

// ================= Main =================
public class OnlineExamSystem {
    public static void main(String[] args) {

        Exam exam = new Exam(60); // 60 seconds exam

        exam.addQuestion(new Question(1, "Java is OOP?", "Yes", 5));
        exam.addQuestion(new Question(2, "What is JVM?", "Java Virtual Machine", 5));

        Student s1 = new Student(1, "Abhay");
        exam.enrollStudent(s1);

        try {
            exam.submitAnswer(s1, 1, "Yes");
            exam.submitAnswer(s1, 2, "Java Virtual Machine");

            EvaluationStrategy objective = new ObjectiveEvaluation();
            exam.generateResult(s1, objective);

        } catch (ExamTimeExpiredException e) {
            System.out.println(e.getMessage());
        }
    }
}
