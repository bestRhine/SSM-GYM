package com.rhine.gym.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rhine.gym.dao.ContractDao;
import com.rhine.gym.entity.Contract;
import com.rhine.gym.entity.ContractCourse;
import com.rhine.gym.entity.ContractItem;
import com.rhine.gym.entity.ContractMember;
import com.rhine.gym.entity.CtMoreInfo;
import com.rhine.gym.service.ContractService;


@Service
public class ContractServiceImpl implements ContractService{
	@Autowired
	private ContractDao contractDao;

	@Override
	public void addContract(Contract contract) {
		// TODO Auto-generated method stub
		contractDao.addContract(contract);
	}

	@Override
	public List<Contract> findBy(Map map) {
		// TODO Auto-generated method stub
		return contractDao.findBy(map);
	}
	
	public List<CtMoreInfo> showMoreCtInfo(int ctid) {
		return contractDao.showMoreCtInfo(ctid);
	}
	public List<CtMoreInfo> showMoreMemInfo(int ctid) {
		return contractDao.showMoreMemInfo(ctid);
	}
	
	@Override
	public void updateContract(int ctid,String cname) {
		// TODO Auto-generated method stub
		contractDao.updateContract(ctid,cname);
	}

	public void insertMiddleContractCourse(ContractCourse contractCourse) {
		contractDao.insertMiddleContractCourse(contractCourse);
	}
	
	public void insertMiddleContractMember(ContractMember contractMember) {
		contractDao.insertMiddleContractMember(contractMember);
	}

	@Override
	public int maxCurrentId() {
		// TODO Auto-generated method stub
		return contractDao.maxCurrentId();
	}

	@Override
	public void contractTransCourse(Map map) { 
		// TODO Auto-generated method stub
		contractDao.contractTransCourse(map);
	}

	@Override
	public void changeTeacher(int ctid, String empName,String type) {
		// TODO Auto-generated method stub
		contractDao.changeTeacher(ctid, empName,type);
	}

	@Override
	public void insertCtRecord(int ctid, String ctoperator, String ctteacher, String cname, int amountuse) {
		// TODO Auto-generated method stub
		contractDao.insertCtRecord(ctid,ctoperator,ctteacher,cname,amountuse);
	}

	@Override
	public int getRecordByConditon(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return contractDao.getRecordByConditon(map);
	}

}