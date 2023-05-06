/**
 * @author 22ddowlin
 * @Purpose Demonstrates quiz and question class which utilizes complexity
 * In order for lines in a text file to be processed properly as a question, the directions are as follows:
 * 
 * On any line, include the question. It must have a question mark or a period.
 * On the next line, include the answer. It should only include the answer itself and NOT a question mark or period
 * On the line after that, include the complexity of the question which has to be an integer value
 */


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuizTime 
{
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		ArrayList<Question> questions = new ArrayList<Question>();
		
		Scanner sc = new Scanner(new File("questions.txt"));
		
		//scans all questions
		while (sc.hasNext())
		{
			String str = sc.nextLine();
			if (str.contains("?") || str.contains("."))
			{
				Question question = new Question(str, sc.nextLine());
				questions.add(question);
				question.setComplexity(Integer.parseInt(sc.nextLine()));
			}
		}
		sc.close();
		
		//creates quiz and adds question
		Quiz quiz = new Quiz(questions);
		
		Question q11 = new Question("What is 40/10?", "4");
		q11.setComplexity(3);
		quiz.addQuestion(q11);
		quiz.giveQuiz();
		
		//prits out results
		System.out.println("\nResults \nScore: " + quiz.getCorrectAnswers() + "/" + questions.size());

		for (Question q : questions)
		{
			if (quiz.getIncorrectlyAnsweredQuestions().contains(questions.indexOf(q)))
			{
				System.out.println(q + " You answered: " +  
						quiz.getIncorrectAnswers().get(quiz.getIncorrectlyAnsweredQuestions().indexOf(questions.indexOf(q))) + "\n");
			}
			else
				System.out.println(q + "\n");
		}
		
		//writes out questions to file
		BufferedWriter out = new BufferedWriter(new FileWriter("questionsmodified.txt"));
		out.write(quiz.toString() + "\n");
	    out.close();
	}
}
