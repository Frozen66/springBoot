package com.zhuyanjing.stronger.controller;

import com.zhuyanjing.stronger.aspect.HttpAspect;
import com.zhuyanjing.stronger.respository.StrongerRepository;
import com.zhuyanjing.stronger.service.StrongerService;
import com.zhuyanjing.stronger.entity.Stronger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StrongerController {
    private final  static Logger logger= LoggerFactory.getLogger(StrongerController.class);
    /*
     * 注意里边的参数也得改成类名！！！
   * */

    @Autowired
    private StrongerRepository strongerRepository;

    @Autowired
    private StrongerService strongerService;
    /*
    *
    * 查询所有人列表
    *
    * */
    @GetMapping(value="/strongers")
    public List<Stronger> strongerList(){
        //jpa操作数据库特别简单，不用自己写sql语句
        logger.info("strongerList");
            return strongerRepository.findAll();
    }
    /*
    *
    * 添加一个人，属性值传过来(第一种方法)
    * */
  /*  @PostMapping(value = "/strongers")
    public Stronger strongerAdd(@RequestParam("beauty") String beauty,@RequestParam("age") Integer age)
    {
        Stronger  stronger=new Stronger();
        stronger.setAge(age);
        stronger.setBeauty(beauty);
        return strongerRepository.save(stronger);
    }*/
  /*
  * 简便的方法
  * */
    @PostMapping(value = "/strongers")
    public Stronger strongerAdd(@Valid Stronger stronger,BindingResult bindingResult)/*验证的结果返回到bindingresult对象里边*/
    {

        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;/*发生错误不能继续往下走*/
        }
        stronger.setAge(stronger.getAge());
        stronger.setBeauty(stronger.getBeauty());
        return strongerRepository.save(stronger);
    }
    /*
    *查一个人
    *
    * */

        @GetMapping(value="/strongers/{id}")
        public Stronger stongerFindById(@PathVariable("id") Integer id)
        {

            return strongerRepository.findById(id).orElse(null);

        }

    /*
     *
     * 通过年龄查找列表
     * */

    @GetMapping(value = "/strongers/age/{age}")
    public List<Stronger> strongerAge(@PathVariable("age") Integer age){

        return strongerRepository.findByAge(age);
    }

    /*
    * 更新
    * */
    @PutMapping(value="/strongers/{id}")
    public Stronger strongerUpdate(@RequestParam("beauty") String beauty,@RequestParam("age") Integer age,@PathVariable("id") Integer id)


    {
        Stronger stronger=new Stronger();
        stronger.setBeauty(beauty);
        stronger.setAge(age);
        stronger.setId(id);
        return strongerRepository.save(stronger);//返回的是一个对象
    }
    /*
    * 删除
    * */
    @DeleteMapping(value = "/strongers/{id}")
    public void strongerDelete(@PathVariable("id") Integer id){
       strongerRepository.deleteById(id);

    }
    /*
    *
    * 插入两条数据
    * */
    @PostMapping(value = "/strongers/insert")
    public void insertStronger(){
        strongerService.insertStrongers();

    }


}
