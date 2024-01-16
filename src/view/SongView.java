package view;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.io.*;

import controller.SongController;
import model.Song;
import repository.SongsRepository;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class SongView extends JFrame {
    private InputStream is;

    private Player player;
    private boolean repeat;
    private boolean paused;
    private long pauseLocation;
    private long totalSongLength;
    String musicFilePath;
    JFileChooser fileChooser;
    FileInputStream fileInputStream;
    BufferedInputStream bufferedInputStream;
    //Player player;
    Long totalLength;
    Long pauseLength;
    File defaultDirectory;

    String fileName;
    File selectedFile;

    private Clip clip;
    SongsRepository songsRepository = new SongsRepository();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel0 = new JPanel();
    JPanel panel3 = new JPanel();

    Song song = new Song(0, null, 0, 0);
    JLabel songTitle = new JLabel();
    String durationString;
    JLabel songDuration = new JLabel();
    JLabel playing = new JLabel("Playing...");

    JButton playButton = new JButton("Play");
    JButton stopButton = new JButton("Stop");
    JButton pauseButton = new JButton("Pause");
    JButton resumeButton = new JButton("Resume");
    JButton backButton = new JButton("<--");
    JFrame frame = new JFrame("Spotify Wannabe");
    Thread playThread;
    Thread resumeThread;
    JLabel albumLabel = new JLabel();
    String album1 = "src/view/reputation.jpg";
    String album2 = "src/view/folk.jpg";
    String album3 = "src/view/beautybehind.jpg";
    String album4 = "src/view/guts_1_20.jpg";
    String album5 = "src/view/The_life_of_pablo_alternate.jpg";
    String album6 = "src/view/6a4e8da0-6c3a-11ee-9f0c-a1ec7dc8d3c8.jpg";
    String album7 = "src/view/freewheelinbob.jpg";
    JButton button = new JButton();
    ImageIcon icon = new ImageIcon();
    JButton likeSong = new JButton("Like");
    JLabel label = new JLabel();
    File file;
    String song1 = "src/view/Taylor Swift - ...Ready For It_ (Audio).mp3";
    String song2 = "src/view/Taylor Swift - End Game ft. Ed Sheeran, Future.mp3";
    String song3 = "src/view/Taylor Swift - I Did Something Bad (Lyrics).mp3";
    String song4 = "src/view/Dont Blame Me.mp3";
    String song5 = "src/view/Taylor Swift - Delicate.mp3";
    String song6 = "src/view/Taylor Swift - Look What You Made Me Do.mp3";
    String song7 = "src/view/Taylor Swift - the 1 (Official Lyric Video).mp3";
    String song8 = "src/view/Taylor Swift - cardigan.mp3";
    String song9 = "src/view/Taylor Swift - the last great american dynasty (Official Lyric Video).mp3";
    String song10 = "src/view/Taylor Swift  mirrorball (Official Lyric Video).mp3";
    String song11 = "src/view/Real Life.mp3";
    String song12 = "src/view/Losers.mp3";
    String song13 = "src/view/The Weeknd - Tell Your Friends (Official Video).mp3";
    String song14 = "src/view/The Weeknd - Often (NSFW) (Official Video).mp3";
    String song15 = "src/view/Olivia Rodrigo - all-american bitch (Official Lyric Video).mp3";
    String song16 = "src/view/Olivia Rodrigo - bad idea right_ (Official Lyric Video).mp3";
    String song17 = "src/view/Olivia Rodrigo - get him back! (Official Lyric Video).mp3";
    String song18 = "src/view/Ultralight Beam.mp3";
    String song19 = "src/view/Father Stretch My Hands Pt. 1.mp3";
    String song20 = "src/view/Pt. 2.mp3";
    String song24 = "src/view/Mitski - Bug Like an Angel (Official Music Video).mp3";
    String song25 = "src/view/Mitski - Buffalo Replaced (Official Lyric Video).mp3";
    String song26 = "src/view/Mitski - Heaven (Official Lyric Video).mp3";
    String song27 = "src/view/Bob Dylan - Blowin in the Wind (Official Audio).mp3";
    String song28 = "src/view/Bob Dylan - Down the Highway (Official Audio).mp3";
    String song29 = "src/view/Bob Dylan - Dont Think Twice, Its All Right (Official Audio).mp3";

    Integer songId;

    public SongView(SongController controller, String title) {
        //super("Image from Database in Swing Example");

        //controller.setView(this);
        frame.setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button.setSize(100000, 100000);
        song = songsRepository.songPage(title);
        ////////////////////////////////////////////
        songId = song.getId();
        if (songId == 1) {
            musicFilePath = song1;
        } else if (songId == 2) {
            musicFilePath = song2;
        } else if (songId == 3) {
            musicFilePath = song3;
        } else if (songId == 29) {
            musicFilePath = song29;
        } else if (songId == 4) {
            musicFilePath = song4;
        } else if (songId == 5) {
            musicFilePath = song5;
        } else if (songId == 6) {
            musicFilePath = song6;
        } else if (songId == 7) {
            musicFilePath = song7;
        } else if (songId == 8) {
            musicFilePath = song8;
        } else if (songId == 9) {
            musicFilePath = song9;
        } else if (songId == 10) {
            musicFilePath = song10;
        } else if (songId == 11) {
            musicFilePath = song11;
        } else if (songId == 12) {
            musicFilePath = song12;
        } else if (songId == 13) {
            musicFilePath = song13;
        } else if (songId == 14) {
            musicFilePath = song14;
        } else if (songId == 15) {
            musicFilePath = song15;
        } else if (songId == 16) {
            musicFilePath = song16;
        } else if (songId == 17) {
            musicFilePath = song17;
        } else if (songId == 18) {
            musicFilePath = song18;
        } else if (songId == 19) {
            musicFilePath = song19;
        } else if (songId == 20) {
            musicFilePath = song20;
        } else if (songId == 24) {
            musicFilePath = song24;
        } else if (songId == 25) {
            musicFilePath = song25;
        } else if (songId == 26) {
            musicFilePath = song26;
        } else if (songId == 27) {
            musicFilePath = song27;
        } else if (songId == 28) {
            musicFilePath = song28;
        }
        ////////


        songTitle.setText(title);
        durationString = song.getDuration().toString();
        songDuration.setText(durationString);
        // Replace with the actual ID of the image in the database
        int imageId = song.getAlbumId();
        if (imageId == 1) {
            icon = createImageIcon(album1);
        } else if (imageId == 2) {
            icon = createImageIcon(album2);
        } else if (imageId == 3) {
            icon = createImageIcon(album7);
        } else if (imageId == 4) {
            icon = createImageIcon(album4);
        } else if (imageId == 5) {
            icon = createImageIcon(album5);
        } else if (imageId == 6) {
            icon = createImageIcon(album6);
        } else if (imageId == 7) {
            icon = createImageIcon(album3);
        }

        // Set the ImageIcon to the JLabel
        //ImageIcon imageIcon = retrieveImageFromDatabase(url, username, password, imageId);
        //imageLabel.setIcon(imageIcon);
        // Set the frame size
        //pack();
        //setLocationRelativeTo(null); // Center the frame
        //setVisible(true);

        label.setIcon(icon);

        /*fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Mp3 files", "mp3"));

        fileChooser.setCurrentDirectory(new File(path));
        selectedFile = fileChooser.getSelectedFile();
        fileName = selectedFile.getName();*/


        playButton.addActionListener(e -> playButtonClicked(musicFilePath));
        stopButton.addActionListener(e -> stopButtonClicked());

        //playButton.addActionListener(e -> );
        //stopButton.addActionListener(e -> this.stopAudio());
        backButton.addActionListener(e -> controller.backButtonClicked());
        songTitle.setText(title);
        panel0.add(backButton);
        panel1.add(label);
        panel2.add(songTitle);
        panel2.add(songDuration);
        panel3.add(playing);
        panel3.add(playButton);
        panel3.add(stopButton);

        JPanel panel = new JPanel();
        panel.add(panel0);
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);

        frame.setContentPane(panel);
        frame.setVisible(true);
        //pack();
        //setLocationRelativeTo(null); // Center the frame
        //setVisible(true);
    }

    public void playButtonClicked(String path)  {
        try {

            fileInputStream = new FileInputStream(path);
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            player = new Player(bufferedInputStream);

            // Create a new thread to play the audio
            Thread playerThread = new Thread(() -> {
                try {
                    player.play();
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                }
            });

            playerThread.start();

        } catch (IOException | JavaLayerException exception) {
            exception.printStackTrace();
        }

    }
    public void stopButtonClicked() {
        if (player != null) {
            player.close();
        }
    }
    private ImageIcon createImageIcon(String imagePath) {
        try {
            return new ImageIcon(ImageIO.read(new File(imagePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setVisibility(boolean isVisible) {
        frame.setVisible(isVisible);
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(frame, message, "Swing Tester", JOptionPane.ERROR_MESSAGE);
    }
    public void play( String musicFilePath ) throws JavaLayerException, IOException
    {

        this.musicFilePath = musicFilePath;

        is = this.getClass().getResourceAsStream( musicFilePath );

        totalSongLength =  is.available();

        player = new Player( is );

        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    player.play();

                    if( player.isComplete() && repeat )
                    {
                        play( musicFilePath );
                    }


                }
                catch ( JavaLayerException | IOException ex)
                {
                    System.err.println("::: there was an error to play " + musicFilePath );
                }
            }////
        }.start();///

    }//

    /**
     * use this method to remuse current paused song
     * @throws FileNotFoundException
     * @throws JavaLayerException
     * @throws IOException
     * @throws java.net.URISyntaxException
     */
    public void resume( ) throws JavaLayerException, IOException
    {

        paused = false;

        is = this.getClass().getResourceAsStream( musicFilePath );

        is.skip( totalSongLength - pauseLocation );

        player = new Player( is );

        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    player.play();
                }
                catch (JavaLayerException ex)
                {
                    System.err.println("::: there was an error to play " + musicFilePath );
                }
            }////
        }.start();///

    }//



    /**
     * use this method to stop current song that is being
     * played
     */
    public void stop()
    {
        paused = false;

        if( null != player)
        {
            player.close();

            totalSongLength = 0;
            pauseLocation = 0;
        }///

    }//

    /**
     * use this method to pause current played song
     */
    public void pause()
    {

        paused = true;
        if( null != player)
        {
            try
            {
                pauseLocation = is.available();
                player.close();
            }
            catch (IOException ex)
            {
                System.out.println("::: error when song is paused");
            }

        }///

    }//

    /**
     *
     * @return true if the song i will start once is done,
     * false if not
     */
    public boolean isRepeat() {
        return repeat;
    }

    /**
     * set if the song will start once is done
     * @param repeat
     */
    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    /*private void playButtonClicked() {
        try {
            // Replace "your_file_path.mp3" with the actual file path
            fileInputStream = new FileInputStream(path);
            player = new Player(fileInputStream);

            new Thread(() -> {
                try {
                    player.play();
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException | JavaLayerException exception) {
            exception.printStackTrace();
        }
    }

    private void stopButtonClicked() {
        if (player != null) {
            player.close();
            player = null;
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*public void playButtonClicked() {
        if (path != null) {

            playThread = new Thread(runnablePlay);
            playThread.start();

        }
    }

    public void pauseButtonClicked() {
        if (player != null && fileName != null) {
            try {
                pauseLength = (long) fileInputStream.available();
                player.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void resumeButtonClicked() {
        if (path != null) {
            resumeThread = new Thread(runnableResume);
            resumeThread.start();
        }
    }

    public void stopButtonClicked() {
        if (player != null) {
            player.close();
        }
    }

    Runnable runnablePlay = new Runnable() {
        @Override
        public void run() {
            try {
                // Code for play button
                fileInputStream = new FileInputStream(path);
                bufferedInputStream = new BufferedInputStream(fileInputStream);
                player = new Player(bufferedInputStream);
                totalLength = (long) fileInputStream.available();
                player.play(); // Starting music
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    Runnable runnableResume = new Runnable() {
        @Override
        public void run() {
            try {
                // Code for resume button
                fileInputStream = new FileInputStream(path);
                bufferedInputStream = new BufferedInputStream(fileInputStream);
                player = new Player(bufferedInputStream);
                fileInputStream.skip(totalLength - pauseLength);
                player.play();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    /*public void actionPerformed(ActionEvent e) throws IOException {


        if (e.getSource().equals(playButton)) {
            //starting play thread
            if (path != null) {
                playThread = new Thread(runnablePlay);
                playThread.start();

            }
            if (e.getSource().equals(pauseButton)) {
                //code for pause button
                if (player != null && fileName != null) {
                    try {
                        pauseLength = (long) fileInputStream.available();
                        player.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }

            if (e.getSource().equals(resumeButton)) {
                //starting resume thread
                if (path != null) {
                    resumeThread = new Thread(runnableResume);
                    resumeThread.start();
                }
            }
            if (e.getSource().equals(stopButton)) {
                //code for stop button
                if (player != null) {
                    player.close();
                }

            }

        }


    }*/
}
