import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
public class QuestionTest
{
  public static void main(String[] args)
  {
    int random1;
    int random2;
    Question question1;
    Question question2;
    random1 = (int)(Math.random() * 51 + 1);
    random2 = (int)(Math.random() * 15 + 1);
    System.out.println(random1);
    System.out.println(random2);
    if ( random1 >= 37 )
    {
      question1 = new PictureCompletionQuestion();
    }
    else 
    {
      question1 = new Question();
    }
    question2 = new PictureCompletionQuestion();
    try
    {
      question1.getQuestion("Questions.txt", random1);
      question2.getQuestion("Questions3.txt", random2);
      System.out.println(question1.getQuestionNumber());
      System.out.println(question1.getQuestion());
      System.out.println(question1.getQuestionOptions());
      System.out.println(question1.getCorrectOptionIndex());
      System.out.println(question1.getPoints());
      
      System.out.println("----------------------------");
      
      System.out.println(question2.getQuestionNumber());
      System.out.println(question2.getQuestion());
      System.out.println(question2.getQuestionOptions());
      System.out.println(question2.getCorrectOptionIndex());
      System.out.println(question2.getPoints());
    }
    catch(FileNotFoundException exception)
    {
      System.out.println("File not found.");
    }
    catch(NoSuchElementException exception)
    {
      System.out.println("File contents invalid.");
    }
    catch(IOException exception)
    {
      exception.printStackTrace();
    }
                    
                   
  }
}