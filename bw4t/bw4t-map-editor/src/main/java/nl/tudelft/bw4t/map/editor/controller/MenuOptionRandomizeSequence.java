package nl.tudelft.bw4t.map.editor.controller;

import java.awt.event.ActionEvent;

import nl.tudelft.bw4t.map.editor.gui.AbstractMenuOption;
import nl.tudelft.bw4t.map.editor.gui.MenuBar;

public class MenuOptionRandomizeSequence extends AbstractMenuOption {

	public MenuOptionRandomizeSequence(MenuBar newView,
			EnvironmentStoreController controller) {
		super(newView, controller);
	}
	
    /**
     * Gets called when the menu item Randomize Sequence as is pressed.
     *
     * @param e The action event.
     */
    public void actionPerformed(final ActionEvent e) {
        System.out.println("Randomize sequence called");
    }

}