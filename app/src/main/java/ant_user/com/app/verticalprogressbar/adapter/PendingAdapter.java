package ant_user.com.app.verticalprogressbar.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ant_user.com.app.verticalprogressbar.R;

public class PendingAdapter extends RecyclerView.Adapter<PendingAdapter.ViewHolder> {

    private final Context mContext;
    Bitmap bitmap =null;
    public PendingAdapter(Context con) {
        mContext = con;
    }

    @NonNull
    @Override
    public PendingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pending, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PendingAdapter.ViewHolder holder, final int position) {



    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);


        }
    }
}