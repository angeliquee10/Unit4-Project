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

            while(s.hasNextLine())
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

        //counter variable for each type of hand
        int fiveOfKind = 0;
        int fullHouse = 0;
        int fourOfKind = 0;
        int threeOfKind = 0;
        int twoPair = 0;
        int onePair = 0;
        int highCard = 0;

        String[] handType = new String[lines.length];
        int[] bid = new int[lines.length];

        int totalBid = 0;

        //goes through every line/hand in the data set
        for(int i = 0; i < lines.length; i++)
        {
            String line = lines[i];

            String[] cards = line.split(",");
            String[] temp = cards[cards.length - 1].split("\\|");
            cards[cards.length - 1] = temp[0];
            bid[i] = Integer.parseInt(temp[1]);
//            System.out.println(Arrays.toString(cards));
//            System.out.println(Arrays.toString(bid));

            //below is an array where each index corresponds to a specific card type
            //0=ace, 1=king,2=queen, 3=jack, 4=ten, 5=nine, 6=eight, 7=seven, 8=six, 9=five, 10=four, 11=three, 12=two
            int[] counters = new int[13];

            //checks for what cards are in the hand, and adds one to the corresponding counter in the array
            for(String card : cards)
            {
                if(card.equals("Ace"))
                { counters[0] ++; }
                else if(card.equals("King"))
                { counters[1] ++; }
                else if(card.equals("Queen"))
                { counters[2] ++; }
                else if(card.equals("Jack"))
                { counters[3] ++; }
                else if(card.equals("10"))
                { counters[4] ++; }
                else if(card.equals("9"))
                { counters[5] ++; }
                else if(card.equals("8"))
                { counters[6] ++; }
                else if(card.equals("7"))
                { counters[7] ++; }
                else if(card.equals("6"))
                { counters[8] ++; }
                else if(card.equals("5"))
                { counters[9] ++; }
                else if(card.equals("4"))
                { counters[10] ++; }
                else if(card.equals("3"))
                { counters[11] ++; }
                else
                { counters[12] ++; }
            }

            Hand hand = new Hand(cards);
            if(hand.fiveOfKind(counters))
            {
                fiveOfKind ++;
                handType[i] = "Five Of Kind";
            }
            else if(hand.fourOfKind(counters))
            {
                fourOfKind ++;
                handType[i] = "Four Of Kind";
            }
            else if(hand.fullHouse(counters))
            {
                fullHouse ++;
                handType[i] = "Full House";
            }
            else if(hand.threeOfKind(counters))
            {
                threeOfKind ++;
                handType[i] = "Third Of Kind";
            }
            else
            {
                if(hand.twoOneOrNone(counters) == 2)
                {
                    twoPair ++;
                    handType[i] = "Two Pairs";
                }
                if(hand.twoOneOrNone(counters) == 1)
                {
                    onePair ++;
                    handType[i] = "One Pair";
                }
                if(hand.twoOneOrNone(counters) == 0)
                {
                    highCard ++;
                    handType[i] = "High Card";
                }
            }


        }

        System.out.println("Number of five of a kind hands: " + fiveOfKind);
        System.out.println("Number of full house hands: " + fullHouse);
        System.out.println("Number of four of a kind hands: " + fourOfKind);
        System.out.println("Number of three of a kind hands: " + threeOfKind);
        System.out.println("Number of two pair hands: " + twoPair);
        System.out.println("Number of one pair hands: " + onePair);
        System.out.println("Number of high card hands: " + highCard);
        System.out.println("Total Bid: " + totalBid);
//        System.out.println(Arrays.toString(handType));

    }
}