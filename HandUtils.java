public class HandUtils {
    public static int compareHands(HandInfo a, HandInfo b)
    {
        if (a.category < b.category) return -1;
        if(a.category > b.category) return 1;
        for(int k = 0; k < 5; k++)
        {
            int sa = a.strengths[k];
            int sb = b.strengths[k];
            if (sa < sb) return -1;
            if (sa > sb) return 1;
        }
        return 0;
    }
}
