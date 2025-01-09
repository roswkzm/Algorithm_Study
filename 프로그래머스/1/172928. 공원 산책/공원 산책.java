class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int height = park.length;
        int width = park[0].length();
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (park[i].charAt(j) == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }

        int[][] directions = {
            {-1, 0}, // N
            {1, 0},  // S
            {0, -1}, // W
            {0, 1}   // E
        };
        String directionStr = "NSWE";

        // 명령 수행
        for (String route : routes) {
            String[] split = route.split(" ");
            String op = split[0];
            int distance = Integer.parseInt(split[1]);

            int dirIndex = directionStr.indexOf(op);
            int[] dir = directions[dirIndex];

            int newY = answer[0];
            int newX = answer[1];
            boolean valid = true;

            for (int i = 0; i < distance; i++) {
                newY += dir[0];
                newX += dir[1];

                // 공원 밖으로 나가는 경우
                if (newY < 0 || newY >= height || newX < 0 || newX >= width) {
                    valid = false;
                    break;
                }

                if (park[newY].charAt(newX) == 'X') {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                answer[0] = newY;
                answer[1] = newX;
            }
        }

        return answer;
    }
}