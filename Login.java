package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField textField;
    JPasswordField passwordField;

    JButton b1,b2;
    Login(){
        JLabel namelabel = new JLabel("Username");
        namelabel.setBounds(40,100,100,30);
        namelabel.setFont(new Font("Tohoma",Font.BOLD,20));
        namelabel.setForeground(Color.BLACK);
        add(namelabel);

        JLabel passwordlabel = new JLabel("Password");
        passwordlabel.setBounds(40,150,100,30);
        passwordlabel.setFont(new Font("Tohoma",Font.BOLD,20));
        passwordlabel.setForeground(Color.BLACK);
        add(passwordlabel);

        textField = new JTextField();
        textField.setBounds(150,100,150,30);
        textField.setFont(new Font("Tahoma",Font.BOLD,20));
        textField.setBackground(new Color(255,179,0));
        add(textField);

        passwordField = new JPasswordField();
        passwordField.setBounds(150,150,150,30);
        passwordField.setFont(new Font("Tahoma",Font.BOLD,20));
        passwordField.setBackground(new Color(255,179,0));
        add(passwordField);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
       ImageIcon imageIcon1 = new ImageIcon(i1);
       JLabel label = new JLabel(imageIcon1);
       label.setBounds(300,0,400,300);
       add(label);

       b1 = new JButton("Login");
       b1.setBounds(40,220,120,30);
       b1.setFont(new Font("serif",Font.BOLD,15));
       b1.setBackground(Color.BLACK);
       b1.setForeground(Color.white);
       b1.addActionListener(this);
       add(b1);

        b2 = new JButton("Cencel");
        b2.setBounds(180,220,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);






        getContentPane().setBackground(new Color(109,164,170));
        setSize( 750,300);
        setLayout(null);
        setVisible(true);
        setLocation(350,250);

    }
    public static void main(String[] args){
        new Login();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            try{
                connection c=new connection();
                String user = textField.getText();
                String pass= passwordField.getText();

                String q = "select * from login where ID ='"+user+"' and password = '"+pass+"'";
                ResultSet resultSet = c.statement.executeQuery(q);

                if(resultSet.next()){
                    new text();
                    setVisible(false);

                }
                else{
                    JOptionPane.showConfirmDialog(null,"Invalid");
                }

            }catch (Exception E){
                E.printStackTrace();
            }

        }else{
            System.exit(10);

        }

    }
}
