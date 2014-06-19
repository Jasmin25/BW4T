package nl.tudelft.bw4t.scenariogui.botstore.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import nl.tudelft.bw4t.map.EntityType;
import nl.tudelft.bw4t.scenariogui.botstore.gui.BotEditorPanel;

/**
 * Handles actions of the resetbutton
 */
public class ResetButton implements ActionListener {
    /**
     * The panel containing the button.
     */
    private BotEditorPanel view;
    /**
     * Constructor.
     * @param pview The panel of the jump box.
     */
    public ResetButton(BotEditorPanel pview) {
        this.view = pview;
    }
    /**
     * Resets all parts of the bot editor panel
     * to their standard value.
     * @param ae The action event causing this.
     */
    public void actionPerformed(ActionEvent ae) {
    	view.getBotController().getBotConfig().setBotSpeed(100);
    	view.getBotController().getBotConfig().setBotSize(2);
    	view.getBatterySlider().setEnabled(false);
    	view.getBotController().getBotConfig().setBotBatteryDischargeRate(0);
    	view.updateView();
    }   
}