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

    public void getInfo()
    {
        System.out.println(Arrays.toString(cards));
    }
}
