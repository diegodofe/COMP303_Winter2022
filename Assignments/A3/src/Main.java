public class Main {
    public static void main(String[] args) {
        // TASK: Write runner code to show your work

        // Showcase Library creation

        Library myLibrary = Library.getInstance();

        myLibrary.setLibraryDescription("This is a collection of my music. Mainly comprised of Rock and Dubstep.");
        System.out.println(myLibrary.getLibraryName());
        System.out.println(myLibrary.getLibraryDescription());

        // Showcase adding Songs to Library
        Song s1 = Song.getSong("DIAMONDS", "RIHANNA");
        Song s2 = Song.getSong("DiAmoNdS", "riHannA");
        Song s3 = Song.getSong("Happy", "Pharrel Williams");

        myLibrary.addSong(s1);
        myLibrary.addSong(s2);
        myLibrary.addSong(s3);

        myLibrary.mySongs.forEach((song) -> System.out.println(song.getTitle() + " " + song.getArtist()));


        // Showcase adding Podcast to Library
        Podcast p1 = Podcast.getPodcast("Experience", "Joe Rogan");
        Podcast p2 = Podcast.getPodcast("EXPERIENCE", "jOe rOgAn");
        Podcast p3 = Podcast.getPodcast("MTLNews", "CTV");

        myLibrary.addPodcast(p1);
        myLibrary.addPodcast(p2);
        myLibrary.addPodcast(p3);

        myLibrary.myPodcasts.forEach((podcast) -> System.out.println(podcast.getName() + " " + podcast.getHost()));


        //Showcase PLaylist
        PlayList l1 = new PlayList("Playlist Number One");
        l1.addPlayable(s1);
        l1.addPlayable(s3);

        PlayList l2 = new PlayList("Playlist Number Two");
        l2.addPlayable(s2);
        l2.addPlayable(s3);

        System.out.println(l1.equals(l2));
    }
}
