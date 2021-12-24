package com.portfolio.service;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.model.RecorderModel;
import com.portfolio.dao.RecorderDao;

@Service
public class RecorderServiceImpl  implements RecorderService {
	@Autowired
	private SqlSession mysqlSqlSession;

	@Override
	public List<RecorderModel> selectRecorder() {
		RecorderDao recorderDao = mysqlSqlSession.getMapper(RecorderDao.class);
		return recorderDao.selectRecorder();
	}

	@Override
	public int checkRecorder(RecorderModel recorderModel) {
		RecorderDao recorderDao = mysqlSqlSession.getMapper(RecorderDao.class);
		return recorderDao.checkRecorder(recorderModel);
	} 
	
	
	
	
}
