package homework.day09;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

/**
 * 生成10个0-100之间的不重复的随机数,并输出
 * @author Xiloer
 *
 */
public class Test03 {
	public static void main(String[] args) {
		Collection<Integer> list = new ArrayList<>();
		Random random = new Random();
		HashSet<Integer> hs = new HashSet<>();
		int[] nums	= new int[10];
		for (int i = 0;i<nums.length;i++){

		}
		while(true){
			Integer num = random.nextInt(100);
			list.add(num);

		}
	}
}
