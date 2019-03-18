import javax.swing.*;
import java.awt.*;

/**
 * Portscanner;
 *
 * Copyright by @author Marcel Mertens
 * Website: https://mertens-web.ddns.net
 *
 * Date: 17.03.2019
 */

public class Main
{
    public static void main(String[] args) {

        //Variables
        int zStartPort = 0;
        int zEndPort = 0;

        JTextField zHostInput = new JTextField();
        JTextField zStartPortInput = new JTextField();
        JTextField zEndPortInput = new JTextField();

        Object[] window = {"Host", zHostInput, "Start Port", zStartPortInput, "End Port", zEndPortInput};

        //Input Dialog
        JOptionPane panel = new JOptionPane( window,
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.OK_CANCEL_OPTION);
        Dialog zDialog = panel.createDialog(null, "Scan Host");
        zDialog.setVisible(true);

        // Read Values from Inputfields
        String zHost = zHostInput.getText();

        try
        {
            zStartPort = Integer.parseInt(zStartPortInput.getText());
        }
        catch (Exception ex)
        {
            System.exit(-1);
        }

        try
        {
            zEndPort = Integer.parseInt(zEndPortInput.getText());
        }
        catch (Exception ex)
        {
            System.exit(-1);
        }

        //Create new Portscanner Object
        Portscanner scanner = new Portscanner(zHost, zStartPort, zEndPort);

        //Close window for exit code 0
        ((JDialog) zDialog).dispose();
    }
}
