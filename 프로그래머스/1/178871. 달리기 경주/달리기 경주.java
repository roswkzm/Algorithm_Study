import java.util.Map;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rankMap = new HashMap<>();
        for(int i = 0; i < players.length; i++){
            rankMap.put(players[i], i);
        }
        
        for(String player : callings){
            // 이름 호출된 선수가 몇번째 선수인지 저장
            int ownRank = rankMap.get(player);
            // 추월당한 선수이름
            String losePlayerName = players[ownRank - 1];
            
            // players 배열 정렬
            players[ownRank - 1] = player;
            players[ownRank] = losePlayerName;
            
            // hashMap 정렬
            rankMap.put(player, ownRank -1);
            rankMap.put(losePlayerName, ownRank);
        }
        
        return players;
    }
}