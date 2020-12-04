package com.org.sb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.org.sb.service.CellDataService;
import com.org.sb.service.CellSampleTypeService;
import com.org.sb.vo.CellDataVo;
import com.org.sb.vo.CellSampleTypeVo;

@Controller
@RequestMapping("/org")
public class SampleBatteryController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CellSampleTypeService cellSampleTypeService;

	@Autowired
	 CellDataService cellDataService;


	@GetMapping("/main")
	public String MainPage() {

		return "main";
	}
	
	@GetMapping("/battery")
	public String AllCellSampleType(Model model, 
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "10") int size, 
			@RequestParam(value = "groupcode",defaultValue = "") String groupcode,
			@RequestParam(value = "samplecode",defaultValue = "") String samplecode,
			@RequestParam(value = "depth1",defaultValue = "") String depth1,
			@RequestParam(value = "depth2",defaultValue = "") String depth2,
			@RequestParam(value = "depth3",defaultValue = "") String depth3) {

		
		List<CellSampleTypeVo> list = cellSampleTypeService.findAll();
		
		Page<CellSampleTypeVo> CellSampleType = cellSampleTypeService.findAllPage(PageRequest.of(page, size));

		HashMap<String, Object> value_list = new HashMap<>();
		value_list.put("size", size);
		value_list.put("groupcode",groupcode);
		value_list.put("samplecode",samplecode);
		value_list.put("depth1",depth1);
		value_list.put("depth2",depth2);
		value_list.put("depth3",depth3);
		model.addAttribute("value_list",value_list);
		model.addAttribute("cell", CellSampleType);
		model.addAttribute("maxPage", 10);
		model.addAttribute("number", CellSampleType.getNumber());
		model.addAttribute("count",CellSampleType.getTotalElements());
		model.addAttribute("searchcheck",0);
	    
		return "excel";

	}

	@GetMapping("/battery/search")
	public String search(Model model, 
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "10") int size, 
			@RequestParam(value = "groupcode",defaultValue = "") String groupcode,
			@RequestParam(value = "samplecode",defaultValue = "") String samplecode,
			@RequestParam(value = "depth1",defaultValue = "") String depth1,
			@RequestParam(value = "depth2",defaultValue = "") String depth2,
			@RequestParam(value = "depth3",defaultValue = "") String depth3) {

		List<CellSampleTypeVo> list = cellSampleTypeService.findAll();

		Page<CellSampleTypeVo> CellSampleType = cellSampleTypeService.findAllsearch(groupcode,samplecode,depth1,depth2,depth3,PageRequest.of(page, size));

		
		HashMap<String, Object> value_list = new HashMap<>();
		value_list.put("size", size);
		value_list.put("groupcode",groupcode);
		value_list.put("samplecode",samplecode);
		value_list.put("depth1",depth1);
		value_list.put("depth2",depth2);
		value_list.put("depth3",depth3);
		
		
		model.addAttribute("cell", CellSampleType);
		model.addAttribute("maxPage", 10);
		model.addAttribute("number",  CellSampleType.getNumber());
		model.addAttribute("value_list",value_list);
		model.addAttribute("count",CellSampleType.getTotalElements());
		model.addAttribute("searchcheck",1);
		return "excel";
	}
	
	@GetMapping("/downloadSampleData")
	public String downloadSampleData(Model model,
			@RequestParam("type_seq") int type_seq,
			@RequestParam("filename") String filename) {
		List<CellDataVo> list = cellDataService.findAllData(type_seq);
		SXSSFWorkbook workbook = cellDataService.excelFileDownLoad(list);
		
		model.addAttribute("locale",Locale.KOREA);
		model.addAttribute("workbook",workbook);
		model.addAttribute("workbookName",filename);
		return "ExcelDownload";
	}

}
