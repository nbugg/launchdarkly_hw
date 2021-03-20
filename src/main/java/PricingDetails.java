import com.launchdarkly.sdk.LDUser;
import com.launchdarkly.sdk.server.LDClient;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;

public class PricingDetails {

    static final String FEATURE_FLAG_KEY = "mic-check";

    public static String showPricelist(LDClient client, LDUser user) {

        boolean showFeature = client.boolVariation(FEATURE_FLAG_KEY, user, false);
        System.out.println("Feature flag '" + FEATURE_FLAG_KEY + "' is " + showFeature + " for this user");

        JFrame frame = new JFrame("Pricelist");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = frame.getContentPane();
        JTextPane pane = new JTextPane();
        SimpleAttributeSet attributeSet = new SimpleAttributeSet();
        StyleConstants.setItalic(attributeSet, true);
        StyleConstants.setForeground(attributeSet, Color.black);
        pane.setCharacterAttributes(attributeSet, true);
        pane.setContentType("text/html");


        StringBuilder pricelist = new StringBuilder();

        pricelist.append("<table style='width:50%'>");

        if (showFeature) {

            pricelist.append("<tr><th>Item</th><th>Component</th><th>Price</th>");
            pricelist.append("<tr><td>Item A</td><td></td><td>$17.00</td></tr>");
            pricelist.append("<tr><td></td><td>A1</td><td>$12.35</td></tr>");
            pricelist.append("<tr><td></td><td>A2</td><td>$4.65</td></tr>");
            pricelist.append("<tr><td>Item B</td><td></td><td>$18.00</td></tr>");
            pricelist.append("<tr><td></td><td>B1</td><td>$11.47</td></tr>");
            pricelist.append("<tr><td></td><td>B2</td><td>$3.53</td></tr>");
            pricelist.append("<tr><td></td><td>B3</td><td>$3.00</td></tr>");
            pricelist.append("<tr><td>Item C</td><td></td><td>$15.00</td></tr>");
            pricelist.append("<tr><td></td><td>C1</td><td>$9.80</td></tr>");
            pricelist.append("<tr><td></td><td>C2</td><td>$2.07</td></tr>");
            pricelist.append("<tr><td></td><td>C3</td><td>$3.13</td></tr>");
            pricelist.append("<tr><td>Total</td><td></td><td>$50.00</td></tr>");


        } else {

            pricelist.append("<tr><th>Item</th><th>Price</th>");
            pricelist.append("<tr><td>Item A</td><td>$17.00</td></tr>");
            pricelist.append("<tr><td>Item B</td><td>$18.00</td></tr>");
            pricelist.append("<tr><td>Item C</td><td>$15.00</td></tr>");
            pricelist.append("<tr><td>Total</td><td>$50.00</td></tr>");

        }

        pricelist.append("</table>");
        pane.setText(pricelist.toString());
        JScrollPane scrollPane = new JScrollPane(pane);
        container.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(500, 500);
        frame.setVisible(true);


        return null;
    }
}
