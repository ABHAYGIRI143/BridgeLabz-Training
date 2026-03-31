
class Movie {
    String title;
    String director;
    int year;
    double rating;

    Movie next;
    Movie prev;

    Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}


class MovieManagement {

    private Movie head = null;
    private Movie tail = null;

    // Add at beginning
    void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);

        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add at end
    void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);

        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Add at specific position (1-based index)
    void addAtPosition(int position, String title, String director, int year, double rating) {

        if (position <= 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        Movie temp = head;
        int count = 1;

        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null || temp.next == null) {
            addAtEnd(title, director, year, rating);
            return;
        }

        Movie newMovie = new Movie(title, director, year, rating);

        newMovie.next = temp.next;
        newMovie.prev = temp;
        temp.next.prev = newMovie;
        temp.next = newMovie;
    }

    // Remove movie by title
    void removeByTitle(String title) {

        if (head == null) {
            System.out.println("No movies available");
            return;
        }

        Movie temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {

                if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                }
                else if (temp == tail) {
                    tail = tail.prev;
                    tail.next = null;
                }
                else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }

                System.out.println("Movie removed successfully");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Movie not found");
    }

    // Search by director
    void searchByDirector(String director) {

        Movie temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No movie found for given director");
    }

    // Search by rating
    void searchByRating(double rating) {

        Movie temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.rating == rating) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No movie found with given rating");
    }

    // Update rating by title
    void updateRating(String title, double newRating) {

        Movie temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated successfully");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Movie not found");
    }

    // Display forward
    void displayForward() {

        if (head == null) {
            System.out.println("No movies available");
            return;
        }

        Movie temp = head;
        while (temp != null) {
            displayMovie(temp);
            temp = temp.next;
        }
    }

    // Display reverse
    void displayReverse() {

        if (tail == null) {
            System.out.println("No movies available");
            return;
        }

        Movie temp = tail;
        while (temp != null) {
            displayMovie(temp);
            temp = temp.prev;
        }
    }

    // Helper method
    private void displayMovie(Movie m) {
        System.out.println("Title: " + m.title +
                ", Director: " + m.director +
                ", Year: " + m.year +
                ", Rating: " + m.rating);
    }
}




public class MovieManagementSystem {

    public static void main(String[] args) {

        MovieManagement mm = new MovieManagement();

        mm.addAtEnd("Inception", "Christopher Nolan", 2010, 9.0);
        mm.addAtBeginning("Interstellar", "Christopher Nolan", 2014, 8.8);
        mm.addAtEnd("Avatar", "James Cameron", 2009, 8.5);
        mm.addAtPosition(2, "Titanic", "James Cameron", 1997, 9.1);

        System.out.println("\n--- Movies (Forward) ---");
        mm.displayForward();

        System.out.println("\n--- Movies (Reverse) ---");
        mm.displayReverse();

        System.out.println("\n--- Search by Director ---");
        mm.searchByDirector("James Cameron");

        System.out.println("\n--- Update Rating ---");
        mm.updateRating("Inception", 9.5);

        System.out.println("\n--- Delete Movie ---");
        mm.removeByTitle("Avatar");

        System.out.println("\n--- Final List ---");
        mm.displayForward();
    }
}
