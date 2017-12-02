//package com.topa.techpark;
//
//import android.app.Activity;
//import android.content.Context;
//import android.support.annotation.NonNull;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.BaseAdapter;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by anish on 11/26/2017.
// */
//
//class ListItem{
//    public String rowNo;
//    public String lotName;
//    public String FreeSpace;
//
//    public ListItem(String t1, String t2, String t3)
//    {
//        this.rowNo = t1;
//        this.lotName = t2;
//        this.FreeSpace = t3;
//    }
//
//    public String getRowNo() {
//        return rowNo;
//    }
//
//    public void setRowNo(String rowNo) {
//        this.rowNo = rowNo;
//    }
//
//    public String getLotName() {
//        return lotName;
//    }
//
//    public void setLotName(String lotName) {
//        this.lotName = lotName;
//    }
//
//    public String getFreeSpace() {
//        return FreeSpace;
//    }
//
//    public void setFreeSpace(String freeSpace) {
//        FreeSpace = freeSpace;
//    }
//
//}
//
//public class customList extends BaseAdapter {
//
////    private Activity context;
////    private ListItem listItem[];
////    public customList(Activity context, ListItem li[]) {
////        super(context, R.layout.activity_comm_north, li);
////    }
//
//    private Context mContext;
//    private List<ListItem> mListItem;
//
//    public customList(Context mContext, ArrayList<Object> mListItem) {
//        this.mContext = mContext;
//        this.mListItem = mListItem;
//    }
//
//    @Override
//    public int getCount() {
//        return mListItem.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return mListItem.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View v = View.inflate(mContext, R.layout.text_view, null);
//        TextView row_No = (TextView)v.findViewById(R.id.row_No);
//        TextView lot_Name = (TextView)v.findViewById(R.id.lot_Name);
//        TextView Free_Space = (TextView)v.findViewById(R.id.Free_Space);
//        //Set text for TextView
//        row_No.setText(mListItem.get(position).getRowNo());
//        lot_Name.setText(mListItem.get(position).getLotName());
//        Free_Space.setText(mListItem.get(position).getFreeSpace());
//        return v;
//    }
//}
