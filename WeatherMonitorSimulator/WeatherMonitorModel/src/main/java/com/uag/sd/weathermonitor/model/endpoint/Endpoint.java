package com.uag.sd.weathermonitor.model.endpoint;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.uag.sd.weathermonitor.model.sensor.Sensor;
import com.uag.sd.weathermonitor.model.sensor.SensorData;
import com.uag.sd.weathermonitor.model.sensor.SensorMonitor;

@Component("endpoint")
@Scope("prototype")
public class Endpoint implements SensorMonitor,Runnable {
	private String id;
	private Map<String,Sensor> sensors;
	private boolean active;
	private ThreadPoolExecutor executorService;
	private Integer threadPoolSize;
	
	public Endpoint() {
		threadPoolSize = 5;
		executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(threadPoolSize);
		sensors = new HashMap<String, Sensor>();
		active = false;
	}
	
	public Endpoint(String id) {
		this();
		this.id = id;
	}
	
	@Override
	public void run() {
		start();
		while(active) {
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, Sensor> getSensors() {
		return sensors;
	}

	public void setSensors(Map<String, Sensor> sensors) {
		this.sensors = sensors;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	private void start() {
		for(Sensor sensor:sensors.values()) {
			sensor.setActive(true);
			executorService.execute(sensor);
		}
	}
	
	public void stop() {
		for(Sensor sensor:sensors.values()) {
			sensor.setActive(false);
			executorService.remove(sensor);
		}
		active = false;
	}
	
	public void addSensor(Sensor sensor) {
		sensor.setMonitor(this);
		sensor.setId(id+":"+"sensor:"+sensors.size());
		sensors.put(sensor.getId(), sensor);
	}
	
	public void removeSensor(String sensorId) {
		Sensor sensor = sensors.remove(sensorId);
		sensor.setActive(false);
	}

	@Override
	public synchronized void nofity(SensorData data) {
		System.out.println(data.getValue());
	}

	

}
