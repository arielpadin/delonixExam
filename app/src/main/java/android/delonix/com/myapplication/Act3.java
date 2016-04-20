package android.delonix.com.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Delonix Staff on 14/04/2016.
 */

public class Act3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.act3, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialization
        final EditText first = (EditText) view.findViewById(R.id.et_firstWord);
        final EditText secnd = (EditText) view.findViewById(R.id.et_secondWord);

        final TextView isNotAnagram = (TextView) view.findViewById(R.id.tv_isNotAnagram);

        Button checkAnagram = (Button) view.findViewById(R.id.btn_anagram);

        // Button was click
        checkAnagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstWord = first.getText().toString();
                String secndWord = secnd.getText().toString();
                if(firstWord.isEmpty() || secndWord.isEmpty())
                {
                    isNotAnagram.setVisibility(View.VISIBLE);
                    isNotAnagram.setText("First Word and Second Word are needed to continue.");
                } else {
                    isNotAnagram.setVisibility(View.GONE);
                    // get only numbers and letters
                    // i use stringbuilder so that i can use the function setChatAt(index)
                    /*
                    * basic anagram flow
                    * get all valid string and capitalize e.g.  P@ssw*rd => Psswrd => PSSWRD
                    * next sort the string PSSWRD = DPRSSW
                    * then compare the two word/s if equal
                    * */

                    StringBuilder validFirstWord = new StringBuilder(validateString(firstWord));
                    StringBuilder validSecndWord = new StringBuilder(validateString(secndWord));

                    if(sortString(validFirstWord).equals(sortString(validSecndWord)))
                    {
                        android.app.AlertDialog.Builder err = new android.app.AlertDialog.Builder(getContext());
                        err.setMessage("It's an Anagram");
                        err.setCancelable(false);
                        err.setPositiveButton("Proceed", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Act4 fragment4 = new Act4();
                                FragmentManager manager = getFragmentManager();
                                FragmentTransaction transaction = manager.beginTransaction();
                                transaction.replace(R.id.ll_main, fragment4);
                                transaction.commit();
                            }
                        });
                        err.setNegativeButton("Try Again", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                // clear all the view for the next round :)
                                first.setText("");
                                secnd.setText("");
                            }
                        });
                        android.app.AlertDialog createDialog = err.create();
                        createDialog.show();
                    } else {
                        android.app.AlertDialog.Builder err = new android.app.AlertDialog.Builder(getContext());
                        err.setMessage("It's NOT an Anagram");
                        err.setCancelable(false);
                        err.setNegativeButton("Try Again", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                // clear all the view for the next round :)
                                first.setText("");
                                secnd.setText("");
                            }
                        });
                        android.app.AlertDialog createDialog = err.create();
                        createDialog.show();
                    }
                }
            }
        });
    }

    public String validateString(String str)
    {
        String validStr = "";
        for(int i=0; i<str.length(); i++)
        {
            // check if isLetterOrDigit
            if(Character.isLetterOrDigit(str.charAt(i)))
            {
                // concat valid character
                validStr = validStr + str.charAt(i);
            }
        }
        // return new String and transform to uppercase
        return validStr.toUpperCase();
    }

    public String sortString(StringBuilder str)
    {
        Character temp;
        for(int x=0; x<str.length()-1; x++)
        {
            // Log.d("x",x+"");
            for(int y=0; y<str.length()-(x+1); y++)
            {
                if(str.charAt(y) >= str.charAt(y+1))
                {
                    temp = str.charAt(y+1);
                    str.setCharAt(y+1, str.charAt(y));
                    str.setCharAt(y, temp);
                }
            }
        }
        return str.toString();
    }
}
