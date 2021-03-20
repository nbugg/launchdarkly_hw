import com.launchdarkly.sdk.*;
import com.launchdarkly.sdk.server.*;
import java.io.IOException;
import java.util.LinkedHashMap;

public class Main {


    public static void main(String... args) throws IOException {

        LinkedHashMap<String, String> settings = Settings.chooseSettings();

        final String SDK_KEY = settings.get("key");
        LDClient client = new LDClient(SDK_KEY);

        LDUser user = new LDUser(settings.get("user"));

        PricingDetails.showPricelist(client, user);

        client.close();
    }
}
