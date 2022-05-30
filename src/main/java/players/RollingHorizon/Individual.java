package players.RollingHorizon;

import java.util.List;

import javax.swing.Action;

import core.AbstractGameState;
import core.actions.AbstractAction;
import games.dicemonastery.components.ForageCard;
import games.pandemic.PandemicGameState;
import games.pandemic.PandemicForwardModel;

public class Individual {
    List <AbstractAction> genes;
    public PandemicGameState estadoDeJuego;
    char id;
    List<AbstractAction> AccionesDisponibles;
    
    public Individual(char nombre, AbstractGameState asignarJuego)
    {
        this.id = nombre;
        AccionesDisponibles = _computeAvailableActions(asignarJuego);
        //asigna jugadas a la lista de genes
        for(int i =0; i<=6; i++)
        {
            this.genes.add();
        }

    }
}

