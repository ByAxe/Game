import creations.ICreation;

import static data.SystemData.QUESTION_FIGHT_OR_RUN;
import static regular.expression.RegExp.FIGHT_IF_TRUE;
import static regular.expression.RegExp.checkOnPattern;

public class Cycle {

    public void choice(final String answer, final ICreation hero) {
        switch (answer) {
            case "a":
                ifHasEntered(hero);
                break;

            case "b":
                hero.checkInventory();
                break;

            case "c":
                    /*TODO Add save logic*/
                break;
        }

    }

    private void ifHasEntered(final ICreation hero) {
        System.out.println(hero.enter());
        if (checkOnPattern(QUESTION_FIGHT_OR_RUN, FIGHT_IF_TRUE)) hero.startBattle();
        else hero.escape();
    }
}