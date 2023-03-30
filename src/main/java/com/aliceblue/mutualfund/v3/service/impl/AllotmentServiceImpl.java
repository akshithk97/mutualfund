package com.aliceblue.mutualfund.v3.service.impl;

import com.aliceblue.mutualfund.v2.service.DataService;
import com.aliceblue.mutualfund.v3.model.MFAllotmentResponse;
import com.aliceblue.mutualfund.v3.repository.MFAllotmentRepository;
import com.aliceblue.mutualfund.v3.service.AllotmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AllotmentServiceImpl implements AllotmentService {

    @Autowired
    DataService v2DataService;

    @Autowired
    MFAllotmentRepository allotmentRepository;

    @Override
    public void migrateAllAllotments()
    {
        List<com.aliceblue.mutualfund.v2.entity.MFAllotmentResponse> v2AllotmentList = v2DataService.getAllAllotments();
        log.info("v2 allotments - {}",v2AllotmentList.size());
        int i=0;
        for (com.aliceblue.mutualfund.v2.entity.MFAllotmentResponse v2Allotment : v2AllotmentList)
        {
            MFAllotmentResponse allotmentResponse = allotmentRepository.findByOrderId(v2Allotment.getORDERNO()).orElse(new MFAllotmentResponse());
            allotmentResponse.setSTT(v2Allotment.getSTT());
            allotmentResponse.setISIN(v2Allotment.getISIN());
            allotmentResponse.setEUIN(v2Allotment.getEUIN());
            allotmentResponse.setAmount(v2Allotment.getAMOUNT());
            allotmentResponse.setUserId(v2Allotment.getUSERID());
            allotmentResponse.setRemarks(v2Allotment.getREMARKS());
            allotmentResponse.setFolioNo(v2Allotment.getFOLIONO());
            allotmentResponse.setDPCFlag(v2Allotment.getDPC_FLAG());
            allotmentResponse.setDPTrans(v2Allotment.getDP_TRANS());
            allotmentResponse.setOrderId(v2Allotment.getORDERNO());
            allotmentResponse.setQuantity(v2Allotment.getAMOUNT());
            allotmentResponse.setEUINDecl(v2Allotment.getEUIN_DECL());
            allotmentResponse.setMemberId(v2Allotment.getMEMBER_ID());
            allotmentResponse.setClientId(v2Allotment.getCLIENT_CODE());
            allotmentResponse.setValidFlag(v2Allotment.getVALIDFLAG());
            allotmentResponse.setSubBrCode(v2Allotment.getSUBBRCODE());
            allotmentResponse.setCreatedAt(v2Allotment.getCreatedAt());
            allotmentResponse.setUpdatedAt(v2Allotment.getUpdatedAt());
            allotmentResponse.setOrderDate(v2Allotment.getORDER_DATE());
            allotmentResponse.setOrderType(v2Allotment.getORDER_TYPE());
            allotmentResponse.setSIPRegnNo(v2Allotment.getSIP_REGN_NO());
            allotmentResponse.setReportDate(v2Allotment.getREPORTDATE());
            allotmentResponse.setRTATransNo(v2Allotment.getRTATRANSNO());
            allotmentResponse.setSchemeCode(v2Allotment.getSCHEMECODE());
            allotmentResponse.setBranchCode(v2Allotment.getBRANCH_CODE());
            allotmentResponse.setClientName(v2Allotment.getCLIENT_NAME());
            allotmentResponse.setAllottedNAV(v2Allotment.getALLOTTED_NAV());
            allotmentResponse.setSIPRegnDate(v2Allotment.getSIP_REGN_DATE());
            allotmentResponse.setAllottedDate(v2Allotment.getAllotedDate());
            allotmentResponse.setAllottedUnit(v2Allotment.getALLOTTED_UNIT());
            allotmentResponse.setSettlementNo(v2Allotment.getSETTLEMENT_NO());
            allotmentResponse.setOrderSubType(v2Allotment.getORDER_SUB_TYPE());
            allotmentResponse.setBeneficiaryId(v2Allotment.getBENEFICIARYID());
            allotmentResponse.setRTASchemeCode(v2Allotment.getRTASCHEMECODE());
            allotmentResponse.setInternalRefNo(v2Allotment.getINTERNAL_REF_NO());
            allotmentResponse.setSettlementType(v2Allotment.getSETTLEMENT_TYPE());
            allotmentResponse.setAllotmentAmount(v2Allotment.getALLOTMENT_AMOUNT());
            allotmentRepository.save(allotmentResponse);
            i++;
        }
        log.info("allotment added - {}",i);
    }

    @Override
    public List<MFAllotmentResponse> getAllAllotments(String clientId, String schemeCode)
    {
        return allotmentRepository.getAllAllotments(clientId, schemeCode);
    }
}
