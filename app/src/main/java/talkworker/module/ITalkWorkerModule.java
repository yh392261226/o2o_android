package talkworker.module;

import com.gjzg.listener.JsonListener;

/**
 * Created by Administrator on 2017/10/29.
 */

public interface ITalkWorkerModule {

    void load(String url, JsonListener jsonListener);

    void check(String url,JsonListener jsonListener);

    void cancelTask();
}
