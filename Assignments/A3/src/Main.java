public class Main {
    public static void main(String[] args) {
        // TASK: Write runner code to show your work

        // Showcase Library creation
        System.out.println("\nTEST CASE 1");
        Library myLibrary = Library.getInstance();
        myLibrary.setLibraryDescription("This is a collection of my music. Mainly comprised of Rock and Dubstep.");
        System.out.println(myLibrary.getLibraryName());
        System.out.println(myLibrary.getLibraryDescription());

        // Showcase adding Songs to Library
        System.out.println("\nTEST CASE 2");
        Song s1 = Song.getSong("DIAMONDS", "RIHANNA");
        Song s2 = Song.getSong("DiAmoNdS", "riHannA");
        Song s3 = Song.getSong("Happy", "Pharrel Williams");

        myLibrary.addSong(s1);
        myLibrary.addSong(s2);
        myLibrary.addSong(s3);

        myLibrary.mySongs.forEach((song) -> System.out.println(song));

        // Showcase adding Podcast to Library
        System.out.println("\nTEST CASE 3");
        Podcast p1 = Podcast.getPodcast("Experience", "Joe Rogan");
        Podcast p2 = Podcast.getPodcast("EXPERIENCE", "jOe rOgAn");
        Podcast p3 = Podcast.getPodcast("MTLNews", "CTV");

        myLibrary.addPodcast(p1);
        myLibrary.addPodcast(p2);
        myLibrary.addPodcast(p3);

        myLibrary.myPodcasts.forEach((podcast) -> System.out.println(podcast));

        // Showcase Episodes all added to the same podcast.
        System.out.println("\nTEST CASE 4");

        Podcast p4 = Podcast.getPodcast("The Daily Show", "Trevor Noah");

        Episode e1 = Episode.getEpisode(p4, "Interview with Micheal Jordan", 360);
        Episode e2 = Episode.getEpisode(p4, "Interview with Lebron James", 361);
        Episode e3 = Episode.getEpisode(p4, "INTERVIEW WITH TOM BRADY", 362);
        Episode e4 = Episode.getEpisode(p4, "INTERVIEW with TOM Brady", 362);

        p4.episodeList();

        // Showcase comparing playlists
        System.out.println("\nTEST CASE 5");
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

        System.out.println(l1.equals(l2));

    }
}
