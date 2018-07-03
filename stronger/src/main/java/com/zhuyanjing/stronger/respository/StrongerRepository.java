package com.zhuyanjing.stronger.respository;

import com.zhuyanjing.stronger.entity.Stronger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/*写一个接口继承jpa*/

public interface StrongerRepository extends JpaRepository<Stronger,Integer> {

    /*
    * 通过年龄来查询
    * */
    public List<Stronger>  findByAge(Integer age);
    //必须这样写方法名

}
