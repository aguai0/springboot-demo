package com.example.mybatisPlus.controller;

import com.example.mybatisPlus.service.TeacherService;
import com.example.mybatisPlus.vo.Teacher;
import com.example.shiroDemo.base.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value = "teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping(value = "/insert")
    public Result insert(){
        Teacher teacher=new Teacher();
       /* teacher.setTeacherName(createRandomStr(6));
        teacher.setTeacherPwd(createRandomStr(6));
        teacherService.insert(teacher);*/
        return  Result.succeed("成功",teacher);
    }

    @GetMapping(value = "/delete")
    public void delete(){
        /*Teacher  teacher=new Teacher();
        teacher.setId(11);
        EntityWrapper entityWrapper=new EntityWrapper(teacher);
        teacherService.delete(entityWrapper);*/
    }

    @GetMapping(value = "/update")
    public void update(){
        //update的判断条件
     /*   EntityWrapper entityWrapper=new EntityWrapper(new Teacher(1));
        //更新之后的对象
        Teacher teacher=new Teacher();
        teacher.setTeacherPwd("new-pwd");
        teacherService.update(teacher,entityWrapper);*/
    }


    /**
     * 根据指定id进行查询
     * SELECT id,teacher_name AS teacherName,teacher_pwd AS teacherPwd
     FROM teacher
     WHERE id=0;
     * @param id
     * @return
     */
    @GetMapping(value = "/selectAllById")
    public Teacher selectByTeacherName(int id){
        //return teacherService.selectOne(new Teacher(id));
        return null;
    }

    /**
     * 使用Map来进行多关键字的查询
     * SELECT id,teacher_name AS teacherName,teacher_pwd AS teacherPwd
     FROM teacher
     WHERE teacher_name = 'qwe';
     * @param name
     * @return
     */
    @GetMapping(value = "/selectAllByMap")
    public List<Teacher> selectAllByEntity(String name){
      /*  Map<String,Object> hashMap=new HashMap<>();
        hashMap.put("teacher_name",name);
        return teacherService.selectByMap(hashMap);*/
        return null;
    }

    /**
     * 统计查询
     * SELECT COUNT(1)  FROM teacher  WHERE id=1 AND teacher_name='qwe';
     * @param name
     * @return
     */
    @GetMapping(value = "/selectCountByEntity")
    public int selectCount(String name){
        /*Teacher teacher=new Teacher();
        teacher.setId(1);
        teacher.setTeacherName(name);
        EntityWrapper<Teacher> entityWrapper=new EntityWrapper<>(teacher);
        return teacherService.selectCount(entityWrapper);*/
        return 0;
    }

    /**
     * 分页查询
     * SELECT id,teacher_name AS teacherName,teacher_pwd AS teacherPwd  FROM teacher  WHERE (id >= 1) LIMIT 0,1;
     * @param pageNumber 第几页
     * @param pageSize 每页多少条
     * @return
     */
    @GetMapping(value = "/selectAllInPage")
    public List<Teacher> selectAllInPage(int pageNumber,int pageSize){
       /* Page<Teacher> page =new Page<>(pageNumber,pageSize);
        EntityWrapper<Teacher> entityWrapper = new EntityWrapper<>();
        entityWrapper.ge("id", 1);
        return teacherService.selectPage(page,entityWrapper);*/
        return null;
    }

    /**
     * in 查询
     * SELECT id,teacher_name AS teacherName,teacher_pwd AS teacherPwd FROM teacher WHERE id IN ( 1 , 10 , 11 );
     * @return
     */
    @GetMapping(value = "/selectInIdArr")
    public List<Teacher> selectInIdArr(){
        List<Integer> idList=new ArrayList<>();
        idList.add(1);
        idList.add(10);
        idList.add(11);
        return null; //teacherService.selectBatchIds(idList);
    }


    /**
     * allEq查询（相当于条件全部都要求满足的情况）
     * SELECT id,teacher_name AS teacherName,teacher_pwd AS teacherPwd
         FROM teacher
         WHERE (teacher_pwd = 'pwd' AND teacher_name = 'name');
     * @return
     */
    @GetMapping(value = "/selectAllByWrapper1")
    public  List<Teacher> selectAllByWrapper1(){
       /* Map<String,Object> map=new HashMap<>();
        map.put("teacher_name","name");
        map.put("teacher_pwd","pwd");
        EntityWrapper entity=new EntityWrapper();
        entity.allEq(map);
        return teacherService.selectList(entity);*/
       return null;
    }

    /**
     * ne查询
     * SELECT id,teacher_name AS teacherName,teacher_pwd AS teacherPwd
     FROM teacher
     WHERE (teacher_name <> 'name');
     * @return
     */
    @GetMapping(value = "/selectAllByWrapper3")
    public List<Teacher> selectAllByWrapper3(){
     /*   EntityWrapper entity=new EntityWrapper();
        entity.ne("teacher_name","name");
        return teacherService.selectList(entity);*/
        return null;
    }

    /**
     * eq查询
     * SELECT id,teacher_name AS teacherName,teacher_pwd AS teacherPwd
     FROM teacher
     WHERE (teacher_name = 'name');
     * @return
     */
    @GetMapping(value = "/selectAllByWrapper2")
    public List<Teacher> selectAllByWrapper2(){
      /*  EntityWrapper entity=new EntityWrapper();
        entity.eq("teacher_name","name");
        return teacherService.selectList(entity);*/
        return null;
    }

    /**
     * 复杂的多条件查询：
     * @return
     */
    @GetMapping(value = "/selectAllByWrapper4")
    public  List<Teacher> selectAllByWrapper4(){
        /*EntityWrapper entity=new EntityWrapper();
        entity.gt("id","0");
        entity.le("id",11);
        entity.ne("teacher_name","null_name");
        entity.like("teacher_name","tt");
        entity.notLike("teacher_pwd","sadas");
        entity.orderBy("id");
        return teacherService.selectList(entity);*/
        return null;
    }











    /**
     * 生成随机字符串
     *
     * @return
     */
    private static String createRandomStr(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(str.length());
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}