import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.SubscriptionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @since 2024-01-25
 */
public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws PulsarClientException {
        String serviceUrl = args[0];
        String topic = "persistent://public/default/test";
        PulsarClient client = PulsarClient.builder()
                .serviceUrl(serviceUrl)
                .build();
        client.newConsumer()
                .topic(topic)
                .subscriptionName("sub0")
                .subscriptionType(SubscriptionType.Shared)
                .subscribe();
        log.info("Consumer of {} started", topic);
    }
}
