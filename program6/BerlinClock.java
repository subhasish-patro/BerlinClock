package program6;
import java.util.Scanner;
import java.util.stream.Stream;

public class BerlinClock {

public String convertTime(String aTime) {
int[] parts = Stream.of(aTime.split(":")).mapToInt(Integer::parseInt).toArray();//returns an int stream in specified sequence ,split is a method which works by invoking 2 argument split method.
// here time which is in hh:mm:ss->hh,mm,ss;
//eg:13:15:04 is splitted into 13,15,04


StringBuffer time = new StringBuffer();


return time.append(getSeconds(parts[2])).append(System.getProperty("line.separator"))
.append(getTopHours(parts[0])).append(System.getProperty("line.separator"))
.append(getBottomHours(parts[0])).append(System.getProperty("line.separator"))
.append(getTopMinutes(parts[1])).append(System.getProperty("line.separator"))
.append(getBottomMinutes(parts[1])).toString(); // returns the substrings in the same sequence as written and gets printed line by line
}
private String getSeconds(int number) {
if (number % 2 == 0)  // seconds are 04 ;04%2 =2
return "Y";       // Y will be printed
else
return "O";
}
private String getTopHours(int number)  {
return getOnOff(4, getTopNumberOfOnSigns(number));  // as no of top hour lights are 4 it is taken and from the function top no of on signs we got is 2
}
private String getBottomHours(int number) {
return getOnOff(4, number % 5); // (4, (13%5)=3 )
}
private String getTopMinutes(int number) {
return getOnOff(11, getTopNumberOfOnSigns(number), "Y").replaceAll("YYY", "YYR"); //default is the 3rd,6th,9th of minute blocks are red.
}
private String getBottomMinutes(int number) {
return getOnOff(4, number % 5, "Y");
}
private String getOnOff(int lamps, int onSigns) {
return getOnOff(lamps, onSigns, "R");
}
private String getOnOff(int lamps, int onSigns, String onSign) {
String out = "";
for (int i = 0; i < onSigns; i++) {
out += onSign;
}
for (int i = 0; i < (lamps - onSigns); i++) {
out += "O";
}
return out;
}
private int getTopNumberOfOnSigns(int number) {
return (number - (number % 5)) / 5; // if 13 hrs is selected, (13-3)/5= 2 red lights on top gets on.
}
public static void main(String[] args) {

BerlinClock berlinClock = new BerlinClock();
Scanner s = new Scanner(System.in);
System.out.print("Enter time in HH:MM:SS format: ");  //if 13:15:04 is entered
String time = s.next();


System.out.println(berlinClock.convertTime(time));



}
}
