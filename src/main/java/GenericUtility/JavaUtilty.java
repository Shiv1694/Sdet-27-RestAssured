package GenericUtility;

import java.util.Random;

/**
 * This class contans java specific generic methods
 * @author navachetan
 *
 */
public class JavaUtilty 
{
	/**
	 * this method will generate a random value for every run
	 * @return 
	 */
	public int getRandomNum()
	{
		Random ran = new Random();
		int value = ran.nextInt();
		return value;
	}
}
