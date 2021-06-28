package com.hrms.service;

import java.util.List;

import com.hrms.dtos.BankMasterDTO;

public interface BankMasterService {

	public List<BankMasterDTO> getAllBankMaster();

	public String editBankMaster(BankMasterDTO bankMasterDTO);

	public void deleteBankMaster(Integer tranid);

	public String saveBankMaster(BankMasterDTO bankMasterDTO);

	public List<BankMasterDTO> getBankMasterByTranId(int tranid);

}
