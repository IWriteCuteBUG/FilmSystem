package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.common.persistence.model.MtimeUserT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.vo.sjb.RegReqVo;
import com.stylefeng.guns.rest.vo.sjb.UpdateUserInfoReqVo;
import com.stylefeng.guns.rest.vo.sjb.UserWithoutPwd;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author jeff
 * @since 2019-10-12
 */
public interface MtimeUserTMapper extends BaseMapper<MtimeUserT> {

    List<String> selectUaernames();

    void addUser(@Param("vo") RegReqVo vo);

    int updateUserInfo(@Param("vo") UpdateUserInfoReqVo vo);

    UserWithoutPwd selectUserWithoutPwdByUuid(@Param("uuid") int uuid);

    String queryPwdByUsername(@Param("username") String userName);
}
