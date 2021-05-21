package com.shop.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class FileUploadUtil {
	//현재의 날짜 및 시간을 문자열로 리턴
	public static String getNowDateTime() {
		String nowDateTime = "";
		Calendar cal = Calendar.getInstance();
		nowDateTime = nowDateTime + cal.get(Calendar.YEAR);
		nowDateTime	= nowDateTime = nowDateTime + cal.get(Calendar.DATE);
		nowDateTime = nowDateTime + cal.get(Calendar.HOUR);
		nowDateTime = nowDateTime + cal.get(Calendar.MINUTE);
		nowDateTime = nowDateTime + cal.get(Calendar.SECOND);
		nowDateTime = nowDateTime + cal.get(Calendar.MILLISECOND);
		
		return nowDateTime;
	}
	//파일첨부 사전준비(첨부될 파일명을 리스트형태로 리턴)
	public static List<String> prepareFileUpload(MultipartHttpServletRequest multi) {
		
		//input태그중 타입이 file인 태그의 name속성값을 가져옴.
		Iterator<String> files = multi.getFileNames();
				
		
		//첨부될 파일명이 들어갈 객체
		List<String> list = new ArrayList<String>();
		
		
		//filse에 데이터가 있는만큼 반복하겠음.
			while(files.hasNext()) {
				String inputTagName = files.next();
				//태그에 있는 파일정보를 가져온다.
				MultipartFile file =  multi.getFile(inputTagName);
				System.out.println(file.getOriginalFilename());
				String fileName = "";
				fileName=getNowDateTime() + "_" + file.getOriginalFilename();
				
				//생성된 파일명을 리스트에 저장
				list.add(fileName);
			
			}			
			return list;
		
	}
	//파일 업로드 기능 수행
	public static void fileUpload(MultipartHttpServletRequest multi, List<String> fileNameList) {
		
		//저장경로 지정해야됨
				String path = "D:\\submit\\workspaceSTS\\SHOP\\src\\main\\webapp\\resources\\image\\";
		
		//input태그중 타입이 file인 태그의 name속성값을 가져옴.
				Iterator<String> files = multi.getFileNames();
				
				int index = 0;
				
				//filse에 데이터가 있는만큼 반복하겠음.
				while(files.hasNext()) {
					String inputTagName = files.next();
					//태그에 있는 파일정보를 가져온다.
					MultipartFile file =  multi.getFile(inputTagName);
					System.out.println(file.getOriginalFilename());
					String fileName = "";
					
					//fileName = getNowDateTime() + "_" + file.getOriginalFilename();
					fileName = fileNameList.get(index++);
					
					
					
					try {
						file.transferTo(new File(path + fileName));
					} catch (IllegalStateException | IOException e) {
						
						e.printStackTrace();
					}

				
				}	
	}
}
