package nl.tudelft.bw4t.scenariogui.controllers.editor;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import nl.tudelft.bw4t.scenariogui.gui.panel.MainPanel;

/**
 * Listens to the launch GUI checkboxes and updates
 * the {@link nl.tudelft.bw4t.scenariogui.BW4TClientConfig} object
 * with the update in the checkbox.
 * 
 * @author Nick
 *
 */
public class SelectLaunchGUIYes implements ItemListener {
    
    private MainPanel view;

    /**
     * Create a new listener to the select launch GUI checkboxes.
     * @param newView The parent view.
     */
    public SelectLaunchGUIYes(final MainPanel newView) {
        this.view = newView;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        view.getClientConfig().setLaunchGui(true);
    }

}
