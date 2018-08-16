package ant_user.com.app.verticalprogressbar.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ant_user.com.app.verticalprogressbar.R;
import ant_user.com.app.verticalprogressbar.adapter.BookingAdapter;

public class BookedFragment extends Fragment {

    static BookedFragment fragment;
    private static Context mContext;

    RecyclerView rvPast;



    BookingAdapter mAdapter;

    public static BookedFragment newInstance(Context context) {
        fragment = new BookedFragment();
        mContext = context;
//        textView.setText("PAST");
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragement_booked, container, false);
        rvPast =   view.findViewById(R.id.recycleview);
        onCreateStuff(view);
        return view;
    }


    protected void onCreateStuff(View view) {
        rvPast.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rvPast.setNestedScrollingEnabled(false);

        mAdapter = new BookingAdapter(getActivity());
        rvPast.setAdapter(mAdapter);
    }

    protected void initListeners() {

    }
}
