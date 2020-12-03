package com.sw.jpatest.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sw.jpatest.vo.CellDataVo;

public interface CellDataRepository extends JpaRepository<CellDataVo, Long> {

	public List<CellDataVo> findAll(Specification<CellDataVo> spec);
}
