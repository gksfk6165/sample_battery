package com.org.sb.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity(name="CellDataVo")
@Table(name="cell_data")
public class CellDataVo {

	@Id
	private Long seq;
	
	@Column(name="type_seq")
	private int typeSeq;
	
	private int data_point;
	
	private double test_time;
	
	private String date_time;
	
	private double step_time;
	
	private int step_index;
	
	private int cycle_index;
	
    private double current;
    
    private double voltage;
    
    private double charge_capacity;
    
    private double discharge_capacity;
    
    private double charge_energy;
    
    private double discharge_energy;
    
    private double dv_dt;
    
    private double internal_resistance;
    
    private double is_fc_data;
    
    private double ac_impedance;
    
    private double aci_phase_angle;
    
    private double temperature_1;
    
    private double temperature_2;

    
}
