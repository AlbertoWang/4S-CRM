package cn.edu.cqu.CRM.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	// 首页
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/index.html")
	public String gotoIndex() {
		return "index";
	}

	@RequestMapping("/saler.html")
	public String gotosSaler() {
		return "saler";
	}

	@RequestMapping("/saler_about.html")
	public String gotoSaler_about() {
		return "saler_about";
	}

	@RequestMapping("/sale.html")
	public String gotoSale() {
		return "sale";
	}

	@RequestMapping("/sale_search.html")
	public String gotoSale_search() {
		return "sale_search";
	}

	@RequestMapping("/maintain_search.html")
	public String gotoMaintain_search() {
		return "maintain_search";
	}

	@RequestMapping("/repair_search.html")
	public String gotoRepair_search() {
		return "repair_search";
	}

	@RequestMapping("/servicer.html")
	public String gotoServicer() {
		return "servicer";
	}

	@RequestMapping("/servicer_about.html")
	public String gotoServicer_about() {
		return "servicer_about";
	}

	@RequestMapping("/maintain.html")
	public String gotoMaintain() {
		return "maintain";
	}

	@RequestMapping("/repair.html")
	public String gotoRepair() {
		return "repair";
	}

	@RequestMapping("/manager.html")
	public String gotoManager() {
		return "manager";
	}

	@RequestMapping("/manager_about.html")
	public String gotoManager_about() {
		return "manager_about";
	}

	@RequestMapping("/sale_record.html")
	public String gotoSale_record() {
		return "sale_record";
	}

	@RequestMapping("/service_record.html")
	public String gotoService_record() {
		return "service_record";
	}

	@RequestMapping("/repair_record.html")
	public String gotoRepair_record() {
		return "repair_record";
	}

}
