
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

        //Part 1

        //counter variable for each type of hand
        int fiveOfKind = 0;
        int fullHouse = 0;
        int fourOfKind = 0;
        int threeOfKind = 0;
        int twoPair = 0;
        int onePair = 0;
        int highCard = 0;

        //arrays that will store the bid and hand type of each hand
        String[] handType = new String[lines.length];
        String[] bid = new String[lines.length];

        for(int i = 0; i < lines.length - 1; i++)
        {
            String line = lines[i];

            String[] cards = line.split(",");
            String[] temp = cards[cards.length - 1].split("\\|");
            cards[cards.length - 1] = temp[0];

            bid[i] = temp[1];

            System.out.println(Arrays.toString(cards));

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

            //counter variable for number of pairs
            int numPairs = 0;

            //now we iterate through the whole list to see which cards we have and add to the corresponding variable
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
            {
                fiveOfKind ++;
                handType[i] = "Five Of A Kind";
            }
            else if(ace == 4 | king == 4| queen == 4| jack == 4| ten == 4| nine == 4| eight == 4| seven == 4| six == 4| five == 4| four == 4| three == 4| two == 4)
            {
                fourOfKind ++;
                handType[i] = "Four Of A Kind";
            }
            else if(ace == 3 | king == 3| queen == 3| jack == 3| ten == 3| nine == 3| eight == 3| seven == 3| six == 3| five == 3| four == 3| three == 3| two == 3)
            {
                if(ace == 2 | king == 2| queen == 2| jack == 2| ten == 2| nine == 2| eight == 2| seven == 2| six == 2| five == 2| four == 2| three == 2| two == 2)
                {
                    fullHouse ++;
                    handType[i] = "Full House";
                }
                else
                {
                    threeOfKind ++;
                    handType[i] = "Four Of A Kind";
                }
            }
            else
            {
                if(ace == 2)
                { numPairs ++; }
                if(king == 2)
                { numPairs ++; }
                if(queen == 2)
                { numPairs ++; }
                if(jack == 2)
                { numPairs ++; }
                if(two == 2)
                { numPairs ++; }
                if(three == 2)
                { numPairs ++; }
                if(four == 2)
                { numPairs ++; }
                if(five == 2)
                { numPairs ++; }
                if(six == 2)
                { numPairs ++; }
                if(seven == 2)
                { numPairs ++; }
                if(eight == 2)
                { numPairs ++; }
                if(nine == 2)
                { numPairs ++; }
                if( ten == 2)
                { numPairs ++; }

                if(numPairs == 2)
                { twoPair ++; }
                else if(numPairs == 1)
                { onePair ++; }
                else
                { highCard ++; }
            }
//            System.out.println(Arrays.toString(cards));

            //Part 2

        }

        //Part 2

        System.out.println("Number of five of a kind hands: " + fiveOfKind);
        System.out.println("Number of full house hands: " + fullHouse);
        System.out.println("Number of four of a kind hands: " + fourOfKind);
        System.out.println("Number of three of a kind hands: " + threeOfKind);
        System.out.println("Number of two pair hands: " + twoPair);
        System.out.println("Number of one pair hands: " + onePair);
        System.out.println("Number of high card hands: " + highCard);


    }
}
