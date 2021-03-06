package tn.esprit.sostotoroadapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import tn.esprit.sostotoroadapp.Adapter.ConnectedUser;
import tn.esprit.sostotoroadapp.database.AppDataBase;
import tn.esprit.sostotoroadapp.model.User;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Login#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Login extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Login() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Login.
     */
    // TODO: Rename and change types and number of parameters
    public static Login newInstance(String param1, String param2) {
        Login fragment = new Login();
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
    private TextView pageLogin;
    private Button btnlogin;
    private EditText loginf;
    private EditText pwdf;
    private AppDataBase dataBase;
    private User user;
    private Spinner spinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        dataBase = AppDataBase.getAppDataBAse(getActivity().getApplicationContext());
        loginf =view.findViewById(R.id.loginName);
        spinner= view.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adaptar = ArrayAdapter.createFromResource(view.getContext() , R.array.userType,R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adaptar);


        pwdf =view.findViewById(R.id.loginPassword);
        pageLogin = view.findViewById(R.id.loginPage);
        btnlogin=view.findViewById(R.id.buttonLogin);
        btnlogin.setOnClickListener(view1 -> {
            String item=spinner.getSelectedItem().toString();
            if (loginf.getText().toString().equals("admin")&&pwdf.getText().toString().equals("123")&&item.equals("admin")){
                Intent intent = new Intent(getActivity(), AdminActivity.class);
                startActivity(intent);
            }
            if(dataBase.userDAO().LoginUser(loginf.getText().toString(),pwdf.getText().toString())!= null ){
                user =dataBase.userDAO().LoginUser(loginf.getText().toString(),pwdf.getText().toString());
            }
            if (user != null) {
                Intent intent = new Intent(getActivity(), AppRoadActivity.class);
                startActivity(intent);

            }else
            {
                Toast.makeText(getActivity().getApplicationContext(),"Errooooooor",Toast.LENGTH_LONG).show();
            }


        });
        return view;
    }
}