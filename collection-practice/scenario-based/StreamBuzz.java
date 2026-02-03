import java.util.*;

class StreamBuzz {
    public String creatorName;
    public double[] weeklyLikes;

    // Static EngagementBoard
    public static List<StreamBuzz> engagementBoard = new ArrayList<>();
}

public class StreamBuzz {

    // Register creator
    public void registerCreator(StreamBuzz record) {
        StreamBuzz.engagementBoard.add(record);
    }

    // Get top post counts
    public Map<String, Integer> getTopPostCounts(List<StreamBuzz> records, double likeThreshold) {
        Map<String, Integer> result = new LinkedHashMap<>(); // preserve insertion order

        for (StreamBuzz creator : records) {
            int count = 0;
            for (double likes : creator.weeklyLikes) {
                if (likes >= likeThreshold) {
                    count++;
                }
            }
            if (count > 0) {
                result.put(creator.creatorName, count);
            }
        }
        return result;
    }

    // Calculate average likes
    public double calculateAverageLikes() {
        double totalLikes = 0;
        int totalWeeks = 0;

        for (StreamBuzz creator : StreamBuzz.engagementBoard) {
            for (double likes : creator.weeklyLikes) {
                totalLikes += likes;
                totalWeeks++;
            }
        }

        if (totalWeeks == 0) return 0;
        return totalLikes / totalWeeks;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StreamBuzz program = new StreamBuzz();
        boolean running = true;

        while (running) {
            System.out.println("1. Register Creator");
            System.out.println("2. Show Top Posts");
            System.out.println("3. Calculate Average Likes");
            System.out.println("4. Exit");
            System.out.println("Enter your choice:");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    StreamBuzz creator = new StreamBuzz();
                    System.out.println("Enter Creator Name:");
                    creator.creatorName = sc.nextLine();

                    creator.weeklyLikes = new double[4];
                    System.out.println("Enter weekly likes (Week 1 to 4):");
                    for (int i = 0; i < 4; i++) {
                        creator.weeklyLikes[i] = Double.parseDouble(sc.nextLine());
                    }

                    program.registerCreator(creator);
                    System.out.println("Creator registered successfully");
                    break;

                case 2:
                    System.out.println("Enter like threshold:");
                    double threshold = Double.parseDouble(sc.nextLine());

                    Map<String, Integer> topPosts =
                            program.getTopPostCounts(StreamBuzz.engagementBoard, threshold);

                    if (topPosts.isEmpty()) {
                        System.out.println("No top-performing posts this week");
                    } else {
                        for (Map.Entry<String, Integer> entry : topPosts.entrySet()) {
                            System.out.println(entry.getKey() + " - " + entry.getValue());
                        }
                    }
                    break;

                case 3:
                    double avg = program.calculateAverageLikes();
                    System.out.println("Overall average weekly likes: " + (int) avg);
                    break;

                case 4:
                    System.out.println("Logging off - Keep Creating with StreamBuzz!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }

        sc.close();
    }
}
