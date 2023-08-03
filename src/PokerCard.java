import java.util.*;

public class PokerCard {
    public static void main(String[] args) {
        List<String> player1 = new ArrayList<>();
        List<String> player2 = new ArrayList<>();

        player1.add("AH");
        player1.add("2S");
        player1.add("3C");
        player1.add("4D");
        player1.add("5D");

        player2.add("5C");
        player2.add("3S");
        player2.add("2H");
        player2.add("4S");
        player2.add("AH");

        System.out.println("Result: " + checkWinner(player1, player2));
    }

    public static int checkWinner(List<String> player1, List<String> player2) {
        //<key, value>: <card, #card>
        HashMap<String, Integer> player1Map = new HashMap<>();
        HashMap<String, Integer> player2Map = new HashMap<>();

        for(int i = 0; i < player1.size(); i ++) {
            if(player1Map.containsKey(player1.get(i).charAt(0) + "")) {
                player1Map.replace(player1.get(i).charAt(0) + "", player1Map.get(player1.get(i).charAt(0) + "") + 1);
            } else {
                player1Map.put(player1.get(i).charAt(0) + "", 1);
            }
        }

        for(int i = 0; i < player2.size(); i ++) {
            if(player2Map.containsKey(player2.get(i).charAt(0) + "")) {
                player2Map.replace(player2.get(i).charAt(0) + "", player2Map.get(player2.get(i).charAt(0) + "") + 1);
            } else {
                player2Map.put(player2.get(i).charAt(0) + "", 1);
            }
        }

        // compare the value inside the maps

//            1: 3, 3, 5, 5, 7
//
//            2: 3, 4, 4, 5, 7
        String[] cards = {"A", "K","Q", "J", "T", "9","8", "7", "6", "5", "4", "3", "2"};

        for(int i = 0; i < cards.length; i ++) {
            if(player1Map.containsKey(cards[i]) && player2Map.containsKey(cards[i])) {
                // compare the value of card
                if(player1Map.get(cards[i]) > player2Map.get(cards[i])) {
                    return 1;
                } else if (player1Map.get(cards[i]) < player2Map.get(cards[i])) {
                    return 2;
                } else {
                    continue;
                }
            } else if(player1Map.containsKey(cards[i]) && !player2Map.containsKey(cards[i])) {
                return 1;
            } else if(!player1Map.containsKey(cards[i]) && player2Map.containsKey(cards[i])) {
                return 2;
            }
        }

        return 0;
    }
}
