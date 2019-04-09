package com.quanlehui.servicebase.base.constant;

/**
 * Desc    :
 * Date    : 2018-01-10
 *
 * @author : yxy
 */
public interface Constants {

    /**
     * 登录用户信息KEY
     */
    String USER_SESSION = "userSession";

    /**
     * 前台注册用户默认昵称
     */
    String USER_NICKNAME = "USER_NICKNAME";

    /**
     * 每日最多提现5次，其中前三次不收取手续费，后两次每笔收取【X%】手续费。
     */
    Integer WITHDRAW_DAY_TIMES = 5;

    /**
     * 数据库名
     */
    String DB_GUESS = "guess";

    /**
     * 表guess_game表名驼峰值
     */
    String TABLE_GUESSGAME = "guessGame";

    String TABLE_GUESSTEAM = "guessTeam";

    String TABLE_GUESSOPEN = "guessOpen";

    String TABLE_GUESSELEMENT = "guessElement";

    String TABLE_GUESSBET = "guessBet";

    String DB_USER = "user";

    String TABLE_PAYINORDER = "payInOrder";

    String TABLE_PAYOUTORDER = "payOutOrder";

    String TABLE_PAYORDER = "payOrder";

    String TABLE_PAYASSETCHANGEORDER = "payAssetChangeOrder";

    String DB_BOT = "bot";

    String TABLE_BOTSHOPORDER = "botShopOrder";

    String TABLE_BOTSHOPORDERDETAIL = "botShopOrderDetail";

    String TRANSACTIONAL_MALLDEMO="transactionalMallDemo";

    String TABLE_GUESS_NORMAL_SETTLE = "guessNormalSettle";

    String TABLE_GUESS_RECOVER = "guessRecover";

    String TABLE_GUESS_BET_PRE_ROLLER = "guessBetPreRoller";

    String TABLE_BOTSTEAMORDER = "botsteamOrder";

    String TABLE_BOTTRANSFERORDER = "botTransferOrder";

    String TABLE_BOTBETORDER = "botBetOrder";

    String TABLE_BOTBETUSERADDORDER = "botBetUseraddOrder";

}
