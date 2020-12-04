package com.org.sb.service;

import java.util.List;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.org.sb.repository.CellSampleTypeRepository;
import com.org.sb.repository.ContentSpecs;
import com.org.sb.vo.CellSampleTypeVo;

@Service
public class CellSampleTypeService {

	@Autowired
	private CellSampleTypeRepository cellSampleTypeRepository;
	
	
	
	public List<CellSampleTypeVo> findAll(){
		return cellSampleTypeRepository.findAll();
	}
	
	public Page<CellSampleTypeVo> findAllPage(PageRequest pageable){
		return cellSampleTypeRepository.findAll(pageable);
	}
	
	public Page<CellSampleTypeVo> findAllsearch(String groupcode,String samplecode,String depth1,String depth2,String depth3,PageRequest pageable){
		Specification<CellSampleTypeVo> spec = Specification.where(ContentSpecs.groupcodelike(groupcode).and(ContentSpecs.samplecoudlike(samplecode)
				.and(ContentSpecs.depthonelike(depth1).and(ContentSpecs.depthtwolike(depth2).and(ContentSpecs.depththrlike(depth3))))));
		
		return cellSampleTypeRepository.findAll(spec,pageable);
	}
	
	
}
