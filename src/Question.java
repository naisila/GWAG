/**
 * __Non-GUI question.
 * @author __Ana Pecini___
 * @version __12/05/2017__
 */
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.io.BufferedReader;
import java.io.FileReader;
public class Question
{
  private int questionNumber;
  private String question;
  private ArrayList<String> questionOptions;
  private int correctOptionIndex;
  private int points;
  
  public Question()
  {
    this.questionNumber = 0;
    this.question = "";
    this.questionOptions = new ArrayList<String>();
    this.correctOptionIndex = 0;
    this.points = 0;
  }
  
  public String getQuestion()
  { 
    return question;
  }
  
  public int getQuestionNumber()
  {
    return questionNumber;
  }
  
  public void setQuestionNumber(int i)
  {
    questionNumber=i;
  }
  
  public int getCorrectOptionIndex()
  {
    return correctOptionIndex;
  }
  
  public ArrayList<String> getQuestionOptions()
  {
    return questionOptions;
  }
  
  public void setQuestion(String s)
  {
    this.question = s;
  }
  public void setCorrectOptionIndex(int i)
  {
    correctOptionIndex=i;
  }
  public void setQuestionOptions(ArrayList<String> s)
  {
    this.questionOptions = s;
  }
  
  public void setPoints(int i)
  {
    this.points = i;
  }
  
  public int getPoints()
  {
    return this.points;
  }
  
  public void getQuestion(String filename, int questionNr) throws IOException
  {
    ArrayList<String> lines = new ArrayList<String>();
    BufferedReader br = new BufferedReader(new FileReader(filename));
    String line = br.readLine();
    while (!line.equals("Question " + questionNr))
    {
      line = br.readLine();
    }
    while (!line.equals(""))
    {
      lines.add(line);
      line = br.readLine();
    }
    this.setQuestionNumber(Integer.parseInt(lines.get(0).substring(lines.get(0).length() - 1)));
    this.setQuestion(lines.get(1));
    this.setCorrectOptionIndex(Integer.parseInt(lines.get(6)));
    //this.setPoints(Integer.parseInt(lines.get(7)));
    this.setPoints(0);
    ArrayList<String> choices = new ArrayList<String>();
    for (int i = 2; i < 6; i++)
    {
      choices.add(lines.get(i));
    }
    this.setQuestionOptions(choices);
  }
}