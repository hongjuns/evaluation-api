package com.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.portfolio.config.BaseController;
import com.portfolio.model.ApiResponseMessage;
import com.portfolio.model.RecorderModel;
import com.portfolio.service.RecorderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "RecorderController", description = "Recorder-Controller")
public class RecorderController extends BaseController {

	@Autowired
	private RecorderService recorderService;
	
	@CrossOrigin(origins = "https://hhongjunss.me")
	@RequestMapping(value="/check/recorder", method=RequestMethod.GET)
	@ApiOperation(value = "발음평가 횟수 체크", notes = "발음평가 횟수를 체크하는 API.")
	public int recorderCheck (HttpServletRequest request, HttpServletResponse response,RecorderModel recorderModel) {
		logger.info("recorderCheck");
		return recorderService.checkRecorder(recorderModel);
	}
	
	@CrossOrigin(origins = "https://hhongjunss.me")
	@RequestMapping(value="/score/recorder", method=RequestMethod.GET)
	@ApiOperation(value = "발음평가 점수 확인", notes = "발음평가 점수를 검색하는 API.")
	public List<RecorderModel> recorderScore (HttpServletRequest request, HttpServletResponse response,RecorderModel recorderModel) {
		logger.info("recorderScore");
		return recorderService.selectRecorderScore(recorderModel);
	}
	
	@CrossOrigin(origins = "https://hhongjunss.me")
	@RequestMapping(value = "/insert/recorder", method = RequestMethod.POST)
	@ApiOperation(value = "발음평가 점수 등록", notes = "발음평가 점수를 저장하는 API.")
	public ResponseEntity<ApiResponseMessage>  recorderInsert (RecorderModel recorderModel){
		logger.info("recorderInsert");
		
	    ApiResponseMessage message;
	    ResponseEntity<ApiResponseMessage> response = null;
        
	    try {
        	if (recorderService.insertRecorderScore(recorderModel) > 0) {
                message = new ApiResponseMessage("Success", "등록되었습니다.", "", "");
                response = new ResponseEntity<ApiResponseMessage>(message, HttpStatus.OK);
        	}
        } catch(Exception ex){
            message = new ApiResponseMessage("Failed", "등록에 실패하였습니다.", "ERROR00001", ex.getMessage());
            response = new ResponseEntity<ApiResponseMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;

	 }
	
}
