package com.zhuyanjing.stronger.service;


import com.zhuyanjing.stronger.respository.StrongerRepository;
import com.zhuyanjing.stronger.entity.Stronger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class StrongerService {


    @Autowired
    private StrongerRepository strongerRepository;

    @Transactional/*添加事务，要么同时插入，要么都不保存，比如 扣钱和口库存*/
    public void insertStrongers(){
        Stronger strongerA =new Stronger();
        strongerA.setAge(90);
        strongerA.setBeauty("old");
        strongerRepository.save(strongerA);

        Stronger strongerB =new Stronger();
        strongerB.setAge(9);
        strongerB.setBeauty("littlebaby");
        strongerRepository.save(strongerB);

    }
}
