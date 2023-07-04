package o_meu_Package;


import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.System.*;
import javax.accessibility.Accessible;
import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.border.*;

public class Encripta extends JFrame implements ActionListener {
	
	
	
		private static final long serialVersionUID = 1L;

		//dados globais
		
		
		//fontes
		Font normal = new Font("Corbel", Font.BOLD, 20);
		Font bold   = new Font("Corbel", Font.BOLD, 20);
		
		//captura tamanho do ecra	
		Toolkit   tlk;
		Dimension dim;
		int comp = 1500;
		int alt  = 850;
		
		//dados barra de menu
		
		JMenuBar menubar;
		JMenu mn;
		JMenu mn1;
	
		String tx    [] = { " Ler Ficheiro ASCII "," Gravar Ficheiro ASCII ", " Ler Ficheiro Morse "," Gravar Ficheiro Morse ",
							 " Converter Morse para ASCII ", " Converter ASCII para Morse ", " Abandonar Aplicação " };
		
		
		String tx1    [] = { " Programa "," Linguagem "," Autor "};
		
		
		JMenuItem it [] = new JMenuItem [tx.length];
		JMenuItem it1 [] = new JMenuItem [tx1.length];
		
	
		String [] st  = { " Conv. para ASCII "," Conv. para Morse "," Apagar TextArea Up "," Apagar TextArea Down "," Abandonar App " };
	
		
		
		//Painéis
		
		JPanel norte, centro, sul, centro1;	
		JLabel lb, lb1;
		JTextField tf, tf1;
		JTextArea ta, ta1;
		JScrollPane sp, sp1;
		JTabbedPane tabbed;
		Border br, br1, br2;
		JButton btn []  = new JButton [5];
		ImageIcon icon  = new ImageIcon (getClass().getResource ("binary.png"));
		Image image      = new ImageIcon (getClass().getResource ("codding.png")).getImage();
		ImageIcon home  = new ImageIcon (getClass().getResource ("Binário.jpeg"));
		JLabel inicio 	  = new JLabel (home);
		JFileChooser fchooser = new JFileChooser();;
		int returnValor;
		File dir;
		Icon dialogo = new ImageIcon (getToolkit().createImage(getClass().getResource("lock.png")));
		Icon linguagem = new ImageIcon (getToolkit().createImage(getClass().getResource("java.png")));
		Icon user = new ImageIcon (getToolkit().createImage(getClass().getResource("user.png")));
	
			
			
	
		String [] ASCII = {
			
			
	
			"a",
			"b",
			"c",
			"d",
			"e",
			"f",
			"g",
			"h",
			"i",
			"j",
			"k",
			"l",
			"m",
			"n",
			"o",
			"p",
			"q",
			"r",
			"s",
			"t",
			"u",
			"v",
			"w",
			"x",
			"y",
			"z",
			
			"A",
			"B",
			"C",
			"D",
			"E",
			"F",
			"G",
			"H",
			"I",
			"J",
			"K",
			"L",
			"M",
			"N",
			"O",
			"P",
		    "Q",
			"R",
			"S",
			"T",
			"U",
			"V",
			"W",
			"X",
			"Y",
			"Z",
			
			"0",
			"1",
			"2",
			"3",
			"4",
			"5",
			"6",
			"7",
			"8",
			"9",
			
			",",
			".",
			"?",
			";",
			":",
			"\\",
			"-",
			"/",
			"(",
			
			")",
			"!",
			"=",
			"_",
			"$",			
	        "@",
		    "&",
		    " ",
	
		    "{",
		    "}",
		    "[",
		    "]",
		    "*",
		    "%",
		    "~",
		    "+",
		    "|"
		    
			
		};	
		
		
		
		
		
