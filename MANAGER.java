import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JScrollBar;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;


public class MANAGER implements ActionListener, KeyListener {

	private JFrame frmWelcomeManager;
	private JTextField txtsid;
	private JTextField txtsname;
	private JTextField txtsphone;
	private JTextField txtsbirth;
	private JTextField txtshours;
	private JTextField txtsrole;
	private JTextField txtssalary;
	private JTextField txtsbranchid;
	private JTextField txtssuperid;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MANAGER window = new MANAGER();
					window.frmWelcomeManager.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
		
		
	}
	
	
		
	

	
	public MANAGER() {
		initialize();
		connect();
		table_load_staff();
		table_load_supplier();
		table_load_customer();
		table_load_branch();
		table_load_resttable();
		table_load1();
		table_load2();
		table_load_contracts();
	}
	
	static Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField txtsidretreive;
	private JTable table_1;
	private JTextField txtstaffid;
	private JTextField txtstaffname;
	private JTextField txtstaffphone;
	private JTable table;
	private JTextField staffidret;
	private JTextField txtcid;
	private JTextField txtcname;
	private JTextField txtcphone;
	private JTable table_2;
	private JTextField cidret;
	private JTextField txtbid;
	private JTextField txtblocation;
	private JTextField txtbphone;
	private JTable table_3;
	private JTextField txtbidret;
	private JTextField txttnum;
	private JTextField txtaval;
	private JTextField txtseats;
	private JTextField txttnumret;
	private JTable table_4;
	private JTable table_5;
	private JTable table_6;
	private JTextField txtcsid;
	private JTextField txtcbid;
	private JTextField txtstart;
	private JTextField txtend;
	private JTable table_7;
	private JTextField txtcsidrret;
	private JTextField txtcbidret;
	private JTextField txtsal;
	private JTextField txtrole;

	public void connect() {
		
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost/restaurant", "root","");
	        }
	        catch (ClassNotFoundException ex)
	        {
	          ex.printStackTrace();
	        }
	        catch (SQLException ex)
	        {
	            ex.printStackTrace();
	        }
	 
		
		
	}
	
	public void table_load1() {
	
	  try
	     {
	    pst = con.prepareStatement("select s.Id as Staff_id,Location from STAFF as s,BRANCH as b where s.Branch_id=b.Id");
	    rs = pst.executeQuery();
	    table_6.setModel(DbUtils.resultSetToTableModel(rs));
	}
	     catch (SQLException e1)
	     {
	     e1.printStackTrace();
	  }	
		
	}
	
	public void table_load2() {
		
		  try
		     {
		    pst = con.prepareStatement("select s.Id as Supplier_id,b.Id as Branch_id, Name as Supplier_name from SUPPLIER as s,BRANCH as b,CONTRACTS where b.Id = Bid and s.Id = Sid ");
		    rs = pst.executeQuery();
		    table_5.setModel(DbUtils.resultSetToTableModel(rs));
		}
		     catch (SQLException e1)
		     {
		     e1.printStackTrace();
		  }	
			
		}
	
	
	public void table_load_contracts()
    {
     try
     {
    pst = con.prepareStatement("select * from CONTRACTS");
    rs = pst.executeQuery();
    table_7.setModel(DbUtils.resultSetToTableModel(rs));
}
     catch (SQLException e)
     {
     e.printStackTrace();
  }
    }
	
	
	
	
	public void table_load_supplier()
    {
     try
     {
    pst = con.prepareStatement("select * from SUPPLIER");
    rs = pst.executeQuery();
    table.setModel(DbUtils.resultSetToTableModel(rs));
}
     catch (SQLException e)
     {
     e.printStackTrace();
  }
    }
	
	public void table_load_branch()
    {
     try
     {
    pst = con.prepareStatement("select * from BRANCH");
    rs = pst.executeQuery();
    table_3.setModel(DbUtils.resultSetToTableModel(rs));
}
     catch (SQLException e)
     {
     e.printStackTrace();
  }
    }
	
	
	public void table_load_resttable()
    {
     try
     {
    pst = con.prepareStatement("select * from RESTTABLE");
    rs = pst.executeQuery();
    table_4.setModel(DbUtils.resultSetToTableModel(rs));
}
     catch (SQLException e)
     {
     e.printStackTrace();
  }
    }

	public void table_load_customer()
    {
     try
     {
    pst = con.prepareStatement("select * from CUSTOMER");
    rs = pst.executeQuery();
    table_2.setModel(DbUtils.resultSetToTableModel(rs));
}
     catch (SQLException e)
     {
     e.printStackTrace();
  }
    }
	
	
	  public void table_load_staff()
	    {
	     try
	     {
	    pst = con.prepareStatement("select * from STAFF");
	    rs = pst.executeQuery();
	    table_1.setModel(DbUtils.resultSetToTableModel(rs));
	}
	     catch (SQLException e)
	     {
	     e.printStackTrace();
	  }
	    }
	
	private void initialize() {
		frmWelcomeManager = new JFrame();
		frmWelcomeManager.getContentPane().setForeground(new Color(255, 255, 255));
		frmWelcomeManager.getContentPane().setBackground(new Color(255, 255, 255));
		frmWelcomeManager.setFont(new Font("Goudy Old Style", Font.BOLD | Font.ITALIC, 13));
		frmWelcomeManager.setTitle("welcome manager");
		frmWelcomeManager.setBackground(new Color(255, 255, 255));
		frmWelcomeManager.setBounds(100, 100, 908, 515);
		frmWelcomeManager.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 11));
		tabbedPane.setForeground(new Color(0, 0, 0));
		frmWelcomeManager.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 234, 223));
		tabbedPane.addTab("STAFF", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(27, 30, 39, 42);
		panel.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(27, 75, 72, 42);
		panel.add(lblName);
		
		JLabel lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPhoneNumber.setBounds(27, 115, 120, 42);
		panel.add(lblPhoneNumber);
		
		JLabel lblBirthDate = new JLabel("Birth date");
		lblBirthDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBirthDate.setBounds(27, 161, 94, 42);
		panel.add(lblBirthDate);
		
		JLabel lblWorkHours = new JLabel("work hours");
		lblWorkHours.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWorkHours.setBounds(27, 201, 94, 42);
		panel.add(lblWorkHours);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRole.setBounds(26, 241, 72, 42);
		panel.add(lblRole);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalary.setBounds(27, 280, 72, 42);
		panel.add(lblSalary);
		
		JLabel lblBranchId = new JLabel("Branch id");
		lblBranchId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBranchId.setBounds(27, 321, 94, 42);
		panel.add(lblBranchId);
		
		JLabel lblSupervisorId = new JLabel("Supervisor id");
		lblSupervisorId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSupervisorId.setBounds(27, 365, 120, 42);
		panel.add(lblSupervisorId);
		
		txtsid = new JTextField();
		txtsid.setBounds(153, 43, 96, 20);
		panel.add(txtsid);
		txtsid.setColumns(10);
		
		txtsname = new JTextField();
		txtsname.setBounds(153, 88, 96, 20);
		panel.add(txtsname);
		txtsname.setColumns(10);
		
		txtsphone = new JTextField();
		txtsphone.setBounds(153, 128, 96, 20);
		panel.add(txtsphone);
		txtsphone.setColumns(10);
		
		txtsbirth = new JTextField();
		txtsbirth.setBounds(153, 174, 96, 20);
		panel.add(txtsbirth);
		txtsbirth.setColumns(10);
		
		txtshours = new JTextField();
		txtshours.setBounds(153, 214, 96, 20);
		panel.add(txtshours);
		txtshours.setColumns(10);
		
		txtsrole = new JTextField();
		txtsrole.setBounds(153, 254, 96, 20);
		panel.add(txtsrole);
		txtsrole.setColumns(10);
		
		txtssalary = new JTextField();
		txtssalary.setBounds(153, 293, 96, 20);
		panel.add(txtssalary);
		txtssalary.setColumns(10);
		
		txtsbranchid = new JTextField();
		txtsbranchid.setBounds(153, 334, 96, 20);
		panel.add(txtsbranchid);
		txtsbranchid.setColumns(10);
		
		txtssuperid = new JTextField();
		txtssuperid.setBounds(153, 378, 96, 20);
		panel.add(txtssuperid);
		txtssuperid.setColumns(10);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(765, 334, -457, -286);
		panel.add(scrollPane);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Search", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_6.setBounds(630, 365, -300, 42);
		panel.add(panel_6);
		
		txtsidretreive = new JTextField();
		txtsidretreive.addKeyListener(new KeyAdapter() { public void keyReleased(KeyEvent e) {
			
			try {
		          
	            String id = txtsidretreive.getText();

	                pst = con.prepareStatement("select Id,Name,Phone_number,Birth_date,Work_hours,Role,Monthly_salary,Branch_id,Super_id from STAFF where Id = ?");
	                pst.setString(1, id);
	                ResultSet rs = pst.executeQuery();

	            if(rs.next()==true)
	            {
	                String Id = rs.getString(1);
	                String name = rs.getString(2);
	                String phone = rs.getString(3);
	                String birth = rs.getString(4);
	                String hours = rs.getString(5);
	                String role = rs.getString(6);
	                String salary = rs.getString(7);
	                String branchid = rs.getString(8);
	                String superid = rs.getString(9);
	              
	                txtsid.setText(Id);
	            	txtsname.setText(name);
	    			txtsphone.setText(phone);
	    			txtsbirth.setText(birth);
	    			txtshours.setText(hours);
	    			txtsrole.setText(role);
	    			txtssalary.setText(salary);
	    			txtsbranchid.setText(branchid);
	    			txtssuperid.setText(superid);
	                
	                
	            }   
	            else
	            {
	            	 txtsid.setText("");
	    			txtsname.setText("");
	    			txtsphone.setText("");
	    			txtsbirth.setText("");
	    			txtshours.setText("");
	    			txtsrole.setText("");
	    			txtssalary.setText("");
	    			txtsbranchid.setText("");
	    			txtssuperid.setText("");
	                 
	            }
	            


	        } 
		
		 catch (SQLException ex) {
	           
	        }
		
		
		
		
			
		}});
		
		txtsidretreive.setColumns(10);
		txtsidretreive.setBounds(465, 378, 171, 20);
		panel.add(txtsidretreive);
		
		JLabel lblNewLabel_1 = new JLabel("Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(416, 365, 39, 42);
		panel.add(lblNewLabel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(259, 115, 620, 221);
		panel.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {
			
			String sid,sname,sphone,sbirth,shours,srole,ssalary,sbranchid,ssuperid;
			
			sid = txtsid.getText();
			sname = txtsname.getText();
			sphone = txtsphone.getText();
			sbirth = txtsbirth.getText();
			shours = txtshours.getText();
			srole = txtsrole.getText();
			ssalary = txtssalary.getText();
			sbranchid = txtsbranchid.getText();
			ssuperid = txtssuperid.getText();
			
			
			try {
				pst = con.prepareStatement("insert into STAFF(Id,Name,Phone_number,Birth_date,Work_hours,Role,Monthly_salary,Branch_id,Super_id)values(?,?,?,?,?,?,?,?,?)");
				pst.setString(1, sid);
				pst.setString(2, sname);
				pst.setString(3, sphone);
				pst.setString(4, sbirth);
				pst.setString(5, shours);
				pst.setString(6, srole);
				pst.setString(7, ssalary);
				pst.setString(8, sbranchid);
				pst.setString(9, ssuperid);
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "insertion is done successfully");
				table_load_staff();
				          
				txtsid.setText("");
				txtsname.setText("");
				txtsphone.setText("");
				txtsbirth.setText("");
				txtshours.setText("");
				txtsrole.setText("");
				txtssalary.setText("");
				txtsbranchid.setText("");
				txtssuperid.setText("");
				txtsid.requestFocus();
				   }
				 
				catch (SQLException e1)
				        {
				e1.printStackTrace();
				}
			
		}});
		btnNewButton.setBounds(361, 43, 94, 48);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {
			
        String sidret,sid,sname,sphone,sbirth,shours,srole,ssalary,sbranchid,ssuperid;
			
			sid = txtsid.getText();
			sname = txtsname.getText();
			sphone = txtsphone.getText();
			sbirth = txtsbirth.getText();
			shours = txtshours.getText();
			srole = txtsrole.getText();
			ssalary = txtssalary.getText();
			sbranchid = txtsbranchid.getText();
			ssuperid = txtssuperid.getText();
			sidret = txtsidretreive .getText();
			
			try {
				pst = con.prepareStatement("update STAFF set Name =?,Phone_number = ?,Birth_date = ? ,Work_hours = ? ,Role = ? ,Monthly_salary = ? ,Branch_id = ?,Super_id = ? where Id=?");
				
				pst.setString(1, sname);
				pst.setString(2, sphone);
				pst.setString(3, sbirth);
				pst.setString(4, shours);
				pst.setString(5, srole);
				pst.setString(6, ssalary);
				pst.setString(7, sbranchid);
				pst.setString(8, ssuperid);
				pst.setString(9, sidret);
			

				
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "update is done successfully");
				table_load_staff();
				          
				txtsid.setText("");
				txtsname.setText("");
				txtsphone.setText("");
				txtsbirth.setText("");
				txtshours.setText("");
				txtsrole.setText("");
				txtssalary.setText("");
				txtsbranchid.setText("");
				txtssuperid.setText("");
				txtsidretreive.setText("");
				txtsid.requestFocus();
				   }
				 
				catch (SQLException e1)
				        {
				e1.printStackTrace();
				}
			
		}});
		btnNewButton_1.setBounds(661, 377, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			
			
	        String sidret,sid,sname,sphone,sbirth,shours,srole,ssalary,sbranchid,ssuperid;
				
				
				sidret = txtsidretreive .getText();
				
				try {
					pst = con.prepareStatement("delete from STAFF  where Id=?");
					
					pst.setString(1, sidret);
					

					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Deletion is done successfully");
					table_load_staff();
					          
					txtsid.setText("");
					txtsname.setText("");
					txtsphone.setText("");
					txtsbirth.setText("");
					txtshours.setText("");
					txtsrole.setText("");
					txtssalary.setText("");
					txtsbranchid.setText("");
					txtssuperid.setText("");
					txtsidretreive.setText("");
					txtsid.requestFocus();
					   }
					 
					catch (SQLException e1)
					        {
					e1.printStackTrace();
					}
				
			
			
		}});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(661, 43, 94, 48);
		panel.add(btnNewButton_2);
		
		
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 234, 223));
		tabbedPane.addTab("SUPPLIER", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Id");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(27, 30, 39, 42);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Name");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(27, 75, 72, 42);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Phone number");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2.setBounds(27, 115, 120, 42);
		panel_1.add(lblNewLabel_2_2);
		
		txtstaffid = new JTextField();
		txtstaffid.setBounds(153, 43, 96, 20);
		panel_1.add(txtstaffid);
		txtstaffid.setColumns(10);
		
		txtstaffname = new JTextField();
		txtstaffname.setColumns(10);
		txtstaffname.setBounds(153, 88, 96, 20);
		panel_1.add(txtstaffname);
		
		txtstaffphone = new JTextField();
		txtstaffphone.setColumns(10);
		txtstaffphone.setBounds(153, 128, 96, 20);
		panel_1.add(txtstaffphone);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(259, 115, 620, 221);
		panel_1.add(scrollPane_2);
		
		table = new JTable();
		scrollPane_2.setViewportView(table);
		
		JButton supplier_insert = new JButton("Insert");
		supplier_insert.setBackground(new Color(255, 255, 255));
		supplier_insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sid,name,phone;
				
			sid = txtstaffid.getText();
			name = txtstaffname.getText();
			phone = txtstaffphone.getText();
			
			try {
				pst = con.prepareStatement("insert into SUPPLIER(Id,Name,Phone_number)values(?,?,?)");
				pst.setString(1, sid);
				pst.setString(2, name);
				pst.setString(3, phone);
				
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "insertion is done successfully");
				table_load_supplier();
				          
				txtstaffid.setText("");
				txtstaffname.setText("");
				txtstaffphone.setText("");
				txtstaffid.requestFocus();
				   }
				 
				catch (SQLException e1)
				        {
				e1.printStackTrace();
				}
			
			
				
			
		}});
		supplier_insert.setFont(new Font("Tahoma", Font.BOLD, 14));
		supplier_insert.setBounds(361, 43, 94, 48);
		panel_1.add(supplier_insert);
		
		JButton supplier_delete = new JButton("Delete");
		supplier_delete.setBackground(new Color(255, 255, 255));
		supplier_delete.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			
			String sidret,sid,name,phone;
			
			
			sidret = staffidret.getText();
			
			try {
				pst = con.prepareStatement("delete from SUPPLIER where Id=?");
				pst.setString(1, sidret);
				
				
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "deletion is done successfully");
				table_load_supplier();
				          
				txtstaffid.setText("");
				txtstaffname.setText("");
				txtstaffphone.setText("");
				txtstaffid.requestFocus();
				   }
				 
				catch (SQLException e1)
				        {
				e1.printStackTrace();
				}
			
			
			
		}});
		supplier_delete.setFont(new Font("Tahoma", Font.BOLD, 14));
		supplier_delete.setBounds(661, 43, 94, 48);
		panel_1.add(supplier_delete);
		
		JButton supplier_update = new JButton("Update");
		supplier_update.setBackground(new Color(255, 255, 255));
		supplier_update.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {
			
			
			String sidret,sid,name,phone;
			
		sid = txtstaffid.getText();
		name = txtstaffname.getText();
		phone = txtstaffphone.getText();
		sidret = staffidret.getText();
		
		try {
			pst = con.prepareStatement("update SUPPLIER set Name = ?,Phone_number = ? where Id=?");
			pst.setString(1, name);
			pst.setString(2, phone);
			pst.setString(3, sidret);
			
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "update is done successfully");
			table_load_supplier();
			          
			txtstaffid.setText("");
			txtstaffname.setText("");
			txtstaffphone.setText("");
			txtstaffid.requestFocus();
			   }
			 
			catch (SQLException e1)
			        {
			e1.printStackTrace();
			}
		
		
			
		}});
		supplier_update.setFont(new Font("Tahoma", Font.BOLD, 14));
		supplier_update.setBounds(661, 377, 89, 23);
		panel_1.add(supplier_update);
		
		staffidret = new JTextField();
		staffidret.addKeyListener(new KeyAdapter() {public void keyReleased(KeyEvent e) {
			
			try {
		          
	            String id = staffidret.getText();

	                pst = con.prepareStatement("select Id,Name,Phone_number from SUPPLIER where Id = ?");
	                pst.setString(1, id);
	                ResultSet rs = pst.executeQuery();

	            if(rs.next()==true)
	            {
	                String Id = rs.getString(1);
	                String name = rs.getString(2);
	                String phone = rs.getString(3);
	                
	              
	                txtstaffid.setText(Id);
	            	txtstaffname.setText(name);
	    			txtstaffphone.setText(phone);
	    		
	                
	            }   
	            else
	            {
	            	 txtsid.setText("");
	    			txtsname.setText("");
	    			txtsphone.setText("");
	    			
	                 
	            }
	            


	        } 
		
		 catch (SQLException ex) {
	           
	        }
		
		
			
			
			
		}});
		staffidret.setColumns(10);
		staffidret.setBounds(465, 378, 171, 20);
		panel_1.add(staffidret);
		
		JLabel lblNewLabel_2_3 = new JLabel("Id");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_3.setBounds(416, 365, 39, 42);
		panel_1.add(lblNewLabel_2_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(240, 234, 223));
		tabbedPane.addTab("CUSTOMER", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2_4 = new JLabel("Id");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_4.setBounds(27, 30, 39, 42);
		panel_2.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("Name");
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_5.setBounds(27, 75, 72, 42);
		panel_2.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_6 = new JLabel("Phone Number");
		lblNewLabel_2_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_6.setBounds(27, 115, 120, 42);
		panel_2.add(lblNewLabel_2_6);
		
		txtcid = new JTextField();
		txtcid.setBounds(153, 43, 96, 20);
		panel_2.add(txtcid);
		txtcid.setColumns(10);
		
		txtcname = new JTextField();
		txtcname.setColumns(10);
		txtcname.setBounds(153, 88, 96, 20);
		panel_2.add(txtcname);
		
		txtcphone = new JTextField();
		txtcphone.setColumns(10);
		txtcphone.setBounds(153, 128, 96, 20);
		panel_2.add(txtcphone);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(259, 115, 620, 221);
		panel_2.add(scrollPane_3);
		
		table_2 = new JTable();
		scrollPane_3.setViewportView(table_2);
		
		JButton customer_insert = new JButton("Insert");
		customer_insert.setBackground(new Color(255, 255, 255));
		customer_insert.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			
			String cid,name,phone;
			
			cid= txtcid.getText();
			name= txtcname.getText();
			phone= txtcphone.getText();
			
			try {
				pst = con.prepareStatement("insert into CUSTOMER(Cust_id,Name,Phone_number)values(?,?,?)");
				pst.setString(1, cid);
				pst.setString(2, name);
				pst.setString(3, phone);
				
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "insertion is done successfully");
				table_load_customer();
				          
				txtcid.setText("");
				txtcname.setText("");
				txtcphone.setText("");
				txtstaffid.requestFocus();
				   }
				 
				catch (SQLException e1)
				        {
				e1.printStackTrace();
				}
			
			
				
			
		}});
		customer_insert.setFont(new Font("Tahoma", Font.BOLD, 14));
		customer_insert.setBounds(361, 43, 94, 48);
		panel_2.add(customer_insert);
		
		JButton customer_delete = new JButton("Delete");
		customer_delete.setBackground(new Color(255, 255, 255));
		customer_delete.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			
			
         String cidre;
			
			
			cidre = cidret.getText();
			
			try {
				pst = con.prepareStatement("delete from CUSTOMER where Cust_id = ? ");
				
				pst.setString(1, cidre);
				
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "deletion is done successfully");
				table_load_customer();
				          
				txtcid.setText("");
				txtcname.setText("");
				txtcphone.setText("");
				txtstaffid.requestFocus();
				   }
				 
				catch (SQLException e1)
				        {
				e1.printStackTrace();
				}
			
			
			
		}});
		customer_delete.setFont(new Font("Tahoma", Font.BOLD, 14));
		customer_delete.setBounds(661, 43, 94, 48);
		panel_2.add(customer_delete);
		
		JButton customer_update = new JButton("Update");
		customer_delete.setBackground(new Color(255, 255, 255));
		customer_update.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			
          String cidre,cid,name,phone;
			
			cid= txtcid.getText();
			name= txtcname.getText();
			phone= txtcphone.getText();
			cidre = cidret.getText();
			
			try {
				pst = con.prepareStatement("update CUSTOMER set Cust_id = ?,Name = ?,Phone_number = ? where Cust_id=?");
				pst.setString(1, cid);
				pst.setString(2, name);
				pst.setString(3, phone);
				pst.setString(4, cidre);
				
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "update is done successfully");
				table_load_customer();
				          
				txtcid.setText("");
				txtcname.setText("");
				txtcphone.setText("");
				cidret.setText("");
				txtstaffid.requestFocus();
				   }
				 
				catch (SQLException e1)
				        {
				e1.printStackTrace();
				}
			
			
				
			
			
			
		}});
		customer_update.setFont(new Font("Tahoma", Font.BOLD, 14));
		customer_update.setBounds(653, 375, 89, 23);
		panel_2.add(customer_update);
		
		JLabel lblNewLabel_2_4_1 = new JLabel("Id");
		lblNewLabel_2_4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_4_1.setBounds(416, 365, 39, 42);
		panel_2.add(lblNewLabel_2_4_1);
		
		cidret = new JTextField();
		cidret.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				
				try {
			          
		            String id = cidret.getText();

		                pst = con.prepareStatement("select Cust_id,Name,Phone_number from CUSTOMER where Cust_id = ?");
		                pst.setString(1, id);
		                ResultSet rs = pst.executeQuery();

		            if(rs.next()==true)
		            {
		                String Id = rs.getString(1);
		                String name = rs.getString(2);
		                String phone = rs.getString(3);
		                
		              
		                txtcid.setText(Id);
		            	txtcname.setText(name);
		    			txtcphone.setText(phone);
		    		
		                
		            }   
		            else
		            {
		            	txtcid.setText("");
		            	txtcname.setText("");
		            	txtcphone.setText("");
		    			
		                 
		            }
		            


		        } 
			
			 catch (SQLException ex) {
		           
		        }
			
				
				
			}});
		cidret.setColumns(10);
		cidret.setBounds(465, 378, 171, 20);
		panel_2.add(cidret);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(240, 234, 223));
		tabbedPane.addTab("BRANCH", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2_4_2 = new JLabel("Id");
		lblNewLabel_2_4_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_4_2.setBounds(27, 30, 39, 42);
		panel_3.add(lblNewLabel_2_4_2);
		
		JLabel lblNewLabel_2_4_3 = new JLabel("Location");
		lblNewLabel_2_4_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_4_3.setBounds(27, 75, 72, 42);
		panel_3.add(lblNewLabel_2_4_3);
		
		JLabel lblNewLabel_2_4_4 = new JLabel("Phone number");
		lblNewLabel_2_4_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_4_4.setBounds(27, 115, 120, 42);
		panel_3.add(lblNewLabel_2_4_4);
		
		txtbid = new JTextField();
		txtbid.setColumns(10);
		txtbid.setBounds(153, 43, 96, 20);
		panel_3.add(txtbid);
		
		txtblocation = new JTextField();
		txtblocation.setColumns(10);
		txtblocation.setBounds(153, 88, 96, 20);
		panel_3.add(txtblocation);
		
		txtbphone = new JTextField();
		txtbphone.setColumns(10);
		txtbphone.setBounds(153, 128, 96, 20);
		panel_3.add(txtbphone);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(259, 115, 620, 221);
		panel_3.add(scrollPane_4);
		
		table_3 = new JTable();
		scrollPane_4.setViewportView(table_3);
		
		JButton branch_insert = new JButton("Insert");
		branch_insert.setBackground(new Color(255, 255, 255));
		branch_insert.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			
          String bid,loction,phone;
			
			bid= txtbid.getText();
			loction= txtblocation.getText();
			phone= txtbphone.getText();
			
			
			try {
				pst = con.prepareStatement("insert into BRANCH(Id,Location,Phone_number)values(?,?,?)");
				pst.setString(1, bid);
				pst.setString(2, loction);
				pst.setString(3, phone);
				
				
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "insertion is done successfully");
				table_load_branch();
				          
				txtbid.setText("");
				txtblocation.setText("");
				txtbphone.setText("");
				
				txtbid.requestFocus();
				   }
				 
				catch (SQLException e1)
				        {
				e1.printStackTrace();
				}
			
			
				
			
			
		}});
		branch_insert.setFont(new Font("Tahoma", Font.BOLD, 14));
		branch_insert.setBounds(361, 43, 94, 48);
		panel_3.add(branch_insert);
		
		JButton branch_delete = new JButton("Delete");
		branch_delete.setBackground(new Color(255, 255, 255));
		branch_delete.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			
			
			 String bidre;
				
				
				bidre = txtbidret.getText();
				
				try {
					pst = con.prepareStatement("delete from BRANCH where Id = ? ");
					
					pst.setString(1, bidre);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "deletion is done successfully");
					table_load_branch();
					          
					txtbid.setText("");
					txtblocation.setText("");
					txtbphone.setText("");
					txtbid.requestFocus();
					
					   }
					 
					catch (SQLException e1)
					        {
					e1.printStackTrace();
					}
				
				
					
			
			
			
		}});
		branch_delete.setFont(new Font("Tahoma", Font.BOLD, 14));
		branch_delete.setBounds(661, 43, 94, 48);
		panel_3.add(branch_delete);
		
		JLabel lblNewLabel_2_4_2_1 = new JLabel("Id");
		lblNewLabel_2_4_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_4_2_1.setBounds(416, 365, 39, 42);
		panel_3.add(lblNewLabel_2_4_2_1);
		
		txtbidret = new JTextField();
		txtbidret.addKeyListener(new KeyAdapter() {public void keyReleased(KeyEvent e) {
			
			try {
		          
	            String id = txtbidret.getText();

	                pst = con.prepareStatement("select Id,Location,Phone_number from BRANCH where Id = ?");
	                pst.setString(1, id);
	                ResultSet rs = pst.executeQuery();

	            if(rs.next()==true)
	            {
	                String Id = rs.getString(1);
	                String name = rs.getString(2);
	                String phone = rs.getString(3);
	                
	              
	                txtbid.setText(Id);
	            	txtblocation.setText(name);
	    			txtbphone.setText(phone);
	    		
	                
	            }   
	            else
	            {
	            	txtcid.setText("");
	            	txtcname.setText("");
	            	txtcphone.setText("");
	    			
	                 
	            }
	            


	        } 
		
		 catch (SQLException ex) {
	           
	        }
		
			
			
		}});
		txtbidret.setColumns(10);
		txtbidret.setBounds(465, 378, 171, 20);
		panel_3.add(txtbidret);
		
		JButton branch_update = new JButton("Update");
		branch_update.setBackground(new Color(255, 255, 255));
		branch_update.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {
		
			
			 String bid,loction,phone,bidret;
				
				bid= txtbid.getText();
				bidret = txtbidret.getText();
				loction= txtblocation.getText();
				phone= txtbphone.getText();
				
				
				try {
					pst = con.prepareStatement("update BRANCH set Id=? ,Location=?,Phone_number=? where Id=? ");
					pst.setString(1, bid);
					pst.setString(2, loction);
					pst.setString(3, phone);
					pst.setString(4, bidret);
					
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "update is done successfully");
					table_load_branch();
					          
					txtbid.setText("");
					txtblocation.setText("");
					txtbphone.setText("");
					txtbidret.setText("");
					
					txtbid.requestFocus();
					   }
					 
					catch (SQLException e1)
					        {
					e1.printStackTrace();
					}
				
				
					
				
			
		}});
		branch_update.setFont(new Font("Tahoma", Font.BOLD, 14));
		branch_update.setBounds(666, 375, 89, 23);
		panel_3.add(branch_update);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(240, 234, 223));
		tabbedPane.addTab("RESTTABLE", null, panel_5, null);
		panel_5.setLayout(null);
		
		txttnum = new JTextField();
		txttnum.setColumns(10);
		txttnum.setBounds(153, 43, 96, 20);
		panel_5.add(txttnum);
		
		txtaval = new JTextField();
		txtaval.setColumns(10);
		txtaval.setBounds(153, 88, 96, 20);
		panel_5.add(txtaval);
		
		txtseats = new JTextField();
		txtseats.setColumns(10);
		txtseats.setBounds(153, 128, 96, 20);
		panel_5.add(txtseats);
		
		JLabel lblNewLabel_2_4_2_2_1 = new JLabel("Table_num");
		lblNewLabel_2_4_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_4_2_2_1.setBounds(27, 30, 105, 42);
		panel_5.add(lblNewLabel_2_4_2_2_1);
		
		JLabel lblNewLabel_2_4_2_2_2 = new JLabel("Aval_status");
		lblNewLabel_2_4_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_4_2_2_2.setBounds(27, 75, 105, 42);
		panel_5.add(lblNewLabel_2_4_2_2_2);
		
		JLabel lblNewLabel_2_4_2_2_3 = new JLabel("Num_seats");
		lblNewLabel_2_4_2_2_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_4_2_2_3.setBounds(27, 115, 120, 42);
		panel_5.add(lblNewLabel_2_4_2_2_3);
		
		JButton table_insert = new JButton("Insert");
		table_insert.setBackground(new Color(255, 255, 255));
		table_insert.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			
          String tablenum,aval,seatsnum;
			
            tablenum= txttnum.getText();
            aval= txtaval.getText();
            seatsnum= txtseats.getText();
			
			
			try {
				pst = con.prepareStatement("insert into RESTTABLE(Table_num,Aval_status,Num_seats)values(?,?,?)");
				pst.setString(1, tablenum);
				pst.setString(2, aval);
				pst.setString(3, seatsnum);
				
				
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "insertion is done successfully");
				table_load_resttable();
				          
				txttnum.setText("");
				txtaval.setText("");
				txtseats.setText("");
				
				txtbid.requestFocus();
				   }
				 
				catch (SQLException e1)
				        {
				e1.printStackTrace();
				}
			
			
			
		}});
		table_insert.setFont(new Font("Tahoma", Font.BOLD, 14));
		table_insert.setBounds(361, 43, 94, 48);
		panel_5.add(table_insert);
		
		JButton table_delete = new JButton("Delete");
		table_delete.setBackground(new Color(255, 255, 255));
		table_delete.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			
			
			String tnum;
			
          
            tnum = txttnumret.getText();
			
			try {
				pst = con.prepareStatement("delete from RESTTABLE where Table_num=?");
			pst.setString(1, tnum);
				
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "deletion is done successfully");
				table_load_resttable();
				          
				txttnum.setText("");
				txtaval.setText("");
				txtseats.setText("");
				txttnumret.setText("");
				
				txtbid.requestFocus();
				   }
				 
				catch (SQLException e1)
				        {
				e1.printStackTrace();
				}
			
			
				
			
		}});
		table_delete.setFont(new Font("Tahoma", Font.BOLD, 14));
		table_delete.setBounds(661, 43, 94, 48);
		panel_5.add(table_delete);
		
		txttnumret = new JTextField();
		txttnumret.addKeyListener( new KeyAdapter() {public void keyReleased(KeyEvent e) {
			
			
			try {
		          
	            String id = txttnumret.getText();

	                pst = con.prepareStatement("select Table_num,Aval_status,Num_seats from RESTTABLE where Table_num = ?");
	                pst.setString(1, id);
	                ResultSet rs = pst.executeQuery();

	            if(rs.next()==true)
	            {
	                String tnum = rs.getString(1);
	                String aval = rs.getString(2);
	                String seats = rs.getString(3);
	                
	              
	                txttnum.setText(tnum);
	            	txtaval.setText(aval);
	    			txtseats.setText(seats);
	    		
	                
	            }   
	            else
	            {
	            	txttnum.setText("");
	            	txtaval.setText("");
	            	txtseats.setText("");
	    			
	                 
	            }
	            


	        } 
		
		 catch (SQLException ex) {
	           
	        }
		
			
			
			
			
		}});
		txttnumret.setColumns(10);
		txttnumret.setBounds(508, 378, 171, 20);
		panel_5.add(txttnumret);
		
		JButton table_update = new JButton("Update");
		table_update.setBackground(new Color(255, 255, 255));
		table_update.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String tablenum,aval,seatsnum,tnum;
				
	            tablenum= txttnum.getText();
	            aval= txtaval.getText();
	            seatsnum= txtseats.getText();
	            tnum = txttnumret.getText();
				
				try {
					pst = con.prepareStatement("update RESTTABLE set Table_num=?,Aval_status=?,Num_seats=? where Table_num=?");
					pst.setString(1, tablenum);
					pst.setString(2, aval);
					pst.setString(3, seatsnum);
					pst.setString(4, tnum);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "update is done successfully");
					table_load_resttable();
					          
					txttnum.setText("");
					txtaval.setText("");
					txtseats.setText("");
					txttnumret.setText("");
					
					txtbid.requestFocus();
					   }
					 
					catch (SQLException e1)
					        {
					e1.printStackTrace();
					}
				
				
					
			
			
			
		}});
		table_update.setFont(new Font("Tahoma", Font.BOLD, 14));
		table_update.setBounds(692, 375, 89, 23);
		panel_5.add(table_update);
		
		JLabel lblNewLabel_2_4_2_2_1_1 = new JLabel("Table_num");
		lblNewLabel_2_4_2_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_4_2_2_1_1.setBounds(416, 365, 96, 42);
		panel_5.add(lblNewLabel_2_4_2_2_1_1);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(259, 115, 620, 221);
		panel_5.add(scrollPane_5);
		
		table_4 = new JTable();
		scrollPane_5.setViewportView(table_4);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(240, 234, 223));
		tabbedPane.addTab("CONTRACTS", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2_4_2_2_1_2 = new JLabel("Supplier id");
		lblNewLabel_2_4_2_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_4_2_2_1_2.setBounds(27, 30, 89, 42);
		panel_4.add(lblNewLabel_2_4_2_2_1_2);
		
		JLabel lblNewLabel_2_4_2_2_1_3 = new JLabel("Branch id");
		lblNewLabel_2_4_2_2_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_4_2_2_1_3.setBounds(27, 75, 89, 42);
		panel_4.add(lblNewLabel_2_4_2_2_1_3);
		
		JLabel lblNewLabel_2_4_2_2_1_4 = new JLabel("Start date");
		lblNewLabel_2_4_2_2_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_4_2_2_1_4.setBounds(27, 115, 120, 42);
		panel_4.add(lblNewLabel_2_4_2_2_1_4);
		
		JLabel lblNewLabel_2_4_2_2_1_5 = new JLabel("End date");
		lblNewLabel_2_4_2_2_1_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_4_2_2_1_5.setBounds(27, 161, 94, 42);
		panel_4.add(lblNewLabel_2_4_2_2_1_5);
		
		txtcsid = new JTextField();
		txtcsid.setColumns(10);
		txtcsid.setBounds(153, 43, 96, 20);
		panel_4.add(txtcsid);
		
		txtcbid = new JTextField();
		txtcbid.setColumns(10);
		txtcbid.setBounds(153, 88, 96, 20);
		panel_4.add(txtcbid);
		
		txtstart = new JTextField();
		txtstart.setColumns(10);
		txtstart.setBounds(153, 128, 96, 20);
		panel_4.add(txtstart);
		
		txtend = new JTextField();
		txtend.setColumns(10);
		txtend.setBounds(153, 174, 96, 20);
		panel_4.add(txtend);
		
		JScrollPane scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(259, 115, 620, 221);
		panel_4.add(scrollPane_8);
		
		table_7 = new JTable();
		scrollPane_8.setViewportView(table_7);
		
		JLabel lblNewLabel_2_4_2_2_1_2_1 = new JLabel("Supplier id");
		lblNewLabel_2_4_2_2_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_4_2_2_1_2_1.setBounds(416, 365, 94, 42);
		panel_4.add(lblNewLabel_2_4_2_2_1_2_1);
		
		JLabel lblNewLabel_2_4_2_2_1_3_1 = new JLabel("Branch id");
		lblNewLabel_2_4_2_2_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_4_2_2_1_3_1.setBounds(415, 418, 95, 15);
		panel_4.add(lblNewLabel_2_4_2_2_1_3_1);
		
		txtcsidrret = new JTextField();
		txtcsidrret.addKeyListener(new KeyAdapter() {public void keyReleased(KeyEvent e) {
			

			try {
		          
	            String ssid = txtcsidrret.getText();

	                pst = con.prepareStatement("select Sid,Bid,Start_date,End_date from CONTRACTS where Sid = ?");
	                pst.setString(1, ssid);
	             
	                ResultSet rs = pst.executeQuery();

	            if(rs.next()==true)
	            {
	                String sid = rs.getString(1);
	                String bid = rs.getString(2);
	                String start = rs.getString(3);
	                String end = rs.getString(4);
	                
	              
	                txtcsid.setText(sid);
	            	txtcbid.setText(bid);
	    			txtstart.setText(start);
	    			txtend.setText(end);
	    		
	                
	            }   
	            else
	            {
	            	txtcsid.setText("");
	            	txtcbid.setText("");
	    			txtstart.setText("");
	    			txtend.setText("");
	    		
	                 
	            }
	            


	        } 
		
		 catch (SQLException ex) {
	           
	        }
		
			
			
			
		}});
		txtcsidrret.setColumns(10);
		txtcsidrret.setBounds(503, 378, 171, 20);
		panel_4.add(txtcsidrret);
		
		txtcbidret = new JTextField();
		txtcbidret.setColumns(10);
		txtcbidret.setBounds(503, 418, 171, 20);
		panel_4.add(txtcbidret);
		
		JButton contracts_update = new JButton("Update");
		contracts_update.setBackground(new Color(255, 255, 255));
		contracts_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}});
		contracts_update.setFont(new Font("Tahoma", Font.BOLD, 14));
		contracts_update.setBounds(703, 394, 89, 23);
		panel_4.add(contracts_update);
		
		JButton contracts_insert = new JButton("Insert");
		contracts_insert.setBackground(new Color(255, 255, 255));
		contracts_insert.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			
			
			 String sid,bid,start,end;
				
			    sid= txtcsid.getText();
	            bid= txtcbid.getText();
	            start= txtstart.getText();
	            end= txtend.getText();
				
				try {
					pst = con.prepareStatement("insert into CONTRACTS(Sid,Bid,Start_date,End_date)values(?,?,?,?)");
					pst.setString(1, sid);
					pst.setString(2, bid);
					pst.setString(3, start);
					pst.setString(4, end);
					
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "insertion is done successfully");
					table_load_contracts();
					          
					txtcsid.setText("");
					txtcbid.setText("");
					txtstart.setText("");
					txtend.setText("");
					
					txtcsid.requestFocus();
					   }
					 
					catch (SQLException e1)
					        {
					e1.printStackTrace();
					}
				
				
			
			
			
		}});
		contracts_insert.setFont(new Font("Tahoma", Font.BOLD, 14));
		contracts_insert.setBounds(361, 43, 94, 48);
		panel_4.add(contracts_insert);
		
		JButton contracts_delete = new JButton("Delete");
		contracts_delete.setBackground(new Color(255, 255, 255));
		contracts_delete.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
		}});
		contracts_delete.setFont(new Font("Tahoma", Font.BOLD, 14));
		contracts_delete.setBounds(661, 43, 94, 48);
		panel_4.add(contracts_delete);
		
		
		JPanel panel_61 = new JPanel();
		panel_61.setBackground(new Color(240, 234, 223));
		tabbedPane.addTab("RETRIEVE", null, panel_61, null);
		panel_61.setLayout(null);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(45, 11, 717, 134);
		panel_61.add(scrollPane_6);
		
		table_5 = new JTable();
		scrollPane_6.setViewportView(table_5);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(45, 158, 717, 162);
		panel_61.add(scrollPane_7);
		
		table_6 = new JTable();
		scrollPane_7.setViewportView(table_6);
		
		txtsal = new JTextField();
		txtsal.setColumns(10);
		txtsal.setBounds(179, 365, 116, 20);
		panel_61.add(txtsal);
		
		txtrole = new JTextField();
		txtrole.addKeyListener(new KeyAdapter() {public void keyReleased(KeyEvent e) {
		
			
			try {
		          
	            String role = txtrole.getText();

	                pst = con.prepareStatement("select AVG(Monthly_salary) from STAFF where Role = ?");
	                pst.setString(1, role);
	             
	                ResultSet rs = pst.executeQuery();

	            if(rs.next()==true)
	            {
	                String salary = rs.getString(1);
	               
	                
	              
	                txtsal.setText(salary);
	            	
	                
	            }   
	            else
	            {
	            	txtsal.setText("");
	            	
	    		
	                 
	            }
	            


	        } 
		
		 catch (SQLException ex) {
	           
	        }
		
			
			
			
			
			
		}});
		txtrole.setColumns(10);
		txtrole.setBounds(55, 365, 96, 20);
		panel_61.add(txtrole);
		
		JLabel lblNewLabel_2_4_2_2_1_2_2 = new JLabel("Role");
		lblNewLabel_2_4_2_2_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_4_2_2_1_2_2.setBounds(82, 344, 95, 15);
		panel_61.add(lblNewLabel_2_4_2_2_1_2_2);
		
		JLabel lblNewLabel_2_4_2_2_1_2_3 = new JLabel("Average salary");
		lblNewLabel_2_4_2_2_1_2_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_4_2_2_1_2_3.setBounds(179, 344, 120, 15);
		panel_61.add(lblNewLabel_2_4_2_2_1_2_3);
		
	}
	
	
	


	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}






	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}






	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}






	





	




	





	




	
	
	
	
	}
