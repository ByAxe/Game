package org.byaxe.texts;

public class Introduction implements Runnable {

    String name;

    public Introduction(String name) {
        this.name = name;
    }

    public void run() {
        try {
            System.out.println("\n\t..Once your teacher said to you: while you won't be perfect -" +
                    " you won't become a King.\n");
            Thread.sleep(4000);
            System.out.println("\tOnly the blood can make you strong enough for this...\n");
            Thread.sleep(4000);
            System.out.println("\tOnly the blood of your enemies on your weapon and face.\n");
            Thread.sleep(4000);
            System.out.println("\tGo ahead, young hero and you will find your own way.\n");
            Thread.sleep(3000);
            System.out.println("\tAt first - clear the labyrinth. It will be your first attempt to become an adult man...\n\t");
            Thread.sleep(3000);
            System.out.println("\n..after a while..\n");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
