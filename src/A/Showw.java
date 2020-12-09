
package A;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.sql.*;
class Showw implements ActionListener
{

   JFrame f;
   JLabel l1,l2,l3,l4,l5;
   JTextField t1,t2,t3,t4,t5;
   JButton b1,b2,b3;
   DefaultTableModel model;
   Connection con;
   JPanel p1,p2,p3;
   Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
    Showw()
    {
       try 
       {
  
         f=new JFrame("Submit details");
         l1=new JLabel("date:");
         l2=new JLabel("Coustumer id:");
         l3=new JLabel("milk liter:");
         l4=new JLabel("rate:");
         l5=new JLabel("total:");
         

         t1=new JTextField(20);
         t2=new JTextField(20);
         t3=new JTextField(20);
         t4=new JTextField(20);
         t5=new JTextField(20);

         b1=new JButton("Insert");
         b2=new JButton("close");
         b3=new JButton("View");
         p1=new JPanel();
         p2=new JPanel();
         p3=new JPanel();
         model= new DefaultTableModel();
         p1.setLayout(new GridLayout(5,2));
          p2.setLayout(new FlowLayout());
         p1.add(l1);
         p1.add(t1);
         p1.add(l2);
         p1.add(t2);
         p1.add(l3);
         p1.add(t3);
          p1.add(l4);
         p1.add(t4);
         p1.add(l5);
         p1.add(t5);
         p2.add(b1);
         p2.add(b3);
         p2.add(b2);
         f.add(p1,BorderLayout.NORTH);
         f.add(p2,BorderLayout.CENTER);
       showRecords();

      b1.addActionListener(this);
      b2.addActionListener(this);
      b3.addActionListener(this);


      f.setSize(d.width,d.height);
      f.setVisible(true);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
    }catch(Exception e)
     {
      System.out.println("caught error "+e);

       }
         }
     
    public void actionPerformed(ActionEvent ae)
   { 

    if(ae.getSource()==b1)
     {
     try{
     
      String sql="insert into Milk_Sell values(?,?,?,?,?)";
      PreparedStatement psmt=con.prepareStatement(sql);
      
      
      int cno=Integer.parseInt(t2.getText());
      String date=t1.getText();
      int lit=Integer.parseInt(t3.getText());
      int rate=Integer.parseInt(t4.getText());
      int rs=Integer.parseInt(t5.getText());
       psmt.setString(1,date);
      psmt.setInt(2,cno);
      psmt.setInt(3,lit);
      psmt.setInt(4,rate);
      psmt.setInt(5,rs);
     
      //psmt.setDouble(3,p);

      int i=psmt.executeUpdate();
      if(i>0)
      JOptionPane.showMessageDialog(null,"record inserted");
      else
      JOptionPane.showMessageDialog(null,"record not inserted");
      t1.setText("");
      t2.setText("");
      t3.setText("");
      psmt.close();
      showRecords();
     }


   

     catch(Exception e)
     {
      System.out.println("caught error "+e);

       }
      }
     if(ae.getSource()==b2)
   {
     System.exit(0);
      }
     if(ae.getSource()==b3)
   {
     showRecords();
      }



       }

   void showRecords()
   {
   try{
   
     model.setRowCount(0);
     model.setColumnCount(0);
  
     model.addColumn("Date");
     model.addColumn("C_No");
      model.addColumn("liter");
      model.addColumn("Rate");
      model.addColumn("Rupees");
   
      Class.forName("org.postgresql.Driver");
       con=DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","shubhampwr");

    Statement smt=con.createStatement();
    ResultSet rs=smt.executeQuery("select * from Milk_Sell");
    String[] row={"","","","",""};
    while(rs.next())
    {
      row[0]=rs.getString(1);
      row[1]=rs.getString(2);
      row[2]=rs.getString(3);
      row[3]=rs.getString(4);
      row[4]=rs.getString(5);
     //Double d=rs.getDouble(3);
      //row[2]=d.toString();
      model.addRow(row);
      }
     JTable table=new JTable(model);
     JScrollPane jsp=new JScrollPane(table);
     p3=new JPanel();
     p3.add(jsp);
    f.add(p3,BorderLayout.SOUTH);
      }
     catch(Exception e)
     {
      System.out.println("caught error "+e);

       }

         }

       public static void main(String args[])
     {
       new Showw();
     }
      }

