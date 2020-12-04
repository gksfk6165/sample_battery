package com.org.sb.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity(name="group")
@Table(name="cell_group")
public class CellGroupVo {

	@Id
	@Column(name="code")
	private String code;
	
	private String name;
	
	
	
	
	
}
