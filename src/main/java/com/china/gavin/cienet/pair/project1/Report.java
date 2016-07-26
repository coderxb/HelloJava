package com.china.gavin.cienet.pair.project1;

import java.util.ArrayList;
import java.util.List;

public class Report implements Constants {

	private String caseNo;
	private String projectName;
	private ResultEnum result;

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public ResultEnum getResult() {
		return result;
	}

	public void setResult(ResultEnum result) {
		this.result = result;
	}

	public static String getTitle() {
		StringBuilder titleStr = new StringBuilder();
		titleStr.append("caseNo").append(TEXT_FILE_SEPERATOR)
				.append("projectName").append(TEXT_FILE_SEPERATOR)
				.append("result").append(LINE_END);
		return titleStr.toString();
	}

	public String getReportStr() {
		StringBuilder csvStr = new StringBuilder();
		csvStr.append(getCaseNo()).append(TEXT_FILE_SEPERATOR)
				.append(getProjectName()).append(TEXT_FILE_SEPERATOR)
				.append(getResult().getValue()).append(LINE_END);
		return csvStr.toString();
	}

	@Override
	public String toString() {
		return "Report [caseNo=" + caseNo + ", projectName=" + projectName
				+ ", result=" + result + "]";
	}

	public static List<Report> generateReportList(int count) {
		List<Report> list = new ArrayList<Report>();
		for (int i = 0; i < count; i++) {
			int num = i + 1;
			Report rpt = new Report();
			rpt.setCaseNo("caseNo" + num);
			rpt.setProjectName("projectName" + num);
			rpt.setResult(ResultEnum.random(ResultEnum.class));
			list.add(rpt);
		}
		return list;
	}

	public static String[] generateReportArray(int count) {
		String[] reportArray = new String[count];
		for (int i = 0; i < count; i++) {
			Report rpt = new Report();
			int num = i + 1;
			rpt.setCaseNo("caseNo" + num);
			rpt.setProjectName("projectName" + num);
			rpt.setResult(ResultEnum.random(ResultEnum.class));
			reportArray[i] = rpt.toString();
		}
		return reportArray;

	}

	public static void main(String[] args) {
		List<Report> rptList = generateReportList(12);
		System.out.println("-----------------  打印結果：  -----------------");
		for (Report rpt : rptList) {
			System.out.println(rpt);
		}
	}
}
