package com.org.sb.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="cell_sample_type")
public class CellSampleTypeVo {

	
	@Id
	@Column(name="seq")
	private int seq;
	
	
	
	@Column(name="depth1")
	private String depth1;
	
	@Column(name="depth2")
	private String depth2;
	
	@Column(name="depth3")
	private String depth3;
	
	@Column(name="sample_file_name")
	private String sample_file_name;
	
	
	
	@ManyToOne
	@JoinColumn(name="group_code")
	private CellGroupVo cellGroupVo;
	
	
	@ManyToOne
	@JoinColumn(name="sample_code")
	private CellSampleVo cellSampleVo;

}
