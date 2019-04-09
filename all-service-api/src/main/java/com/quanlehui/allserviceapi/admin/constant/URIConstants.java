package com.quanlehui.allserviceapi.admin.constant;

/**
 * Description 数据服务后台管理服务http接口定义
 *
 * @author yxy
 * @date 2018/12/12
 */
public interface URIConstants {

    interface AdminIpWhitelistConfigURL {
        String PAGE = "/ipwhitelist/page";
        String INSERT = "/ipwhitelist/insert";
        String DELETE = "/ipwhitelist/delete";
        String FEIGN_LIST = "/feign/ipwhitelist/list";
    }

    /**
     * 获取图片验证码
     */
    String COMMON_IMGCODE = "/common/imgcode";
    /**
     * 登录
     */
    String LOGIN = "/login";
    /**
     * 操作日志查询
     */
    String OPERATELOG_QUERY = "/operateLog/query";
    /**
     * 获取管理员自身信息
     */
    String SELF_INFO = "/self/info";
    /**
     * 资源列表
     */
    String RESOURCE_LIST = "/resource/list";
    /**
     * 菜单列表
     */
    String MENU_LIST = "/menu/list";
    /**
     * 资源新增
     */
    String RESOURCE_INSERT = "/resource/insert";
    /**
     * 插入角色
     */
    String ROLE_INSERT = "/role/insert";
    /**
     * 更新角色权限
     */
    String ROLE_UPDATE_AUTHORITY = "/role/update/authority";
    /**
     * 角色列表
     */
    String ROLE_LIST = "/role/list";
    /**
     * 管理员用户列表
     */
    String ADMINUSER_LIST = "/adminUser/list";
    /**
     * 新增管理员
     */
    String ADMINUSER_INSERT = "/adminUser/insert";
    /**
     * 管理员编辑
     */
    String ADMINUSER_UPDATE = "/adminUser/update";
    /**
     * 管理员删除
     */
    String ADMINUSER_DELETE = "/adminUser/delete";
    /**
     * 重置密码
     */
    String ADMINUSER_RESET_PASSWORD = "/adminUser/reset/password";
    /**
     * 游戏新增
     */
    String DATAITEM_INSERT = "/dataItem/insert";
    /**
     * 游戏修改
     */
    String DATAITEM_UPDATE = "/dataItem/update";
    /**
     * 根据游戏id启用游戏
     */
    String DATAITEM_ENABLE = "/dataItem/enable/{id}";
    /**
     * 根据游戏id禁用游戏
     */
    String DATAITEM_DISABLE = "/dataItem/disable/{id}";
    /**
     * 根据游戏id删除游戏
     */
    String DATAITEM_DELETE = "/dataItem/delete/{id}";
    /**
     * 分页查询游戏列表
     */
    String DATAITEM_SEARCH_LIST = "/dataItem/search/list";
    /**
     * 获取所有游戏
     */
    String DATAITEM_ALL_GAME = "/dataItem/all/game";
    /**
     * 操作日志列表
     */
    String OPERATE_LOG_LIST = "/operateLog/list";
    /**
     * 赛事新增
     */
    String DATA_TOURNAMENT_INSERT = "/dataTournament/insert";
    /**
     * 联赛修改
     */
    String DATA_TOURNAMENT_UPDATE = "/dataTournament/update";
    /**
     * 联赛删除
     */
    String DATA_TOURNAMENT_DELETE = "/dataTournament/delete";
    /**
     * 根据联赛ID查询数据
     */
    String DATA_TOURNAMENT_SELECT = "/dataTournament/select";
    /**
     * 根据条件查询单个联赛
     */
    String DATA_TOURNAMENT_FIND = "/dataTournament/find";
    /**
     * 根据条件查询联赛列表 （分页）
     */
    String DATA_TOURNAMENT_SEARCH = "/dataTournament/search";
    /**
     * 所有联赛获取
     */
    String DATA_TOURNAMENT_ALL = "/dataTournament/all";
    /**
     * 根据游戏和时间查询联赛
     */
    String DATA_TOURNAMENT_SEARCH_TIME = "/dataTournament/search/time";
    /**
     * 赛事推荐
     */
    String DATA_TOURNAMENT_RECOMMEND = "/dataTournament/recommend";
    /**
     * 赛事战队分组新增
     */
    String DATA_ROSTER_GROUP_INSERT = "/dataRoster/group/insert";
    /**
     * 赛事战队分组修改
     */
    String DATA_ROSTER_GROUP_UPDATE = "/dataRoster/group/update";
    /**
     * 赛事战队分组查询
     */
    String DATA_ROSTER_GROUP_SELECT = "/dataRoster/group/select/{id}";
    /**
     * 对战列表查询
     */
    String DATA_SERIES_SEARCH = "/dataSeries/search";
    /**
     * 对战信息
     */
    String DATA_SERIES_SEARCH_INFO = "/dataSeries/search/info";
    /**
     * 对战设置
     */
    String DATA_SERIES_SETUP = "/dataSeries/setup";
    /**
     * 启用对战
     */
    String DATA_SERIES_ENABLE = "/dataSeries/enable/{id}";
    /**
     * 禁用对战
     */
    String DATA_SERIES_DISABLE = "/dataSeries/disable/{id}";
    /**
     * 新增对战
     */
    String DATA_SERIES_INSERT = "/dataSeries/insert";
    /**
     * 删除对战
     */
    String DATA_SERIES_DELETE = "/dataSeries/delete/{id}";
    /**
     * 对战结束
     */
    String DATA_SERIES_FINISH = "/dataSeries/finish";
    /**
     * 录入比分
     */
    String DATA_ENTRY_SCORE = "/dataSeries/entryScore";
    /**
     * 新增常用英雄
     */
    String DATA_HERO_INSERT = "/dataHero/insert";
    /**
     * 更新常用英雄
     */
    String DATA_HERO_UPDATE = "/dataHero/update";
    /**
     * 常用列表查询
     */
    String DATA_HERO_SEARCH = "/dataHero/search";
    /**
     * 战队列表(分页)查询
     */
    String DATA_ROSTER_SEARCH = "/dataRoster/search";
    /**
     * 战队列表（不分页）
     */
    String DATA_ROSTER_LIST = "/dataRoster/list";
    /**
     * 战队新增
     */
    String DATA_ROSTER_INSERT = "/dataRoster/insert";
    /**
     * 战队编辑
     */
    String DATA_ROSTER_UPDATE = "/dataRoster/update";
    /**
     * 启用战队
     */
    String DATA_ROSTER_ENABLE = "/dataRoster/enable/{id}";
    /**
     * 禁用战队
     */
    String DATA_ROSTER_DISABLE = "/dataRoster/disable/{id}";
    /**
     * 关联战队名称
     */
    String DATA_ROSTER_ASSOCIATE_TITLE = "/dataRoster/associate/title";
    /**
     * 战队成员新增
     */
    String DATA_ROSTER_DETAIL_INSERT = "/dataRoster/detail/insert";
    /**
     * 战队成员编辑
     */
    String DATA_ROSTER_DETAIL_UPDATE = "/dataRoster/detail/update";
    /**
     * 战队成员列表查询
     */
    String DATA_ROSTER_DETAIL_SEARCH = "/dataRoster/detail/search";
    /**
     * 成员启用
     */
    String DATA_ROSTER_DETAIL_ENABLE = "/dataRoster/detail/enable/{id}";
    /**
     * 成员禁用
     */
    String DATA_ROSTER_DETAIL_DISABLE = "/dataRoster/detail/disable/{id}";