		String[] Morse = {
				
				
		     ".-",
			"-...",
			"-.-.",
			"-..",
			".",
			"..-.",
			"--.",
			"....",
			"..",
			".---",
			"-.-",
			".-..",
			"--",
			"-.",
			"---",
			".--.",
			"--.-",
			".-.",
			"...",
			"-",
			"..-",
			"...-",
			".--",
			"-..-",
			"-.--",
			"--..",
			
			".---.-",
			".----...",
			".----.-.",
			".----..",
			".---.",
			".---..-.",
			".-----.",
			".---....",
			".---..",
			".---.---",
			".----.-",
			".---.-..",
			".-----",
			".----.",
			".------",
			".---.--.",
			".-----.-",
			".---.-.",
			".---...",
			".----",
			".---..-",
			".---...-",
			".---.--",
			".----..-",
			".----.--",
			".-----..",
			
			"-----",
			".----",
			"..---",
			"...--",
			"....-",
			".....",
			"-....",
			"--...",
			"---..",
			"----.",
			
			
			
			
			"--..--",
			".-.-.-",
			"..--..",
		    "-.-.-.",
			"---...",
			".--.--.",
			"-....-",
			"-..-.",
			"-.--.",
			
			
			
			"-.--.-",
			"-.-.--",
			"-...-",
			"..--.-",
			"...-..-",			
	        ".--.-.",
		    ".-...",
		    "----...",
		    "-------",
		    "...----",
		    "--..--..",
		   "..--..--",
		    ".-.-.-.-",
		    "-.-.-.-.",
		    "----...--",
		   "....---..",
		   "..--.--.."
		   
		   
			
		};
				
				
		

			
		//Conversão ASCII para Morse
	
		public String Converte_para_Morse (String Conversao){
			
			
				
				String espaco = " ";
				char letra=' ';
				String letra2 = " ";
		
		
			for (int ct=0;ct<Conversao.length();ct++){
					letra = Conversao.charAt(ct);
					letra2 = String.valueOf(letra);
							
				for (int ct2=0;ct2<Morse.length;ct2++){
							
							
							
					if (letra2.equals(ASCII[ct2]) ){
						
						
							espaco += Morse[ct2]+" "; 
							
						}
					
				}			
						
			}			
						
							
				return espaco;
						
				
		}		
					


			
			
			
		
		//Conversão Morse para ASCII
				
	
	
		public String Converte_para_ASCII(String Conversao) {
			
			
			String espaco1 = " ";
			
			String[] palavras= Conversao.split(" ");
			
			
			for (int ct = 0; ct < palavras.length; ct++){
				
				for (int ct2 = 0; ct2 < Morse.length; ct2++){
					
					if (palavras[ct].equals(Morse[ct2])){
						
						espaco1 += ASCII[ct2];
					}
				}
			}	
				
				return espaco1;
			
		}
			
			
			
	
	
		//construtor
		
