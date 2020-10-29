package id.co.roxas.project.core.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Component;

import id.co.roxas.common.lib.share.MasterComponent;

@Component
public abstract class BaseCtl extends MasterComponent{

	
	protected Pageable pageableSetting(Integer page, Integer size, List<String> sorts) {
		String properties = "";
		List<Order> orders = new ArrayList<Sort.Order>();
		for (String sort : sorts) {
			if(sort.charAt(0)=='+') {
				orders.add(Sort.Order.asc(sort.replace("+", "")));
			}
			else if(sort.charAt(0)=='-') {
				orders.add(Sort.Order.desc(sort.replace("-", "")));
			}
		}
		return PageRequest.of(page, size, Sort.by(orders));
	}
	
}
