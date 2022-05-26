package players.RollingHorizon;

import core.AbstractForwardModel;
import core.AbstractGameState;
import core.AbstractPlayer;
import core.actions.AbstractAction;

import java.util.List;
import java.util.Random;

public class RollingHorizonPlayer extends AbstractPlayer {

    private final Random rhea;
    
    //contructor de jugador
    public RollingHorizonPlayer()
    {
        this(new RollingHorizonPlayer());
    }

    //metodo abstracto de conseguir accion, cambiar en un futuro
    @Override
    public AbstractAction getAction(AbstractGameState observation, List<AbstractAction> actions) {
        int randomAction = rhea.nextInt(actions.size()); //elige una accion random con el metodo nextInt de Java util random
        return actions.get(randomAction);
    }

    @Override
    public AbstractPlayer copy() {
        // TODO Auto-generated method stub
        return null;
    }
}
