package com.org.sb.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.org.sb.vo.CellGroupVo;
import com.org.sb.vo.CellSampleTypeVo;
import com.org.sb.vo.CellSampleVo;

public class ContentSpecs {

	public static Specification<CellSampleTypeVo> groupcodelike(final String keyword){
		return new Specification<CellSampleTypeVo>(){

			@Override
			public Predicate toPredicate(Root<CellSampleTypeVo> root, CriteriaQuery<?> query,
					CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				Join<CellSampleTypeVo, CellGroupVo> m = root.join("cellGroupVo");
				return cb.like(m.get("code"), "%"+keyword+"%");
			}
			
		};
	}
	
	public static Specification<CellSampleTypeVo> samplecoudlike(final String keyword){
		return new Specification<CellSampleTypeVo>(){

			@Override
			public Predicate toPredicate(Root<CellSampleTypeVo> root, CriteriaQuery<?> query,
					CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				Join<CellSampleTypeVo, CellSampleVo> m = root.join("cellSampleVo");
				return cb.like(m.get("code"), "%"+keyword+"%");
			}
			
		};
	}
	
	public static Specification<CellSampleTypeVo> depthonelike(final String keyword){
		return new Specification<CellSampleTypeVo>(){

			@Override
			public Predicate toPredicate(Root<CellSampleTypeVo> root, CriteriaQuery<?> query,
					CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				return cb.like(root.get("depth1"), "%"+keyword+"%");
			}
			
		};
	}
	
	public static Specification<CellSampleTypeVo> depthtwolike(final String keyword){
		return new Specification<CellSampleTypeVo>(){

			@Override
			public Predicate toPredicate(Root<CellSampleTypeVo> root, CriteriaQuery<?> query,
					CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				return cb.like(root.get("depth2"), "%"+keyword+"%");
			}
			
		};
	}
	
	public static Specification<CellSampleTypeVo> depththrlike(final String keyword){
		return new Specification<CellSampleTypeVo>(){

			@Override
			public Predicate toPredicate(Root<CellSampleTypeVo> root, CriteriaQuery<?> query,
					CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				return cb.like(root.get("depth3"), "%"+keyword+"%");
			}
			
		};
	}
}
