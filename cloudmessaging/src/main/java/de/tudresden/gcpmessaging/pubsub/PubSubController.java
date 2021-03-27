package de.tudresden.gcpmessaging.pubsub;


import de.tudresden.gcpmessaging.cloudmessaging.CloudmessagingApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class PubSubController {
    //tag::autowireGateway []
    @Autowired
    private CloudmessagingApplication.PubsubOutboundGateway messagingGateway;
    //end::autowireGateway

    @PostMapping("/publishMessage")
    public RedirectView publishMessage(@RequestParam("message")String message) {
        messagingGateway.sendToPubSub(message);
        return new RedirectView("/");
    }
}
