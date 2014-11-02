package com.uag.sd.weathermonitor.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.uag.sd.weathermonitor.model.sensor.HumiditySensor;
import com.uag.sd.weathermonitor.model.sensor.Sensor;
import com.uag.sd.weathermonitor.model.sensor.TemperatureSensor;

public class SensorTableModel extends AbstractTableModel{
	
	private List<Sensor> sensors;
	private String[] columnNames = { "ID", "Type", "Lapse","Value",
	        "Status" };

	/**
	 * 
	 */
	private static final long serialVersionUID = 829922993812147530L;
	
	public SensorTableModel() {
		sensors = new ArrayList<Sensor>();
	}

	@Override
	public int getRowCount() {
		return sensors.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Sensor sensor = sensors.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return sensor.getId();
		case 1:
			if(sensor instanceof TemperatureSensor) {
				return "Temperature";
			}else if(sensor instanceof HumiditySensor) {
				return "Humidity";
			}
		case 2:
			return (sensor.getLapse()/1000)+" seg";
		case 3:
			return sensor.detect();
		case 4:
			return sensor.isActive()?"Active":"Inactive";
		}
		return null;
	}
	
	public void addSensor(Sensor sensor) {
		int rowCount = sensors.size();
		sensors.add(sensor);
		fireTableRowsInserted(rowCount, rowCount);
	}
	
	public void addAll(List<Sensor> sensors) {
		this.sensors.addAll(sensors);
		fireTableDataChanged();
	}
	
	public void replaceAll(List<Sensor> sensors) {
		this.sensors = new ArrayList<Sensor>();
		this.sensors.addAll(sensors);
		fireTableDataChanged();
	}
	
	public Sensor getSensor(int rowIndex) {
		return sensors.get(rowIndex);
	}
	
	public int getIndexOf(Sensor sensor) {
		int index = -1;
		for(int i=0;i<sensors.size();i++) {
			if(sensors.get(i).equals(sensor)) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public Sensor removeSensor(int rowIndex) {
		fireTableRowsDeleted(rowIndex, rowIndex);
		return sensors.remove(rowIndex);
	}
	
	public void clear() {
		sensors = new ArrayList<Sensor>();
		fireTableDataChanged();
	}

}
