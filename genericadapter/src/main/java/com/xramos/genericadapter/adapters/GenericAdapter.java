package com.xramos.genericadapter.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.xramos.genericadapter.viewholders.GenericViewHolder;

import java.util.List;

/**
 * Generic Adapter class that encapsulates common methods
 *
 * Created by xramos on 10/8/17.
 */

public abstract class GenericAdapter<T, V extends GenericViewHolder<T>> extends BaseAdapter {

    protected Context context;
    protected int layoutId;
    protected List<T> objects;

    /**
     * Constructor
     * @param cxt context
     * @param layoutId layout id
     * @param objs list of objects
     */
    public GenericAdapter(final Context cxt, final int layoutId, final List<T> objs) {
        this.context = cxt;
        this.layoutId = layoutId;
        this.objects = objs;
    }

    /**
     * Update objects and notifiy data changed
     * @param objs list of objects
     */
    public final void updateObjects(final List<T> objs) {
        this.objects = objs;
        notifyDataSetChanged();
    }

    /**
     * Get number of objects
     * @return number of objects
     */
    @Override
    public final int getCount() {
        return objects.size();
    }

    /**
     * Get object at position
     * @param position position
     * @return object at position
     */
    @Override
    public final T getItem(final int position) {
        return objects.get(position);
    }

    /**
     * Get item id
     * @param position position
     * @return item position
     */
    public final long getItemId(final int position) {
        return position;
    }

    /**
     * Get view
     * @param position position
     * @param convertView view to convert
     * @param parent parent
     * @return current view
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        GenericViewHolder<T> holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
            holder = createViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (GenericViewHolder<T>)convertView.getTag();
        }

        T model = objects.get(position);

        holder.bind(model);

        return convertView;
    }

    /**
     * Creates GenericViewHolder for specified itemView
     * @param itemView view
     * @return GenericViewHolder
     */
    public abstract V createViewHolder(View itemView);
}
