public class SnakeGame {

    final static int NO_PLAY = 0;
    final static int LADDER = 1;
    final static int SNAKE = 2;

    public static void main(String[] args) {
    	
    	//uc1
        int playerPosition = 0;
        
        int count = 0;

        
        //uc4
        while (playerPosition !=100) {

            int rollDie = die();
            int chance = play();
            count++;

            switch (chance) {

                case NO_PLAY:
                    System.out.println("No Play");
                    break;

                case LADDER:
                	
                	//uc5
                    System.out.println("Ladder");
                    if((playerPosition+rollDie)>100)  {
                    	System.out.println("Stop! Need to roll die again");
                    }
                    
                    else {
                    	playerPosition += rollDie;
                    }
                    
                    break;

                case SNAKE:
                    System.out.println("Snake");
                    playerPosition -= rollDie;
                    if (playerPosition < 0) playerPosition = 0;
                    break;
            }

            System.out.println("Player position: " + playerPosition);
        }

        //uc6
        System.out.println("Total number of dice rolls: " + count);
    }

    //uc2
    public static int die() {
        return (int)(Math.random() * 6) + 1;
    }

    //uc3
    public static int play() {
        return (int)(Math.random() * 3);
    }
}
