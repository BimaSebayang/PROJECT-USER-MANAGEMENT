package id.co.roxas.management.ui.web.controller.tester;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import id.co.roxas.common.lib.tester.MessageBean;
import id.co.roxas.management.ui.web.controller.BaseCtl;

@Controller
public class SocketController extends BaseCtl{

    @MessageMapping("/user-all")
    @SendTo(TOPIC+"user")
    public MessageBean send(@Payload MessageBean message) {
        return message;
    }
}