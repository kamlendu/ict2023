/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.Applet;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author root
 */
public class HelloApplet extends Applet {

    /**
     * Initialization method that will be called after the applet is loaded
     * into the browser.
     */
    public void init() {
        // TODO start asynchronous download of heavy resources
    }

    // TODO overwrite start(), stop() and destroy() methods

public void paint(Graphics g) {
    g.setFont(new Font("Arial",40,Font.BOLD));
    g.drawString("Hello Wrold of Plugins", 30, 30);
}


}
