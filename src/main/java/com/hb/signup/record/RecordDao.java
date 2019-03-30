package com.hb.signup.record;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.FileCopyUtils;

import com.hb.signup.course.Course;

@Repository("recordDao")
public class RecordDao implements IRecordDao {
	private HashMap<String, Course> recordMap;
	
	public RecordDao() {
		recordMap = new HashMap<String, Course>();
	}
	
	public void recordInsert(ClassPathResource file) {
		//여기서 file로부터 적절히 읽어들여 sampleMap에 넣어야 함
		byte[] bdata = null;
		try {
			bdata = FileCopyUtils.copyToByteArray(file.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		String courseTxt = new String(bdata, StandardCharsets.UTF_8); 
		String txtLine[] = courseTxt.split("\r\n");
		
		for (int i=0; i<txtLine.length; i++) {
			String word[] = txtLine[i].split(" ");
			
			Course course = new Course();
			course.setCourseCode(word[0].substring(0, 7));
			course.setCourseSubClass(word[0].substring(8, 10));
			
			course.setCourseName(word[1]);
			
			String time[] = word[2].split("/");
			course.setCourseTime1(Integer.parseInt(time[0]));
			course.setCourseTime2(Integer.parseInt(time[1]));
			
			course.setCourseRoom(word[3]);
			course.setCourseCredit(Integer.parseInt(word[4]));
			course.setCourseProf(word[5]);
			
			try {
				course.setCoursePre(word[6]);
			} catch (ArrayIndexOutOfBoundsException e) {
				course.setCoursePre(null);
			}
			
			recordMap.put(course.getCourseCode(), course);
		}
	};
	
	public HashMap<String, Course> recordSelect(){
		//샘플맵을 리턴하는 함수
		return recordMap;
	};
	
}
