package com.labServer.util;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SqlOutPutUtil {

	public static void main(String[] args) throws Exception {

		int startId = 1; // ��ʼid
		int endId = 2867; // ����id
		int startTemp = 28; // ����¶���߽�
		int stopTemp = 29; // ����¶��ұ߽�
		int startHum = 60; // ���ʪ����߽�
		int stopHum = 70; // ���ʪ���ұ߽�
		String tableName = "lab_fdisplayparamter"; // ����̽ͷ��Ӧ�ı���

		String txtName = tableName + startId + "_" + endId;

		String updateSql = generalUpdateMessage(tableName, startId, endId, startTemp, stopTemp, startHum, stopHum);

		write(txtName, updateSql);

	}

	/**
	 * �����������update_sql(����id�Ÿ�����ʪ������)
	 * 
	 * @param tableName
	 *            ���޸ı���
	 * @param startId
	 *            ID��ʼ
	 * @param endId
	 *            ID����
	 * @param startTemp
	 *            ����¶���߽�
	 * @param stopTemp
	 *            ����¶��ұ߽�
	 * @param startHum
	 *            ���ʪ����߽�
	 * @param stopHum
	 *            ���ʪ���ұ߽�
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
