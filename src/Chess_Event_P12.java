import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Chess_Event_P12 {

    public static void main(String[] args){
        
     
        JFrame frame = new JFrame();
        JTable table = new JTable(); 
        
        frame.setTitle("Chess Event");
        frame.getContentPane().setBackground(Color.decode("#2078D1"));
        
        
        Object[] columns = {"Eventnaam","Datum","Tijd","Locatie"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        
        
        table.setModel(model);
        
        
        table.setBackground(Color.white);
        table.setForeground(Color.black);
        Font font = new Font("",1,15);
        table.setFont(font);
        table.setRowHeight(30);
        
        JLabel eNaam = new JLabel();
        eNaam.setText("Eventnaam");
        eNaam.setBounds(20,190,800,80);
        eNaam.setFont(new Font("", Font.BOLD, 15));
        eNaam.setForeground(Color.white);
        
        JLabel dNaam = new JLabel();
        dNaam.setText("Datum");
        dNaam.setBounds(20,220,800,80);
        dNaam.setFont(new Font("", Font.BOLD, 15));
        dNaam.setForeground(Color.white);
        
        JLabel tNaam = new JLabel();
        tNaam.setText("Tijd");
        tNaam.setBounds(20,250,800,80);
        tNaam.setFont(new Font("", Font.BOLD, 15));
        tNaam.setForeground(Color.white);
        
        JLabel lNaam = new JLabel();
        lNaam.setText("Locatie");
        lNaam.setBounds(20,280,800,80);
        lNaam.setFont(new Font("", Font.BOLD, 15));
        lNaam.setForeground(Color.white);
        
        
        JTextField textEvent = new JTextField();
        JTextField textDate = new JTextField();
        JTextField textTijd = new JTextField();
        JTextField textLocatie = new JTextField();
        
        
        JButton btnAdd = new JButton("Add");
        JButton btnDelete = new JButton("Delete");
        JButton btnUpdate = new JButton("Update");     
        
        textEvent.setBounds(120, 220, 100, 25);
        textDate.setBounds(120, 250, 100, 25);
        textTijd.setBounds(120, 280, 100, 25);
        textLocatie.setBounds(120, 310, 100, 25);
        
        btnAdd.setBounds(250, 285, 150, 50);
        btnUpdate.setBounds(420, 285, 150, 50);
        btnDelete.setBounds(590, 285, 150, 50);
        
        btnAdd.setBackground(Color.decode("#21B563"));
        btnAdd.setForeground(Color.white);
        btnAdd.setFont(new Font("", Font.BOLD, 20));
        
        btnUpdate.setBackground(Color.WHITE);
        btnUpdate.setForeground(Color.BLACK);
        btnUpdate.setFont(new Font("", Font.BOLD, 20));
        
        btnDelete.setBackground(Color.decode("#D8213B"));
        btnDelete.setForeground(Color.white);
        btnDelete.setFont(new Font("", Font.BOLD, 20));
        
        
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0, 880, 200);
        
        frame.setLayout(null);
        
        frame.add(pane);
        
        frame.add(eNaam);
        frame.add(dNaam);
        frame.add(tNaam);
        frame.add(lNaam);
        
        
        frame.add(textEvent);
        frame.add(textDate);
        frame.add(textTijd);
        frame.add(textLocatie);
    
        
        frame.add(btnAdd);
        frame.add(btnDelete);
        frame.add(btnUpdate);
        
        
        Object[] row = new Object[4];
        
        
        btnAdd.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
             
                row[0] = textEvent.getText();
                row[1] = textDate.getText();
                row[2] = textTijd.getText();
                row[3] = textLocatie.getText();
                
                
                model.addRow(row);
            }
        });
        
        
        btnDelete.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            
              
                int i = table.getSelectedRow();
                if(i >= 0){
                   
                    model.removeRow(i);
                }
                else{
                    System.out.println("Delete Error");
                }
            }
        });
        
       
        table.addMouseListener(new MouseAdapter(){
        
        @Override
        public void mouseClicked(MouseEvent e){
            
        
            int i = table.getSelectedRow();
            
            textEvent.setText(model.getValueAt(i, 0).toString());
            textDate.setText(model.getValueAt(i, 1).toString());
            textTijd.setText(model.getValueAt(i, 2).toString());
            textLocatie.setText(model.getValueAt(i, 3).toString());
        }
        });
        
        
        btnUpdate.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
             
               
                int i = table.getSelectedRow();
                
                if(i >= 0) 
                {
                   model.setValueAt(textEvent.getText(), i, 0);
                   model.setValueAt(textDate.getText(), i, 1);
                   model.setValueAt(textTijd.getText(), i, 2);
                   model.setValueAt(textLocatie.getText(), i, 3);
                }
                else{
                    System.out.println("Update Error");
                }
            }
        });
        
        frame.setSize(890,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
}