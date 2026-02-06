//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
            String fileData = "";
            try
            {
                File f = new File("src/data");
                Scanner s = new Scanner(f);

                while (s.hasNextLine())
                {
                    String line = s.nextLine();
                    fileData += line + "\n";
                }
            }
            catch(FileNotFoundException e)
            {
                System.out.println("File not found");
            }

            String[] lines = fileData.split("\n");

            for(String line : lines)
            {
                String[] cards = line.split(",");
                String[] temp = cards[cards.length - 1].split("\\|");
                cards[cards.length - 1] = temp[0];

                //Part 1

                //counter variable for each type of card
                int ace = 0;
                int king = 0;
                int queen = 0;
                int jack = 0;
                int two = 0;
                int three = 0;
                int four = 0;
                int five = 0;
                int six = 0;
                int seven = 0;
                int eight = 0;
                int nine = 0;
                int ten = 0;

                //counter variable for each type of hand
                int fiveOfKind = 0;
                int fullHouse = 0;
                int fourOfKind = 0;
                int threeOfKind = 0;
                int twoPair = 0;
                int onePair = 0;
                int highCard = 0;

                //counter variable for number of pairs
                int numPairs = 0;

//                //now we iterate through the whole list to see which cards we have and add to the corresponding variable
                for(String card : cards)
                {
                    if(card.equals("Ace"))
                    { ace ++; }
                    else if(card.equals("King"))
                    { king ++; }
                    else if(card.equals("Queen"))
                    { queen ++; }
                    else if(card.equals("Jack"))
                    { jack ++; }
                    else if(card.equals("10"))
                    { ten ++; }
                    else if(card.equals("9"))
                    { nine ++; }
                    else if(card.equals("8"))
                    { eight ++; }
                    else if(card.equals("7"))
                    { seven ++; }
                    else if(card.equals("6"))
                    { six ++; }
                    else if(card.equals("5"))
                    { five ++; }
                    else if(card.equals("4"))
                    { four ++; }
                    else if(card.equals("3"))
                    { three ++; }
                    else
                    { two ++; }
                }

                //now we look at the counters and see if we have a five of a kind, four of a kind, or a three of a kind
                if(ace == 5 | king == 5| queen == 5| jack == 5| ten == 5| nine == 5| eight == 5| seven == 5| six == 5| five == 5| four == 5| three == 5| two == 5)
                { fiveOfKind ++; }
                else if(ace == 4 | king == 4| queen == 4| jack == 4| ten == 4| nine == 4| eight == 4| seven == 4| six == 4| five == 4| four == 4| three == 4| two == 4)
                { fourOfKind ++; }
                else if(ace == 3 | king == 3| queen == 3| jack == 3| ten == 3| nine == 3| eight == 3| seven == 3| six == 3| five == 3| four == 3| three == 3| two == 3)
                { threeOfKind ++; }
                else
                {
                    if(ace == 2)
                    { numPairs ++; }
                    else if(king == 2)
                    { numPairs ++; }
                    else if()
                    { numPairs ++; }
                    else if()
                    { numPairs ++; }
                    else if()
                    { numPairs ++; }
                    else if()
                    { numPairs ++; }
                    else if()
                    { numPairs ++; }
                    else if()
                    { numPairs ++; }
                    else if()
                    { numPairs ++; }
                    else if()
                    { numPairs ++; }
                    else if()
                    { numPairs ++; }
                    else if()
                    { numPairs ++; }
                    else if( two == 2)
                    { numPairs ++; }

                    if(numPairs == 2)
                    { twoPair ++; }
                    else if(numPairs == 1)
                    { onePair ++; }
                    else
                    { highCard ++; }
                }
                System.out.println(Arrays.toString(cards));
            }
    }
}