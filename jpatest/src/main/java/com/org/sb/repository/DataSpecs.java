package com.org.sb.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.org.sb.vo.CellDataVo;

public class DataSpecs {

	public static Specification<CellDataVo> bytypeseq(final int keyword){
		System.out.println("확인 :  " + keyword);
		return new Specification<CellDataVo>(){
			
			@Override
			public Predicate toPredicate(Root<CellDataVo> root, CriteriaQuery<?> query,
					CriteriaBuilder cb) {
				return cb.equal(root.get("typeSeq"), keyword);
			}
			
		};
	
	}
	
}
