package activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;

import com.gjzg.R;

import java.io.IOException;

import bean.ToEmployerToTalkBean;
import config.IntentConfig;
import config.NetConfig;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import utils.Utils;
import view.CProgressDialog;

public class EmployerToTalkActivity extends AppCompatActivity implements View.OnClickListener {

    private View rootView;
    private RelativeLayout returnRl;
    private CProgressDialog cpd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        rootView = LayoutInflater.from(EmployerToTalkActivity.this).inflate(R.layout.activity_employer_to_talk, null);
        setContentView(rootView);
        initView();
        setListener();
        loadData();
    }

    private void initView() {
        initRootView();
    }

    private void initRootView() {
        returnRl = (RelativeLayout) rootView.findViewById(R.id.rl_employer_to_talk_return);
        cpd = Utils.initProgressDialog(EmployerToTalkActivity.this, cpd);
    }

    private void setListener() {
        returnRl.setOnClickListener(this);
    }

    private void loadData() {
        cpd.show();
        ToEmployerToTalkBean toEmployerToTalkBean = (ToEmployerToTalkBean) getIntent().getSerializableExtra(IntentConfig.toEmployerToTalk);
        String t_id = toEmployerToTalkBean.getTaskId();
        Utils.log(EmployerToTalkActivity.this, "t_id\n" + t_id);
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request
                .Builder()
                .url(NetConfig.taskBaseUrl + "?action=info&t_id=" + toEmployerToTalkBean.getTaskId())
                .get()
                .build();
        okHttpClient
                .newCall(request)
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        if (response.isSuccessful()) {
                            String json = response.body().string();
                            Utils.log(EmployerToTalkActivity.this, "json\n" + json);
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_employer_to_talk_return:
                finish();
                break;
        }
    }

}