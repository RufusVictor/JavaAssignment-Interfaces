import java.util.Scanner;

interface Playable {
    void play();
    void pause();
    void stop();
}

class MP3Player implements Playable {
    private boolean isPlaying = false;
    private boolean isPaused = false;

    public void play() {
        if (!isPlaying) {
            System.out.println("MP3 Player: Playing music...");
            isPlaying = true;
            isPaused = false;
        } else if (isPaused) {
            System.out.println("MP3 Player: Resuming playback...");
            isPaused = false;
        } else {
            System.out.println("MP3 Player: Already playing.");
        }
    }

    public void pause() {
        if (isPlaying && !isPaused) {
            System.out.println("MP3 Player: Music paused.");
            isPaused = true;
        } else if (isPaused) {
            System.out.println("MP3 Player: Already paused.");
        } else {
            System.out.println("MP3 Player: No music is playing to pause.");
        }
    }

    public void stop() {
        if (isPlaying || isPaused) {
            System.out.println("MP3 Player: Music stopped.");
            isPlaying = false;
            isPaused = false;
        } else {
            System.out.println("MP3 Player: No music is playing to stop.");
        }
    }
}

class CDPlayer implements Playable {
    private boolean isPlaying = false;
    private boolean isPaused = false;

    public void play() {
        if (!isPlaying) {
            System.out.println("CD Player: Playing CD...");
            isPlaying = true;
            isPaused = false;
        } else if (isPaused) {
            System.out.println("CD Player: Resuming playback...");
            isPaused = false;
        } else {
            System.out.println("CD Player: Already playing.");
        }
    }

    public void pause() {
        if (isPlaying && !isPaused) {
            System.out.println("CD Player: CD paused.");
            isPaused = true;
        } else if (isPaused) {
            System.out.println("CD Player: Already paused.");
        } else {
            System.out.println("CD Player: No CD is playing to pause.");
        }
    }

    public void stop() {
        if (isPlaying || isPaused) {
            System.out.println("CD Player: CD stopped.");
            isPlaying = false;
            isPaused = false;
        } else {
            System.out.println("CD Player: No CD is playing to stop.");
        }
    }
}

class StreamingPlayer implements Playable {
    private boolean isPlaying = false;
    private boolean isPaused = false;

    public void play() {
        if (!isPlaying) {
            System.out.println("Streaming Player: Streaming music...");
            isPlaying = true;
            isPaused = false;
        } else if (isPaused) {
            System.out.println("Streaming Player: Resuming stream...");
            isPaused = false;
        } else {
            System.out.println("Streaming Player: Already streaming.");
        }
    }

    public void pause() {
        if (isPlaying && !isPaused) {
            System.out.println("Streaming Player: Stream paused.");
            isPaused = true;
        } else if (isPaused) {
            System.out.println("Streaming Player: Already paused.");
        } else {
            System.out.println("Streaming Player: No stream is playing to pause.");
        }
    }

    public void stop() {
        if (isPlaying || isPaused) {
            System.out.println("Streaming Player: Stream stopped.");
            isPlaying = false;
            isPaused = false;
        } else {
            System.out.println("Streaming Player: No stream is playing to stop.");
        }
    }
}

public class MusicPlayerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Playable player = null;

        while (true) {
            System.out.println("\nSelect a music player:");
            System.out.println("1. MP3 Player");
            System.out.println("2. CD Player");
            System.out.println("3. Streaming Player");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();

            if (choice == 4) {
                System.out.println("Exiting...");
                break;
            }

            switch (choice) {
                case 1:
                    player = new MP3Player();
                    System.out.println("MP3 Player selected.");
                    break;
                case 2:
                    player = new CDPlayer();
                    System.out.println("CD Player selected.");
                    break;
                case 3:
                    player = new StreamingPlayer();
                    System.out.println("Streaming Player selected.");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    continue;
            }

            while (true) {
                System.out.println("\nChoose an action:");
                System.out.println("1. Play");
                System.out.println("2. Pause");
                System.out.println("3. Stop");
                System.out.println("4. Back to player selection");
                int action = scanner.nextInt();

                if (action == 4) {
                    break;
                }

                switch (action) {
                    case 1:
                        player.play();
                        break;
                    case 2:
                        player.pause();
                        break;
                    case 3:
                        player.stop();
                        break;
                    default:
                        System.out.println("Invalid action!");
                }
            }
        }
        scanner.close();
    }
}
