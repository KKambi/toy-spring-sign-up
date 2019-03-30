package com.hb.signup.course.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hb.signup.course.Course;
import com.hb.signup.course.service.CourseService;

@Controller
public class CourseController {
	
	@Resource(name="courseService")
	CourseService service;
	
	private HashMap<String, Course> courseMap;
	private HashMap<String, Course> courseRecordMap;
	
	private static final Logger logger = LoggerFactory.getLogger(CourseController.class);
	
	@RequestMapping(value = "/courseRegister", method = RequestMethod.GET)
	public String courseRegister(Locale locale, Model model, HttpServletRequest request) {
		logger.info("★★courseRegister");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	
		ClassPathResource resource = new ClassPathResource("data/course.txt");
		if (resource.exists()) {
			service.sampleRegister(resource);
			courseMap = new HashMap<String, Course>(service.sampleSearch());
			model.addAttribute("courseMap", courseMap);
		}
		else {
			model.addAttribute("courseMap", null);
		}
		
		resource = new ClassPathResource("data/courseRecord.txt");
		if (resource.exists()) {
			service.recordRegister(resource);
			courseRecordMap = new HashMap<String, Course>(service.recordSearch());
		}
		
		String formattedDate = dateFormat.format(date);
		String memId = request.getParameter("memId");
		
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("memId", memId);
		
		return "courseRegister";
	}
	
	@RequestMapping(value = "/courseRecord", method = RequestMethod.GET)
	public String courseRecord(Locale locale, Model model, HttpServletRequest request) {
		logger.info("★★courseRecord");
		
		model.addAttribute("courseRecordMap", courseRecordMap);
		
		String memId = request.getParameter("memId");
		
		model.addAttribute("memId", memId);
		
		return "courseRecord";
	}
	
	@RequestMapping(value = "/courseCheck", method = RequestMethod.POST)
	public String courseCheck(RedirectAttributes rttr, Locale locale, Model model, HttpServletRequest request) {
		logger.info("★★courseCheck");

		//신청한 과목들이 조건에 맞는지 검사하는 컨트롤러
		String[] checked = request.getParameterValues("checkedCourse");			
		
		//조건1. 최소9학점 ~ 최대 24학점
		//조건2. 신청 과목들의 강의 시간 중복 여부
		//조건3. 선수과목 수강 여부
		boolean checkFlag = true;
		boolean creditFlag = true;
		boolean timeFlag = true;
		boolean preFlag = true;
		
		int totalCredit = 0;	//총 신청 학점
		Set<Integer> timeSet = new HashSet<Integer>();	//강의시간을 넣고 중복여부 판단
		Set<String> alreadySet = new HashSet<String>();	//이미 수강한 과목의 코드를 저장한 set	
		HashMap<String, Course> registerMap = new HashMap<String, Course>();
		
		for (String alreadyCode : courseRecordMap.keySet()) {
			alreadySet.add(alreadyCode);
		}
		
		String creditResult = null;
		String timeResult = null;
		String preResult = null;

		if (checked != null) {
			for (String code : checked) {
				Course course = courseMap.get(code);
				registerMap.put(code, course);
				
				int credit = course.getCourseCredit();
				int time1 = course.getCourseTime1();
				int time2 = course.getCourseTime2();
				String preString = course.getCoursePre();
				
				//총 학점 더하기
				totalCredit += credit;
				
				//강의시간 중복 검사
				if (timeFlag && (time1 >= 0)) {
					if (!timeSet.add(time1))
						timeFlag = false;
				}
				if (timeFlag && (time2 >= 0)) {
					if (!timeSet.add(time2))
						timeFlag = false;
				}
				
				//선수과목 수강 여부 검사
				if (preString != null) {
					String[] pre = preString.split("/");
					for (String preCode : pre) {
						if (!alreadySet.contains(preCode))
							preFlag = false;
					}
				}
			}
		} else {
			checkFlag = false;
			creditResult = "최소 9학점을 신청해야 합니다.";
		}
		
		if (checkFlag) {
			//학점
			if (totalCredit < 9) {
				creditResult = "최소 9학점을 신청해야 합니다. (신청학점: " +
									totalCredit + ")";
				creditFlag = false;
			}
			else if (totalCredit > 24) {
				creditResult = "최대 24학점까지 신청할 수 있습니다. (신청학점: " +
								totalCredit + ")";
				creditFlag = false;
			}
			//시간
			if (timeFlag == false)
				timeResult = "신청하신 과목들의 강의시간이 중복됩니다.";
			
			//선수과목
			if (preFlag == false)
			preResult = "신청하신 과목들의 선수과목을 수강하지 않았습니다.";
		}
		
		String memId = request.getParameter("memId");
		model.addAttribute("memId", memId);
		model.addAttribute("creditResult", creditResult);
		model.addAttribute("timeResult", timeResult);
		model.addAttribute("preResult", preResult);
		
		//성공할 시, /courseResult로 redirect
		//실패할 시, /courseCheck로 보내면서 실패사유 보내고, 다시 체크할 것을 유도!
		if (checkFlag && creditFlag && timeFlag && preFlag) {
			rttr.addFlashAttribute("memId", memId);
			rttr.addFlashAttribute("totalCredit", totalCredit);
			rttr.addFlashAttribute("registerMap", registerMap);
			return "redirect:/courseResult";
		}
		else{
			return "courseCheck";
		}
	}
	
	@RequestMapping(value = "/courseResult", method = RequestMethod.GET)
	public String courseResult(Locale locale, Model model, HttpServletRequest request) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "courseResult";
	}
	
}
