package com.example.kjra;

import androidx.fragment.app.Fragment;

public interface Navigation{
    void navigateTo(Fragment fragment, boolean addToBackstack);
}