package com.org.sb.service;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.org.sb.repository.CellDataRepository;
import com.org.sb.repository.DataSpecs;
import com.org.sb.vo.CellDataVo;

@Service
public class CellDataService {

	private String [] rowname= {"Data_Point","Test_Time(s)","Date_Time","Step_Time(s)","Step_Index","Cycle_Index",
			"Current(A)","Voltage(V)","Charge_Capacity(Ah)","Discharge_Capacity(Ah)","Charge_Energy(Wh)","Discharge_Energy(Wh)",
			"dV/dt(V/s)","Internal_Resistance(Ohm)","Is_FC_Data","AC_Impedance(Ohm)","ACI_Phase_Angle(Deg)","Temperature_(C)_1","Temperature_(C)_2",};
	@Autowired
	CellDataRepository cellDataRepository;
	
	public List<CellDataVo> findAllData(int type_seq){
		Specification<CellDataVo> spec = Specification.where(DataSpecs.bytypeseq(type_seq));
		return cellDataRepository.findAll(spec);
	}
	
	public SXSSFWorkbook excelFileDownLoad(List<CellDataVo> list) {
		return this.makeExcelWorkbook(list);
	}
	
	public SXSSFWorkbook makeExcelWorkbook(List<CellDataVo> list) {
        SXSSFWorkbook workbook = new SXSSFWorkbook();
        int num =1;
        // 시트 생성
        SXSSFSheet sheet = workbook.createSheet("sheet1");
        
        sheetwidth(sheet);
        
        // 헤더 행 생
        Row headerRow = sheet.createRow(0);
        // 해당 행의 첫번째 열 셀 생성
        Cell headerCell;
        for(int i=0;i<19;i++) {
        	 headerCell = headerRow.createCell(i);
        	 headerCell.setCellValue(rowname[i]);
        }
        
        // 과일표 내용 행 및 셀 생성
        Row bodyRow = null;
        Cell bodyCell = null;
        int dbsize= list.size();
        for(int i=0; i<dbsize; i++) {
        	
            CellDataVo cellDataVo = list.get(i);
            
            // 행 생성
            bodyRow = sheet.createRow(i+1);
            // 데이터 번호 표시
           
            bodyCell = bodyRow.createCell(0);
            bodyCell.setCellValue(cellDataVo.getData_point());
            // 데이터 이름 표시
            bodyCell = bodyRow.createCell(1);
            bodyCell.setCellValue(cellDataVo.getTest_time());
            
            bodyCell = bodyRow.createCell(2);
            bodyCell.setCellValue(cellDataVo.getDate_time());
            
            bodyCell = bodyRow.createCell(3);
            bodyCell.setCellValue(cellDataVo.getStep_time());
            
            bodyCell = bodyRow.createCell(4);
            bodyCell.setCellValue(cellDataVo.getStep_index());
            
            bodyCell = bodyRow.createCell(5);
            bodyCell.setCellValue(cellDataVo.getCycle_index());
            
            bodyCell = bodyRow.createCell(6);
            bodyCell.setCellValue(cellDataVo.getCurrent());
            
            bodyCell = bodyRow.createCell(7);
            bodyCell.setCellValue(cellDataVo.getVoltage());
            
            bodyCell = bodyRow.createCell(8);
            bodyCell.setCellValue(cellDataVo.getCharge_capacity());
            
            bodyCell = bodyRow.createCell(9);
            bodyCell.setCellValue(cellDataVo.getDischarge_capacity());
            
            bodyCell = bodyRow.createCell(10);
            bodyCell.setCellValue(cellDataVo.getCharge_energy());
            
            bodyCell = bodyRow.createCell(11);
            bodyCell.setCellValue(cellDataVo.getDischarge_energy());
            
            bodyCell = bodyRow.createCell(12);
            bodyCell.setCellValue(cellDataVo.getDv_dt());
            
            bodyCell = bodyRow.createCell(13);
            bodyCell.setCellValue(cellDataVo.getInternal_resistance());
            
            bodyCell = bodyRow.createCell(14);
            bodyCell.setCellValue(cellDataVo.getIs_fc_data());
            
            bodyCell = bodyRow.createCell(15);
            bodyCell.setCellValue(cellDataVo.getAc_impedance());
            
            bodyCell = bodyRow.createCell(16);
            bodyCell.setCellValue(cellDataVo.getAci_phase_angle());
            
            bodyCell = bodyRow.createCell(17);
            bodyCell.setCellValue(cellDataVo.getTemperature_1());
            
            bodyCell = bodyRow.createCell(18);
            bodyCell.setCellValue(cellDataVo.getTemperature_2());
            
            if(i%5000 == 0 ) {
            	try {
					((SXSSFSheet)sheet).flushRows(5000);
				} catch (IOException e) {
					
				}
            }
        }
        
        
       
        
        return workbook;
    }
	
	//시트 열 너비 설정
	public void sheetwidth(SXSSFSheet sheet) {
        sheet.setColumnWidth(0, 1500);
        sheet.setColumnWidth(0, 3000);
        sheet.setColumnWidth(0, 3000);
        sheet.setColumnWidth(0, 1500);
	}
}
