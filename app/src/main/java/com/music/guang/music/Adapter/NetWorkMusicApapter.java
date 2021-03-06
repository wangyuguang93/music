package com.music.guang.music.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.music.guang.music.NetworkData;
import com.music.guang.music.R;

import java.util.List;

/**
 * Created by guang on 2017/8/18.
 */

public class NetWorkMusicApapter extends BaseAdapter {
    LayoutInflater mInflater;
    Context context;
    TextView SongName;
    private int position;
    private ItemClickCallable fragment;
    private List<NetworkData> musicList;

    public NetWorkMusicApapter(Context context,List<NetworkData> musicList){
            this.context=context;
            this.musicList=musicList;
            mInflater=LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return musicList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        this.position=position;
        if (convertView== null){
            convertView=mInflater.inflate(R.layout.music_item,null);
            holder= new ViewHolder();
            holder.tv_music_num=(TextView)convertView.findViewById(R.id.music_item_num);
            holder.tv_music_Name=(TextView) convertView.findViewById(R.id.music_item_SongName);

            holder.img_ico=(ImageView) convertView.findViewById(R.id.music_item_ico);
            holder.img_more=(ImageView) convertView.findViewById(R.id.music_item_more);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.img_more.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                showPopupMenu(v,position);
            }
        });
        if (getCount() != 0) {


            holder.tv_music_num.setText("" + (position + 1) + ".");
            holder.tv_music_Name.setText(musicList.get(position).getFilename());

            Bitmap pic = musicList.get(position).getPic();
            if (pic != null) {
                holder.img_ico.setImageBitmap(pic);
            } else {
                holder.img_ico.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.lab));
            }
        }
//			System.out.println(almid[position]);
//		}

        convertView.setTag(holder);
        return convertView;
    }


    static class ViewHolder {
        private TextView tv_music_num;
        private ImageView img_ico;
        private TextView tv_music_Name;
        private ImageView img_more;

    }

    private void showPopupMenu(View view,final int index) {
        // View当前PopupMenu显示的相对View的位置
        PopupMenu popupMenu = new PopupMenu(context, view);
        // menu布局
        view.getId();

        popupMenu.getMenuInflater().inflate(R.menu.bendi_option, popupMenu.getMenu());
        // menu的item点击事件
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // Toast.makeText(mContext, item.getTitle(), Toast.LENGTH_SHORT).show();
                switch (item.getItemId()) {
                    case R.id.bendi_option_delete:
                        break;
                    case R.id.bendi_option_play:;
                        break;
                    case R.id.bendi_option_xiangqing:
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
        // PopupMenu关闭事件
        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
            @Override
            public void onDismiss(PopupMenu menu) {
                // Toast.makeText(mContext, "关闭PopupMenu", Toast.LENGTH_SHORT).show();
            }
        });
        popupMenu.show();
    }
    ///////////////////////抽取接口//////////////////>
    /**
     * 点击子项目，通知外部进行处理。
     */
    public interface ItemClickCallable
    {

        /**
         * 点击条目。
         * @param position
         */
        public void intoItem(int position);
    }
    ///////////////////////抽取接口//////////////////<
}
