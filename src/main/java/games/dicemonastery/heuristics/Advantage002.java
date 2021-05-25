package games.dicemonastery.heuristics;

import core.AbstractGameState;
import core.AbstractPlayer;
import core.actions.AbstractAction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

import static java.util.stream.Collectors.toList;

public class Advantage002 extends AbstractPlayer {

    Random rnd = new Random(System.currentTimeMillis());

    private double RND_WEIGHT;

    Map<Integer, Double> actionAdvantage = new HashMap<>();

    public Advantage002() {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("Advantage002.csv"));
            String weight = reader.readLine();
            RND_WEIGHT = Double.parseDouble(weight);
            reader.readLine();
            // we expect two columns; hash and advantage estimate

            //   List<List<Double>> data = new ArrayList<>();
            String nextLine = reader.readLine();
            while (nextLine != null) {
                List<Double> data = Arrays.stream(nextLine.split(",")).map(Double::valueOf).collect(toList());

                int hash = data.get(0).intValue();
                double advantage = data.get(1);
                actionAdvantage.put(hash, advantage);
                nextLine = reader.readLine();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public AbstractAction getAction(AbstractGameState gameState, List<AbstractAction> possibleActions) {

        double bestValue = Double.NEGATIVE_INFINITY;
        AbstractAction retValue = possibleActions.get(0);
        for (AbstractAction action : possibleActions) {
            double actionValue = actionAdvantage.getOrDefault(action.hashCode(), 0.0) + rnd.nextDouble() * RND_WEIGHT;
            if (actionValue > bestValue) {
                retValue = action;
                bestValue = actionValue;
            }
        }
        return retValue;
    }
}
