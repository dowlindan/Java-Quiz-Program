import java.util.ArrayList;
import java.util.Scanner;

public class Quiz
{
	private ArrayList<Question> questions;
	private int correctAnswers;
	private ArrayList<Integer> incorrectlyAnsweredQuestions;
	private ArrayList<String> incorrectAnswers;
	

	/**
	 * Default constructor, creates a blank quiz
	 */
	public Quiz()
	{
		this.questions = new ArrayList<Question>();
		correctAnswers = 0;
		incorrectlyAnsweredQuestions = new ArrayList<Integer>();
		incorrectAnswers = new ArrayList<String>();
	}
	/**
	 * Makes quiz object with arraylist of questions
	 * @param ArrayList of questions
	 */
	public Quiz(ArrayList<Question> questions)
	{
		this.questions = questions;
		correctAnswers = 0;
		incorrectlyAnsweredQuestions = new ArrayList<Integer>();
		incorrectAnswers = new ArrayList<String>();
	}
	
	/**
	 * Adds question to ArrayList of questions in Quiz object
	 * @param question
	 */
	public void addQuestion(Question question)
	{
		questions.add(question);
	}
	/**
	 * Removes question from ArrayList of questions
	 * @param question
	 */
	public void removeQuestion(Question question)
	{
		questions.remove(question);
	}
	
	/*
	 * Gives the quiz in the console and saves results
	 */
	public void giveQuiz()
	{
		if ((questions.size()>=10))
		{
			Scanner sc = new Scanner(System.in);
			for (Question q: questions)
			{
				System.out.println(q.getQuestion() + " (Complexity: " + q.getComplexity() + ")");
				String input = sc.nextLine();
				if (q.answerCorrect(input)) 
					correctAnswers++;
				else
				{
					incorrectlyAnsweredQuestions.add(questions.indexOf(q));
					incorrectAnswers.add(input);
				}
			}
			sc.close();
		}
		else
			System.out.println("Quiz must be 10 or more questions");
	}
	
	/**
	 * @return Amount of correct answers in the quiz
	 */
	public int getCorrectAnswers()
	{
		return correctAnswers;
	}
	
	/**
	 * @return Integer ArrayList of incorrectly answered questions
	 */
	public ArrayList<Integer> getIncorrectlyAnsweredQuestions()
	{
		return incorrectlyAnsweredQuestions;
	}
	
	/**
	 * @return String ArrayList of incorrect answers
	 */
	public ArrayList<String> getIncorrectAnswers()
	{
		return incorrectAnswers;
	}
	
	/**
	 * Prints out quiz in string form. Returns results as well in case quiz has been given
	 */
	public String toString()
	{
		String str = "";
		for (Question q: questions)
		{
			str += q.toString() + "\n";
		}
		str += "\nScore(in case taken): " + correctAnswers + "/" + questions.size();
		return str;
	}
}

