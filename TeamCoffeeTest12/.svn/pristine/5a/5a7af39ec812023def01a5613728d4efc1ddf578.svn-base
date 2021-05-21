package com.teamcoffee.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class FileUploadUtil {
	public static String getNowDateTime() {
		//현재의 날짜 및 시간을 문자열로 리턴
		String nowDateTime = "";
		Calendar cal = Calendar.getInstance();
		nowDateTime += cal.get(Calendar.YEAR);
		nowDateTime += cal.get(Calendar.MONTH) + 1;
		nowDateTime += cal.get(Calendar.DATE);
		nowDateTime += cal.get(Calendar.HOUR);
		nowDateTime += cal.get(Calendar.MINUTE);
		nowDateTime += cal.get(Calendar.SECOND);
		nowDateTime += cal.get(Calendar.MILLISECOND);
		return nowDateTime;
	}
	
	//파일 첨부 사전 준비(첨부될 파일명을 리스트형태로 리턴)
	public static List<String> prepareFileUpload(MultipartHttpServletRequest multi) {
		//input 태그 중 타입이 file인 태그의 name 속성값을 가져온다
		Iterator<String> files = multi.getFileNames();
		
		//첨부될 파일명이 들어갈 객체
		List<String> list = new ArrayList<>();
		
		//files에 데이터가 있는만큼 반복
		while(files.hasNext()) {
			String inputTagName = files.next();
			
			//태그에 있는 파일 정보를 가져온다
			MultipartFile file = multi.getFile(inputTagName);
			String fileName = "";
			fileName = getNowDateTime() + "_" + file.getOriginalFilename();
			
			list.add(fileName);
		}
		return list;
	}
	
	//파일 업로드 기능 수행
	public static void fileUpload(MultipartHttpServletRequest multi, List<String> fileNameList) {
		//저장경로지정
		String path = "D:\\workspaceSTS\\TeamCoffee\\src\\main\\webapp\\resources\\img\\";
		
		//input 태그 중 타입이 file인 태그의 name 속성값을 가져온다
		Iterator<String> files = multi.getFileNames();
		
		int i = 0;
		//files에 데이터가 있는만큼 반복
		while(files.hasNext()) {
			String inputTagName = files.next();
			
			//태그에 있는 파일 정보를 가져온다
			MultipartFile file = multi.getFile(inputTagName);

			try {
				file.transferTo(new File(path + fileNameList.get(i++)));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}		

	}
}
