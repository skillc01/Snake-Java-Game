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

		g.setColor(Color.black);                 //colour background roundrect
		g.fillRect(0, 0, 400, 400);  //position & size of rect
				
		//20 horizontal top border of 20 (height 20 and width 20) squares
		
			
		//top line of GRAY blocks (every other block)
		for (int x = 0; x < 400; x=x+40) {
			g.setColor(Color.GRAY);  
			g.fillRect(x+20, 0, 20, 20);   
        } 
		
		//top line of DARK_GRAY blocks (every other block)
		for (int x = 0; x < 400; x=x+40) {
			g.setColor(Color.DARK_GRAY);  
			g.fillRect(x, 0, 20, 20);   
        } 
		
		//left line of GRAY blocks (every other block)
		for (int x = 0; x < 400; x=x+40) {
			g.setColor(Color.GRAY);  
			g.fillRect(0, x+20, 20, 20);   
        } 
				
		//left line of DARK_GRAY blocks (every other block)
		for (int x = 0; x < 400; x=x+40) {
			g.setColor(Color.DARK_GRAY);  
			g.fillRect(0, x, 20, 20);   
	    } 
					
		//bottom line of GRAY blocks (every other block)
		for (int x = 0; x < 400; x=x+40) {
			g.setColor(Color.GRAY);  
			g.fillRect(x+20, 400, 20, 20);   
		 } 
		
		//bottom line of DARK_GRAY blocks (every other block)
		for (int x = 0; x < 410; x=x+40) {
			g.setColor(Color.DARK_GRAY);  
			g.fillRect(x, 400, 20, 20);   
		} 
						
		//right line of GRAY blocks (every other block)
		for (int x = 0; x < 400; x=x+40) {
			g.setColor(Color.GRAY);  
			g.fillRect(400, x+20, 20, 20);   
	    } 
				
		//right line of DARK_GRAY blocks (every other block)
		for (int x = 0; x < 400; x=x+40) {
			g.setColor(Color.DARK_GRAY);  
			g.fillRect(400, x, 20, 20);   
        } 	
		
	
		g.setColor(Color.magenta);                       //sets the colour of the snake's head
		g.fillOval(snake.snekHead.x * 10, snake.snekHead.y * 10, 10, 10);
		
        //sets the colour, font and position of the text shown at the bottom on the game
		g.setColor(Color.white);
		g.setFont(new Font("Ariel", Font.BOLD, 15));
		g.drawString(""+"Time: "+snake.time/25+"     "+"    Length: "+snake.snekLength+
		"      Score: "+snake.myscore + "     Clicks: " + snake.mouseclicks, 20, 396);

		
		
		
		
		
		g.setColor(Color.magenta);                //colour of the snake
		for (int i = 0; i < (snake.snekbody).size(); i++) {   
		    Point pos = (snake.snekbody).get(i);
	
		g.fillOval(pos.x * 10, pos.y * 10, 10, 10);  //position include .x and .y as the snake and shape move and will not be in fixed positions
		} 
		
		//needs last so the shape appears in front of anything on the board so we can see it
		g.setColor(Color.red);                         //sets colour of shape to be collected 
		g.fillOval(snake.snekshape.x * 10, snake.snekshape.y * 10, 10, 10);  //sets (unfiixed) position and size
		

		

		if (snake.gameover)       
			                              //font, colour, size and position of "YOU LOSE" string
		{   score = Integer.toString(snake.myscore); 
		    times = Integer.toString(snake.time/25);
			g.setColor(Color.GRAY);                 //colour of front roundrect
			g.fillRoundRect(60, 60, 300, 300, 25, 50);
			g.setFont(new Font("COMIC SANS", Font.BOLD, 18));
		    g.setColor(Color.white);	
			g.drawString("YOU LOSE", 160, 75);
			
						
			
			g.drawString("Your Score:" + score + "  " + "Your Time:" + times, 75, 100);
			
			//the next block of code will print on screen the top ten scores of all time
			g.setFont(new Font("COMIC SANS", Font.BOLD, 15));
		    g.setColor(Color.white);	
			g.drawString("Highscores: ", 60, 130);
			g.drawString(" 1) " + s1, 80, 150);
			g.drawString(" 2) " + s2, 80, 170);
			g.drawString(" 3) " + s3, 80, 190);
			g.drawString(" 4) " + s4, 80, 210);
			g.drawString(" 5) " + s5, 80, 230);
			g.drawString(" 6) " + s6, 80, 250);
			g.drawString(" 7) " + s7, 80, 270);
			g.drawString(" 8) " + s8, 80, 290);
			g.drawString(" 9) " + s9, 80, 310);
			g.drawString("10) " + s10,80, 330);
			
			g.drawString("Monthly Highscores: ", 190, 130);
			g.drawString(" 1) " + s1_24, 280, 150);
			g.drawString(" 2) " + s2_24, 280, 170);
			g.drawString(" 3) " + s3_24, 280, 190);
			g.drawString(" 4) " + s4_24, 280, 210);
			g.drawString(" 5) " + s5_24, 280, 230);
			g.drawString(" 6) " + s6_24, 280, 250);
			g.drawString(" 7) " + s7_24, 280, 270);
			g.drawString(" 8) " + s8_24, 280, 290);
			g.drawString(" 9) " + s9_24, 280, 310);
			g.drawString("10) " + s10_24,280, 330);
			
			writeScore();
			writeScoremonth();
			getScore();
			getScoremonth();
			 
			    	
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
	
	private void writeScoremonth() { //method will write to new or existing files score at endgame to a different text file
		
		String textfile2 = "C:\\Users\\chloe\\workspace\\Java Project\\src\\Snake\\scoreboardmonth.txt";
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
				System.out.println("Monthly score submitted.");   
				
				//creating the dates task will be scheduled to
				DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			    Date date1 = dateFormatter.parse("2019-09-01 15:00:00");
			    Date date2 = dateFormatter.parse("2019-10-01 15:00:00");
			    Date date3 = dateFormatter.parse("2019-11-01 15:00:00");
			    Date date4 = dateFormatter.parse("2019-12-01 15:00:00");
			    Date date5 = dateFormatter.parse("2020-01-01 15:00:00");
			    Date date6 = dateFormatter.parse("2020-02-01 15:00:00");
			    Date date7 = dateFormatter.parse("2020-03-01 15:00:00");

			    //scheduling the task (for 7 days)
			    Timer timer2 = new Timer();
			    timer2.schedule(deletemonthscore(),date1);
			    timer2.schedule(deletemonthscore(),date2); 
			    timer2.schedule(deletemonthscore(),date3); 
			    timer2.schedule(deletemonthscore(),date4); 
			    timer2.schedule(deletemonthscore(),date5);
			    timer2.schedule(deletemonthscore(),date6);
			    timer2.schedule(deletemonthscore(),date7);
			    
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
	
	
	//this method will delete month scoreboard file every 24 hours
	private TimerTask deletemonthscore() {
		String textfile2 = "C:\\Users\\chloe\\workspace\\Java Project\\src\\Snake\\scoreboardmonth.txt";
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

	public void getScoremonth() {  //this method reads

		{
        try {
			
	        List<Integer> highscores2 = new ArrayList<Integer>();  //creating an arrayList to hold the scores from the text file
	        //reads the correct file full of the scores                   
	        BufferedReader reader2 = new BufferedReader(new FileReader(      //change this location to a place on the pc this java file is being run on
	        		"C:\\Users\\chloe\\workspace\\Java Project\\src\\Snake\\scoreboardmonth.txt"));
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