/**
 * __Non-GUI picture completion question. It extends class Question.
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
public class PictureCompletionQuestion extends Question
{
  private String pictureFile;
  
  public PictureCompletionQuestion()
  {
    this.pictureFile = "";
  }
  public String getPicture()
  {
    return this.pictureFile;
  }
  
  public void setPicture(String pictureFile)
  {
    this.pictureFile = pictureFile;
  }
  
  @Override
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
    this.setPicture(lines.get(2));
    this.setCorrectOptionIndex(Integer.parseInt(lines.get(7)));
    //this.setPoints(Integer.parseInt(lines.get(8)));
    this.setPoints(0);
    ArrayList<String> choices = new ArrayList<String>();
    for (int i = 3; i < 7; i++)
    {
      choices.add(lines.get(i));
    }
    this.setQuestionOptions(choices);
  }
}