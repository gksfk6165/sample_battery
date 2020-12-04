package com.org.sb.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="cell_sample")
public class CellSampleVo {

	@Id
	private String code;
	
	@Column(name="group_code")
	private String groupCode;
	
	private String name;
	
	private String description;
}
