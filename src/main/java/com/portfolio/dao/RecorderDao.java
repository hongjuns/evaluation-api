package com.portfolio.dao;

import java.util.List;

import com.portfolio.model.RecorderModel;

public interface RecorderDao {
	public List<RecorderModel> selectRecorder();
	public int checkRecorder(RecorderModel recorderModel);
	public List<RecorderModel> selectRecorderScore (RecorderModel recorderModel);
}
