package com.uag.sd.weathermonitor.gui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.springframework.stereotype.Component;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@Component("sensorNetworkSimulationGUI")
public class SensorNetworkSimGUI {

	private JFrame frmSensorNetworkSimulation;
	private JTable endPointsTable;
	private JTable sensorsTable;

	/**
	 * Create the application.
	 */
	public SensorNetworkSimGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSensorNetworkSimulation = new JFrame();
		frmSensorNetworkSimulation.setTitle("Sensor Network Simulation");
		frmSensorNetworkSimulation.setBounds(100, 100, 536, 542);
		frmSensorNetworkSimulation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSensorNetworkSimulation.getContentPane().setLayout(new BorderLayout(0, 0));

		JSplitPane splitPane = new JSplitPane();
		frmSensorNetworkSimulation.getContentPane().add(splitPane, BorderLayout.CENTER);

		JPanel categoriesPanel = new JPanel();
		splitPane.setLeftComponent(categoriesPanel);

		JToggleButton tglbtnEndpoints = new JToggleButton("Endpoints");
		tglbtnEndpoints.setSelected(true);
		GroupLayout gl_categoriesPanel = new GroupLayout(categoriesPanel);
		gl_categoriesPanel.setHorizontalGroup(gl_categoriesPanel
				.createParallelGroup(Alignment.LEADING).addGroup(
						gl_categoriesPanel.createSequentialGroup()
								.addContainerGap()
								.addComponent(tglbtnEndpoints)
								.addContainerGap(10, Short.MAX_VALUE)));
		gl_categoriesPanel.setVerticalGroup(gl_categoriesPanel
				.createParallelGroup(Alignment.LEADING).addGroup(
						gl_categoriesPanel.createSequentialGroup().addGap(28)
								.addComponent(tglbtnEndpoints)
								.addContainerGap(356, Short.MAX_VALUE)));
		categoriesPanel.setLayout(gl_categoriesPanel);

		JPanel endpointsPanel = new JPanel();
		splitPane.setRightComponent(endpointsPanel);

		JLabel lblNewLabel = new JLabel("Endpoints");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));

		JButton btnAdd = new JButton("Add");

		JButton btnEdit = new JButton("Edit");

		JButton btnDelete = new JButton("Remove");

		JScrollPane scrollPane = new JScrollPane();
		
		JSeparator separator = new JSeparator();
		
		JLabel lblEndpointId = new JLabel("Endpoint ID:");
		lblEndpointId.setFont(new Font("Lucida Grande", Font.BOLD, 12));
		
		JLabel lblE = new JLabel("E1");
		lblE.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_endpointsPanel = new GroupLayout(endpointsPanel);
		gl_endpointsPanel.setHorizontalGroup(
			gl_endpointsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_endpointsPanel.createSequentialGroup()
					.addGap(16)
					.addGroup(gl_endpointsPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addGroup(gl_endpointsPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAdd)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnEdit)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDelete)))
					.addContainerGap(110, Short.MAX_VALUE))
				.addComponent(separator, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_endpointsPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_endpointsPanel.createSequentialGroup()
					.addGap(20)
					.addComponent(lblEndpointId)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblE)
					.addContainerGap(260, Short.MAX_VALUE))
				.addGroup(gl_endpointsPanel.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_endpointsPanel.setVerticalGroup(
			gl_endpointsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_endpointsPanel.createSequentialGroup()
					.addGap(15)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(gl_endpointsPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdd)
						.addComponent(btnDelete)
						.addComponent(btnEdit))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_endpointsPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEndpointId)
						.addComponent(lblE))
					.addGap(12)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
		);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Sensors", null, panel, null);
		
		JButton addSensorButton = new JButton("Add");
		
		JButton editSensorButton = new JButton("Edit");
		
		JButton deleteSensorButton = new JButton("Remove");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JSeparator separator_1 = new JSeparator();
		
		JLabel lblConsole = new JLabel("Console");
		lblConsole.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		
		JTextArea sensorsConsole = new JTextArea();
		sensorsConsole.setForeground(Color.GREEN);
		sensorsConsole.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 11));
		sensorsConsole.setBackground(Color.BLACK);
		sensorsConsole.setColumns(1);
		sensorsConsole.setEditable(false);
		sensorsConsole.setRows(5);
		sensorsConsole.setText("11-01-14 12:11:05 S1 > 27 ºC\n11-01-14 12:11:05 S2 > .5");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
								.addContainerGap())
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(addSensorButton, GroupLayout.PREFERRED_SIZE, 72, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(editSensorButton, GroupLayout.PREFERRED_SIZE, 73, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(deleteSensorButton, GroupLayout.PREFERRED_SIZE, 81, Short.MAX_VALUE)
								.addGap(123))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
								.addContainerGap()))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(sensorsConsole)
									.addContainerGap())
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblConsole)
									.addGap(317))))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(addSensorButton)
						.addComponent(deleteSensorButton)
						.addComponent(editSensorButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblConsole)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(sensorsConsole, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		sensorsTable = new JTable();
		sensorsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(sensorsTable);
		panel.setLayout(gl_panel);

		endPointsTable = new JTable();
		endPointsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(endPointsTable);
		endpointsPanel.setLayout(gl_endpointsPanel);

		Object endpointrowData[][] = {
				{ "E1", "Active" },
				{ "E2", "Inactive" },
				{ "E2", "Inactive" } ,
				{ "E2", "Inactive" } ,
				{ "E2", "Inactive" } ,
				{ "E2", "Inactive" }  };
		Object endpointcolumnNames[] = { "ID", "Status" };
		TableModel endpointmodel = new DefaultTableModel(endpointrowData, endpointcolumnNames);
		endPointsTable.setModel(endpointmodel);
		
		Object sensorsRowData[][] = {
				{ "S1", "Temperature","5 seg","Active" },
				{ "S2", "Humidity","3 seg","Active" }};
		Object sensoresColumnNames[] = { "ID", "Type","Lapse","Status" };
		TableModel sensoresmodel = new DefaultTableModel(sensorsRowData, sensoresColumnNames);
		sensorsTable.setModel(sensoresmodel);
	}

	public JFrame getFrame() {
		return frmSensorNetworkSimulation;
	}
}
