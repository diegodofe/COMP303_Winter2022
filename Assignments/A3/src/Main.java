/**
 * @author Diego Dorantes-Ferreira 260854063
 */
public class Main {
    public static void main(String[] args) {

        /**
         * TEST CASE 1: Showcase Library creation
         * 
         * 
         * Client creates Singleton Library using getInstance() method, then changes the
         * Description
         * 
         */
        System.out.println("\nTEST CASE 1");
        Library myLibrary = Library.getInstance();
        myLibrary.setLibraryName("Diego's Library");
        myLibrary.setLibraryDescription(
                "This is a collection of my music. Mainly comprised of decent music and some podcast episodes.");
        System.out.println(myLibrary.getLibraryName());
        System.out.println(myLibrary.getLibraryDescription());

        /**
         * TEST CASE 2: Showcase adding Songs to Library
         * 
         * 
         * Client creates a few songs. Demonstrates flyweight design and equals method
         * as s1 and s2 both point to
         * the same Song object.
         * Therefore there are only two songs in the Library.
         * 
         */
        System.out.println("\nTEST CASE 2");
        Song s1 = Song.getSong("DIAMONDS", "RIHANNA");
        Song s2 = Song.getSong("DiAmoNdS", "riHannA");
        Song s3 = Song.getSong("Happy", "Pharrel Williams");

        myLibrary.addSong(s1);
        myLibrary.addSong(s2);
        myLibrary.addSong(s3);

        myLibrary.playEntireLibrary();

        /**
         * TEST CASE 3: Showcase adding Podcasts to Library
         * 
         * 
         * Client creates a few Podcasts. Demonstrates flyweight design and equals
         * method as p1 and p2 both point to
         * the same Song object.
         * Therefore there is only one Podcasts in the Library, and three episodes
         * total.
         * 
         */
        System.out.println("\nTEST CASE 3");
        Podcast p1 = Podcast.getPodcast("The Daily Show", "Trevor Noah");

        Episode e1 = Episode.getEpisode(p1, "Interview with Micheal Jordan", 360);
        Episode e2 = Episode.getEpisode(p1, "Interview with Lebron James", 361);

        Podcast p2 = Podcast.getPodcast("ThE DAiLy SHOw", "TreVoR noAH");

        Episode e3 = Episode.getEpisode(p2, "INTERVIEW WITH TOM BRADY", 362);
        Episode e4 = Episode.getEpisode(p2, "INTERVIEW with TOM Brady", 362);

        myLibrary.addPodcast(p1);
        myLibrary.addPodcast(p2);

        myLibrary.playEntireLibrary();

        /**
         * TEST CASE 4: Showcase comparing playlist and ensuring no duplicates in
         * Library
         * 
         * 
         * Client creates two playlists that are equal. Client then add one more new
         * song to
         * Playlist 1, and adds the playlist to the Library.
         * 
         * Library already contains all of the previous episodes and songs, except the
         * new song.
         * 
         * Before: Library contains 2 songs and 3 episodes.
         * After: Library contains 3 song and 3 epiodes.
         */
        System.out.println("\nTEST CASE 4");
        PlayList l1 = new PlayList("Playlist Number One");
        l1.addPlayable(s1);
        l1.addPlayable(s3);
        l1.addPlayable(e1);
        l1.addPlayable(e2);
        l1.addPlayable(e3);

        PlayList l2 = new PlayList("Playlist Number Two");
        l2.addPlayable(s2);
        l2.addPlayable(s3);
        l2.addPlayable(e1);
        l2.addPlayable(e2);
        l2.addPlayable(e4);

        // Compare the two playlists
        System.out.println(l1.equals(l2));

        // Add new song to Playlist 1
        Song s4 = Song.getSong("bohemian rhapsody", "queen");
        l1.addPlayable(s4);

        // Add Playlist to Library
        myLibrary.addPlayList(l1);

        // Play entire Library to see changes
        myLibrary.playEntireLibrary();

    }
}
