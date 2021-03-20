import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;

public class Settings {

    public static LinkedHashMap<String, String> chooseSettings() {

        JFrame frame = new JFrame("FrameDemo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel label = new JLabel("Settings");
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

        Object[] users = {"anna@example.com", "bob@example.com", "chris@example.com"};
        java.lang.String selectedUser = (java.lang.String) JOptionPane.showInputDialog(frame, "Pick a user:", "User Options",
                JOptionPane.OK_CANCEL_OPTION, null, users, users[0]);

        Object[] environments = {"Production", "Test"};
        java.lang.String selectedEnvironment = (java.lang.String) JOptionPane.showInputDialog(frame, "Pick an environment:", "Project Options",
                JOptionPane.OK_CANCEL_OPTION, null, environments, environments[1]);

        frame.dispose();

        LinkedHashMap<String, String> returnMap = new LinkedHashMap<String, String>();
        returnMap.put("user", selectedUser);
        returnMap.put("key", getSDKKey(selectedEnvironment));

        return returnMap;

    }

    protected static String getSDKKey(String selectedEnvironment) {

        String key;

        if (selectedEnvironment == "Production") {

            key = "sdk-beab9e46-cf22-44ae-91b5-c6e308b0f5c9";
        }

        //Test is the only other environment. Better to be explicit about Production being chosen.
        else {

            key = "sdk-0d01c9c0-d64c-47e0-b202-3d37d02e9e3a";

        }

        return key;

    }


}
