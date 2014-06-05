package nl.tudelft.bw4t.client.gui.listeners;

import eis.exceptions.ActException;
import eis.iilang.Percept;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import nl.tudelft.bw4t.client.controller.ClientController;
import nl.tudelft.bw4t.client.startup.Launcher;
import org.apache.log4j.Logger;

/**
 * ActionListener that performs the put down action when that command is pressed
 * in the pop up menu
 * 
 * @author trens
 */
public class PutdownActionListener extends AbstractClientActionListener {
    /** Logger to report error messages to. */
    private static final Logger LOGGER = Logger.getLogger(GoToBlockActionListener.class);

    /** @param controller - The {@link ClientController} to listen to and interact with. */
    public PutdownActionListener(ClientController controller) {
        super(controller);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!Launcher.getEnvironment().isConnectedToGoal()) {
            try {
                getController().getHumanAgent().putDown();
            } catch (ActException e1) {
            	LOGGER.error(e1);
            }
        } else {
            LinkedList<Percept> percepts = new LinkedList<Percept>();
            Percept percept = new Percept("putDown");
            percepts.add(percept);
            getController().setToBePerformedAction(percepts);
        }
    }
}
