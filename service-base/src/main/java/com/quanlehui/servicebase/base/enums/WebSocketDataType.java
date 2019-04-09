package com.quanlehui.servicebase.base.enums;

/**
 * Desc    :
 * Author  : yxy
 * Date    : 2018-04-17
 */
public enum WebSocketDataType {
    OPEN_ADD(0), //盘口新增
    NORMAL_ELIMINATION(1), //正常淘汰队伍
    FALL_ELEMENT(2),   //异常淘汰队伍
    DATA_CHANGE(3),  //盘口状态变更
    V2_INITIAL_OPEN_ADD(10), //V2对战盘初盘新增
    V2_ROLL_OPEN_ADD(11), //V2对战盘滚盘新增
    V2_TOURNAMENT_OPEN_ADD(12), //V2联赛盘盘口新增
    ;

    private Integer code;

    public Integer getCode() {
        return code;
    }

    WebSocketDataType(Integer code) {
        this.code = code;
    }
}
