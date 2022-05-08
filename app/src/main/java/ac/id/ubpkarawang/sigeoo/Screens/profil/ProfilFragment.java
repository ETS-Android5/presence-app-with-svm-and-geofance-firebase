package ac.id.ubpkarawang.sigeoo.Screens.profil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import ac.id.ubpkarawang.sigeoo.R;

public class ProfilFragment extends Fragment {

    TextView txtNama, txtEmail;
    RelativeLayout layout_main;

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profil, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        layout_main = view.findViewById(R.id.content_profil);
        txtEmail = view.findViewById(R.id.text_email_profil);
        txtNama = view.findViewById(R.id.text_nama_profil);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth == null) {
            txtNama.setText("Nama Kosong");
            txtEmail.setText("Email Kosong");
        } else {
            firebaseUser = firebaseAuth.getCurrentUser();
            String username = firebaseUser.getDisplayName();
            String email = firebaseUser.getEmail();

            txtNama.setText(username);
            txtEmail.setText(email);
        }
    }
}