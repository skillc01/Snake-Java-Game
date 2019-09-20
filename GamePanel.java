package Snake;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.Point;
import java.util.*;
import java.util.List;
import java.util.Timer;
import java.text.*;             //used for the dateformat

public class GamePanel extends JPanel
{	
	protected int s1, s2, s3, s4 ,s5;        //instantiating  the variable that will hold the top ten scores
	protected int s6, s7, s8, s9, s10;
	protected int s1_24, s2_24, s3_24, s4_24 ,s5_24; //instantiating the variable that will hold the top ten scores in the last 24 hours
	protected int s6_24, s7_24, s8_24, s9_24, s10_24;
	protected String score;                        //will be used to show score at end and write to txt files
	protected String times;
	protected BufferedWriter writer = null;
	protected FileWriter writeFile = null;
	protected BufferedWriter writer2 = null;
	protected FileWriter writeFile2 = null;
		
	protected void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		Snake snake = Snake.snake;

		g.setColor(Color.gray);                 //colour background roundrect
		g.fillRoundRect(0, 0, 400, 400, 25, 50);  //position & size of roundrect
				
		//20 horizontal top border of 20 (height 20 and width 20) squares
		g.fillRect(0, 0, 20, 20);   g.setColor(Color.lightGray); 
		g.fillRect(20,0,  20, 20);  g.setColor(Color.pink);      
		g.fillRect(40,0,  20, 20);  g.setColor(Color.lightGray); 
		g.fillRect(60,0,  20, 20);  g.setColor(Color.pink);      
		g.fillRect(80,0,  20, 20);  g.setColor(Color.lightGray);  
		g.fillRect(100,0,  20, 20); g.setColor(Color.pink);       
		g.fillRect(120,0,  20, 20); g.setColor(Color.lightGray); 
		g.fillRect(140,0,  20, 20); g.setColor(Color.pink);       
		g.fillRect(160,0,  20, 20); g.setColor(Color.lightGray);  
		g.fillRect(180,0,  20, 20); g.setColor(Color.pink);  
		g.fillRect(200,0,  20, 20); g.setColor(Color.lightGray); 
		g.fillRect(220,0,  20, 20); g.setColor(Color.pink); 
		g.fillRect(240,0,  20, 20); g.setColor(Color.lightGray);  
		g.fillRect(260,0,  20, 20); g.setColor(Color.pink); 
		g.fillRect(280,0,  20, 20); g.setColor(Color.lightGray);  
		g.fillRect(300,0,  20, 20); g.setColor(Color.pink); 
		g.fillRect(320,0,  20, 20); g.setColor(Color.lightGray);  
		g.fillRect(340,0,  20, 20); g.setColor(Color.pink); 
		g.fillRect(360,0,  20, 20); g.setColor(Color.lightGray);  
		g.fillRect(380,0,  20, 20); g.setColor(Color.pink); 
		
		
		//20 vertical left border of 20 (height 20 and width 20) squares
		g.fillRect(0, 0, 20, 20);   g.setColor(Color.lightGray);
		g.fillRect(0, 20, 20, 20);  g.setColor(Color.pink);
		g.fillRect(0, 40, 20, 20);  g.setColor(Color.lightGray); 
		g.fillRect(0, 60, 20, 20);  g.setColor(Color.pink);
		g.fillRect(0, 80, 20, 20);  g.setColor(Color.lightGray); 
		g.fillRect(0, 100, 20, 20); g.setColor(Color.pink);
		g.fillRect(0, 120, 20, 20); g.setColor(Color.lightGray); 
		g.fillRect(0, 140, 20, 20); g.setColor(Color.pink);
		g.fillRect(0, 160, 20, 20); g.setColor(Color.lightGray); 
		g.fillRect(0, 180, 20, 20); g.setColor(Color.pink);
		g.fillRect(0, 200, 20, 20); g.setColor(Color.lightGray); 
		g.fillRect(0, 220, 20, 20); g.setColor(Color.pink);
		g.fillRect(0, 240, 20, 20); g.setColor(Color.lightGray); 
		g.fillRect(0, 260, 20, 20); g.setColor(Color.pink);
		g.fillRect(0, 280, 20, 20); g.setColor(Color.lightGray); 
		g.fillRect(0, 300, 20, 20); g.setColor(Color.pink);
		g.fillRect(0, 320, 20, 20); g.setColor(Color.lightGray);
		g.fillRect(0, 340, 20, 20); g.setColor(Color.pink);
		g.fillRect(0, 360, 20, 20); g.setColor(Color.lightGray);
		g.fillRect(0, 380, 20, 20); g.setColor(Color.lightGray);
		
