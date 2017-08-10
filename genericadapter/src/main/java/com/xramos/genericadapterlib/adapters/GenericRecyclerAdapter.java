package com.xramos.genericadapterlib.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xramos.genericadapterlib.listeners.OnRecyclerViewItemClickListener;
import com.xramos.genericadapterlib.viewholders.GenericViewHolder;

import java.util.List;

/**
 * Generic Recycler Adapter class that encapsulates common methods
 *
 * Created by xramos on 10/8/17.
 */

public abstract class GenericRecyclerAdapter<T, V extends GenericViewHolder<T>> extends RecyclerView.Adapter<V> implements View.OnClickListener {

    protected Context context;
    protected int layoutId;
    protected List<T> objects;
    protected OnRecyclerViewItemClickListener<T> itemClickListener;

    /**
     * Constructor
     * @param cxt context
     * @param layoutId layout id
     * @param objects list of objects
     */
    protected GenericRecyclerAdapter(final Context cxt, final int layoutId, final List<T> objects) {
        this.context = cxt;
        this.layoutId = layoutId;
        this.objects = objects;
    }

    /**
     * Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item
     * @param parent parent view
     * @param viewType type of view
     * @return GenericViewHolder
     */
    @Override
    public V onCreateViewHolder(ViewGroup parent, int viewType) {

        //Inflate View
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);

        //Set Click Listener
        itemLayoutView.setOnClickListener(this);

        return createViewHolder(itemLayoutView);
    }

    /**
     * Called by RecyclerView to display the data at the specified position
     * @param holder GenericViewHolder
     * @param position position
     */
    @Override
    public void onBindViewHolder(V holder, int position) {

        T model = objects.get(position);

        //Set object as Model for item click purposes
        holder.itemView.setTag(model);

        holder.bind(model);
    }

    /**
     * Update objects and notify data changed
     * @param objects list of objects
     */
    public final void updateObjects(final List<T> objects) {
        this.objects = objects;
        notifyDataSetChanged();
    }

    /**
     * Get number of objects
     * @return number of objects
     */
    @Override
    public final int getItemCount() {
        return objects.size();
    }

    /**
     * Set item click listener
     * @param listener OnRecyclerViewItemClickListener
     */
    public final void setOnItemClickListener(final OnRecyclerViewItemClickListener listener) {
        this.itemClickListener = listener;
    }

    /**
     * Called when a view has been clicked
     * @param view view clicked
     */
    public final void onClick(final View view) {
        if (itemClickListener != null) {
            T model = (T) view.getTag();
            if (model != null) {
                itemClickListener.onItemClick(view, model);
            }
        }
    }

    /**
     * Creates GenericViewHolder for specified itemView
     * @param itemView view
     * @return GenericViewHolder
     */
    public abstract V createViewHolder(View itemView);
}