    /**
     * 单场比赛每个战队人员比赛数据列表查询
     */
    String DATA_SERIES_PLAYER_DATA_SEARCH = "/dataSeriesPlayerData/search";
    /**
     * 战队成员比赛历史
     */
    String DATA_SERIES_PLAYER_DATA_HISTORY = "/dataSeriesPlayerData/history";
    /**
     * 系列赛每场比赛战队数据实体类
     */
    String DATA_SERIES_MATCH_DATA_SEARCH = "/dataSeriesMatchData/search";
    /**
     * dota2战队数据查询
     */
    String DATA_SERIES_MATCH_DATA_CSGO_SEARCH = "/dataSeriesMatchData/csgo/search";
    /**
     * 新增授权客户端
     */
    String CLIENT_INFO_INSERT = "/client/info/insert";
    /**
     * 删除授权客户端
     */
    String CLIENT_INFO_DELETE = "/client/info/delete/{id}";
    /**
     * 编辑授权客户端
     */
    String CLIENT_INFO_UPDATE = "/client/info/update";
    /**
     * 授权客户端列表（分页）
     */
    String CLIENT_INFO_SEARCH = "/client/info/search";
    /**
     * 启用授权客户端
     */
    String CLIENT_INFO_ENABLE = "/client/info/enable/{id}";
    /**
     * 禁用授权客户端
     */
    String CLIENT_INFO_DISABLE = "/client/info/disable/{id}";
    /**
     * 生成授权客户端唯一授权码
     */
    String CLIENT_INFO_AUTHORIZATION_CODE = "/client/info/authorizationCode";
    /**
     * 新增客户端ip白名单
     */
    String CLIENT_IPWHITE_INSERT = "/client/ipWhite/insert";
    /**
     * 删除客户端ip白名单
     */
    String CLIENT_IPWHITE_DELETE = "/client/ipWhite/delete/{id}";
    /**
     * 客户端ip白名单列表（分页）
     */
    String CLIENT_IPWHITE_SEARCH = "/client/ipWhite/search";
}
