package com.labServer.util;
import java.text.DecimalFormat;

public class RandomDoubleUtil {

	/**
	 * ����˫�����������x,y���������߽�ֵ
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
