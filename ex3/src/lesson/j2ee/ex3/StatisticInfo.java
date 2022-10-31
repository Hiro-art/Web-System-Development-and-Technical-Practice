package lesson.j2ee.ex3;

/**
 * 访问统计计数
 * 
 * @author liyong
 *
 */
public class StatisticInfo {

	private static int count = 1;

	/**
	 * 每次调用将计数+1，注意synchronized参数的使用，避免多进程计数错误！
	 * 
	 * @return 当前访问计数
	 */
	public static synchronized int getCount() {

		return count++;
	}

}