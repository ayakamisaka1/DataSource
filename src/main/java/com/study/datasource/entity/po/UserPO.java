package com.study.datasource.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author : ayaka
 * @version : 1.0
 * @appName : DataSource
 * @moduleName : DataSource
 * @className : com.study.datasource.entity.po.UserPO
 * @date : 2024/4/23 14:09
 */
@Data
@TableName("system_user")
public class UserPO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableField(value = "id")
    private String id;
    /**
     * 中文名
     */
    @TableField(value = "chinese_name")
    private String chineseName;
    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;
    /**
     * 删除标识
     */
    @TableField(value = "deleted")
    private String deleted;
    /**
     * 创建人
     */
    @TableField(value = "created_by")
    private String createdBy;
    /**
     * 创造时间
     */
    @TableField(value = "created_time")
    private Date createdTime;
    /**
     * 修改人
     */
    @TableField(value = "update_by")
    private String updateBy;
    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    private Date updateTime;
    /**
     * 版本号
     */
    @TableField(value = "version")
    private Integer version;
}
