import creations.ICreation;

public class Cycle {

    public void choice(final String answer, final ICreation hero) {
        switch (answer) {
            case "a":
                ifEntered(hero);
                break;

            case "b":
                hero.checkInventory();
                /*TODO hero wants to change equipment?*/
                break;

            case "c":
                    /*TODO Add save logic*/
                break;
        }

    }

    private void ifEntered(final ICreation hero) {
        System.out.println(hero.enter());
        hero.startBattle();
    }
}