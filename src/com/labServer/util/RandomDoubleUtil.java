package com.labServer.util;
import java.text.DecimalFormat;

public class RandomDoubleUtil {

	/**
	 * 生成双精度随机数【x,y】，包含边界值
	 * @param x
	 * @param y
	 * @return
	 */
	public static String generalDouble(int x, int y) {

		double d = x + Math.random() * y % (y - x + 1);
		DecimalFormat df = new DecimalFormat("0.00");

		return df.format(d);
	}

}
