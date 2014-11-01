package com.uag.sd.weathermonitor.model.sensor;

public abstract class Sensor implements Runnable{

	protected String id;
	protected long lapse;
	protected boolean active;
	protected SensorMonitor monitor;
	protected String value;
	
	//In milliseconds, 5000 = 5 sec
	public static final long DEFAULT_LAPSE = 5000;
	
	public Sensor() {
		active = false;
		lapse = DEFAULT_LAPSE;
	}
	
	@Override
	public void run() {
		while (active) {
			if(monitor!=null) {
				monitor.nofity(new SensorData(id, detect()));
			}
			try {
				Thread.sleep(lapse);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected abstract String detect();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public long getLapse() {
		return lapse;
	}
	public void setLapse(long lapse) {
		this.lapse = lapse;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public SensorMonitor getMonitor() {
		return monitor;
	}
	public void setMonitor(SensorMonitor monitor) {
		this.monitor = monitor;
	}
}
