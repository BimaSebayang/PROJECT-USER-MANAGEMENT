package id.co.roxas.management.ui.web.controller.department;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import id.co.roxas.common.lib.dto.mssg.MessageDepartmentDto;
import id.co.roxas.common.lib.dto.user_mgmt.department.TblDepartmentMgmtDto;
import id.co.roxas.common.lib.tester.MessageBean;
import id.co.roxas.management.ui.web.controller.BaseCtl;

@Controller
public class DepartmentMenuSvcSubscribe extends BaseCtl{

	  	@MessageMapping("/successTransactionDepartment")
	    @SendTo(TOPIC+"allUser")
	    public String sendSuccessTransactionDepartment(@Payload TblDepartmentMgmtDto message) {
	  		System.err.println("payloadnya adalah " + message);
	        return message.getCreatedBy() + " baru saja menambahkan nama department " + message.getDepartmentName();
	    }
	
}
