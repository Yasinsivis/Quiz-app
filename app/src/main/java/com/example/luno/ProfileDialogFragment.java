package com.example.luno;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_profile, null);


        ImageView profileImage = dialogView.findViewById(R.id.profile_image);
        TextView usernameText = dialogView.findViewById(R.id.username_text);
        TextView passwordText = dialogView.findViewById(R.id.password_text);
        Button logoutButton = dialogView.findViewById(R.id.logout_button);


        builder.setView(dialogView);

        return builder.create();
    }
}

