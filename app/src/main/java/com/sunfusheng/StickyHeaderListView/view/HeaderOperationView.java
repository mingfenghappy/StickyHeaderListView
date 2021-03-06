package com.sunfusheng.StickyHeaderListView.view;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.sunfusheng.StickyHeaderListView.R;
import com.sunfusheng.StickyHeaderListView.adapter.HeaderOperationAdapter;
import com.sunfusheng.StickyHeaderListView.model.OperationEntity;
import com.sunfusheng.StickyHeaderListView.util.ToastTip;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sunfusheng on 16/4/20.
 */
public class HeaderOperationView extends HeaderViewInterface<List<OperationEntity>> {

    @Bind(R.id.gv_operation)
    FixedGridView gvOperation;

    public HeaderOperationView(Activity context) {
        super(context);
    }

    @Override
    protected void getView(List<OperationEntity> list, ListView listView) {
        View view = mInflate.inflate(R.layout.header_operation_layout, listView, false);
        ButterKnife.bind(this, view);

        dealWithTheView(list);
        listView.addHeaderView(view);
    }

    private void dealWithTheView(List<OperationEntity> list) {
        final HeaderOperationAdapter adapter = new HeaderOperationAdapter(mContext, list);
        gvOperation.setAdapter(adapter);

        gvOperation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ToastTip.show(mContext, adapter.getItem(position).getTitle());
            }
        });
    }

}
