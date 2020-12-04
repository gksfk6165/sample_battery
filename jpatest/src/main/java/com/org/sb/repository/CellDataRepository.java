package com.org.sb.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.org.sb.vo.CellDataVo;

public interface CellDataRepository extends JpaRepository<CellDataVo, Long> {

	public List<CellDataVo> findAll(Specification<CellDataVo> spec);
}
