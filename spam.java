import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;

class Spam{
    public static void main(String[] args) {
        Spam1 l=new Spam1();
        

    }

}

 class Spam1 extends JFrame implements ActionListener
{
JTextField t1;
    JButton b1;
    Spam1(){
        setLocation(250,250);
        setSize(400,300);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        Container c = getContentPane();
        c.setBackground(Color.CYAN);
        JLabel l1=new JLabel("Spam check");
        l1.setFont(new Font("Times New Roman",Font.BOLD,30));
        l1.setForeground(Color.BLUE);
        l1.setBounds(50,100,200,30);
        c.add(l1);


        t1=new JTextField(500);
        b1=new JButton("Check");
        t1.setBounds(50,150,200,50);
        b1.setBounds(50,250,100,30);
       
        
        c.add(t1);
        c.add(b1);
        b1.addActionListener(this);
  }
  public void actionPerformed(ActionEvent e)
            {
            String s =t1.getText();
            String cpy =s;

            String[] sentence=s.split("\\.");
            String[][] matrix =new String[sentence.length][100];
            for(int i=0;i<sentence.length;i++) 
           {
                 String sentences=sentence[i].trim();
                 String[] words = sentences.split("\\s+");
                  matrix[i]=words;           

            }
            
          //printing the matrix containing sentences in each row
          /*for(int i=0;i<matrix.length;i++)
        {   for(int j=0;j<matrix[i].length;j++)
        {
           System.out.println(matrix[i][j]+" ");
        }
           System.out.println();
        }*/
        int count[][]= new int[10][100];
        for(int i =0;i<10;i++)
        {
             count[i][0]=1;
             count[i][1]=2;
             count[i][2]=3;
             count[i][3]=4;
             count[i][4]=5;
             count[i][5]=5; //assuming the 5th word is a dot
             count[i][6]=2;
             count[i][7]=3;
             count[i][8]=4;
             count[i][9]=3;
        }
        String[] exceededWords = new String[100]; // Assuming a maximum of 100 words
                int exceededIndex = 0;
        int thirdarray[]= new int[100];
        int m=0;
                // Check occurrence of each word in each sentence
                for (int i = 0; i < matrix.length; i++) {
                    String[] sent = matrix[i];
                    for (int j = 0; j < sent.length; j++) {
                        String word = sent[j];
                        int occurrence = 0;
                        for (int k = 0; k < sent.length; k++) {
                            if (word.equals(sent[k])) {
                                occurrence++;
                                
                            }
                        }
                        if (occurrence > count[i][j]) {
                            exceededWords[exceededIndex++] = word;
                            thirdarray[m++]=occurrence;
                        }
                    }
                }

                // Print the words with occurrences greater than the set value
                System.out.println("Words with occurrences greater than set value:");
                for (int i = 0; i < exceededIndex; i++) {
                    System.out.println(exceededWords[i]);
                }
                if (m > 4) {
            JOptionPane.showMessageDialog(this, "This is a spam");
        } else {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to check for specific spam words?", "Check Spam Words", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.NO_OPTION) {
                System.exit(0); // Terminate the program if the user clicks "No"
            } else {
                new CheckSpamWords(cpy); // Start a new ActionListener if the user clicks "Yes"
            }
        }
    }
}

class CheckSpamWords extends JFrame implements ActionListener{
    
    JButton b1;
    String cpy;
    CheckSpamWords(String cpy) {
        
        this.cpy = cpy;
        setLocation(250, 250);
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        Container c1 = getContentPane();
        b1 = new JButton("Check");
        b1.setBounds(50, 100, 100, 30);

        
        c1.add(b1);
        b1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String s =cpy;
        String[] spamWords = {"fraud", "money", "kill"}; // Spam words to check against
        int count = 0;
        for (int i = 0; i < spamWords.length; i++) {
            if (s.contains(spamWords[i])) {
                count++;
            }
        }
        if (count >= 2) {
            JOptionPane.showMessageDialog(this, "This is a spam");
        } else {
            JOptionPane.showMessageDialog(this, "Not a spam");
        }
    }
}