		public Encripta() {
			
	
		super (" Conversor de Ficheiros ");
		
		
		
		tlk = getToolkit();
		dim = tlk.getScreenSize();
		
		//Menubar
		
		menubar = new JMenuBar();
		mn   = new JMenu(" File ");
		menubar.add (mn);
		
		mn1 = new JMenu (" About ");
		menubar.add (mn1);
		
		setJMenuBar (menubar);
		
		
		//Separador '-' dos Menus Items
		
		for(int i=0 ; i<tx.length ; i++) {
		
			it[i] = new JMenuItem (tx[i]);			
			it[i].addActionListener (this);
			
				if(i%2 == 0 && i != 0) {
					
				
				mn.add (new JSeparator());
				
				
				}
				

			mn.add (it[i]);
			mn.setFont (normal);
			it[i].setFont (normal);
		}
		
		for(int i=0 ; i<tx1.length ; i++) {
		
			it1[i] = new JMenuItem (tx1[i]);			
			it1[i].addActionListener (this);
			
				if(i%2 == 0 && i != 0) {
					
				
				mn1.add(new JSeparator());
				
				
				}
				
				
			mn1.add (it1[i]);
			mn1.setFont (normal);
			it1[i].setFont (normal);
			
			
		}
		
		//Painel
		
		centro1 = new JPanel(new BorderLayout());
		
		
		//Painel norte
		
		norte 	= new JPanel();
		br 	= new LineBorder (Color.gray, 5);
		br1	= new LineBorder (Color.gray, 2);
		br2	= new LineBorder (Color.gray, 4);
		norte.setBorder (new TitledBorder (br1, " [Nome dos Ficheiros] ",TitledBorder.LEFT,TitledBorder.TOP, bold, Color.black));

		
		//CAIXAS DE TEXTO
		
		//ASCII
		
		lb = new JLabel (" Ascii  ");
		lb.setFont (normal);
		norte.add (lb);
		
		tf = new JTextField(30);
		tf.setEditable (false);
		tf.setFont (normal);
		norte.add (tf);
		
		
		
		//Morse
		
		lb1 = new JLabel("                Morse  ");
		lb1.setFont(normal);
		norte.add (lb1);
		
		tf1 = new JTextField (30);
		tf1.setEditable (false);
		tf1.setFont (normal);
		norte.add (tf1);	
		
		centro1.add (norte,BorderLayout.NORTH);
		
		//Painel centro
		
		centro  = new JPanel(new GridLayout (2, 1));
				
		sp  = new JScrollPane();
		ta = new JTextArea();
		ta.setFont (normal);
		sp.setHorizontalScrollBarPolicy (JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setVerticalScrollBarPolicy	(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setViewportView (ta);
		sp.setBorder (new TitledBorder (br, " [Visualização do Ficheiro ASCII] ",TitledBorder.LEFT,TitledBorder.TOP, bold, Color.black));
		centro.add (sp);
		
		sp1  = new JScrollPane();
		ta1 = new JTextArea();
		ta1.setFont (normal);
		sp1.setHorizontalScrollBarPolicy (JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp1.setVerticalScrollBarPolicy	(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp1.setViewportView (ta1);
		sp1.setBorder (new TitledBorder (br, " [Visualização do Ficheiro Morse] ",TitledBorder.LEFT,TitledBorder.TOP, bold, Color.black));
		centro.add (sp1);	
		
		centro1.add(centro,BorderLayout.CENTER);
		
		
		
		//Painel sul
		
		sul = new JPanel();
		
		sul.setBorder (new TitledBorder (br2, " [Ações Disponíveis] ",TitledBorder.LEFT,TitledBorder.TOP, bold, Color.black));
		
		
		//Fontes e formatação das caixas de Diálogos usando UIManager
		
		UIManager.put("OptionPane.yesButtonText","Sim");
		UIManager.put("OptionPane.noButtonText","Não");
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Calibri", Font.BOLD, 23))); 
		UIManager.put("Button.background", Color.white.darker());
		UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font ("Calibri",Font.BOLD, 18)));
		UIManager.put("OptionPane.minimumSize",new Dimension(400,200)); 
		
		
		for(int i=0 ; i<btn.length ; i++) {
		
			btn[i] = new JButton (st[i]);
			sul.add (btn[i]);
			btn[i].addActionListener (this);
			btn[i].setBackground (Color.white.brighter());
			btn[i].setFont (bold);
			
		}
		
		centro1.add(sul,BorderLayout.SOUTH);
		
		//Separador 
		
		tabbed = new JTabbedPane();
		tabbed.setFont (normal);
		tabbed.setTabPlacement (1);
		tabbed.addTab (" Home ",icon, inicio);
		tabbed.addTab (" Encriptar Ficheiros ",icon,centro1);
		tabbed.setBorder(br);
		getContentPane().add (tabbed,BorderLayout.CENTER);
		getContentPane().setBackground(Color.white);
		
		
		//Frame
		
		
		setIconImage(image);
		setBounds (dim.width/2-comp/2, dim.height/2-alt/2, comp, alt);
		setVisible (true);
		setResizable (false);
		
		
		//JFileChooser
		
		FileNameExtensionFilter filtro= new FileNameExtensionFilter("Ficheiros java & txt","java","txt");
		fchooser = new JFileChooser();
		fchooser.setFileFilter(filtro);
		fchooser.setCurrentDirectory(dir);
		fchooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		
		
		 
	}//end construtor

		
	//Menu Items --> Acões
		
		public void actionPerformed(ActionEvent e) {
	
			
	//Menu Item --> File
			
	
	//LER ASCII
			
		if(e.getSource() == it[0]){
		
		try {
			
			returnValor = fchooser.showOpenDialog(null);
			if (returnValor == JFileChooser.APPROVE_OPTION) {
				File ASCIITexto = fchooser.getSelectedFile();
				
					FileReader lf = new FileReader(ASCIITexto);
			
					BufferedReader lb = new BufferedReader(lf);
					
					String linha, txt="";
					
					
				
					
					while((linha = lb.readLine())!= null){
						linha+="\n";
					tf.setText((ASCIITexto).getAbsolutePath());
					
					
					txt += linha;
					
					

						
					}
					
					
					ta.setText(txt);
					
					
					
					lf.close();
					
					
					
				}
				
				

			} catch (IOException io){
				
				
				System.err.println(io.getMessage());
				
				
		}
		
	}
					
					
				
				
       //Gravar ASCII
	

		
		if(e.getSource() == it[1]){
			
			
			
		File  ASCIITexto;
	
		 
		try {
			
			
			
			returnValor = fchooser.showSaveDialog(null);
			if (returnValor == JFileChooser.APPROVE_OPTION) {
				ASCIITexto = fchooser.getSelectedFile();
				
					FileWriter lf = new FileWriter(ASCIITexto);
			
					BufferedWriter lb = new BufferedWriter(lf);
			
			
			
			PrintWriter out = new PrintWriter(ASCIITexto);
			
			
			
			out.println(ta.getText()+"\n");
			
				
			
			out.close();
			
		
			
			JOptionPane.showMessageDialog (null,    
		    "Gravado com sucesso!!","Gravar",	
			JOptionPane.PLAIN_MESSAGE);	
		
	 }
			
}
		
		catch(IOException io){JOptionPane.showMessageDialog (null,    
				"Falha ao gravar!! Por favor, tente novamente." + "\n\n" + io + "\n","Gravar",	
				JOptionPane.ERROR_MESSAGE);
		}
		
}
			
		
		
		 

		
		
		//Ler Morse


		if(e.getSource() == it[2]){
	
			try {
				
				returnValor = fchooser.showOpenDialog(null);
				if (returnValor == JFileChooser.APPROVE_OPTION) {
					File MorseTexto = fchooser.getSelectedFile();
					
						FileReader lf = new FileReader(MorseTexto);
				
						BufferedReader lb = new BufferedReader(lf);
						
						String linha, txt="";
						
						
					
						
						while((linha = lb.readLine())!= null){
							linha+="\n";
						tf1.setText((MorseTexto).getAbsolutePath());
						
						
						txt += linha;
						
						

							
						}
						
						
						ta1.setText(txt);
						
						
						
						lf.close();
						
						
						
					}
					
					

				} catch (IOException io){
					
					
					System.err.println(io.getMessage());
					
					
			}
				
	}
		
		
	
		//Gravar Morse


		if(e.getSource() == it[3]){
			
			File  MorseTexto;
			
			 
			try {
				
				
				
				returnValor = fchooser.showSaveDialog(null);
				if (returnValor == JFileChooser.APPROVE_OPTION) {
					MorseTexto = fchooser.getSelectedFile();
					
						FileWriter lf = new FileWriter(MorseTexto);
				
						BufferedWriter lb = new BufferedWriter(lf);
				
				
				
				PrintWriter out = new PrintWriter(MorseTexto);
				
				
				
				out.println(ta1.getText()+"\n");
				
					
				
				out.close();
				
			
				
				
				JOptionPane.showMessageDialog (null,    
			    "Gravado com sucesso!!","Gravar",	
				JOptionPane.PLAIN_MESSAGE);	
			
		 }
	}
			
			catch(IOException io){ JOptionPane.showMessageDialog (null,    
					"Falha ao gravar!! Por favor, tente novamente." + "\n\n" + io + "\n","Gravar",	
					JOptionPane.ERROR_MESSAGE);
		}
			
	}
				
			
	
		
		
		//Converter ASCII


		if(e.getSource() == it[4]){
			
			
			
			
			ta.setText(Converte_para_ASCII(ta1.getText()));
	
	
	
	
		}
		
		
		//Converter Morse

		if(e.getSource() == it[5]){
			
			
			
			
			
			ta1.setText(Converte_para_Morse(ta.getText()));
			
			
		
		
	
		}

		
		
			
			
		if(e.getSource() == it[6]){
			
			int qual = JOptionPane.showConfirmDialog (this,"    Abandonar a Aplicação?    ", "Abandonar", JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
			if(qual == JOptionPane.YES_OPTION)
			{
				System.gc();
				System.exit(0);   
			}
			
			
			
		}
			
			
			
		//Menu Items --> About	
			
			
		if (e.getSource() == it1[0]) 
		{
		
		JOptionPane.showMessageDialog (null,    
		"\t\t\nNome: Encripta de Morse para ASCII         \t\t\n\nVersao : 1.0\t\t\n\nData : 18-01-2019\n\n",  "Diálogo de Programa",		
		JOptionPane.PLAIN_MESSAGE,dialogo);		
		}		
		
		if (e.getSource() == it1[1]) 
		{
		JOptionPane.showMessageDialog (null,    
		"\t\t\nLinguagem : Java\n\nVersao : 11.0.1\t\t\n\nSoftWare House: Oracle Corporation\t\t\nSoftWare House: Sum MicroSystems           \t\t\n\nWrite Once Run Anywhere\n\n", "Diálogo de Linguagem",	
		JOptionPane.PLAIN_MESSAGE,linguagem);		 	
		}
				
		if (e.getSource() == it1[2])
		{
		JOptionPane.showMessageDialog (null,    
		"\n\n\tProjeto Realizado por :  Luís Sá              \n\n\tMakes the Things Easy        \n\n\n\n\tCurso :TPSI PL 1018\n\n\tUFCD :5089 Programação\n\n",  "Diálogo de Autor",			
		JOptionPane.PLAIN_MESSAGE,user);			
		}
		
		
		//Butões
		
		//Converter para ASCII
		
		if(e.getSource() == btn[0]){
			
			ta.setText(Converte_para_ASCII(ta1.getText()));
			
			
		}
		
		
		//Converter para Morse
	

		if(e.getSource() == btn[1]){
	
			
		ta1.setText(Converte_para_Morse(ta.getText()));
	
	
		}
		
		
		//Limpar TextArea up (ASCII)
		
		if(e.getSource() == btn[2]){
			
			
			tf1.setText("");
			ta.setText("");
			
			
			
		}
		
		
		//Limpar TextArea down (MORSE)
		
		if(e.getSource() == btn[3]){
			
			
			tf1.setText("");
			ta1.setText("");
			
			
			
			
		}
		
		if (e.getSource() == btn[4]) 
		{
			int qual = JOptionPane.showConfirmDialog (this,"    Abandonar a Aplicação?    ", "Abandonar", JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
			if(qual == JOptionPane.YES_OPTION)
			{
				System.gc();
				System.exit(0);   
			}
			
		}
		
		
 }//end
		
		
	

		//main
		
		public static void main(String[] args) {
	
		//Fechar no x
		Encripta app = new Encripta();
		app.addWindowListener (new WindowAdapter(){ 
		
			public void windowClosing (WindowEvent e){
			
				System.gc();
				System.exit(0);
				
			}
			
		});
		
	}//end Main	
	}//end class
