package nl.tudelft.bw4t.scenariogui.controllers.editor;

import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import nl.tudelft.bw4t.scenariogui.BW4TClientConfig;
import nl.tudelft.bw4t.scenariogui.gui.panel.MainPanel;

/**
 * Handles the event to update the epartner count.
 * 
 * @author Seu Man To
 * @version 0.1
 * @since 05-06-2014
 */
public class UpdateEPartnerCount implements TableModelListener {
	private MainPanel view;
	private BW4TClientConfig model;
	
	/**
	 * Create an UpdateEPartnerCount event handler.
	 * @param newView The parent view.
	 * @param model The model.
	 */
	public UpdateEPartnerCount(final MainPanel newView, BW4TClientConfig model) {
		this.view = newView;
		this.model = model;
	}
	
	/**
	 * Executes action that needs to happen when the epartner table changes.
     *
     * @param e The action.
	 */
	@Override
	public void tableChanged(TableModelEvent e) {
	    SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
    		model.updateAmountEPartner();
    		view.getEntityPanel().updateEPartnerCount(model.getAmountEPartner());
	        }
	    });
	}
}
