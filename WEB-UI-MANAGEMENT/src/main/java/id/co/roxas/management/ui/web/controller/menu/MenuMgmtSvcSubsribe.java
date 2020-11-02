package id.co.roxas.management.ui.web.controller.menu;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import id.co.roxas.management.ui.web.controller.BaseCtl;

@Controller
public class MenuMgmtSvcSubsribe extends BaseCtl{
	
	@MessageMapping("/successTransactionMenu")
    @SendTo(TOPIC_TRANSACTION)
    public String sendSuccessTransactionMenu(@Payload Object message) {
  		System.err.println("payloadnya adalah " + message);
       // return message.getCreatedBy() + " baru saja menambahkan nama department " + message.getDepartmentName();
       return "Transaksi Berhasil";
  	}

}
