package tn.esprit.sostotoroadapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import tn.esprit.sostotoroadapp.database.AppDataBase;
import tn.esprit.sostotoroadapp.model.User;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Inscription#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Inscription extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Inscription() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Inscription.
     */
    // TODO: Rename and change types and number of parameters
    public static Inscription newInstance(String param1, String param2) {
        Inscription fragment = new Inscription();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private TextView textViewInscrip;
    private Button ok;
    private Button annuler;
    private EditText textPersonName;
    private EditText textEmailAddress;
    private EditText textPostalAddress;
    private EditText textPhone;
    private EditText textPassword;

    private AppDataBase dataBase;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inscription, container, false);
        ok=view.findViewById(R.id.ok);
        annuler=view.findViewById(R.id.annuler);
        textViewInscrip=view.findViewById(R.id.textViewInscrip);
        textPersonName =view.findViewById(R.id.textPersonName);
        textEmailAddress =view.findViewById(R.id.textEmailAddress);
        textPostalAddress = view.findViewById(R.id.textPostalAddress);
        textPhone = view.findViewById(R.id.textPhone);
        textPassword= view.findViewById(R.id.textPassword);
        dataBase = AppDataBase.getAppDataBAse(getActivity().getApplicationContext());
        ok.setOnClickListener(view1 -> {
            User user = new User();
            user.setName(textPersonName.getText().toString());
            user.setEmail(textEmailAddress.getText().toString());
            user.setAdresse(textPostalAddress.getText().toString());
            user.setPhone(textPhone.getText().toString());
            user.setPassword(textPassword.getText().toString());
            dataBase.userDAO().insertUser(user);
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayout, new Login())
                    .commit();

        });
        return view;
    }
}