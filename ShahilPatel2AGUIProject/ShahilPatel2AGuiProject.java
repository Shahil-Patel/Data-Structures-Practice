import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.border.*;
public class ShahilPatel2AGuiProject extends JPanel implements ActionListener
{
    JFrame frame;
    JMenu font,fontSize,textColor,background,outline;
    JMenuBar menuBar;
    JButton north,south,east,west,reset;
    JPanel buttonPanel;
    JTextArea area;
    JMenuItem arial,tnr,cambria;
    JMenu[] menuArr;
    JButton[] buttonArr;
    JMenuItem[] itemArr;
    JMenuItem size10,size20,size40;
    JMenuItem red,blue,random;
    JMenuItem redBackground,blueBackground,randomBackground;
    JMenuItem noOutline,redOutline,blueOutline,randomOutline;
    String fontStr="";
    int fontNum=10;
    public ShahilPatel2AGuiProject()
    {
        frame=new JFrame();
        buttonPanel=new JPanel();
        menuBar=new JMenuBar();
        north=new JButton("North");
        south=new JButton("South");
        east=new JButton("East");
        west=new JButton("West");
        reset=new JButton("Reset");
        font=new JMenu("Fonts");
        fontSize=new JMenu("Sizes");
        textColor=new JMenu("Color");
        background=new JMenu("Background");
        outline=new JMenu("Outline");
        arial=new JMenuItem("Arial");
        tnr=new JMenuItem("Times New Roman");
        cambria=new JMenuItem("Cambria");
        size10=new JMenuItem("10");
        size20=new JMenuItem("20");
        size40=new JMenuItem("40");
        red=new JMenuItem("Red");
        blue=new JMenuItem("Blue");
        random=new JMenuItem("Random");
        redBackground=new JMenuItem("Red");
        blueBackground=new JMenuItem("Blue");
        randomBackground=new JMenuItem("Random");
        noOutline=new JMenuItem("No Color");
        redOutline=new JMenuItem("Red");
        blueOutline=new JMenuItem("Blue");
        randomOutline=new JMenuItem("Random");
        area=new JTextArea();
        font.add(arial);
        font.add(tnr);
        font.add(cambria);
        arial.addActionListener(this);
        tnr.addActionListener(this);
        cambria.addActionListener(this);
        fontSize.add(size10);
        fontSize.add(size20);
        fontSize.add(size40);
        size10.addActionListener(this);
        size20.addActionListener(this);
        size40.addActionListener(this);
        textColor.add(red);
        textColor.add(blue);
        textColor.add(random);
        red.addActionListener(this);
        blue.addActionListener(this);
        random.addActionListener(this);
        background.add(redBackground);
        background.add(blueBackground);
        background.add(randomBackground);
        redBackground.addActionListener(this);
        blueBackground.addActionListener(this);
        randomBackground.addActionListener(this);
        outline.add(noOutline);
        outline.add(redOutline);
        outline.add(blueOutline);
        outline.add(randomOutline);
        noOutline.addActionListener(this);
        redOutline.addActionListener(this);
        blueOutline.addActionListener(this);
        randomOutline.addActionListener(this);
        north.addActionListener(this);
        south.addActionListener(this);
        east.addActionListener(this);
        west.addActionListener(this);
        reset.addActionListener(this);
        menuBar.add(font);
        menuBar.add(fontSize);
        menuBar.add(textColor);
        menuBar.add(background);
        menuBar.add(outline);
        menuBar.setLayout(new GridLayout(1,5));
        buttonPanel.setLayout(new GridLayout(1,6));
        buttonPanel.add(north);
        buttonPanel.add(south);
        buttonPanel.add(east);
        buttonPanel.add(west);
        buttonPanel.add(reset);
        buttonPanel.add(menuBar);
        menuArr=new JMenu[]{font,fontSize,textColor,background,outline};
        buttonArr=new JButton[]{north,south,east,west,reset};
        itemArr=new JMenuItem[]{arial,tnr,cambria,size10,size20,size40,red,blue,random,redBackground,blueBackground,randomBackground,noOutline,redOutline,blueOutline,randomOutline};
        frame.add(this);
		fontStr="Arial";
		fontNum=12;
		for(JMenu menu:menuArr)
		{
			menu.setFont(new Font(fontStr,Font.PLAIN,fontNum));
		}
		for(JButton button:buttonArr)
		{
			button.setFont(new Font(fontStr,Font.PLAIN,fontNum));
		}
		for(JMenuItem item:itemArr)
		{
			item.setFont(new Font(fontStr,Font.PLAIN,fontNum));
		}
		for(JMenu menu:menuArr)
		{
			menu.setForeground(new Color(0,0,0));
		}
		for(JButton button:buttonArr)
		{
			button.setForeground(new Color(0,0,0));
		}
		for(JMenuItem item:itemArr)
		{
			item.setForeground(new Color(0,0,0));
		}
		for(JButton button:buttonArr)
		{
			button.setBorder(new LineBorder(new Color(0,0,0)));
		}
		area.setText("");
		area.setBackground(new Color(255,255,255));
		arial.setFont(new Font("Arial",Font.PLAIN,fontNum));
		tnr.setFont(new Font("Times New Roman",Font.PLAIN,fontNum));
		cambria.setFont(new Font("Cambria",Font.PLAIN,fontNum));
		size10.setFont(new Font(fontStr,Font.PLAIN,10));
		size20.setFont(new Font(fontStr,Font.PLAIN,20));
		size40.setFont(new Font(fontStr,Font.PLAIN,40));
		redBackground.setBackground(new Color(255,0,0));
		red.setForeground(new Color(255,0,0));
		redOutline.setBorder(new LineBorder(new Color(255,0,0)));
		blueBackground.setBackground(new Color(0,0,255));
		blue.setForeground(new Color(0,0,255));
		blueOutline.setBorder(new LineBorder(new Color(0,0,255)));
		frame.remove(buttonPanel);
		buttonPanel.setLayout(new GridLayout(1,6));
		menuBar.setLayout(new GridLayout(1,6));
		buttonPanel.add(menuBar);
		frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(buttonPanel,BorderLayout.NORTH);
        frame.add(area,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500,600);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
		String name=e.getActionCommand();
		if(name.equals("North")||name.equals("South")||name.equals("East")||name.equals("West"))
		{
			switch(name){
                case "North":
					frame.remove(buttonPanel);
					buttonPanel.setLayout(new GridLayout(1,6));
					menuBar.setLayout(new GridLayout(1,6));
					buttonPanel.add(menuBar);
                    frame.add(buttonPanel, BorderLayout.NORTH);
                    break;
                case "South":
					frame.remove(buttonPanel);
					buttonPanel.setLayout(new GridLayout(1,6));
					menuBar.setLayout(new GridLayout(1,6));
					buttonPanel.add(menuBar);
                    frame.add(buttonPanel, BorderLayout.SOUTH);
                    break;
                case "East":
					frame.remove(buttonPanel);
					buttonPanel.setLayout(new GridLayout(6,1));
					menuBar.setLayout(new GridLayout(6,1));
					buttonPanel.add(menuBar);
                    frame.add(buttonPanel, BorderLayout.EAST);
                    break;
                case "West":
					frame.remove(buttonPanel);
					buttonPanel.setLayout(new GridLayout(6,1));
					menuBar.setLayout(new GridLayout(6,1));
					buttonPanel.add(menuBar);
                    frame.add(buttonPanel, BorderLayout.WEST);
                    break;
            }
		}
		if(e.getSource()==arial)
        {
        	fontStr="Arial";
		}
        if(e.getSource()==tnr)
        {
        	fontStr="Times New Roman";
		}
        if(e.getSource()==cambria)
        {
        	fontStr="Cambria";
		}
        if(e.getSource()==size10)
		{
        	fontNum=10;
		}
        if(e.getSource()==size20)
        {
        	fontNum=20;
		}
        if(e.getSource()==size40)
        {
            fontNum=40;
		}
        for(JMenu menu:menuArr)
        {
            menu.setFont(new Font(fontStr,Font.PLAIN,fontNum));
        }
        for(JButton button:buttonArr)
        {
            button.setFont(new Font(fontStr,Font.PLAIN,fontNum));
        }
        for(JMenuItem item:itemArr)
        {
            item.setFont(new Font(fontStr,Font.PLAIN,fontNum));
        }
        area.setFont(new Font(fontStr,Font.PLAIN,fontNum));
        if(e.getSource()==redBackground)
        {
            area.setBackground(new Color(255,0,0));
		}
        if(e.getSource()==blueBackground)
        {
            area.setBackground(new Color(0,0,255));
		}
        if(e.getSource()==randomBackground)
        {
            area.setBackground(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
		}
        if (e.getSource()==noOutline)
        {
			for (JButton button:buttonArr)
			{
				button.setBorder(new LineBorder(new Color(255,255,255)));
			}
		}
        if(e.getSource()==redOutline)
        {
			for (JButton button:buttonArr)
			{
				button.setBorder(new LineBorder(new Color(255,0,0)));
			}
		}
        if(e.getSource()==blueOutline)
        {
			for (JButton button:buttonArr)
			{
				button.setBorder(new LineBorder(new Color(0,0,255)));
			}
		}
        if(e.getSource()==randomOutline)
        {
			for (JButton button:buttonArr)
			{
				button.setBorder(new LineBorder(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255))));
			}
		}
		if(e.getSource()==red||e.getSource()==blue)
		{
			if(e.getSource()==red)
			{
				for (JMenu menu:menuArr
				) {
					menu.setForeground(new Color(255,0,0));
				}
				for (JButton button:buttonArr)
				{
					button.setForeground(new Color(255,0,0));
				}
				for (JMenuItem item:itemArr)
				{
					item.setForeground(new Color(255,0,0));
				}
				area.setForeground(new Color(255,0,0));
			}
			if (e.getSource()==blue)
			{
				for (JMenu menu:menuArr)
				{
					menu.setForeground(new Color(0,0,255));
				}
				for (JButton button:buttonArr)
				{
					button.setForeground(new Color(0,0,255));
				}
				for (JMenuItem item:itemArr)
				{
					item.setForeground(new Color(0,0,255));
				}
				area.setForeground(new Color(0,0,255));
			}
		}
		if(e.getSource()==random)
		{
			for (JMenu menu:menuArr)
			{
				menu.setForeground(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
			}
			for (JButton button:buttonArr)
			{
				button.setForeground(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
			}
			for (JMenuItem item:itemArr)
			{
				item.setForeground(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
			}
			area.setForeground(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
        }
        if(e.getSource()==reset)
        {
			fontStr="Arial";
			fontNum=12;
			for(JMenu menu:menuArr)
			{
				menu.setFont(new Font(fontStr,Font.PLAIN,fontNum));
			}
			for(JButton button:buttonArr)
			{
				button.setFont(new Font(fontStr,Font.PLAIN,fontNum));
			}
			for(JMenuItem item:itemArr)
			{
				item.setFont(new Font(fontStr,Font.PLAIN,fontNum));
			}
			for(JMenu menu:menuArr)
			{
				menu.setForeground(new Color(0,0,0));
			}
			for(JButton button:buttonArr)
			{
				button.setForeground(new Color(0,0,0));
			}
			for(JMenuItem item:itemArr)
			{
				item.setForeground(new Color(0,0,0));
			}
			for(JButton button:buttonArr)
			{
				button.setBorder(new LineBorder(new Color(0,0,0)));
			}
			area.setText("");
			area.setBackground(new Color(255,255,255));
			arial.setFont(new Font("Arial",Font.PLAIN,fontNum));
			tnr.setFont(new Font("Times New Roman",Font.PLAIN,fontNum));
			cambria.setFont(new Font("Cambria",Font.PLAIN,fontNum));
			frame.remove(buttonPanel);
			buttonPanel.setLayout(new GridLayout(1,6));
			menuBar.setLayout(new GridLayout(1,6));
			buttonPanel.add(menuBar);
			frame.add(buttonPanel, BorderLayout.NORTH);
		}
		arial.setFont(new Font("Arial",Font.PLAIN,fontNum));
		tnr.setFont(new Font("Times New Roman",Font.PLAIN,fontNum));
		cambria.setFont(new Font("Cambria",Font.PLAIN,fontNum));
		size10.setFont(new Font(fontStr,Font.PLAIN,10));
		size20.setFont(new Font(fontStr,Font.PLAIN,20));
		size40.setFont(new Font(fontStr,Font.PLAIN,40));
		redBackground.setBackground(new Color(255,0,0));
		red.setForeground(new Color(255,0,0));
		redOutline.setBorder(new LineBorder(new Color(255,0,0)));
		blueBackground.setBackground(new Color(0,0,255));
		blue.setForeground(new Color(0,0,255));
		blueOutline.setBorder(new LineBorder(new Color(0,0,255)));
        frame.revalidate();
    }
    public static void main(String[] args)
    {
        ShahilPatel2AGuiProject app=new ShahilPatel2AGuiProject();
    }
}