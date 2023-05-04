package com.example.tastyfoods.mvvm.viewmodels.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tastyfoods.mvvm.model.Food;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class ProductViewModel extends ViewModel {
    private final MutableLiveData<List<Food>> mFoods = new MutableLiveData<>();

    public LiveData<List<Food>> getFoods() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("food").addSnapshotListener((value, error) -> {
            try {
                if (value != null) {
                    List<Food> foods = new ArrayList<>();
                    for (QueryDocumentSnapshot doc : value) {
                        Food food = doc.toObject(Food.class);
                        foods.add(food);
                    }
                    mFoods.postValue(foods);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return mFoods;
    }


}
