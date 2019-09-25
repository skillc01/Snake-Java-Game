package Snake;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Snake implements KeyListener, ActionListener, MouseListener  {
	protected GamePanel panel1;  //instantiate frame, panel,	           
	protected int time;              //instantiate time, myscore, snakelength(snekLength), snakehead(snekHead) int variables
	protected int myscore;
	protected int snekLength;
	protected Point snekHead;
	protected int direct;                //creating int variable that will be used for direction
	protected Random random;             //will be used to randomise shape to collect by snake
	protected Timer timer;
	protected ArrayList<Point> snekbody = new ArrayList<Point>();  //creating the array
	protected int startpoint = 12;
	protected int area = 25;
	protected int zeroAtStart = 0;
	protected int snakelengthStart = 1;
	protected int mouseclicks = 0;                 //used for mouse events later
	protected final static int DOWN = 0;          //now int variable direct can equal 0 to mean down 
	protected final static int UP  = 1;           // UP will always equal 1 due to public final static (done for all directions) 
	protected final static int RIGHT = 2;
	protected final static int LEFT = 3;
	protected int secs; 
	protected Point snekshape;
	protected boolean gameover;
	protected static Snake snake;    
	
	public void BeginGame()	{   
    	gameover =! true;                      //gameover isn't true at game start
	    snekHead = new Point(startpoint, startpoint);          //starting point of the snake
	    timer = new Timer(25, this);  ///
	    time = zeroAtStart;                              //time and myscore are 0 at game start 
		myscore = zeroAtStart;
		secs = zeroAtStart;
		snekLength = snakelengthStart;                        //snake will start with a tail of length 1
		direct = 2;                     //because protected final static int RIGHT = 2,  when direct equal 2 direction is RIGHT 
		random = new Random();
		snekbody.clear();                         
		snekshape = new Point(random.nextInt(area), random.nextInt(area));
		timer.start();
	}
	
	
	public Snake()  {      //constructor   	
		JFrame frame1;		
		frame1 = new JFrame();                     //create a new frame and add title, panel
		frame1.addKeyListener(this);                              //////
		frame1.setTitle("SNAKE by C Skillman");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //game will end and application will close when exit window
		frame1.setSize(435, 460);                          //sets size of window of game
		frame1.add(panel1 = new GamePanel());         //code for GamePanel exists in the other class file
		frame1.addMouseListener(this);
		frame1.addKeyListener(this);
		frame1.setVisible(true);                      //allows the frame to be seen instead of just existing
		BeginGame();                                  //final thing to do, call BeginGame to start the game
	}
	

	public static void main(String[] args)	{
		System.out.println("Game Start");
		snake = new Snake(); 
	}
	
	public void keyReleased(KeyEvent e) {} //arrow keys do not need to be held down to continue in one direct so this method can be left empty                  
	public void keyTyped(KeyEvent e)  {}  //must be inherited to avoid errors but does not need to contain anything
	public void keyPressed(KeyEvent k)	{      //events that will happen when arrow keys are pressed
		int keycode = k.getKeyCode();
        if (direct!= 0  && (keycode ==KeyEvent.VK_UP)  )           //if up arrow on keyboard pressed then snake object go up
		{                                             //having direct!= 0 makes sure we can't go down from moving up
			direct = 1;                                      //because public final static int UP = 1,  when direct equal 1 direction is UP
		}
        if (direct != 1 && (keycode == KeyEvent.VK_DOWN)  )          //if down arrow on keyboard pressed then snake object go down
		{
			direct = 0;                                      //because public final static int DOWN = 0,  when direct equal 0 direction is DOWN
		}
        if (direct != 3 && (keycode == KeyEvent.VK_RIGHT) )     //if right arrow on keyboard pressed then snake object go right
		{
			direct = 2;                                    //because public final static int RIGHT = 2,  when direct equal 2 direction is RIGHT
		}
        if (direct != 2 && (keycode == KeyEvent.VK_LEFT) )      //if left arrow on keyboard pressed then snake object go left
		{
			direct = 3;                                   //because public final static int LEFT = 3,  when direct equal 3 direction is LEFT
		}
  

	}
	
	public void actionPerformed(ActionEvent A)	{
		
		panel1.repaint();  //gets component to repaint itself  // used to cause paint() to be invoked
		
		if (!gameover) {    
		boolean bool1;
		
		
		//REFERENCE
		//IDEAS FOR IF STATEMENTS in this method HERE TAKEN FROM     https://www.youtube.com/watch?v=S_n3lryyGZM    spoken about in report
		secs = secs + 25;   //able to control the speed of the timer & snake
		if (secs % 10 == 0 && !gameover && snekHead != null ) //every %of a second everything in if bracket is called (assuming all conditions true too)
		{	time = time + 1;    //allows the timer to be incremented by 1, allows timer to work
			snekbody.add(new Point(snekHead.x, snekHead.y));  //adds new oval shape to end of snake  			
			if (snekLength<snekbody.size())
			{snekbody.remove(0);        //removes the end of snake oval after snake has moved off of that point
			}
			
		
			if (direct == 1 && direct != 2 && direct != 2 && direct != 3)   
			{    
	 
			if (OverTouchTail(snekHead.x, snekHead.y - 1) && 2 <= snekHead.y - 1 )  //if snake goes beyond horizontal 2 then gameover occurs  
			{ snekHead = new Point(snekHead.x, snekHead.y - 1);    
			}
			else
			{bool1 = true;
			gameover = bool1;               
			}
			}
			
			if (direct == 3 && direct != 0 && direct != 1 && direct != 2)  //because public final static int LEFT = 3,  when direct equal 3 direction is LEFT
			{
				if (OverTouchTail(snekHead.x - 1, snekHead.y) && 2 <= snekHead.x - 1 ) //at 2 point(vertically) if snake hits it, gameover will occur (hit left border)
				{snekHead = new Point(snekHead.x - 1, snekHead.y);
				}
				else
				{bool1 = true;
				gameover = bool1;
				}
			}

			if (direct == 2 && direct != 0 && direct != 1 && direct != 3)  
			{   //only affect right direction (right movements)
				if (OverTouchTail(snekHead.x + 1, snekHead.y) && 39 >= snekHead.x + 1 )  //at 39point(vertically) if snake hits it, gameover will occur (hit right border)
				{snekHead = new Point(snekHead.x + 1, snekHead.y);
				}
				else
				{bool1 = true;
				gameover = bool1;
				}
			}
			
			
					
			if (direct == 0 && direct != 1 && direct != 2 && direct != 3)      
			{
				if (OverTouchTail(snekHead.x, snekHead.y + 1) && snekHead.y + 1 <= 39)
				{
					snekHead = new Point(snekHead.x, snekHead.y + 1);
				}
				else {
				bool1 = true;
				gameover = bool1;
				}
			}

			if (snekshape == null)
			{
				
			}
			else {
				if (snekHead.equals(snekshape))	{
			int x = 4; //added so the score object won't appear of the left or top border
			snekshape.setLocation(random.nextInt(28)+x, random.nextInt(28)+x);  //shape will appear randomly left of vertical point 51 and above horizontal point 44 so it does not appear out of bounds
			myscore = myscore + 25;                  //gain 25 points when a shape is collected by snake
			snekLength = snekLength + 1;
			}
			}
		}
		}
		
	}
	//when mouse clicked increments by 1
	public void mouseClicked(MouseEvent e) {
	 mouseclicks = mouseclicks + 1;   }
    public void mousePressed(MouseEvent E) {}	
	public void mouseEntered(MouseEvent E) {}
	public void mouseExited(MouseEvent E) {}
	public void mouseReleased(MouseEvent E) {}

	
	public boolean OverTouchTail(int H, int V)  { //allows gameover if snake touches its tail
		//REFERENCE
	//IDEA for how to do some of this part gotten from    https://www.youtube.com/watch?v=S_n3lryyGZM    spoken about in report
		
		
		boolean bool2;
		for (int a = 0; a < snekbody.size(); a = a+1) {   //gameover for all snake body parts
			    Point pos = snekbody.get(a);
			    
			//game will end if snake goes to point where tail is    
			if (!gameover && pos.equals(new Point(H, V )))       
				                                       
			{
			bool2 = false;
			return bool2;
			}
			
		}
		bool2 = true;
		return bool2;
	}
	
    
		
}