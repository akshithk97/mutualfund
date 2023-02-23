package com.aliceblue.mutualfund.v2.service;

import com.aliceblue.mutualfund.v2.entity.MFAllotmentResponse;
import com.aliceblue.mutualfund.v2.entity.MFOrder;
import com.aliceblue.mutualfund.v2.entity.MFRedemptionResponse;
import com.aliceblue.mutualfund.v2.repository.AllotmentRepository;
import com.aliceblue.mutualfund.v2.repository.OrderRepository;
import com.aliceblue.mutualfund.v2.repository.RedemptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    AllotmentRepository allotmentRepository;

    @Autowired
    RedemptionRepository redemptionRepository;

    public List<MFOrder> getAllOrders(Integer pageNo, Integer pageSize)
    {
//        Pageable paging = PageRequest.of(pageNo, pageSize,  Sort.by("id").ascending());
//        return orderRepository.findAll(paging).getContent();
        return orderRepository.findAll(Sort.by("id").ascending());
    }

    public List<MFAllotmentResponse> getAllAllotments()
    {
        return allotmentRepository.findAll(Sort.by("id").ascending());
    }

    public List<MFRedemptionResponse> getAllRedemptions()
    {
        return redemptionRepository.findAll(Sort.by("id").ascending());
    }
}
