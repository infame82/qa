package com.uag.sd.weathermonitor.gui;

import java.awt.EventQueue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					@SuppressWarnings("resource")
					ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/META-INF/spring/spring-ctx.xml");
					SensorNetworkSimGUI window = applicationContext.getBean(SensorNetworkSimGUI.class);
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
