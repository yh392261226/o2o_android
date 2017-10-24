package workermanage.adapter;


import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gjzg.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import bean.PersonBean;
import config.StateConfig;
import listener.ListItemClickHelp;
import workermanage.bean.WorkerManageBean;

public class WorkerManageAdapter extends BaseAdapter {

    private Context context;
    private List<WorkerManageBean> list;
    private ListItemClickHelp clickHelp;

    public WorkerManageAdapter(Context context, List<WorkerManageBean> list, ListItemClickHelp clickHelp) {
        this.context = context;
        this.list = list;
        this.clickHelp = clickHelp;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_worker_manage, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        WorkerManageBean workerManageBean = list.get(position);
        if (workerManageBean != null) {
            Picasso.with(context).load(workerManageBean.getIcon()).into(holder.iconIv);
            if (workerManageBean.getO_status().equals("0")) {
                if (workerManageBean.getO_confirm().equals("0") || workerManageBean.getO_confirm().equals("1")) {
                    holder.statusIv.setImageResource(R.mipmap.worker_talk);
                } else {
                    holder.statusIv.setImageResource(R.mipmap.worker_mid);
                }
                holder.deleteTv.setVisibility(View.INVISIBLE);
            } else {
                holder.statusIv.setImageResource(R.mipmap.worker_over);
                holder.deleteTv.setVisibility(View.VISIBLE);
            }
            holder.titleTv.setText(workerManageBean.getTitle());
            holder.infoTv.setText(workerManageBean.getInfo());
        }
        return convertView;
    }

    private class ViewHolder {

        private ImageView iconIv, statusIv;
        private TextView titleTv, infoTv, deleteTv;

        public ViewHolder(View itemView) {
            iconIv = (ImageView) itemView.findViewById(R.id.iv_item_worker_manage_icon);
            statusIv = (ImageView) itemView.findViewById(R.id.iv_item_worker_manage_status);
            titleTv = (TextView) itemView.findViewById(R.id.tv_item_worker_manage_title);
            infoTv = (TextView) itemView.findViewById(R.id.tv_item_worker_manage_info);
            deleteTv = (TextView) itemView.findViewById(R.id.tv_item_worker_manage_delete);
        }
    }
}
