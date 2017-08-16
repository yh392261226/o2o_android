package config;

/**
 * 创建日期：2017/8/16 on 10:27
 * 作者:孙明明
 * 描述:状态配置
 */

public interface StateConfig {

    //加载状态
    public static final int LOAD_NO_NET = 0;
    public static final int LOAD_DONE = 1;
    public static final int LOAD_REFRESH = 2;
    public static final int LOAD_LOAD = 3;

    //加载结果
    public static final String loadNonet = "网络异常";
    public static final String loadRefreshSuccess = "刷新成功";
    public static final String loadRefreshFailure = "刷新失败，请检查网络设置";
    public static final String loadLoadSuccess = "加载成功";
    public static final String loadLoadFailure = "加载失败，请检查网络设置";
}
