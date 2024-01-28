import java.util.Scanner;
public class AlarmClock {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String time1 = input.nextLine();
    int time = Integer.parseInt(time1.replaceAll(" ", ""));

    int count = -1;
    int i;
    for (i = 0; i < 1; i--) {
      count++;
      String newTime = input.nextLine();
      int alarm = Integer.parseInt(newTime.replaceAll(" ", ""));
      if (alarm > time) {
        i = 2;
      }
    }

    System.out.println("false alarms: " + count);
  }
}