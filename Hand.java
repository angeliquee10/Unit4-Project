import java.util.Arrays;

public class Hand {
    private String[] cards;

    public Hand (String[] hand)
    {
        cards = hand;
    }

    public boolean fiveOfKind(int[] counters)
    {
        boolean fiveKind = false;
        for(int num : counters)
        {
            if(num == 5)
            {
                fiveKind = true;
            }
        }
        return fiveKind;
    }

    public boolean fourOfKind(int[] counters)
    {
        boolean fourKind = false;
        for(int num : counters)
        {
            if(num == 4)
            {
                fourKind = true;
            }
        }
        return fourKind;
    }

    public boolean fullHouse(int[] counters)
    {
        boolean fullHouse = false;
        for(int num : counters)
        {
            if(num == 3)
            {
                for(int check : counters)
                {
                    if(check == 2)
                    {
                        fullHouse = true;
                    }
                }
            }
        }
        return fullHouse;
    }

    public boolean threeOfKind(int[] counters)
    {
        boolean thirdKind = false;
        for(int num : counters)
        {
            if(num == 3)
            {
                thirdKind = true;
            }
        }
        return thirdKind;
    }

    public int twoOneOrNone(int[] counters)
    {
        int pairs = 0;
        for(int num : counters)
        {
            if(num == 2)
            {
                pairs ++;
            }
        }
        return pairs;
    }

    public int[] setCardValues(String[] hand)
    {
        int[] strength = new int[hand.length];
        for(int i = 0; i < hand.length - 1; i++)
        {
            String card = hand[i];
            if(card == "Ace") { strength[i] = 14;}
            if(card == "King") {strength[i] = 13;}
            if(card == "Queen") {strength[i] = 12;}
            if(card == "Jack") {strength[i] = 11;}
            if(card == "10") {strength[i] = 10;}
            if(card == "9") {strength[i] = 9;}
            if(card == "8") {strength[i] = 8;}
            if(card == "7") {strength[i] = 7;}
            if(card == "6") {strength[i] = 6;}
            if(card == "5") {strength[i] = 5;}
            if(card == "4") {strength[i] = 4;}
            if(card == "3") {strength[i] = 3;}
            if(card == "2") {strength[i] = 2;}
        }
        return strength;
    }

    public int getCategory(int[] counters)
    {
        if(fiveOfKind(counters)) return 7;
        else if(fourOfKind(counters)) return 6;
        else if(fullHouse(counters)) return 5;
        else if (threeOfKind(counters)) return 4;
        else
        {
            int pairs = twoOneOrNone(counters);

            if (pairs == 2) return 3;
            else if (pairs == 1) return 2;
            else return 1;
        }
    }

}