public class HandInfo {
    String[] cards;
    int[] strengths;
    int category;
    int bid;
    int rank;

    public HandInfo(String[] cards, int bid, Hand handMethods, int[] counters)
    {
        this.cards = cards;
        this.bid = bid;
        this.strengths = handMethods.setCardValues(cards);
        this.category = handMethods.getCategory(counters);
        this.rank = 0;
    }
}
