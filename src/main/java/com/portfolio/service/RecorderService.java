package com.portfolio.service;

import java.util.List;
import com.portfolio.model.RecorderModel;

public interface RecorderService {
	public List<RecorderModel> selectRecorder();
	public int checkRecorder(RecorderModel recorderModel);
	public List<RecorderModel> selectRecorderScore (RecorderModel recorderModel);
	public int insertRecorderScore(RecorderModel recorderModel);
}
