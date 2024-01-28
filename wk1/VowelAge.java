import java.util.Scanner;
public class VowelAge
{
  public static void main(String[] args)
  {
    Scanner name = new Scanner(System.in);
    String uName = name.nextLine();
    int uAge = name.nextInt();

    String vowels = "aeiouAEIOU";
    int vowelCount= 0;
    int i, j;
    for(i = 0; i < uName.length(); i++){
      for(j = 0; j < vowels.length(); j++){
        if (uName.charAt(i) == vowels.charAt(j)){
          vowelCount++;
        }
      }
    }

    String status;
    if (uAge < 18) {
      status = "minor";
      System.out.println("Hello " + uName + ", you have " + vowelCount + " vowels, and you are a " + status);
    }
    else {
      status = "adult";
      System.out.println("Hello " + uName + ", you have " + vowelCount + " vowels, and you are an " + status);
    }
  }
}