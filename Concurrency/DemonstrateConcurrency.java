package Concurrency;


import java.util.Random;

class DownloadTask implements Runnable {

    @Override
    public void run() {

        Random random = new Random();

        System.out.println("Download Started...");

        for (int i = 1; i <= 10; i++) {

            try {
                Thread.sleep(700 + random.nextInt(400));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println(
                    Thread.currentThread().getName()
                            + " Downloaded "
                            + (i * 10)
                            + "%");
        }

        System.out.println("Download Completed");
    }
}

class MusicTask implements Runnable {

    String[] songs = {
            "Playing Intro...",
            "Playing Verse...",
            "Playing Chorus...",
            "Playing Solo...",
            "Playing Outro..."
    };

    @Override
    public void run() {

        try {

            for (String song : songs) {

                System.out.println(Thread.currentThread().getName()
                        + " : " + song);

                Thread.sleep(1200);
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Music Finished");
    }
}

class UiTask implements Runnable {

    @Override
    public void run() {

        try {

            for (int i = 1; i <= 20; i++) {

                System.out.println(
                        Thread.currentThread().getName()
                                + " Updating UI..."
                );

                Thread.sleep(500);
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("UI Update Finished");
    }
}

public class DemonstrateConcurrency {

    public static void main(String[] args) throws InterruptedException {

        Thread downloadThread = new Thread(
                new DownloadTask(),
                "Downloader"
        );

        Thread musicThread = new Thread(
                new MusicTask(),
                "Music Player"
        );

        Thread uiThread = new Thread(
                new UiTask(),
                "UI Thread"
        );

        downloadThread.start();
        musicThread.start();
        uiThread.start();

        downloadThread.join();
        musicThread.join();
        uiThread.join();

        System.out.println("\nApplication Finished Successfully");
    }

    
}