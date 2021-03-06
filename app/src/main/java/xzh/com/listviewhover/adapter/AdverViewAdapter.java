package xzh.com.listviewhover.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import xzh.com.listviewhover.R;
import xzh.com.listviewhover.model.AdverNotice;
import xzh.com.listviewhover.view.AdverView;


public class AdverViewAdapter {
    private List<AdverNotice> mDatas;

    public AdverViewAdapter(List<AdverNotice> mDatas) {
        this.mDatas = mDatas;
        if (mDatas == null || mDatas.isEmpty()) {
            throw new RuntimeException("nothing to show");
        }
    }

    public int getCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    public AdverNotice getItem(int position) {
        return mDatas.get(position);
    }

    public View getView(AdverView parent) {
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.adver_item, null);
    }

    public void setItem(final View view, final AdverNotice data) {

        ViewHolder viewHolder = null;
        viewHolder = new ViewHolder(view);
        viewHolder.title.setText(data.title);
        viewHolder.tag.setText(data.url);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(view.getContext(), data.url, Toast.LENGTH_SHORT).show();
            }
        });
    }

   static   class ViewHolder {
       @InjectView(R.id.tag)
       TextView tag;
       @InjectView(R.id.title)
       TextView title;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
            view.setTag(this);
        }

    }
}