		//20 horizontal bottom border of 20 (height 20 and width 20) squares
		g.fillRect(0, 380, 20, 20);  g.setColor(Color.pink); //1
		g.fillRect(20,380,  20, 20); g.setColor(Color.lightGray);   //2
		g.fillRect(40,380,  20, 20); g.setColor(Color.pink); //3
		g.fillRect(60,380,  20, 20); g.setColor(Color.lightGray);  //4
		g.fillRect(80,380,  20, 20); g.setColor(Color.pink);  //5
		g.fillRect(100,380,  20, 20); g.setColor(Color.lightGray); //6
		g.fillRect(120,380,  20, 20); g.setColor(Color.pink); //7
		g.fillRect(140,380,  20, 20); g.setColor(Color.lightGray);  //8
		g.fillRect(160,380,  20, 20); g.setColor(Color.pink);  //9
		g.fillRect(180,380,  20, 20); g.setColor(Color.lightGray);  //10
		g.fillRect(200,380,  20, 20); g.setColor(Color.pink); //11
		g.fillRect(220,380,  20, 20); g.setColor(Color.lightGray); //12
		g.fillRect(240,380,  20, 20); g.setColor(Color.pink);  //13
		g.fillRect(260,380,  20, 20); g.setColor(Color.lightGray); //14
		g.fillRect(280,380,  20, 20); g.setColor(Color.pink);  //15
		g.fillRect(300,380,  20, 20); g.setColor(Color.lightGray); //16
		g.fillRect(320,380,  20, 20); g.setColor(Color.pink);  //17
		g.fillRect(340,380,  20, 20); g.setColor(Color.lightGray); //18
		g.fillRect(360,380,  20, 20); g.setColor(Color.pink);  //19
		g.fillRect(380,380,  20, 20); g.setColor(Color.pink); //20   // will touch point 400, 400
		
		//20 vertical right border of 20 (height 20 and width 20) squares
		g.fillRect(380, 20, 20, 20); g.setColor(Color.lightGray);
		g.fillRect(380, 40, 20, 20); g.setColor(Color.pink); 
		g.fillRect(380, 60, 20, 20); g.setColor(Color.lightGray);
		g.fillRect(380, 80, 20, 20); g.setColor(Color.pink); 
		g.fillRect(380, 100, 20, 20); g.setColor(Color.lightGray);
		g.fillRect(380, 120, 20, 20); g.setColor(Color.pink); 
		g.fillRect(380, 140, 20, 20); g.setColor(Color.lightGray);
		g.fillRect(380, 160, 20, 20); g.setColor(Color.pink); 
		g.fillRect(380, 180, 20, 20); g.setColor(Color.lightGray);
		g.fillRect(380, 200, 20, 20); g.setColor(Color.pink); 
		g.fillRect(380, 220, 20, 20); g.setColor(Color.lightGray);
		g.fillRect(380, 240, 20, 20); g.setColor(Color.pink); 
		g.fillRect(380, 260, 20, 20); g.setColor(Color.lightGray);
		g.fillRect(380, 280, 20, 20); g.setColor(Color.pink); 
		g.fillRect(380, 300, 20, 20); g.setColor(Color.lightGray);
		g.fillRect(380, 320, 20, 20); g.setColor(Color.pink);
		g.fillRect(380, 340, 20, 20); g.setColor(Color.lightGray);
		g.fillRect(380, 360, 20, 20); g.setColor(Color.pink);

		
		
	
		g.setColor(Color.magenta);                       //sets the colour of the snake's head
		g.fillOval(snake.snekHead.x * 10, snake.snekHead.y * 10, 10, 10);
		
        //sets the colour, font and position of the text shown at the bottom on the game
		g.setColor(Color.black);
		g.setFont(new Font("Ariel", Font.BOLD, 15));
		g.drawString(""+"Time: "+snake.time/25+"     "+"    Length: "+snake.snekLength+
		"      Score: "+snake.myscore + "     Clicks: " + snake.mouseclicks, 20, 396);

		
		
		
		
		
		g.setColor(Color.magenta);                //colour of the snake
		for (int i = 0; i < (snake.snekbody).size(); i++) {   
		    Point pos = (snake.snekbody).get(i);
	
		g.fillOval(pos.x * 10, pos.y * 10, 10, 10);  //position include .x and .y as the snake and shape move and will not be in fixed positions
		} 
		
		//needs last so the shape appears in front of anything on the board so we can see it
		g.setColor(Color.green);                         //sets colour of shape to be collected 
		g.fillOval(snake.snekshape.x * 10, snake.snekshape.y * 10, 10, 10);  //sets (unfiixed) position and size

		

