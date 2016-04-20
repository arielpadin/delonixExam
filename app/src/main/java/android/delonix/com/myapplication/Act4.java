package android.delonix.com.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Delonix Staff on 15/04/2016.
 */
public class Act4 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.act4, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button retake = (Button) view.findViewById(R.id.btn_retake);
        retake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Act1 fragment1 = new Act1();
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.ll_main, fragment1);
                transaction.commit();
            }
        });
    }
}
