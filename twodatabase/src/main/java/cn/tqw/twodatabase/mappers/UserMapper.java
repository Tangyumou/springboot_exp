package cn.tqw.twodatabase.mappers;


import cn.tqw.twodatabase.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    int addUser(User user);

    User findUser(User user);

    int updateUser(User user);


    //通过用户email 修改该用户对应单位用户医院
    void updateHospitalByEmail(@Param("userEmail") String userEmail, @Param("hname") String hname, @Param("cname") String cname);


    //通过email修改普通用户国家信息
    void updateCountryByEmail(@Param("userEmail") String userEmail, @Param("cname") String cname);


    List<User> findAllUser();//查找所有用户信息，分页显示

    //根据userId设置用户头像图片路径
    int updateUserImgByUserId(@Param("userId") Long userId, @Param("userImg") String userImg);


}
