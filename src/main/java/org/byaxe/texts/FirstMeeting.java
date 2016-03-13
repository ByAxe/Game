package org.byaxe.texts;

public class FirstMeeting implements Runnable {

    String name;

    public FirstMeeting(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(6000);
            System.out.println("\n\t...You go downstairs and sends shivers up" +
                    " when your eyes watch at the darkness below your feet.\n");
            Thread.sleep(5000);
            System.out.println("\tThe end of the stairs... turn left... long corridor...\n");
            Thread.sleep(4000);
            System.out.println("\tYou merely see nothing except the dark-red light, that" +
                    " goes through the walls around...\n");
            Thread.sleep(5000);
            System.out.println("\tStop. What's that was? What is the sound forward of you?\n");
            Thread.sleep(4000);
            System.out.println("\tOh, that is the man. But... I see only madness in his eyes.\n");
            Thread.sleep(2500);
            System.out.println("\tIt's time to fight.");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
