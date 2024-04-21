import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame implements ActionListener {
    JTextField idField,nameField,addressField,smartphonefield,oopfield,Tshirtfield;JButton summit;
    ElectronicProduct smartphone=new ElectronicProduct(1,"smartphone"
            , 599.9F,"sumsang",1);
    ClothingProduct Tshirt=new ClothingProduct(1,"T-shirt",19.99F,
            "midum","cotton");
    BookProduct oop=new BookProduct(3,"opp",39.99F,
            "O Relly","X publication");
    Gui(){
        setTitle("Customer Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(7, 2, 5, 5));

        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();
        add(idLabel);
        add(idField);

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        add(nameLabel);
        add(nameField);

        JLabel addressLabel = new JLabel("Address:");
        addressField = new JTextField();
        add(addressLabel);
        add(addressField);


        JLabel smartphonelabel = new JLabel("smartphone:");
        smartphonefield = new JTextField();
        add(smartphonelabel);
        add(smartphonefield);

        JLabel Tshirtlabel = new JLabel("Tshirt:");
        Tshirtfield = new JTextField();
        add(Tshirtlabel);
        add(Tshirtfield);

        JLabel ooplabel = new JLabel("oop:");
        oopfield = new JTextField();
        add(ooplabel);
        add(oopfield);

        summit=new JButton();
        summit.setText("summit");
        add(summit);
        summit.addActionListener(this);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(summit)){

            int id = Integer.parseInt(idField.getText());
            String name =nameField.getText();
            String address =addressField.getText();
            Customer customer=new Customer(id,name,address);
            Cart cart=new Cart(id,3);
            if (!oopfield.getText().isEmpty()){
                int Noop = Integer.parseInt(oopfield.getText());
                oop.setPrice(oop.getPrice()*Noop);
                cart.addProduct(oop);
            }
            if (!Tshirtfield.getText().isEmpty()){
                int NTshirt = Integer.parseInt(Tshirtfield.getText());
                Tshirt.setPrice(Tshirt.getPrice()*NTshirt);
                cart.addProduct(Tshirt);

            }
            if (!smartphonefield.getText().isEmpty()){
                int Nsmartphone = Integer.parseInt(smartphonefield.getText());
                smartphone.setPrice(smartphone.getPrice()*Nsmartphone);
                cart.addProduct(smartphone);
            }
            Order order=new Order(id,1,cart.getProducts(),cart.numbers);
            String a="your total is %f whould you like to place the order".formatted(cart.calculatePrice());
            int action=JOptionPane.showConfirmDialog(null,a,
                    "action",JOptionPane.YES_NO_OPTION);
            if (action==0){
                String b=order.getOrderInfo();
                JOptionPane.showConfirmDialog(null,b,
                        "action",JOptionPane.OK_OPTION);
            }else{
                System.exit(0);

            }
        }
    }
}
