package com.uag.sd.weathermonitor.model.sensor;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("temperatureSensor")
@Scope("prototype")
public class TemperatureSensor extends Sensor{

	public enum SCALE{CELSIUS,FARENHEIT};
	private SCALE scale;
	
	public TemperatureSensor() {
		value = "27";
		scale = SCALE.CELSIUS;
	}
	
	public TemperatureSensor(SCALE scale) {
		this();
		this.scale = scale;
	}

	@Override
	protected String detect() {
		if(scale == SCALE.CELSIUS) {
			return value+" ºC";
		}else {
			return value+" ºF";
		}
	}

}
