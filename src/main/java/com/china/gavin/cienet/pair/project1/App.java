package com.china.gavin.cienet.pair.project1;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Report> rptList = Report.generateReportList(12);
		System.out.println("-----------------  打印結果：  -----------------");
		for (Report rpt : rptList) {
			System.out.println(rpt);
		}
		writeDataToFile("D:/output.csv", rptList);
	}

	public static void writeDataToFile(String filename, List<Report> rptList) {
		// BufferedOutputStream bos = null;
		OutputStreamWriter bos = null;
		try {
			// bos = new BufferedOutputStream(new FileOutputStream(filename));
			// bos.write(Report.getTitle().getBytes());
			bos = new OutputStreamWriter(new FileOutputStream(filename),
					"UTF-8");
			bos.write(Report.getTitle());
			for (Report rpt : rptList) {
				bos.write(rpt.getReportStr());
			}
			bos.flush();
		} catch (Exception e) {
			// log.error("Can't write,permission denied.", e);
			e.getStackTrace();
			// ignore
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (Exception e) {
					// log.error(e.getMessage(), e);
					System.out.println("太牛了，關不掉");
					// ignore
				}
			}
		}
	}
}
