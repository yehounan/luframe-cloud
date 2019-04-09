package com.quanlehui.allserviceapi.admin.dto;

import lombok.Data;

/**
 * Desc    : 管理员用户Payload
 * @date    : 2018-01-13
 *
 * @author : yxy
 */
@Data
public class AdminUserPayloadDTO {

    private Long id;

    private String username;

    @Override
    public String toString() {
        return "AdminUserPayloadDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
