package com.labServer.util;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SqlOutPutUtil {

	public static void main(String[] args) throws Exception {

		int startId = 1; // 起始id
		int endId = 2867; // 截至id
		int startTemp = 28; // 随机温度左边界
		int stopTemp = 29; // 随机温度右边界
		int startHum = 60; // 随机湿度左边界
		int stopHum = 70; // 随机湿度右边界
		String tableName = "lab_fdisplayparamter"; // 需修探头对应的表名

		String txtName = tableName + startId + "_" + endId;

		String updateSql = generalUpdateMessage(tableName, startId, endId, startTemp, stopTemp, startHum, stopHum);

		write(txtName, updateSql);

	}

	/**
	 * 传入参数生成update_sql(根据id号更新温湿度数据)
	 * 
	 * @param tableName
	 *            需修改表名
	 * @param startId
	 *            ID起始
	 * @param endId
	 *            ID截至
	 * @param startTemp
	 *            随机温度左边界
	 * @param stopTemp
	 *            随机温度右边界
	 * @param startHum
	 *            随机湿度左边界
	 * @param stopHum
	 *            随机湿度右边界
	 * @return
	 */
	public static String generalUpdateMessage(String tableName, int startId, int endId, int startTemp, int stopTemp,
			int startHum, int stopHum) {

		String update = "UPDATE ";
		String disTemp = " lab SET lab.DISTEMPERATURE = ";
		String disHum = " ,lab.DISHUMIDITY = ";
		String id = " where lab.ID = ";
		String suffix = " ;\n";
		StringBuffer sb = new StringBuffer();

		for (int i = startId; i <= endId; i++) {
			sb.append(update).append(tableName).append(disTemp)
					.append(RandomDoubleUtil.generalDouble(startTemp, stopTemp)).append(disHum)
					.append(RandomDoubleUtil.generalDouble(startHum, stopHum)).append(id).append(i).append(suffix);
		}

		return sb.toString();
	}

	public static void write(String fileName, String content) throws IOException {
		File file = new File(fileName);
		// if file doesnt exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(content);
		bw.close();
	}

}
