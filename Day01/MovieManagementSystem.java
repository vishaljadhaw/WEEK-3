class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

public class MovieManagementSystem {
    private Movie head;
    private Movie tail;

    // Add a movie record at the beginning
    public void addMovieAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add a movie record at the end
    public void addMovieAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Add a movie record at a specific position
    public void addMovieAtPosition(String title, String director, int year, double rating, int position) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (position == 0) {
            addMovieAtBeginning(title, director, year, rating);
        } else {
            Movie current = head;
            for (int i = 0; i < position - 1; i++) {
                if (current != null) {
                    current = current.next;
                } else {
                    throw new IndexOutOfBoundsException("Position out of bounds");
                }
            }
            newMovie.next = current.next;
            newMovie.prev = current;
            if (current.next != null) {
                current.next.prev = newMovie;
            }
            current.next = newMovie;
            if (newMovie.next == null) {
                tail = newMovie;
            }
        }
    }

    // Remove a movie record by Movie Title
    public void removeMovieByTitle(String title) {
        if (head == null) return;
        if (head.title.equals(title)) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
            return;
        }
        Movie current = head;
        while (current != null && !current.title.equals(title)) {
            current = current.next;
        }
        if (current != null) {
            if (current.prev != null) {
                current.prev.next = current.next;
            }
            if (current.next != null) {
                current.next.prev = current.prev;
            }
            if (current == tail) {
                tail = current.prev;
            }
        }
    }

    // Search for a movie record by Director
    public Movie searchMovieByDirector(String director) {
        Movie current = head;
        while (current != null) {
            if (current.director.equals(director)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Search for a movie record by Rating
    public Movie searchMovieByRating(double rating) {
        Movie current = head;
        while (current != null) {
            if (current.rating == rating) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Display all movie records in forward order
    public void displayAllMoviesForward() {
        Movie current = head;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director + 
                               ", Year: " + current.year + ", Rating: " + current.rating);
            current = current.next;
        }
    }

    // Display all movie records in reverse order
    public void displayAllMoviesReverse() {
        Movie current = tail;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director + 
                               ", Year: " + current.year + ", Rating: " + current.rating);
            current = current.prev;
        }
    }

    // Update a movie's rating based on the Movie Title
    public void updateMovieRating(String title, double newRating) {
        Movie movie = searchMovieByDirector(title);  // Using search by title instead of director
        if (movie != null) {
            movie.rating = newRating;
        }
    }

    public static void main(String[] args) {
        MovieManagementSystem mms = new MovieManagementSystem();
        
        mms.addMovieAtEnd("Inception", "Christopher Nolan", 2010, 8.8);
        mms.addMovieAtBeginning("The Matrix", "Wachowski Brothers", 1999, 8.7);
        mms.addMovieAtPosition("Interstellar", "Christopher Nolan", 2014, 8.6, 1);

        System.out.println("All Movies (Forward):");
        mms.displayAllMoviesForward();

        System.out.println("\nAll Movies (Reverse):");
        mms.displayAllMoviesReverse();

        System.out.println("\nSearching for Movies Directed by 'Christopher Nolan':");
        Movie movie = mms.searchMovieByDirector("Christopher Nolan");
        if (movie != null) {
            System.out.println("Found: Title: " + movie.title + ", Director: " + movie.director + 
                               ", Year: " + movie.year + ", Rating: " + movie.rating);
        } else {
            System.out.println("Movie not found");
        }

        System.out.println("\nUpdating Rating for 'Interstellar':");
        mms.updateMovieRating("Interstellar", 9.0);
        mms.displayAllMoviesForward();

        System.out.println("\nRemoving Movie 'The Matrix':");
        mms.removeMovieByTitle("The Matrix");
        mms.displayAllMoviesForward();
    }
}