		if (snake.gameover)       
			                              //font, colour, size and position of "YOU LOSE" string
		{   score = Integer.toString(snake.myscore); 
		    times = Integer.toString(snake.time/25);
			g.setColor(Color.pink);                 //colour of front roundrect
			g.fillRoundRect(50, 50, 300, 300, 25, 50);
			g.setFont(new Font("COMIC SANS", Font.BOLD, 18));
		    g.setColor(Color.darkGray);	
			g.drawString("YOU LOSE", 150, 65);
			
						
			
			g.drawString("Your Score: " + score + "    " + "Your Time: " + times, 50, 90);
			
			//the next block of code will print on screen the top ten scores of all time
			g.setFont(new Font("COMIC SANS", Font.BOLD, 15));
		    g.setColor(Color.black);	
			g.drawString("Highscores: ", 50, 120);
			g.drawString(" 1) " + s1, 70, 140);
			g.drawString(" 2) " + s2, 70, 160);
			g.drawString(" 3) " + s3, 70, 180);
			g.drawString(" 4) " + s4, 70, 200);
			g.drawString(" 5) " + s5, 70, 220);
			g.drawString(" 6) " + s6, 70, 240);
			g.drawString(" 7) " + s7, 70, 260);
			g.drawString(" 8) " + s8, 70, 280);
			g.drawString(" 9) " + s9, 70, 300);
			g.drawString("10) " + s10,70, 320);
			
			g.drawString("24 Hour Highscores: ", 180, 120);
			g.drawString(" 1) " + s1_24, 270, 140);
			g.drawString(" 2) " + s2_24, 270, 160);
			g.drawString(" 3) " + s3_24, 270, 180);
			g.drawString(" 4) " + s4_24, 270, 200);
			g.drawString(" 5) " + s5_24, 270, 220);
			g.drawString(" 6) " + s6_24, 270, 240);
			g.drawString(" 7) " + s7_24, 270, 260);
			g.drawString(" 8) " + s8_24, 270, 280);
			g.drawString(" 9) " + s9_24, 270, 300);
			g.drawString("10) " + s10_24,270, 320);
			
			writeScore();
			writeScore24hour();
			getScore();
			getScore24hour();
			 
			    	
			    }
			    	
			} 
	

	private void writeScore() {  //method will write to new or existing files score at endgame
		                                                //location of file
			String textfile = "C:\\Users\\chloe\\workspace\\Java Project\\src\\Snake\\scoreboard.txt";
              try {
					
					File file1 = new File(textfile);
					
					if (!file1.exists()) {
						file1.createNewFile();  //if the file does not exist then scoreboard.txt will be created in that location
					}

							
					if (writeFile == null) {   //code to append to the text file
					
					boolean	bool3 = true;
					writeFile = new FileWriter(file1.getAbsoluteFile(), bool3);
					writer = new BufferedWriter(writeFile);
					

					writer.write(score);
					writer.newLine();                 //so each score is written to a new line 
					System.out.println("Alltime score submitted.");   
					
					}

				} catch (Exception e) {

					System.out.println("Exception Caught"); 

				} 
				
				finally {
					
						try {

						if (writer != null)
							writer.close();

						if (writeFile != null)
							writeFile.close();

					} catch (IOException E) {

						System.out.println("Exception Caught");
				  }
				}

			}
	
	private void writeScore24hour() { //method will write to new or existing files score at endgame to a different text file
		
		String textfile2 = "C:\\Users\\chloe\\workspace\\Java Project\\src\\Snake\\scoreboard24hour.txt";
          try {
				//creates file if it doesn't exist already
				File file2 = new File(textfile2);
				
				if (!file2.exists()) {
					file2.createNewFile();  
				}

						
				if (writeFile2 == null) {     //code to append to the text file
				
				boolean	bool4 = true;
				writeFile2 = new FileWriter(file2.getAbsoluteFile(), bool4);
				writer2 = new BufferedWriter(writeFile2);
				

				writer2.write(score);
				writer2.newLine();                 //so each score is written to a new line 
				System.out.println("Game End"); 
				System.out.println("24 hour score submitted.");   
				
				//creating the dates task will be scheduled to
				DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			    Date date1 = dateFormatter.parse("2017-12-12 15:00:00");
			    Date date2 = dateFormatter.parse("2017-12-13 15:00:00");
			    Date date3 = dateFormatter.parse("2017-12-14 15:00:00");
			    Date date4 = dateFormatter.parse("2017-12-15 15:00:00");
			    Date date5 = dateFormatter.parse("2017-12-16 15:00:00");
			    Date date6 = dateFormatter.parse("2017-12-17 15:00:00");
			    Date date7 = dateFormatter.parse("2017-12-18 15:00:00");

			    //scheduling the task (for 7 days)
			    Timer timer2 = new Timer();
			    timer2.schedule(delete24hourscore(),date1);
			    timer2.schedule(delete24hourscore(),date2); 
			    timer2.schedule(delete24hourscore(),date3); 
			    timer2.schedule(delete24hourscore(),date4); 
			    timer2.schedule(delete24hourscore(),date5);
			    timer2.schedule(delete24hourscore(),date6);
			    timer2.schedule(delete24hourscore(),date7);
			    
			}

			} catch (Exception e) {

				System.out.println("Exception Caught");
				

			} 
			
			finally {
			
					try {

					if (writer2 != null)
						writer2.close();

					if (writeFile2 != null)
						writeFile2.close();

				} catch (IOException E) {

					System.out.println("Exception Caught");
			  }
			}

		}
	
	
	//this method will delete 24hour scoreboard file every 24 hours
	private TimerTask delete24hourscore() {
		String textfile2 = "C:\\Users\\chloe\\workspace\\Java Project\\src\\Snake\\scoreboard24hour.txt";
		File file2 = new File(textfile2);
		
		if (file2.exists()) {
			file2.delete();
		}
		return null;
	}



	public void getScore() {  //this method reads the text file and sort into descending order after pputting them in an array

		{
        try {
			
	        List<Integer> highscores = new ArrayList<Integer>();  //creating an arrayList to hold the scores from the text file
	        //reads the correct file full of the scores                   
	        BufferedReader reader1 = new BufferedReader(new FileReader(      //change this location to a place on the pc this java file is being run on
	        		"C:\\\\Users\\\\chloe\\\\workspace\\\\Java Project\\\\src\\\\Snake\\\\scoreboard.txt"));
	        String lines = null;
	        String nullvalue = null;
	        
	        // splits the individual scores and converts strings in the text file to int
	         while ( (lines = reader1.readLine()) != nullvalue ) {
	             String []strhighscores = lines.split(" ");
	             for (int j = 0; j < strhighscores.length; j = j+1) { 

             	 String strNumb = strhighscores[j];
             	 highscores.add(Integer.parseInt(strNumb));

              }
	             

	                       
	         }   
	         reader1.close();
	         Collections.sort(highscores);         //sorts scores into ascending order
	         Collections.reverse(highscores);      //reverses the order so highest scores at top
	         s1 = highscores.get(0);
	         s2 = highscores.get(1);
	         s3 = highscores.get(2);
	         s4 = highscores.get(3);
	         s5 = highscores.get(4);
	         s6 = highscores.get(5);
	         s7 = highscores.get(6);
	         s8 = highscores.get(7);
	         s9 = highscores.get(8);
	         s10 = highscores.get(9);

	         
			}

	        catch (Exception lessthantenscores) {
	        	//this exception is caught if there is less than 10 scores
	        	//nothing will print to tell you the exception is caught.
			} 
        
	     }

  }

	public void getScore24hour() {  //this method reads

		{
        try {
			
	        List<Integer> highscores2 = new ArrayList<Integer>();  //creating an arrayList to hold the scores from the text file
	        //reads the correct file full of the scores                   
	        BufferedReader reader2 = new BufferedReader(new FileReader(      //change this location to a place on the pc this java file is being run on
	        		"C:\\Users\\chloe\\workspace\\Java Project\\src\\Snake\\scoreboard24hour.txt"));
	        String lines2 = null;
	        String nullvalue2 = null;
	        
	        // splits the individual scores and converts strings in the text file to int
	         while ( (lines2 = reader2.readLine()) != nullvalue2 ) {
	             String []strhighscores2 = lines2.split(" ");
	             for (int o = 0; o < strhighscores2.length; o = o+1) { 

             	 String strNumb2 = strhighscores2[o];
             	 highscores2.add(Integer.parseInt(strNumb2));

              }
	             

	                       
	         }   
	         reader2.close();
	         Collections.sort(highscores2);         //sorts scores into ascending order
	         Collections.reverse(highscores2);      //reverses the order so highest scores at top
	         s1_24 = highscores2.get(0);
	         s2_24 = highscores2.get(1);
	         s3_24 = highscores2.get(2);
	         s4_24 = highscores2.get(3);
	         s5_24 = highscores2.get(4);
	         s6_24 = highscores2.get(5);
	         s7_24 = highscores2.get(6);
	         s8_24 = highscores2.get(7);
	         s9_24 = highscores2.get(8);
	         s10_24 = highscores2.get(9);

	         
			}

	        catch (Exception lessthantenscores) {
	        	//this exception is caught if there is less than 10 scores
	        	//nothing will print to tell you the exception is caught.
			} 
        
	     }

  }
	
	
}	
			
		
		
		
	